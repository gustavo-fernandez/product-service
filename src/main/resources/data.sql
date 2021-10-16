INSERT INTO product (sku, description, json_info)
VALUES ('S0001', 'Mermelada', '{"fechaDeCreacion":"2020-01-01","fechaDeVencimiento":"2020-10-12","codigoProveedor":999}');
INSERT INTO product (sku, description)
VALUES ('S0002', 'Arroz');

INSERT INTO price (product_id, day, price)
VALUES ((SELECT id FROM product WHERE sku = 'S0001'), '2021-10-01', 2.12);
INSERT INTO price (product_id, day, price)
VALUES ((SELECT id FROM product WHERE sku = 'S0001'), '2021-10-02', 2.13);
INSERT INTO price (product_id, day, price)
VALUES ((SELECT id FROM product WHERE sku = 'S0001'), '2021-10-03', 12.0);