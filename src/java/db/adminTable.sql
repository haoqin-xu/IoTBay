/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  TED
 * Created: 21/04/2021
 */

CREATE TABLE "ADMIN" (
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

insert into IOTDB.ADMIN(EMAIL,"NAME",PASSWORD,PHONE,ADDRESS,DOB,"ROLE")
values  ('adam@mail.com', 'adam', '1234', '12345678', 'adam ADDRESS', 'adam DOB','Admin'),
        ('james@mail.com', 'james', '0123', '12345678', 'james ADDRESS', 'james DOB','Admin'),
        ('kappa@mail.com', 'kappa', '0457', '12345678', 'kappa ADDRESS', 'kappa DOB','Admin'),
        ('wtf@mail.com', 'wtf', '9867', '12345678', 'wtf ADDRESS', 'wtf DOB','Admin'),
        ('bteve@mail.com', 'bteve', '1234', '12345678', 'ADDRESS', 'DOB','Admin'),
        ('cteve@mail.com', 'cteve', '2314', '12345678', 'ADDRESS', 'DOB','Admin'),
        ('dteve@mail.com', 'dteve', '2452', '12345678', 'ADDRESS', 'DOB','Admin'),
        ('eteve@mail.com', 'eteve', '1678', '12345678', 'ADDRESS', 'DOB','Admin'),
        ('fteve@mail.com', 'fteve', '5790', '12345678', 'ADDRESS', 'DOB','Admin'),
        ('gteve@mail.com', 'gteve', '3578', '12345678', 'ADDRESS', 'DOB','Admin'),
        ('hteve@mail.com', 'hteve', '7535', '12345678', 'ADDRESS', 'DOB','Admin'),
        ('iteve@mail.com', 'iteve', '1468', '12345678', 'ADDRESS', 'DOB','Admin'),
        ('jteve@mail.com', 'jteve', '4670', '12345678', 'ADDRESS', 'DOB','Admin'),
        ('kteve@mail.com', 'kteve', '4578', '12345678', 'ADDRESS', 'DOB','Admin'),
        ('lteve@mail.com', 'lteve', '4678', '12345678', 'ADDRESS', 'DOB','Admin'),
        ('mteve@mail.com', 'mteve', '5790', '12345678', 'ADDRESS', 'DOB','Admin'),
        ('nteve@mail.com', 'nteve', '0457', '12345678', 'ADDRESS', 'DOB','Admin'),
        ('oteve@mail.com', 'oteve', '6160', '12345678', 'ADDRESS', 'DOB','Admin'),
        ('pteve@mail.com', 'pteve', '5679', '12345678', 'ADDRESS', 'DOB','Admin'),
        ('qteve@mail.com', 'qteve', '9626', '12345678', 'ADDRESS', 'DOB','Admin'),
        ('rteve@mail.com', 'rteve', '2568', '12345678', 'ADDRESS', 'DOB','Admin');