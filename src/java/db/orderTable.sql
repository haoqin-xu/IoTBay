/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  TED
 * Created: 21/04/2021
 */
CREATE TABLE "ORDER"(
    ORDERID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100, INCREMENT BY 1),
    CUSTOMERID INTEGER,
    PAYMENTID INTEGER NOT NULL,
    DEVICEID INTEGER NOT NULL,
    STATUS VARCHAR(255) NOT NULL,
    INVOICEID INTEGER NOT NULL,
    "DATE" VARCHAR(255) NOT NULL,
    PRIMARY KEY(ORDERID)
);

insert into IOTDB."ORDER"(ORDERID,CUSTOMERID,PAYMENTID,DEVICEID,STATUS,INVOICEID,"DATE")
values (100,100, 100, 100, "Pending", 100, '14/05/2021'),
       (101,100, 100, 101, "Pending", 101, '14/05/2021'),
       (102,100, 100, 102, "Pending", 102, '14/05/2021'),
       (103,100, 100, 103, "Pending", 103, '14/05/2021'),
       (104,100, 100, 104, "Pending", 104, '14/05/2021'),
       (105,100, 100, 105, "Pending", 105, '14/05/2021'),
       (106,100, 100, 106, "Pending", 106, '14/05/2021'),
       (107,100, 100, 107, "Pending", 107, '14/05/2021'),
       (108,100, 100, 108, "Pending", 108, '14/05/2021'),
       (109,100, 100, 109, "Pending", 109, '14/05/2021'),
       (110,100, 100, 110, "Pending", 110, '14/05/2021'),
       (111,100, 100, 111, "Pending", 111, '14/05/2021'),
       (112,100, 100, 112, "Pending", 112, '14/05/2021'),
       (113,100, 100, 113, "Pending", 113, '14/05/2021'),
       (114,100, 100, 114, "Pending", 114, '14/05/2021'),
       (115,100, 100, 115, "Pending", 115, '14/05/2021'),
       (116,100, 100, 116, "Pending", 116, '14/05/2021'),
       (117,100, 100, 117, "Pending", 117, '14/05/2021'),
       (118,100, 100, 118, "Pending", 118, '14/05/2021',
       (119,100, 100, 119, "Pending", 119, '14/05/2021'),