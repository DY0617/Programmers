-- 코드를 입력하세요
SELECT DISTINCT S1.USER_ID , S1.PRODUCT_ID FROM ONLINE_SALE S1 JOIN ONLINE_SALE S2 WHERE S1.USER_ID=S2.USER_ID AND S1.PRODUCT_ID=S2.PRODUCT_ID AND S1.ONLINE_SALE_ID != S2.ONLINE_SALE_ID ORDER BY USER_ID, PRODUCT_ID DESC