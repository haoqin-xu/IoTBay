/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  TED
 * Created: 21/04/2021
 */
CREATE TABLE "INVOICE"(
    INVOICEID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100, INCREMENT BY 1),
    RECIPIENTEMAIL VARCHAR(255) NOT NULL,
    CONTENT VARCHAR(255) NOT NULL,
    PRIMARY KEY(INVOICEID)
);

