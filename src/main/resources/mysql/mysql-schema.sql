CREATE DATABASE product_db;

USE product_db;

CREATE TABLE product
(
  id          bigint auto_increment primary key,
  sku         varchar(20) not null,
  description varchar(50),
  json_info   varchar(2000)
);

CREATE TABLE price
(
  id         bigint auto_increment primary key,
  product_id bigint,
  day        varchar(10)   not null,
  price      decimal(8, 2) not null
);

ALTER TABLE price
  ADD FOREIGN KEY (product_id) REFERENCES product (id);