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
