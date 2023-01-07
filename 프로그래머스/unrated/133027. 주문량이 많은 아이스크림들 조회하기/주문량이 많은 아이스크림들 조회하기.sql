-- 코드를 입력하세요
SELECT fj.FLAVOR
FROM (
    SELECT sum(f.TOTAL_ORDER + j.TOTAL_ORDER) as cnt, f.FLAVOR
    FROM FIRST_HALF as f
    JOIN JULY AS j ON f.FLAVOR = j.FLAVOR
    GROUP BY f.FLAVOR
    ORDER BY cnt DESC
    LIMIT 3
    ) AS fj
