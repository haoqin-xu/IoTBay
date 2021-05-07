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

INSERT INTO ORDERLINEITEM(ORDERID, DEVICEID) 
(SELECT "ORDER".ORDERID, DEVICE.DEVICEID
FROM "ORDER", DEVICE WHERE "ORDER".DEVICEID = DEVICE.DEVICEID)