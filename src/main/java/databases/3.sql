SELECT p.post_id
FROM post p
WHERE (SELECT COUNT(*) FROM comment c WHERE c.post_id = p.post_id) <= 1
ORDER BY p.post_id
LIMIT 10;