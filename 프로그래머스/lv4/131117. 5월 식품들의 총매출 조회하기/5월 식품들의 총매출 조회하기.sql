-- 코드를 입력하세요
SELECT p.product_id as PRODUCT_ID, p.product_name as PRODUCT_NAME, (o.amount * p.price) as TOTAL_SALES
FROM FOOD_PRODUCT as p
JOIN (select fo.product_id, sum(fo.amount) as amount
     from FOOD_ORDER as fo
     where month(fo.PRODUCE_DATE) = 5 and year(fo.PRODUCE_DATE) = 2022
     group by fo.product_id) as o on o.product_id = p.product_id
order by TOTAL_SALES desc, p.product_id asc