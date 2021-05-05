/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  TED
 * Created: 21/04/2021
 */

CREATE TABLE ADMIN (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100, INCREMENT BY 1),
    EMAIL VARCHAR(255) NOT NULL,
    "NAME" VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    PHONE VARCHAR(255) NOT NULL,
    GENDER VARCHAR(255) NOT NULL,
    DOB VARCHAR(255) NOT NULL,
    "ROLE" INTEGER(10) NOT NULL,
    USERS ARRAY  NOT NULL,
    HISTORY_LOG ARRAY NOT NULL,
    PRIMARY KEY(ID) 
);