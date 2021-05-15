/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  TED
 * Created: 21/04/2021
 */


CREATE TABLE ORDERLINEITEM(
    DEVICEID INTEGER NOT NULL,
    ORDERID INTEGER NOT NULL,
    "COUNT" INTEGER,
    FOREIGN KEY(DEVICEID) REFERENCES DEVICE(DEVICEID),
    FOREIGN KEY(ORDERID) REFERENCES "ORDER"(ORDERID)
);

insert into IOTDB.ORDERLINEITEM(DEVICEID,ORDERID,"COUNT")
values (100,100,1),
       (101,101,1),
       (102,102,1),
       (103,103,1),
       (104,104,1),
       (105,105,1),
       (106,106,1),
       (107,107,1),
       (108,108,1),
       (109,109,1),
       (110,110,1),
       (111,111,1),
       (112,112,1),
       (113,113,1),
       (114,114,1),
       (115,115,1),
       (116,116,1),
       (117,117,1),
       (118,118,1),
       (119,119,1);

