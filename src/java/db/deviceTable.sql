/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  TED
 * Created: 21/04/2021
 */

CREATE TABLE DEVICE(
    DEVICEID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100, INCREMENT BY 1),
    "NAME" VARCHAR(20) NOT NULL,
    MANUFACTURER VARCHAR(20),
    ORIGIN VARCHAR(20),
    "TYPE" VARCHAR(20),
    INSTOCK BOOLEAN,
    PRICEPERUNIT DOUBLE NOT NULL,
    STOCK_NUM INTEGER NOT NULL,
    PRIMARY KEY(DEVICEID)
);


insert into IOTDB."DEVICE"("NAME",MANUFACTURER,ORIGIN,"TYPE",INSTOCK,PRICEPERUNIT,STOCK_NUM)
values ('10mm flat','Simons Screws', 'USA', 'Screws', TRUE, 5.5, 10),
       ('Light Detector','Light Flux', 'USA', 'Sensor', TRUE, 6.5, 10),
       ('Light Transmitter','Light Flux', 'USA', 'Sensor', TRUE, 5.0, 10),
       ('1080p 60Hz','LCDs', 'China', 'Monitor', TRUE, 230.50, 10),
       ('2080p 144Hz','LCDs', 'China', 'Monitor', TRUE, 680, 10),
       ('SSD 1TB','Solid Solutions', 'Japan', 'Memory', TRUE, 250, 10),
       ('SSD 4TB','Solid Solutions', 'Japan', 'Memory', TRUE, 700.5, 10),
       ('Blue LED','Lighting Guys', 'Australia', 'Light', TRUE, 0.6, 10),
       ('Red LED','Lighting Guys', 'Australia', 'Light', TRUE, 0.6, 10),
       ('Yellow LED','Lighting Guys', 'Australia', 'Light', TRUE, 0.6, 10),
       ('Green LED','Lighting Guys', 'Australia', 'Light', TRUE, 0.6, 10),
       ('24pc Screw Driver kit','Handees', 'Australia', 'Tools', TRUE, 60.5, 10),
       ('12pc Screw Driver kit','Handees', 'Australia', 'Tools', TRUE, 16.5, 10),
       ('5mm flat','Simons Screws', 'USA', 'Screws', TRUE, 5.5, 10),
       ('3mm flat','Simons Screws', 'USA', 'Screws', TRUE, 5.5, 10),
       ('Electrical tape','Handees', 'Australia', 'Tools', TRUE, 12.95, 10),
       ('750W PSU','Power2U', 'England', 'PSU', TRUE, 749.99, 10),
       ('500W PSU','Power2U', 'England', 'PSU', TRUE, 499.99, 10),
       ('1000W PSU','Power2U', 'England', 'PSU', TRUE, 1000, 10),
       ('16GB RAM','Solid Solutions', 'Japan', 'Memory', TRUE, 239, 10);
