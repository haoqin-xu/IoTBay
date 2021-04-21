This folder contains all the SQL scripts used to setup the IoTBay database.

## Setup Procedure

First, create a new database called *iotdb* in the `Databases/Java DB` tab under the `Services` tab inside netbeans IDE.

Set *Database Name* as `iotdb`, *User Name* as `iotdb`, and *Password* as `iotdb`. (it is very important you use these exact values as the SQL scripts used to populate the database will reference the database name and the user name of the database, so we must all have the same values or the scripts won't work)

After creating the database, double click or right click and select 'Connect' on the connection string to connect to the *iotdb* database.

Navigate to *IOTDB/Tables*, right click the 'Tables' tab and select 'Execute Command'.

You can now proceed to paste in all the scripts within this folder in order to initialise the different tables and populate the database with dummy data.