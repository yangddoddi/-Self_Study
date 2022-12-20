-- 코드를 입력하세요
SELECT a.MCDP_CD AS 진료과코드, COUNT(a.MDDR_ID) AS 5월예약건수
FROM appointment a
WHERE a.APNT_YMD LIKE '2022-05-%'
GROUP BY 진료과코드
ORDER BY 5월예약건수 ASC, 진료과코드 ASC