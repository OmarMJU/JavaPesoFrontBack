FROM tomcat:8.0.39-jre8-alpine
MAINTAINER omarmju@icloud.com
#ENV dbDriver=com.mysql.jdbc.Driver dbConnectionURL=jdbc:mysql://MySQL_Container:3306/prueba dbUserName=root dbPassword=root
COPY web-app.war /usr/local/tomcat/webapps/
