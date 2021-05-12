/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  TED
 * Created: 21/04/2021
 */

CREATE TABLE CUSTOMER (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100, INCREMENT BY 1),
    EMAIL VARCHAR(255) NOT NULL,
    "NAME" VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    PHONE VARCHAR(255) NOT NULL,
    ADDRESS VARCHAR(255) NOT NULL,
    DOB VARCHAR(255) NOT NULL,
    "ROLE" VARCHAR(255) NOT NULL,
    PRIMARY KEY(ID)
);

insert into IOTDB.CUSTOMER(ID,EMAIL,"NAME",PASSWORD,PHONE,ADDRESS,DOB,"ROLE")
values ('100','steve@mail.com', 'steve', '1234', '12345678', 'steve ADDRESS', 'steve DOB','Customer'),
       ('101','jim@mail.com', 'jim', 'qwerty', '87654321', 'jim ADDRESS', 'jim DOB','Customer'),
       ('102','bob@mail.com', 'bob', 'asdf', '14253647', 'bob ADDRESS', 'bob DOB','Customer');
      