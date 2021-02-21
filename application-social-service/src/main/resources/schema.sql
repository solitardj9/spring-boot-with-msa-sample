create table if not exists follow (
	followee_id	LONG,
	follower_id	LONG,
	created_at		Date,
	PRIMARY KEY (followee_id, follower_id)
);