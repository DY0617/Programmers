-- 코드를 입력하세요
SELECT category,price as max_price,product_name from food_product where    price  in(
    SELECT MAX(PRICE) MAX_PRICE
    FROM FOOD_PRODUCT
    GROUP BY CATEGORY
    )
AND CATEGORY IN ('과자', '국', '김치', '식용유') group by category order by max_price desc