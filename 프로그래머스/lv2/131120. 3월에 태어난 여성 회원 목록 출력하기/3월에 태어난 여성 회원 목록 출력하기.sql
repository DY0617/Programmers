-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH,'%Y-%m-%d') FROM MEMBER_PROFILE WHERE TLNO is not null and DATE_OF_BIRTH like "%-03-%" and GENDER='W'