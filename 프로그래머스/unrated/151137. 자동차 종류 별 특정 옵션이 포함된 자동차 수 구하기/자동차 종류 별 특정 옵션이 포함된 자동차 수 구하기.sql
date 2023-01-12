-- 코드를 입력하세요
SELECT c.CAR_TYPE, COUNT(c.CAR_ID) AS CARS
FROM CAR_RENTAL_COMPANY_CAR as c
WHERE c.OPTIONS like '%가죽시트%' OR c.OPTIONS like '%통풍시트%' OR c.OPTIONS like '%열선시트%'
GROUP BY c.CAR_TYPE 
ORDER BY c.CAR_TYPE ASC