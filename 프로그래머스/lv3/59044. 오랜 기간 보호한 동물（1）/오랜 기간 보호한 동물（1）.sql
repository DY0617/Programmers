-- 코드를 입력하세요
SELECT i.name,i.datetime from animal_ins i left outer join animal_outs o on i.animal_id = o.animal_id where o.datetime is null
order by datetime limit 3