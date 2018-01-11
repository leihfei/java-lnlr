<?xml version="1.0" encoding="UTF-8"?>
<configuration>
	<appender name="console" class="ch.qos.logback.core.ConsoleAppender">
		<encoder>
			<pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
		</encoder>
	</appender>

	<appender name="rollingFile" class="ch.qos.logback.core.rolling.RollingFileAppender">
		<file>logs/${projectName}.log</file>
		<rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
			<fileNamePattern>logs/${projectName}.%d{yyyy-MM-dd}.log</fileNamePattern>
		</rollingPolicy>
		<encoder>
			<pattern>%d [%thread] %-5level %logger{36} - %msg%n</pattern>
		</encoder>
	</appender>

	<!-- project default level -->
	<logger name="com.anycc" level="INFO" />

	<!--log4jdbc -->
	<!-- <logger name="jdbc.sqltiming" level="INFO"/> -->

	<root level="ERROR">
		<appender-ref ref="console" />
		<appender-ref ref="rollingFile" />
	</root>
</configuration>