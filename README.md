jws-issue
=========

bug reproduction for java web start


bug description
java web start when runs against 1.7.0_45 fails setting jvm properties via resources/property elements in jnlp description (http://docs.oracle.com/javase/7/docs/technotes/guides/javaws/developersguide/syntax.html#resources)

preriquisites:
- jdk 1.7.0_40 (where it works)
java version "1.7.0_40"
Java(TM) SE Runtime Environment (build 1.7.0_40-b43)
Java HotSpot(TM) 64-Bit Server VM (build 24.0-b56, mixed mode)
- jdk 1.7.0_45 (where it fails)
java version "1.7.0_45"
Java(TM) SE Runtime Environment (build 1.7.0_45-b18)
Java HotSpot(TM) 64-Bit Server VM (build 24.45-b08, mixed mode)
- mvn 3.x (for building)
Apache Maven 3.0.3 (r1075438; 2011-02-28 18:31:09+0100)
Maven home: /opt/mvn/maven
Java version: 1.7.0_45, vendor: Oracle Corporation
Java home: /opt/jvm/jdk1.7.0_45/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "3.0.0-32-generic", arch: "amd64", family: "unix"
- (optional) git to clone project from github via following in cmd "git clone https://github.com/lrozek/jws-issue.git"



how to reproduce:
- first build application and run it, via mvn clean package
- run following command to execute application javaws http://localhost:8080/jws-backend/webstart/launch.jnlp
- please accept warning about untrusted issuer
- you should see simple swing application displaying jvm properties
- first line displays if system property ("custom_property") is present in jvm or not. Possible values are: YES, NO
- second line displays value of this property. it should be "ifYouSeeThisValueThanJwsPickedUpThisProperty". In case this property is missing it will display null
- in the table below all properties are displayed