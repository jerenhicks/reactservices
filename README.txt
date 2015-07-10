To CREATE NEW MAVEN SPRING PROJECT:

-Set Variables
	- Add java home to jdk
	- Add %JAVA_HOME%/bin to path.

- In eclipse:
	- Create new project
	- Select dynamic web project
	- Give name and select next.
	- Select next again.
	- On Web Module Page, select 'Generate web.xml deployment descriptor'.
	- Select finish.
	- Right click project.
	- Select 'Configure' and 'Convert to Maven Project'
	- Select ok and finish.
	- Go to Window-> Preferences -> Java -> Installed JREs and make sure JDK is added. Java 7.

- Set up Spring MVC
	- Go to the pom.xml
	- Lookup the spring mvc maven information. This is an example:
  <properties>
 <spring.version>4.0.1.RELEASE</spring.version>
 </properties>
  <dependencies>
 <dependency>
 <groupId>org.springframework</groupId>
 <artifactId>spring-core</artifactId>
 <version>${spring.version}</version>
 </dependency>

 <dependency>
 <groupId>org.springframework</groupId>
 <artifactId>spring-web</artifactId>
 <version>${spring.version}</version>
 </dependency>

 <dependency>
 <groupId>org.springframework</groupId>
 <artifactId>spring-webmvc</artifactId>
 <version>${spring.version}</version>
 </dependency>

 		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${spring.version}</version>
		</dependency>
  </dependencies>


	- Right click the project, Maven -> Update Project.
	- Right click the project, Run as -> Maven install
	- Create dispatcher-servlet.xml in WebContent/WEB-INF
	- Add the following: 
	<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
	http://www.springframework.org/schema/beans/spring-beans-3.0.xsd 
	http://www.springframework.org/schema/context 
	http://www.springframework.org/schema/context/spring-context-3.0.xsd">

	<context:component-scan base-package="com.ocean.nuhuh.controllers" />

	</beans>
	-Open web.xml
	-Add the following:
		<servlet>
		<servlet-name>dispatcher</servlet-name>
		<servlet-class>
			org.springframework.web.servlet.DispatcherServlet
		</servlet-class>
		<load-on-startup>1</load-on-startup>
	</servlet>

	<servlet-mapping>
		<servlet-name>dispatcher</servlet-name>
		<url-pattern>/</url-pattern>
	</servlet-mapping>

	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/dispatcher-servlet.xml</param-value>
	</context-param>

	<listener>
		<listener-class>
			org.springframework.web.context.ContextLoaderListener
		</listener-class>
	</listener>
	
- Set up JPA
	- Install postgres 9.
	- Add the following to the pom.xml
	<postgres.version>9.3-1103-jdbc41</postgres.version>
	<hibernate.version>4.3.8.Final</hibernate.version>
	<dependency>
		<groupId>org.postgresql</groupId>
		<artifactId>postgresql</artifactId>
		<version>${postgres.version}</version>
	</dependency>
	<dependency>
		<groupId>org.hibernate</groupId>
		<artifactId>hibernate-core</artifactId>
		<version>${hibernate.version}</version>
	</dependency>
	- Add hibernate.properties to the src folder:
		hibernate.connection.driver_class = org.postgresql.Driver
		hibernate.connection.url = jdbc:postgresql://localhost:5432/nuhuh
		hibernate.connection.username = postgres
		hibernate.connection.password = Ashley5659!
		hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
		hibernate.current_session_context_class=thread
	-Add hibernate.cfg.xml to src folder:
		<?xml version="1.0" encoding="utf-8"?>
			<!DOCTYPE hibernate-configuration PUBLIC
			"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
			"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
			
			<hibernate-configuration>
				<session-factory>
					<property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
					<property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/nuhuh</property>
					<property name="hibernate.connection.username">postgres</property>
					<property name="hibernate.connection.password">Ashley5659!</property>
					<property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
					<property name="show_sql">true</property>
					<property name="format_sql">true</property>
					<property name="hbm2ddl.auto">create</property>
				</session-factory>
			</hibernate-configuration>
	

- Add Server
	- Click on the servers tab.
	- Click the link to add server.
	- Select apache and then server.
	- Open the dialog and select the install.
	- Click ok.
	- Add maven dependencies to web deployment assembly. (FILL ME IN)

- Start up
	- Add the project to the server.
	- http://localhost:8080/{project.name}/{controller.method}

- Set up Git
	- Go to bitbucket.
	- Click 'Create' and fill in info.
	- Click the 'I have an existing project' and copy the code and execute it in terminal.
	
- Set up to send datas via postman
	- set to post
	- click x-www-form-urlencoded on the presets.
	- set the values in the fields.