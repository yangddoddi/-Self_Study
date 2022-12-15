-- 식당id, 식당 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수 조회
-- 리뷰 평균 점수는 소수점 세 번째 자리에서 반올림
-- 정렬 : 평균 점수 기준 내림차순, 같다면 즐겨찾기 수 기준 내림차순
-- 코드를 입력하세요
SELECT info.REST_ID, info.REST_NAME, info.FOOD_TYPE, info.FAVORITES, info.ADDRESS, 
       ROUND(AVG(review.REVIEW_SCORE), 2) AS REVIEW_SCORE
FROM REST_REVIEW AS review
INNER JOIN REST_INFO AS info ON info.REST_ID = review.REST_ID
WHERE info.ADDRESS LIKE '서울%'
GROUP BY info.REST_NAME
ORDER BY REVIEW_SCORE DESC, info.FAVORITES DESC;