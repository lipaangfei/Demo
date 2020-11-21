export MAVEN_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,address=8099,server=y,suspend=n"
mvn clean -Djetty.port=8082 jetty:run -Dorg.eclipse.jetty.annotations.maxWait=120%
