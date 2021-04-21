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
    "ROLE" INTEGER(10) NOT NULL,
    PURCHASE_HISTORY ARRAY  NOT NULL,
    PAYMENTS ARRAY NOT NULL,
    PRIMARY KEY() 
);