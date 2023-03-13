-- 코드를 입력하세요
SELECT hour(datetime) as hour, count(*) as count from animal_outs group by hour having hour>=9 and hour<=19 order by hour