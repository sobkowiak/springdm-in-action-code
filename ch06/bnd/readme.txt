Manning's "Spring DM in action", chapter 6 sample: OSGifying Commons DBCP with Bnd
Commons DBCP and its dependency Commons Pool can be OSGified with the following commands:
java -jar bnd-0.0.313.jar wrap -properties commons-pools-1.3.0.bnd commons-pool-1.3.jar
java -jar bnd-0.0.313.jar wrap -properties commons-dbcp-1.2.2.bnd commons-dbcp-1.2.2.jar

To test the OSGified DBCP, the sample comes with 2 projects:
  - dbcp-config-fragment: a fragment to add the HSQLDB driver package into the DBCP bundle imported packages
  - datasource: a Spring-powered bundle that configures a pool and tests it

Launch the HSQLDB server (in database directory) and launch Equinox (in the container directory), you should see a message on the console, telling the connection was successful.