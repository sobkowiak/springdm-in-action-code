This directory provides code source for the data access chapter which covers both
JDBC and JPA technologies. For the later, the following JPA implementations are
supported:
- Hibernate JPA
- OpenJPA
- EclipseLink

When trying to execute integration tests, you need to reconfigure the ch07-dataaccess-simple
with the necessary value for the Import-Package header of this component. To do that, you need
to need the pom.xml file and uncomment the right block at its end.
You need then to execute the command: mvn install

The generated jar file in the target directory of the project must be copied into the corresponding
sub directory of the container/bundles directory. For example, for OpenJPA, under container/bundles/bundles-openjpa.
