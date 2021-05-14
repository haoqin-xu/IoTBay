/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Briana Margetts
 * Created: 14/05/2021
 */

CREATE TABLE "PAYMENTMETHOD"(
    METHODID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100, INCREMENT BY 1),
    CUSTOMERID INTEGER NOT NULL,
    PAYMENTTYPE VARCHAR(255) NOT NULL,
    ACCOUNTNUMBER  INTEGER NOT NULL,
    CCV INTEGER NOT NULL,
    PRIMARY KEY(METHODID)
);

insert into IOTDB."PAYMENTMETHOD"(CUSTOMERID,PAYMENTTYPE,ACCOUNTNUMBER,CCV)
    values ( 765, 'Credit Card', 1235345 ,124),
           (765, 'Debit Card', 352323 ,434),
           ( 12, 'Prepaid Card', 234323 ,342),
           (23, 'Credit Card', 433432 ,532);