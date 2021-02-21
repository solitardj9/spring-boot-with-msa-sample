create table if not exists user (
	id				LONG AUTO_INCREMENT PRIMARY KEY,
	username		VARCHAR(50),
	password		VARCHAR(50),
	created_at		Date
);

create table if not exists post (
	id				LONG AUTO_INCREMENT PRIMARY KEY,
	user_id		VARCHAR(50),
	title			VARCHAR(200),
	content		LONGTEXT,
	created_at		Date
);

create table if not exists comment (
	id				LONG AUTO_INCREMENT PRIMARY KEY,
	user_id		VARCHAR(50),
	post_id		LONG,
	content		LONGTEXT,
	created_at		Date
);