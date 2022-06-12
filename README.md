# List Adapter

This is a project that contains a List Adapter made in java. It uses the Vector class from [CLDC 1.1](https://docs.oracle.com/javame/config/cldc/ref-impl/cldc1.1/jsr139/index.html "CLDC1.1") as the adaptee of this class. The implementation allows function from the [J2RE 1.4.2](https://www2.cs.duke.edu/csed/java/jdk1.4.2/docs/api/index.html "J2RE 1.4.2") only.

---

### Sub-directories

The project is divided in 2 packages in the src folder:

1. myAdapter -> contains interfaces and classes that implements this adapter.
2. myTest -> contains tests for all the methods implemented in the myAdapter package.

---

### Dependencies

This project is run through [maven](https://maven.apache.org/download.cgi "Maven") dependencies. As so also Junit is passed as a dependency of the project. In the project directory there is a folder named: "apache-maven-3.8.5". It provides all the components to run the project and its tests. Follow the USAGE section below.

---

### USAGE (IMPORTANT)

In order to compile both of the packages open `compiler.sh`.
Script in the file:

```bash
apache-maven-3.8.5\bin\mvn.cmd clean
apache-maven-3.8.5\bin\mvn.cmd compiler:compile
apache-maven-3.8.5\bin\mvn.cmd mopiler:testCompile
```

.classes files will be created in the target folder.

In order to build the project open `builder.sh`.
Script in the file:

```bash
apache-maven-3.8.5\bin\mvn.cmd package
```

.jar file will be created in the target folder.

In order to create the javadoc documentation open `javadoc.sh`.
Script in the file:

```bash
apache-maven-3.8.5\bin\mvn.cmd javadoc:javadoc
apache-maven-3.8.5\bin\mvn.cmd javadoc:test-javadoc
```

apidocs and testapidocs javadocs will be created in the documentation folder. Just open the index.html file in those folder and you will be able to access the documentation.

If you ever want to clean the project, just type `apache-maven-3.8.5\bin\mvn.cmd clean`.

In order to run only the tests in myTest package type `apache-maven-3.8.5\bin\mvn.cmd test`.

In order to run the single TestRunner file type `apache-maven-3.8.5\bin\mvn.cmd -e exec:java -Dexec.mainClass="myTest.TestRunner" -Dexec.classpathScope="test"` which looks into myTest package and run the main() method.
