# Write your MySQL query statement below
SELECT 
    d.date_id,
    d.make_name,
    COUNT(DISTINCT d.lead_id) AS unique_leads,
    COUNT(DISTINCT d.partner_id) AS unique_partners
FROM DailySales d
GROUP BY d.date_id,d.make_name;