-- 코드를 입력하세요
SELECT prod.CATEGORY, prod.PRICE, prod.PRODUCT_NAME
FROM FOOD_PRODUCT as prod
JOIN (SELECT MAX(join_prod.PRICE) as p, join_prod.CATEGORY AS cate
     FROM FOOD_PRODUCT as join_prod
     GROUP BY join_prod.CATEGORY) as max_prod ON max_prod.p = prod.Price AND max_prod.cate = prod.CATEGORY
WHERE prod.CATEGORY IN ('과자','국','김치','식용유')
ORDER BY prod.PRICE DESC