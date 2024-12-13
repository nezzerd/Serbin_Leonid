SELECT p.post_id
FROM post p
         JOIN (SELECT post_id FROM comment GROUP BY post_id HAVING COUNT(comment_id) = 2) c ON p.post_id = c.post_id
WHERE LENGTH(p.content) > 20
  AND p.title ~ '^[0-9]'
ORDER BY p.post_id;