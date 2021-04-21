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
    "ROLE" INTEGER(10) NOT NULL,
    HISTORY Log ARRAY  NOT NULL,
    APPLICATION ACCESS LOG ARRAY NOT NULL,
    Device List ARRAY  NOT NULL,
    PRIMARY KEY("ROLE") 
);