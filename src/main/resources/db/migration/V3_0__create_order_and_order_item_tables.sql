create table warehouse
(
    id       varchar(36) not null,
    location varchar(255),
    primary key (id)
);

create table inventory_item
(
    id        varchar(36) not null,
    name      varchar(255),
    count     integer,
    warehouse varchar(36),
    primary key (id),
    constraint fk_inventory_item_warehouse_id foreign key (warehouse) references warehouse (id)
);