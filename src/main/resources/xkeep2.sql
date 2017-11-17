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

-- auto-generated definition
create table notes
(
  id          INT AUTO_INCREMENT
    PRIMARY KEY,
  note        TEXT         NOT NULL,
  note_title  VARCHAR(255) NOT NULL,
  is_archieve TINYINT(1)   NOT NULL,
  date_added  VARCHAR(10)  NOT NULL,
  color       VARCHAR(6)   NOT NULL,
  user_id     INT          NOT NULL
);

