CREATE TABLE users
(
  id       INT AUTO_INCREMENT PRIMARY KEY,
  email    VARCHAR(150) NOT NULL,
  password VARCHAR(150) NOT NULL,
  name     VARCHAR(50)  NOT NULL,
  date     DATE         NOT NULL,
  role     INT(1)       NOT NULL,
  CONSTRAINT users_email_uindex
  UNIQUE (email)
)
  COMMENT 'all users';
