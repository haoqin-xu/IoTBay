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

insert into IOTDB.CUSTOMER(EMAIL,"NAME",PASSWORD,PHONE,ADDRESS,DOB,"ROLE")
values ('steve@mail.com', 'steve', '1234', '12345678', 'steve ADDRESS', 'steve DOB','Customer'),
       ('jim@mail.com', 'jim', 'qwerty', '87654321', 'jim ADDRESS', 'jim DOB','Customer'),
       ('bob@mail.com', 'bob', 'asdf', '14253647', 'bob ADDRESS', 'bob DOB','Customer'),
       ('a@mail.com', 'steve', '1234', '12345678', 'steve ADDRESS', 'steve DOB','Customer'),
       ('bteve@mail.com', 'bteve', '1234', '12345678', 'ADDRESS', 'DOB','Customer'),
       ('cteve@mail.com', 'cteve', '2314', '12345678', 'ADDRESS', 'DOB','Customer'),
       ('dteve@mail.com', 'dteve', '2452', '12345678', 'ADDRESS', 'DOB','Customer'),
       ('eteve@mail.com', 'eteve', '1678', '12345678', 'ADDRESS', 'DOB','Customer'),
       ('fteve@mail.com', 'fteve', '5790', '12345678', 'ADDRESS', 'DOB','Customer'),
       ('gteve@mail.com', 'gteve', '3578', '12345678', 'ADDRESS', 'DOB','Customer'),
       ('hteve@mail.com', 'hteve', '7535', '12345678', 'ADDRESS', 'DOB','Customer'),
       ('iteve@mail.com', 'iteve', '1468', '12345678', 'ADDRESS', 'DOB','Customer'),
       ('jteve@mail.com', 'jteve', '4670', '12345678', 'ADDRESS', 'DOB','Customer'),
       ('kteve@mail.com', 'kteve', '4578', '12345678', 'ADDRESS', 'DOB','Customer'),
       ('lteve@mail.com', 'lteve', '4678', '12345678', 'ADDRESS', 'DOB','Customer'),
       ('mteve@mail.com', 'mteve', '5790', '12345678', 'ADDRESS', 'DOB','Customer'),
       ('nteve@mail.com', 'nteve', '0457', '12345678', 'ADDRESS', 'DOB','Customer'),
       ('oteve@mail.com', 'oteve', '6160', '12345678', 'ADDRESS', 'DOB','Customer'),
       ('pteve@mail.com', 'pteve', '5679', '12345678', 'ADDRESS', 'DOB','Customer'),
       ('qteve@mail.com', 'qteve', '9626', '12345678', 'ADDRESS', 'DOB','Customer'),
       ('rteve@mail.com', 'rteve', '2568', '12345678', 'ADDRESS', 'DOB','Customer');
       
      