create table address
(
    id      varchar(36) not null,
    city    varchar(255),
    state   varchar(255),
    street  varchar(255),
    zipcode varchar(255),
    primary key (id)
);

create table user_account
(
    id         varchar(36)  not null,
    name       varchar(255) not null,
    email      varchar(255) not null,
    address_id varchar(36),
    primary key (id),
    constraint fk_user_account_address_id foreign key (address_id) references address (id)
);