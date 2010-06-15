Spring DM in action appendix D code samples

 - database directory: contains the H2 database to test the Commons DBCP datasource.
 Launch the database with the h2.sh or h2.bat script.
 - dbapp directory: contains the modular Maven 2 project created with Pax Construct. Launch
 the mvn clean install pax:provision to test the datasource. You can stop/start the
 dbapp.client and dbapp.query.client to see the database being queried.