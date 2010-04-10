Spring DM in action chapter 6 code samples

  - "bnd" directory: Commons DBCP OSGi-fication with plain bnd, with a bundle to test it.
  - commons-dbcp.osgi and commons-pool.osgi folders: Commons DBCP OSGi-fication with Maven 2 and Bnd Apache Felix Plugin.
  - directoy module: contact application, with SOA and extreme-modular approaches
  - paint module: Spring-powered paint application
  - ch06-integration-tests folder: integration tests for all the modules
  
before running integration tests, run a "mvn install" command so that the Maven 2 local repository contains the JAR files.

files with a "args" extension are configuration for PAX-RUNNER. You must build ("install goal") the modules before using as they refer to the Maven repository. Here the command:

pax-run --args=file:paint.args

If you use Windows:

pax-run "--args=file:paint.args"

do not forget to start the database (directory/database folder) before trying the directory samples!
The directory sample has one web page (http://localhost:8080/directory/contacts.htm) that reads the contacts from the database. 