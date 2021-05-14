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
    ACCOUNTNUMBER VARCHAR(255) NOT NULL,
    CCV INTEGER NOT NULL,
    PRIMARY KEY(MEHTODID)
);

insert into IOTDB."PAYMENTMEHTOD"(METHODID,CUSTOMERID,PAYMENTTYPE,ACCOUNTNUMBER,CCV)
    values (1, 765, 'Credit Card', 1234532345 ,124),
           (2, 765, 'Debit Card', 35423423 ,434),
           (3, 12, 'Prepaid Card', 23423423 ,342),
           (4, 23, 'Credit Card', 4334234232 ,532);
