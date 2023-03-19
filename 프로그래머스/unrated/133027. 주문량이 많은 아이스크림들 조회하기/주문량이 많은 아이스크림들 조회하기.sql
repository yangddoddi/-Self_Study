-- 코드를 입력하세요

SELECT result.FLAVOR
FROM (SELECT (j2.total + f.TOTAL_ORDER) as total, f.FLAVOR
FROM FIRST_HALF AS f
JOIN (SELECT sum(j.TOTAL_ORDER) as total, j.FLAVOR
     FROM JULY as j
     GROUP BY j.FLAVOR) as j2 ON j2.FLAVOR = f.FLAVOR
ORDER BY total DESC
LIMIT 3) as result
     