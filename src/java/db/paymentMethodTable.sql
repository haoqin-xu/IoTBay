/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Briana Margetts
 * Created: 14/05/2021
 */
DROP TABLE "PAYMENTMETHOD";

CREATE TABLE "PAYMENTMETHOD"(
    METHODID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100, INCREMENT BY 1),
    CUSTOMERID INTEGER NOT NULL,
    PAYMENTTYPE VARCHAR(255) NOT NULL,
    ACCOUNTNUMBER  INTEGER NOT NULL,
    CCV INTEGER NOT NULL,
    PRIMARY KEY(METHODID),
    FOREIGN KEY(CUSTOMERID) REFERENCES CUSTOMER(ID)
);


insert into IOTDB."PAYMENTMETHOD"(CUSTOMERID,PAYMENTTYPE,ACCOUNTNUMBER,CCV)
    values (100, 'Credit Card', 122323 ,124),
           (100, 'Credit Card', 342642 ,124),
           (100, 'Debit Card', 223523 ,434),
           (100, 'Pre-paid Card', 223132 ,342),
           (100, 'Gift Card', 443643 ,232),
           (101, 'Credit Card', 342323 ,345),
           (101, 'Debit Card', 346373 ,233),
           (101, 'Pre-paid Card', 643535 ,443),
           (101, 'Gift Card', 353636 ,454),
           (102, 'Credit Card', 887654 ,345),
           (102, 'Debit Card', 565366 ,345),
           (102, 'Pre-paid Card', 836252 ,356),
           (102, 'Gift Card', 433235 ,467),
           (103, 'Credit Card', 638289 ,347),
           (103, 'Debit Card', 438853 ,734),
           (103, 'Pre-paid Card', 348239 ,744),
           (103, 'Gift Card', 948324 ,473),
           (103, 'Credit Card', 937234 ,467),
           (103, 'Debit Card', 834923 ,534),
           (103, 'Pre-paid Card', 948324 ,845);