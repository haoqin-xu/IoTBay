/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  TED
 * Created: 21/04/2021
 */

CREATE TABLE "PAYMENT"(
    PAYMENTID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100, INCREMENT BY 1),
    CUSTOMERID INTEGER NOT NULL,
    PAYMENTMETHOD VARCHAR(255) NOT NULL,
    ACCOUNTNUMBER VARCHAR(255) NOT NULL,
    CVVNUMBER INTEGER NOT NULL,
    AMOUNT DOUBLE NOT NULL,
    PAYMENTDATE VARCHAR(255),
    PRIMARY KEY(PAYMENTID)
);

insert into IOTDB."PAYMENT"(CUSTOMERID,PAYMENTMETHOD,ACCOUNTNUMBER,CVVNUMBER,AMOUNT,PAYMENTDATE)
    values (123, 'mastercard', '11455344534', 765, 12.30, '1021'),
    values (123, 'mastercard', '11455344534', 765, 35.00, '0921'),
    values (423, 'mastercard', '13243232332', 232, 38.20, '0821'),
    values (232, 'mastercard', '23256445342', 534, 145.50, '0621');