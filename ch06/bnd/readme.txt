Manning's "Spring DM in action", chapter 6 sample: OSGifying Commons DBCP with Bnd
Commons DBCP and its dependency Commons Pool can be OSGified with the following commands:
java -jar bnd-0.0.337.jar wrap -properties commons-pools-1.3.0.bnd commons-pool-1.3.jar
java -jar bnd-0.0.337.jar wrap -properties commons-dbcp-1.2.2.bnd commons-dbcp-1.2.2.jar

To test the OSGified DBCP, the sample comes with 2 projects:
  - dbcp-config-fragment: a fragment to add the H2 driver package into the DBCP bundle imported packages
  - datasource: a bundle with an activator that creates a connection pool and tests it.

build (package Maven goal) both projects and launches the datasource.args pax-runner file (pax-runner --args=file:datasource.args). You should see a message on the console, telling the connection was successful.