SELECT (SELECT COUNT(profile_id) FROM profile)
           - (SELECT COUNT(DISTINCT profile_id) FROM post) AS count_without_posts;