To run this project through maven command, use:
mvn clean test -Dtestngfilename=testng.xml -Dgroups=regression -Durl=https://www.ajio.com/

To run failed test cases
mvn clean test -Dtestngfilename=test-output/testng-failed.xml -Dgroups=regression -Durl=https://www.ajio.com/