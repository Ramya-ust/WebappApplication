FROM tomcat:8.5.16-jre8-alpine

MAINTAINER Ramya

ADD target/OnlineBidding.war OnlineBidding.war

EXPOSE 8085

CMD ["catalina.sh","run"]