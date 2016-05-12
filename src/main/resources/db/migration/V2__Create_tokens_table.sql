CREATE TABLE "tokens" (
  "id"      BIGSERIAL PRIMARY KEY,
  "user_id" BIGINT,
  "token"   VARCHAR NOT NULL
);
ALTER TABLE "tokens" ADD CONSTRAINT "USER_FK" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON UPDATE RESTRICT ON DELETE CASCADE;

CREATE TABLE `users` (
  id bigint unsigned PRIMARY KEY auto_increment,
  username VARCHAR(60),
  `password` VARCHAR(60)
);
CREATE TABLE `tokens` (
  id bigint unsigned PRIMARY KEY auto_increment,
  user_id BIGINT,
  token	VARCHAR(128)
);