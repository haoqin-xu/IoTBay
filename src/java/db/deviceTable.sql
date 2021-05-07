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
    INSTOCK BOOLEAN, /* when inserting values 1 = instock and 0 = not instock*/
    STOCK_NUM INTEGER NOT NULL,
    PRIMARY KEY(DEVICEID)
);


insert into IOTDB."DEVICE"("NAME",MANUFACTURER,ORIGIN,INSTOCK,STOCK_NUM)
values ('item1','manu 1', 'Origin 1', TRUE, 10),
       ('item2','manu 2', 'Origin 2', TRUE, 10);
       ('item3','manu 3', 'Origin 3', TRUE, 10),
       ('item4','manu 4', 'Origin 4', TRUE, 10);
       ('item5','manu 5', 'Origin 5', TRUE, 10),
       ('item6','manu 6', 'Origin 6', TRUE, 10);
       ('item7','manu 7', 'Origin 7', TRUE, 10),
       ('item8','manu 8', 'Origin 8', TRUE, 10);
       ('item9','manu 9', 'Origin 9', TRUE, 10),
       ('item10','manu 10', 'Origin 10', TRUE, 10);
