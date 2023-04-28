-- 코드를 입력하세요
SELECT
order_id,
product_id,
if(out_date=NULL,"",date_format(out_date,"%Y-%m-%d")) as out_date,
IF(OUT_DATE <='2022-05-01','출고완료',IF(OUT_DATE>'2022-05-01','출고대기','출고미정'))출고여부
from
food_order
order by
order_id