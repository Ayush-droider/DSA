# Write your MySQL query statement below
SELECT
    p.patient_id,
    p.patient_name,
    p.age,
    DATEDIFF(
        MIN(CASE
            WHEN ct.result='Negative'
            AND ct.test_date>(
                SELECT MIN(ct2.test_date)
                FROM covid_tests ct2
                WHERE ct2.patient_id=p.patient_id
                AND ct2.result='Positive'
            )
            THEN ct.test_date
        END),
        MIN(CASE WHEN ct.result='Positive' THEN ct.test_date END)
    ) AS recovery_time
FROM patients p
LEFT JOIN covid_tests ct
ON p.patient_id=ct.patient_id
GROUP BY p.patient_id,p.patient_name,p.age
HAVING recovery_time IS NOT NULL
ORDER BY recovery_time ASC, p.patient_name ASC;
