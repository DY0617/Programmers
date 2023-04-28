-- 코드를 입력하세요
SELECT
i.animal_id, i.animal_type, i.name
FROM 
animal_ins as i join animal_outs as o on i.animal_id=o.animal_id
where
i.sex_upon_intake like "Intact%"
and
(o.sex_upon_outcome like "Neutered%"
or
o.sex_upon_outcome like "Spayed%")
order by i.animal_id