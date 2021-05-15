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

insert into IOTDB."PAYMENTMETHOD"(CUSTOMERID,PAYMENTTYPE,ACCOUNTNUMBER,CCV)
    values (1, 'Credit Card', 122323 ,124),
           (2, 'Credit Card', 342642 ,124),
           (3, 'Debit Card', 223523 ,434),
           (4, 'Pre-paid Card', 223132 ,342),
           (5, 'Gift Card', 443643 ,232),
           (6, 'Credit Card', 342323 ,345),
           (7, 'Debit Card', 346373 ,233),
           (8, 'Pre-paid Card', 643535 ,443),
           (9, 'Gift Card', 353636 ,454),
           (10, 'Credit Card', 887654 ,345),
           (11, 'Debit Card', 565366 ,345),
           (12, 'Pre-paid Card', 836252 ,356),
           (13, 'Gift Card', 433235 ,467),
           (14, 'Credit Card', 638289 ,347),
           (15, 'Debit Card', 438853 ,734),
           (16, 'Pre-paid Card', 348239 ,744),
           (17, 'Gift Card', 948324 ,473),
           (18, 'Credit Card', 937234 ,467),
           (19, 'Debit Card', 834923 ,534),
           (20, 'Pre-paid Card', 948324 ,845);