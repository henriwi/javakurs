javakurs
========

Demo-app til bruk i Javakurs

Installer Jetty: http://download.eclipse.org/jetty/stable-9/dist/

Utfør følgende kommandoer:


	git clone git@github.com:henriwi/javakurs.git
	cd javakurs
	mvn clean install
	cp nav-sbl-demo-web/target/nav-sbl-demo-web-1.0-SNAPSHOT.war ${jetty_home}/webapps/.

Start jetty: 
	
	java -jar ${jetty_home}/start.jar
 
Gå til http://localhost:8080/nav-demo

Åpne prosjektet i IDEA:

	File -> Open -> javakurs/pom.xml