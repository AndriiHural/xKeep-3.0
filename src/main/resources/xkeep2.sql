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

CREATE TABLE notes
(
  id          INT AUTO_INCREMENT
    PRIMARY KEY,
  note        TEXT         NOT NULL,
  note_title  VARCHAR(255) NOT NULL,
  is_archieve TINYINT(1)   NOT NULL,
  date_added  VARCHAR(10)  NOT NULL,
  color       VARCHAR(6)   NOT NULL,
  user_id     INT          NOT NULL,
  CONSTRAINT notes_users_id_fk
  FOREIGN KEY (user_id) REFERENCES users (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE INDEX notes_users_id_fk
  ON notes (user_id);


CREATE TABLE shared_notes
(
  id       INT AUTO_INCREMENT PRIMARY KEY,
  user_id  INT NULL,
  notes_id INT NULL,
  CONSTRAINT shared_notes_users_id_fk
  FOREIGN KEY (user_id) REFERENCES users (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
  CONSTRAINT shared_notes_notes_id_fk
  FOREIGN KEY (notes_id) REFERENCES notes (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE INDEX shared_notes_notes_id_fk
  ON shared_notes (notes_id);

CREATE INDEX shared_notes_users_id_fk
  ON shared_notes (user_id);


INSERT INTO `users` (`email`, `password`, `name`, `date`, `role`)
VALUES ("igor@lyutak.com", "1122", "Igor", "2017-11-15", 1);

INSERT INTO `users` (`email`, `password`, `name`, `date`, `role`)
VALUES ("sirko5300@gmail.com", "1122", "Andrii", "2017-11-16", 1);

INSERT INTO `users` (`email`, `password`, `name`, `date`, `role`)
VALUES ("sasha19970808@com.ua", "1122", "Sashal", "2017-11-16", 1);

INSERT INTO `users` (`email`, `password`, `name`, `date`, `role`)
VALUES ("user3@gmail.com", "1122", "Andriy3", "2017-11-16", 2);

INSERT INTO `users` (`email`, `password`, `name`, `date`, `role`)
VALUES ("user4@gmail.com", "1122", "Andriy4", "2017-11-16", 2);

INSERT INTO `notes` (`note`, `note_title`, `date_added`,`is_archieve`, `color` ,`user_id`)
VALUES ("T1", "text", "2017-11-16", 0, "white",2);

INSERT INTO `notes` (`note`, `note_title`, `date_added`,`is_archieve`, `color` ,`user_id`)
VALUES ("T2", "text2", "2017-11-16", 0, "white",2);

INSERT INTO `notes` (`note`, `note_title`, `date_added`,`is_archieve`, `color` ,`user_id`)
VALUES ("T3", "text3", "2017-11-16", 0, "white",1);

INSERT INTO `notes` (`note`, `note_title`, `date_added`,`is_archieve`, `color` ,`user_id`)
VALUES ("T4", "text4", "2017-11-16", 0, "white",3);

INSERT INTO `shared_notes` (`notes_id`, `user_id`)
VALUES ("1", "1");

INSERT INTO `shared_notes` (`notes_id`, `user_id`)
VALUES ("1", "3");

INSERT INTO `shared_notes` (`notes_id`, `user_id`)
VALUES ("1", "5");


CREATE TABLE shared_notes
(
  id       INT AUTO_INCREMENT PRIMARY KEY,
  user_id  INT NULL,
  notes_id INT NULL,
  CONSTRAINT shared_notes_users_id_fk
  FOREIGN KEY (user_id) REFERENCES users (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
  CONSTRAINT shared_notes_notes_id_fk
  FOREIGN KEY (notes_id) REFERENCES notes (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE INDEX shared_notes_notes_id_fk
  ON shared_notes (notes_id);

CREATE INDEX shared_notes_users_id_fk
  ON shared_notes (user_id);


INSERT INTO `users` (`email`, `password`, `name`, `date`, `role`)
VALUES ("igor@lyutak.com", "1122", "Igor", "2017-11-15", 1);

INSERT INTO `users` (`email`, `password`, `name`, `date`, `role`)
VALUES ("user@gmail.com", "1122", "Igor", "2017-11-16", 2);

INSERT INTO `users` (`email`, `password`, `name`, `date`, `role`)
VALUES ("user2@gmail.com", "1122", "Andriy", "2017-11-16", 2);

INSERT INTO `users` (`email`, `password`, `name`, `date`, `role`)
VALUES ("user3@gmail.com", "1122", "Andriy3", "2017-11-16", 2);

INSERT INTO `users` (`email`, `password`, `name`, `date`, `role`)
VALUES ("user4@gmail.com", "1122", "Andriy4", "2017-11-16", 2);

INSERT INTO `notes` (`note`, `note_title`, `date_added`, `user_id`, `is_archieve`, `color`)
VALUES ("T1", "text", "2017-11-16", 2, 0, "white");

INSERT INTO `notes` (`note`, `note_title`, `date_added`, `user_id`, `is_archieve`, `color`)
VALUES ("T2", "text 2", "2017-11-17", 2, 0, "white");

INSERT INTO `shared_notes` (`notes_id`, `user_id`)
VALUES ("1", "1");

INSERT INTO `shared_notes` (`notes_id`, `user_id`)
VALUES ("1", "3");

INSERT INTO `shared_notes` (`notes_id`, `user_id`)
VALUES ("1", "5");


