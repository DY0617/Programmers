-- 코드를 입력하세요
SELECT o.animal_id, o.name from animal_ins i right outer join animal_outs o on i.animal_id=o.animal_id where i.name is null and o.name is not null order by animal_id