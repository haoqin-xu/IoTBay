/* 
 * SQL statements to intialize the USER table for the IoTBay project
 */
/**
 * Author:  TED
 * Created: 21/04/2021
 */

-- WIP, will be changed later
CREATE TABLE "USER"(
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100000, INCREMENT BY 1),
    EMAIL VARCHAR(255) NOT NULL,
    "NAME" VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    PHONE VARCHAR(255) NOT NULL,
    GENDER VARCHAR(255) NOT NULL,
    DOB VARCHAR(255) NOT NULL,
    PRIMARY KEY(ID)
);