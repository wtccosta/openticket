#!/bin/zsh
sudo rm -rf /opt/tomcat/webapps/opentickets*
rm -rf target
./mvnw clean package
sudo -u tomcat cp target/opentickets-0.0.1-SNAPSHOT.war /opt/tomcat/webapps/opentickets.war
clear
tail -f /opt/tomcat/logs/catalina.out 
