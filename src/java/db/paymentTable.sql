/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  TED
 * Created: 21/04/2021
 */

CREATE TABLE PAYMENT(
    PAYMENTID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100, INCREMENT BY 1),
    METHODID INTEGER NOT NULL,
    AMMOUNT DOUBLE NOT NULL,
    PAYMENTDATE VARCHAR(255),
    PRIMARY KEY(PAYMENTID)
);

insert into IOTDB."PAYMENT"(PAYMENTID,METHODID,AMMOUNT,PAYMENTDATE)
    values (123, 765, 12.30, '10/04/21'),
           (123, 765, 35.00, '09/04/21'),
           (423, 232, 38.20, '08/04/21'),
           (232, 534, 145.50, '06/04/21');