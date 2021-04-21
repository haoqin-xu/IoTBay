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
    DEVICE_ID INTEGER(10) NOT NULL,
    ORDER_ID INTEGER(10) NOT NULL,
    "COUNT" INTEGER(10) NOT NULL,
    PRIMARY KEY(DEVICE_ID)
);