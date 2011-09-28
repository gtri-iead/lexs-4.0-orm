LEXS XMLBeans

Apache XMLBeans databinding library for LEXS 4.0 

Layout of the tree:
- README.txt    this file
- pom.xml       maven2 build file
- src           the source code
    -main/java  	java source code for various library utilities
    -main/xsd		LEXS 4.0 schemas
    -main/xsdconfig	contains the mappings for the XMLBeans
    -test/java  	library unit tests code
    -test/resources	the resource files needed for the test cases.

    
Prerequisites:
	Java 1.5
	Maven 2.0.9


To generate LEXS 4.0 XMLBeans databinding library run:
"mvn install" 

To generate a zip file of the project source, run:
"mvn assembly:assembly -DdescriptorId=src"

Test Cases:
- TestPublishDiscover.java defines test cases that test the marshalling and 
  unmarshalling of the generated publish discover XMLBeans.

- TestSearchRetrieve.java defines test cases that test the marshalling and 
  unmarshalling of the generated search retrieve XMLBeans.

- TestDomainExchange.java defines test cases that test the marshalling and 
  unmarshalling of the generated domain exchange XMLBeans.

- TestSubscribeNotify.java defines test cases that test the marshalling and 
  unmarshalling of the generated subscribe notify XMLBeans.

- ConversionAdapterTest.java defines the test case that is used to test the code
  that converts XMLBeans to JDOM elements, and vise versa.