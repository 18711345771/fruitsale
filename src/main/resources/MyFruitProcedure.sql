-- 第一步
-- 准备数据
-- 建库myfruitdatabase
drop database if exists myfruitdatabase;
create database myfruitdatabase;

-- 第二步
-- 切换到myfruitdatabase
use myfruitdatabase;

-- 第三步
-- 新建水果价位表t_fruit
DROP TABLE IF EXISTS t_fruit;
CREATE TABLE t_fruit (
  id   INT NOT NULL PRIMARY KEY COMMENT '编号',
  price  INT NOT NULL COMMENT '价格',
  name VARCHAR(16) NOT NULL COMMENT '名称'
) COMMENT '水果价位表';

-- 第三步
-- 补充水果价位
insert ignore into t_fruit(id,price,name)values(1,8,'苹果');
insert ignore into t_fruit(id,price,name)values(2,13,'草莓');
insert ignore into t_fruit(id,price,name)values(3,20,'芒果');

-- 第四步
-- 新建水果价格计算的存储过程
-- 设置结束符为$
DELIMITER $
-- 如果存储过程存在则删除
DROP PROCEDURE IF EXISTS MyFruitProcedure;
/*创建存储过程proc2*/
CREATE PROCEDURE MyFruitProcedure(in appleWeight int,in strawberryWeight int,in mangoWeight int,in isDiscount int,out minTotal INT)
  BEGIN
    -- 声明总价变量
    DECLARE v_total int DEFAULT 0;
    -- 声明苹果单价变量
    DECLARE p_apple int;
    -- 声明草莓单价变量
    DECLARE p_strawberry int;
    -- 声明芒果单价变量
    DECLARE p_mango int;
    -- 声明折扣价变量
    DECLARE p_temp int;
    select price into p_apple from t_fruit where id = 1;
    select price into p_strawberry from t_fruit where id = 2;
    select price into p_mango from t_fruit where id = 3;
    -- 如果无优惠
    IF isDiscount=0 THEN
        set v_total = p_apple*appleWeight+p_strawberry*strawberryWeight+p_mango*mangoWeight;
    -- 如果草莓限时打 8 折优惠
    elseif isDiscount=1 THEN
        set p_temp = p_strawberry*strawberryWeight*0.8;
        set v_total = p_apple*appleWeight+p_temp+p_mango*mangoWeight;
    -- 购物满 100 减 10 块优惠
    elseif isDiscount=2 THEN
        set v_total = p_apple*appleWeight+p_strawberry*strawberryWeight+p_mango*mangoWeight;
        if v_total >= 100 then
            set v_total = v_total - 10;
        end if;
    end if;
    set minTotal = v_total;
  END $
-- 将结束符置为;
DELIMITER ;

-- 第五步
-- 验证结果：开启cmd窗口，连接mysql，执行下面操作：
CALL MyFruitProcedure(10,10,10,2,@v_total);
select @v_total;

