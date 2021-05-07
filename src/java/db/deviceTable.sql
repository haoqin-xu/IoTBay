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