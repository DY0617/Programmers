-- 코드를 입력하세요
SELECT p.product_code,sum(o.sales_amount*p.price) as sales from product p join offline_sale o on p.product_id=o.product_id
group by product_code
order by sales desc,product_code