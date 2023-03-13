-- 코드를 입력하세요
SELECT date_format(sales_date, '%Y-%m-%d') sales_date, product_id, user_id, sales_amount
from online_sale
where date_format(sales_date, '%Y-%m') = '2022-03'
union all
select date_format(sales_date, '%Y-%m-%d')sales_date, product_id, NULL as user_id, sales_amount
from offline_sale 
where date_format(sales_date, '%Y-%m') = '2022-03'

order by sales_date, product_id, user_id