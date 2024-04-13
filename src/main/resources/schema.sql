
create table course (

    `id` BIGINT NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `author` varchar(255) NOT NULL,

    PRIMARY KEY (id)
);

-- insert into course(id, name, author)
-- values (1, 'Learn AWS', 'yimo22');