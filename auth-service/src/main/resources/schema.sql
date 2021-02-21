create table if not exists token (
	token			VARCHAR(500) PRIMARY KEY,
	user_id		VARCHAR(50),
	created_at		Date
);