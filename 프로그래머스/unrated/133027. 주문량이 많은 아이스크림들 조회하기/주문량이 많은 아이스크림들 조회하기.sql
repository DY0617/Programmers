-- 코드를 입력하세요
SELECT
    half.flavor as FLAVOR
FROM
    first_half as half, july
WHERE
    half.flavor = july.flavor
GROUP BY
    july.flavor
ORDER BY
    half.total_order + sum(july.total_order) desc
LIMIT
    3