CREATE TABLE product
(
  id identity,
  sku         varchar(20) not null,
  description varchar(50),
  json_info varchar(2000)
);

CREATE TABLE price
(
  id identity,
  product_id bigint,
  day        varchar(10)   not null,
  price      decimal(8, 2) not null
);

ALTER TABLE price
  ADD FOREIGN KEY (product_id) REFERENCES product (id);