This directory provides code source for the data access chapter which covers both
JDBC and ORM technologies. For the latter, the following tools are supported:

- Hibernate (annotations)
- Hibernate JPA (JPA)
- OpenJPA (JPA)
- EclipseLink (JPA)

When trying to execute integration tests, you need to reconfigure the ch07-dataaccess-simple
project with the necessary value for the Import-Package header of this component.
To do that, you need to edit the pom.xml file and uncomment the right block at its
end.

You can then execute the following command to execute test: mvn test

1°) Executing JDBC sample

- Updates the pom.xml of the ch07-dataaccess-simple project and uncomment the code
under the text "For JDBC: uncomment the following configuration block".

- Builds and installs the ch07-dataaccess-simple project using the following
command: mvn install

- Builds and installs the ch07-jdbc-simple project using the following
command: mvn install

- Executes JDBC integration tests for the ch07-jdbc-integration-tests project with
the following command: mvn test

2°) Executing Hibernate sample

- Updates the pom.xml of the ch07-dataaccess-simple project and uncomment the code
under the text "For Hibernate: uncomment the following configuration block".

- Builds and installs the ch07-dataaccess-simple project using the following
command: mvn install

- Builds and installs the ch07-hibernate-simple project using the following
command: mvn install

- Executes Hibernate integration tests of the ch07-hibernate-integration-tests project
with the following command: mvn test

3°) Executing Hibernate JPA sample

- Updates the pom.xml of the ch07-dataaccess-simple project and uncomment the code
under the text "For Hibernate JPA: uncomment the following configuration block".

- Builds and installs the ch07-dataaccess-simple project using the following
command: mvn install

- Builds and installs the ch07-jpa-hibernatejpa-simple project using the following
command: mvn install

- Executes Hibernate JPA integration tests of the ch07-jpa-hibernatejpa-integration-tests
project with the following command: mvn test

4°) Executing OpenJPA sample

- Updates the pom.xml of the ch07-dataaccess-simple project and uncomment the code
under the text "For OpenJPA: uncomment the following configuration block".

- Adds bundles org.eclipse.equinox.weaving.hook and org.eclipse.equinox.weaving.springweaver
within Maven using the command mvn install:install-file. These files are available
in the directory container/bundles/bundles-openjpa.

mvn install:install-file -Dfile=container/bundles/bundles-openjpa/org.eclipse.equinox.weaving.hook_1.0.0.200905031323.jar
  -DgroupId=org.eclipse.equinox
  -DartifactId=org.eclipse.equinox.weaving.hook
  -Dversion=1.0.0.200905031323
  -Dpackaging=bundle
  -DgeneratePom=true

mvn install:install-file -Dfile=container/bundles/bundles-openjpa/org.eclipse.equinox.weaving.springweaver_0.1.0.jar
  -DgroupId=org.eclipse.equinox
  -DartifactId=org.eclipse.equinox.weaving.springweaver
  -Dversion=0.1.0
  -Dpackaging=bundle
  -DgeneratePom=true

- Builds and installs the ch07-jpa-openjpa-simple project using the following
command: mvn install

- Executes OpenJPA integration tests of the ch07-jpa-openjpa-integration-tests
project with the following command: mvn test

5°) Executing EclipseLink sample

- Updates the pom.xml of the ch07-dataaccess-simple project and uncomment the code
under the text "For EclipseLink: uncomment the following configuration block".

- Builds and installs the ch07-dataaccess-simple project using the following
command: mvn install

- Adds bundles org.eclipse.equinox.weaving.hook and org.eclipse.equinox.weaving.springweaver
within Maven using the command mvn install:install-file. These files are available
in the directory container/bundles/bundles-eclipselink.

mvn install:install-file -Dfile=container/bundles/bundles-eclipselink/org.eclipse.equinox.weaving.hook_1.0.0.200905031323.jar
  -DgroupId=org.eclipse.equinox
  -DartifactId=org.eclipse.equinox.weaving.hook
  -Dversion=1.0.0.200905031323
  -Dpackaging=bundle
  -DgeneratePom=true

mvn install:install-file -Dfile=container/bundles/bundles-eclipselink/org.eclipse.equinox.weaving.springweaver_0.1.0.jar
  -DgroupId=org.eclipse.equinox
  -DartifactId=org.eclipse.equinox.weaving.springweaver
  -Dversion=0.1.0
  -Dpackaging=bundle
  -DgeneratePom=true

- Builds and installs the ch07-jpa-eclipselink-simple project using the following
command: mvn install

- Executes EclipseLink integration tests of the ch07-jpa-eclipselink-integration-tests
project with the following command: mvn test

