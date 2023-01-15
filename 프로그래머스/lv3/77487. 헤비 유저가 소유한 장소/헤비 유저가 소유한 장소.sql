-- 코드를 입력하세요
SELECT p.ID, p.NAME, p.HOST_ID
FROM PLACES as p
JOIN (SELECT count(p2.HOST_ID) as cnt, p2.HOST_ID
     FROM PLACES as p2
     GROUP BY p2.HOST_ID
     HAVING cnt > 1) as p3 ON p.HOST_ID = p3.HOST_ID
ORDER BY p.ID ASC;