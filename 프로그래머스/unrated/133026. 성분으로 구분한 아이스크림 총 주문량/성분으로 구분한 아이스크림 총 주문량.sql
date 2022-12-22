-- 코드를 입력하세요

-- 상반기 동안 각 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량을 총주문량이 작은 순서대로
-- 총주문량을 나타내는 컬럼명은 TOTAL_ORDER
SELECT info.INGREDIENT_TYPE, SUM(half.TOTAL_ORDER) as TOTAL_ORDER
FROM ICECREAM_INFO as info
JOIN FIRST_HALF as half ON info.FLAVOR = half.FLAVOR
GROUP BY info.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER ASC;