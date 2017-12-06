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
VALUES ("serhiil@gmail.com", "1122", "Serhii", "2017-11-15", 1);

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

INSERT INTO `notes` (`note_title`, `note`, `date_added`,`is_archieve`, `color` ,`user_id`)
VALUES ("What is Lorem Ipsum?", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", "2017-11-16", 0, "white",1);

INSERT INTO `notes` (`note_title`, `note`, `date_added`,`is_archieve`, `color` ,`user_id`)
VALUES ("Why do we use it?", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).", "2017-11-16", 0, "white",1);

INSERT INTO `notes` (`note_title`, `note`, `date_added`,`is_archieve`, `color` ,`user_id`)
VALUES ("What is Lorem Ipsum?", "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.", "2017-11-16", 0, "white",1);

INSERT INTO `notes` (`note_title`, `note`, `date_added`,`is_archieve`, `color` ,`user_id`)
VALUES ("Where can I get some?", "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of de Finibus Bonorum et Malorum (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, Lorem ipsum dolor sit amet.., comes from a line in section 1.10.32.", "2017-11-16", 0, "white",1);

INSERT INTO `notes` (`note_title`, `note`, `date_added`,`is_archieve`, `color` ,`user_id`)
VALUES ("What is Lorem Ipsum?", "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.", "2017-11-16", 0, "white",1);

INSERT INTO `notes` (`note_title`, `note`, `date_added`,`is_archieve`, `color` ,`user_id`)
VALUES ("What is Lorem Ipsum?", "t is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).", "2017-11-16", 0, "white",1);

INSERT INTO `notes` (`note`, `note_title`, `date_added`,`is_archieve`, `color` ,`user_id`)
VALUES ("T4", "text4", "2017-11-16", 0, "white",3);

INSERT INTO `shared_notes` (`notes_id`, `user_id`)
VALUES ("1", "3");

INSERT INTO `shared_notes` (`notes_id`, `user_id`)
VALUES ("2", "3");

INSERT INTO `shared_notes` (`notes_id`, `user_id`)
VALUES ("1", "5");
INSERT INTO `shared_notes` (`notes_id`, `user_id`)
VALUES ("1", "1");
INSERT INTO `shared_notes` (`notes_id`, `user_id`)
VALUES ("2", "1");
INSERT INTO `shared_notes` (`notes_id`, `user_id`)
VALUES ("6", "1");


