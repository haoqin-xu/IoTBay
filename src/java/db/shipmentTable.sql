/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  TED
 * Created: 21/04/2021
 */
CREATE TABLE SHIPMENT (
    SHIPMENT_ID INTEGER(10) NOT NULL,
    PAYMENT_ID INTEGER(10)  NOT NULL,
    SHIPPING_DATE VARCHAR(10) NOT NULL,
    STATUS VARCHAR(10) NOT NULL,
    SHIPPING_ADDRESS VARCHAR(100) NOT NULL,
    PRIMARY KEY(SHIPMENT_ID) 
);
