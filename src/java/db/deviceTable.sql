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
    INSTOCK BOOLEAN, /* when inserting values 1 = instock and 0 = not instock*/
    PRICEPERUNIT DOUBLE NOT NULL,
    STOCK_NUM INTEGER NOT NULL,
    PRIMARY KEY(DEVICEID)
);


insert into IOTDB."DEVICE"("NAME",MANUFACTURER,ORIGIN,"TYPE",INSTOCK,PRICEPERUNIT,STOCK_NUM)
values ('item1','manu 1', 'Origin 1', 'Screws', TRUE, 5.5, 10),
       ('item2','manu 2', 'Origin 2', 'Tools', TRUE, 6.5, 10),
       ('item3','manu 3', 'Origin 3', 'Saws', TRUE, 5.0, 10),
       ('item4','manu 4', 'Origin 4', 'Nails', TRUE, 8.0, 10),
       ('item5','manu 5', 'Origin 5', 'Monitor', TRUE, 7.8, 10),
       ('item6','manu 6', 'Origin 6', 'GPU', TRUE, 6.5, 10),
       ('item7','manu 7', 'Origin 7', 'CPU', TRUE, 5.5, 10),
       ('item8','manu 8', 'Origin 8', 'Spade', TRUE, 5.6, 10),
       ('item9','manu 9', 'Origin 9', 'Hammer', TRUE, 7.6, 10),
       ('item10','manu 10', 'Origin 10', 'Driver', TRUE, 9.5, 10),
       ('item11','manu 11', 'Origin 11', 'Screws', TRUE, 5.5, 10),
       ('item12','manu 12', 'Origin 12', 'Tools', TRUE, 6.5, 10),
       ('item13','manu 13', 'Origin 13', 'Saws', TRUE, 5.0, 10),
       ('item14','manu 14', 'Origin 14', 'Nails', TRUE, 8.0, 10),
       ('item15','manu 15', 'Origin 15', 'Monitor', TRUE, 7.8, 10),
       ('item16','manu 16', 'Origin 16', 'GPU', TRUE, 6.5, 10),
       ('item17','manu 17', 'Origin 17', 'CPU', TRUE, 5.5, 10),
       ('item18','manu 18', 'Origin 18', 'Spade', TRUE, 5.6, 10),
       ('item19','manu 19', 'Origin 19', 'Hammer', TRUE, 7.6, 10),
       ('item20','manu 20', 'Origin 20', 'Driver', TRUE, 9.5, 10);
