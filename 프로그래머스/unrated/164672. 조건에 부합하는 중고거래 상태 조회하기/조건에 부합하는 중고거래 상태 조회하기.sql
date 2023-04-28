-- 코드를 입력하세요
SELECT
board_id,
writer_id,
title,
price,
if(status="DONE","거래완료",if(status="SALE","판매중","예약중")) as status
from USED_GOODS_BOARD
where
created_date ="2022-10-05"
order by
board_id desc