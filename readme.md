### Tut 05, Group 29
# IoTBay Project, Assignment 2

Briana Margetts 14057400

Hao-qin Xu 13572641

Dinh Hai Anh Le 13343001

Duc Le 13586413

Daniel Creak 12890024

ISD Wrk05, group 29

## Install GlassFish

The GlassFish server must be first installed. It can either be installed alongside netbeans IDE or independantly.

## Configure GlassFish domain

locate the glassfish /bin folder containing executables for the glassfish server.

This is usually in C:\Program Files\glassfish-[version]\glassfish\bin

First, start the GlassFish server primary process by running StartServ.bat file

Then run the asadmin.bat file, which opens an administrative console.

run the command `create-domain --adminport 5000 --profile developer --user admin domain2`

This creates a domain on port 5000 which the webapp will be deployed to.

run `start-domain domain2`, which will start the newly created domain.

## Deploy the .war file

Run the command `deploy --port 5000 -host localhost D:\path\to\war\file`

If successful, the WAR file will be deployed to domain 2, and is accessible at https://localhost:51395/Ass1_R0/