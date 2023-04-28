-- 코드를 입력하세요
SELECT
history_id,
car_id,
date_format(start_date,"%Y-%m-%d") as start_date,
date_format(end_date,"%Y-%m-%d") as end_date,
if(datediff(end_date,start_date)+1>=30,"장기 대여","단기 대여") as rent_type
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where
start_date like "2022-09%"
order by
history_id desc