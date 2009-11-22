Spring DM in action chapter 6 code samples

module test.directory contains tests using the Spring TestContext Framework.

module test.mock contains tests based on Spring DM's mock objects.

modules directory-domain, directory-dao and directory-dao-jdbc make the sample application for integration tests. Module ch10-integration-tests contains the corresponding integration tests and module ch10-datasource-tests is DataSource bundle for the integration.

to launch the build:

mvn clean install -P equinox

there are also profiles (felix and knopflerfish) for the Felix and the Knopflerfish OSGi platforms.