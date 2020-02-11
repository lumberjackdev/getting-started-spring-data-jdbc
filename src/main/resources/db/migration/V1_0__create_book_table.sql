create table book (
    id varchar(36) not null,
    title varchar(255) not null,
    author varchar(255),
    isbn varchar(15),
    published_date date,
    page_count integer,
    primary key (id)
);