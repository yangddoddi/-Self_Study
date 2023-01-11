-- 코드를 입력하세요
SELECT ins.ANIMAL_ID, ins.ANIMAL_TYPE, ins.NAME
FROM ANIMAL_INS AS ins
JOIN (SELECT outs.ANIMAL_ID as id
          FROM ANIMAL_OUTS AS outs
     WHERE outs.SEX_UPON_OUTCOME like 'Spayed%' or outs.SEX_UPON_OUTCOME like 'Neutered%') AS o ON o.id = ins.ANIMAL_ID
WHERE ins.SEX_UPON_INTAKE like 'Intact%'
ORDER BY ins.ANIMAL_ID ASC