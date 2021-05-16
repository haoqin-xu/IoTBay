/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  TED
 * Created: 21/04/2021
 */

CREATE TABLE STAFF (
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

insert into IOTDB.STAFF(EMAIL,"NAME",PASSWORD,PHONE,ADDRESS,DOB,"ROLE")
values  ('wait@mail.com', 'wait', '3585', '12345678', 'wait ADDRESS', 'wait DOB','Staff'),
        ('tako@mail.com', 'tako', '8963', '12345678', 'tako ADDRESS', 'tako DOB','Staff'),
        ('shork@mail.com', 'shork', '4563', '12345678', 'shork ADDRESS', 'shork DOB','Staff'),
        ('jack@mail.com', 'jack', '8925', '12345678', 'jack ADDRESS', 'jack DOB','Staff'),
        ('bteve@mail.com', 'bteve', '1234', '12345678', 'ADDRESS', 'DOB','Staff'),
        ('cteve@mail.com', 'cteve', '2314', '12345678', 'ADDRESS', 'DOB','Staff'),
        ('dteve@mail.com', 'dteve', '2452', '12345678', 'ADDRESS', 'DOB','Staff'),
        ('eteve@mail.com', 'eteve', '1678', '12345678', 'ADDRESS', 'DOB','Staff'),
        ('fteve@mail.com', 'fteve', '5790', '12345678', 'ADDRESS', 'DOB','Staff'),
        ('gteve@mail.com', 'gteve', '3578', '12345678', 'ADDRESS', 'DOB','Staff'),
        ('hteve@mail.com', 'hteve', '7535', '12345678', 'ADDRESS', 'DOB','Staff'),
        ('iteve@mail.com', 'iteve', '1468', '12345678', 'ADDRESS', 'DOB','Staff'),
        ('jteve@mail.com', 'jteve', '4670', '12345678', 'ADDRESS', 'DOB','Staff'),
        ('kteve@mail.com', 'kteve', '4578', '12345678', 'ADDRESS', 'DOB','Staff'),
        ('lteve@mail.com', 'lteve', '4678', '12345678', 'ADDRESS', 'DOB','Staff'),
        ('mteve@mail.com', 'mteve', '5790', '12345678', 'ADDRESS', 'DOB','Staff'),
        ('nteve@mail.com', 'nteve', '0457', '12345678', 'ADDRESS', 'DOB','Staff'),
        ('oteve@mail.com', 'oteve', '6160', '12345678', 'ADDRESS', 'DOB','Staff'),
        ('pteve@mail.com', 'pteve', '5679', '12345678', 'ADDRESS', 'DOB','Staff'),
        ('qteve@mail.com', 'qteve', '9626', '12345678', 'ADDRESS', 'DOB','Staff'),
        ('rteve@mail.com', 'rteve', '2568', '12345678', 'ADDRESS', 'DOB','Staff');