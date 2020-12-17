package com.opendatapolicing.enus.main.pom;

/**
 * ContentType: application/xml
 * DisplayName.enUS: opendatapolicing/pom.xml
 * Map.hackathonMission: to define the Maven POM file to define the version dependencies and build plugins for the opendatapolicing project
 */     
public class PomXml {

	/**
	 * DisplayName.enUS: Maven artifact
	 * enUS: Create a new file: /usr/local/src/opendatapolicing/pom.xml
	 * enUS: 
	 * enUS: Setup a Maven groupId, artifactId and version for the opendatapolicing project. 
	 */
	public void partArtifact() {
//<?xml version="1.0" encoding="UTF-8" standalone="no"?>
//<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
//
//	<modelVersion>4.0.0</modelVersion>
//	<groupId>com.opendatapolicing</groupId>
//	<artifactId>opendatapolicing</artifactId>
//	<version>1.0.1-SNAPSHOT</version>
//	<name>opendatapolicing</name>
//	<description></description>
	}

	/**
	 * DisplayName.enUS: Maven properties
	 * enUS: Setup the version properties of the various Maven plugins. 
	 */
	public void partProperties() {
//
//	<properties>
//		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
//		<vertx.verticle>com.opendatapolicing.enUS.vertx.AppVertx</vertx.verticle>
//
//		<!-- maven plugin versions -->
//		<maven-compiler-plugin.version>3.6.0</maven-compiler-plugin.version>
//		<maven-surefire-plugin.version>2.19.1</maven-surefire-plugin.version>
//		<vertx-maven-plugin.version>1.0.9</vertx-maven-plugin.version>
//		<build-helper-maven-plugin.version>3.0.0</build-helper-maven-plugin.version>
//		<exec-maven-plugin.version>1.5.0</exec-maven-plugin.version>
//		<vertx.version>3.8.5</vertx.version>
//	</properties>
	}

	/**
	 * DisplayName.enUS: Apache Commons Dependencies
	 * enUS: Setup the Apache Commons dependencies for common libraries. 
	 */
	public void partDependenciesCommon() {
//
//	<dependencies>
//
//		<!-- Apache Commons -->
//		<dependency>
//			<groupId>commons-beanutils</groupId>
//			<artifactId>commons-beanutils</artifactId>
//			<version>1.9.4</version>
//		</dependency>
//		<dependency>
//			<groupId>org.apache.commons</groupId>
//			<artifactId>commons-configuration2</artifactId>
//			<version>2.7</version>
//		</dependency>
//		<dependency>
//			<groupId>commons-dbutils</groupId>
//			<artifactId>commons-dbutils</artifactId>
//			<version>1.7</version>
//		</dependency>
//		<dependency>
//			<groupId>org.apache.commons</groupId>
//			<artifactId>commons-exec</artifactId>
//			<version>1.3</version>
//		</dependency>
//		<dependency>
//			<groupId>org.apache.commons</groupId>
//			<artifactId>commons-text</artifactId>
//			<version>1.8</version>
//		</dependency>
	}

	/**
	 * DisplayName.enUS: PostgreSQL Dependencies
	 * enUS: Setup the PostgreSQL dependencies for persistence and database integration. 
	 */
	public void partDependenciesDatabase() {
//
//		<!-- PostgreSQL Database -->
//		<dependency>
//			<groupId>org.postgresql</groupId>
//			<artifactId>postgresql</artifactId>
//			<version>42.2.2.jre7</version>
//		</dependency>
	}

	/**
	 * DisplayName.enUS: Apache Solr Dependencies
	 * enUS: Setup the Apache Solr dependencies for advanced search engine integration and analytics. 
	 */
	public void partDependenciesSearchEngine() {
//
//		<!-- Apache Solr Search Engine -->
//		<dependency>
//			<groupId>org.apache.solr</groupId>
//			<artifactId>solr-solrj</artifactId>
//			<version>8.4.1</version>
//		</dependency>
	}

	/**
	 * DisplayName.enUS: Flying Saucer Dependencies
	 * enUS: Setup the Flying Saucer dependencies for PDF file generation. 
	 */
	public void partDependenciesPdf() {
//
//		<!-- PDF Generation -->
//		<dependency>
//			<groupId>org.xhtmlrenderer</groupId>
//			<artifactId>flying-saucer-core</artifactId>
//			<version>9.1.19</version>
//		</dependency>
//		<dependency>
//			<groupId>org.xhtmlrenderer</groupId>
//			<artifactId>flying-saucer-swt</artifactId>
//			<version>9.1.19</version>
//		</dependency>
//		<dependency>
//			<groupId>org.xhtmlrenderer</groupId>
//			<artifactId>flying-saucer-pdf-itext5</artifactId>
//			<version>9.1.19</version>
//		</dependency>
//		<dependency>
//			<groupId>com.github.librepdf</groupId>
//			<artifactId>openpdf</artifactId>
//			<version>1.3.11</version>
//		</dependency>
//		<dependency>
//			<groupId>com.itextpdf</groupId>
//			<artifactId>itext-asian</artifactId>
//			<version>5.2.0</version>
//		</dependency>
	}

	/**
	 * DisplayName.enUS: Vert.X Dependencies
	 * enUS: Setup the Vert.X dependencies for reactive, asynchronous, scalable application deployable on OpenShift. 
	 */
	public void partDependenciesVertx() {
//
//		<!-- Vert.X -->
//		<dependency>
//			<groupId>io.netty</groupId>
//			<artifactId>netty-codec-http</artifactId>
//			<version>4.1.45.Final</version>
//		</dependency>
//		<dependency>
//			<groupId>io.netty</groupId>
//			<artifactId>netty-codec</artifactId>
//			<version>4.1.45.Final</version>
//		</dependency>
//		<dependency>
//			<groupId>io.netty</groupId>
//			<artifactId>netty-transport</artifactId>
//			<version>4.1.45.Final</version>
//		</dependency>
//		<dependency>
//			<groupId>io.netty</groupId>
//			<artifactId>netty-buffer</artifactId>
//			<version>4.1.45.Final</version>
//		</dependency>
//		<dependency>
//			<groupId>io.netty</groupId>
//			<artifactId>netty-common</artifactId>
//			<version>4.1.45.Final</version>
//		</dependency>
//		<dependency>
//			<groupId>io.netty</groupId>
//			<artifactId>netty-handler</artifactId>
//			<version>4.1.46.Final</version>
//		</dependency>
//		<dependency>
//			<groupId>io.netty</groupId>
//			<artifactId>netty-transport-native-epoll</artifactId>
//			<version>4.1.45.Final</version>
//		</dependency>
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-core</artifactId>
//			<version>${vertx.version}</version>
//		</dependency>
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-web</artifactId>
//			<version>${vertx.version}</version>
//			<exclusions>
//				<exclusion>
//					<groupId>io.netty</groupId>
//					<artifactId>netty-common</artifactId>
//				</exclusion>
//				<exclusion>
//					<groupId>io.netty</groupId>
//					<artifactId>netty-buffer</artifactId>
//				</exclusion>
//				<exclusion>
//					<groupId>io.netty</groupId>
//					<artifactId>netty-codec</artifactId>
//				</exclusion>
//				<exclusion>
//					<groupId>io.netty</groupId>
//					<artifactId>netty-codec-http</artifactId>
//				</exclusion>
//				<exclusion>
//					<groupId>io.netty</groupId>
//					<artifactId>netty-handler</artifactId>
//				</exclusion>
//				<exclusion>
//					<groupId>io.netty</groupId>
//					<artifactId>netty-transport</artifactId>
//				</exclusion>
//			</exclusions>
//		</dependency>
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-zookeeper</artifactId>
//			<version>${vertx.version}</version>
//		</dependency>
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-pg-client</artifactId>
//			<version>${vertx.version}</version>
//		</dependency>
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-auth-oauth2</artifactId>
//			<version>${vertx.version}</version>
//		</dependency>
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-reactive-streams</artifactId>
//			<version>${vertx.version}</version>
//		</dependency>
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-sql-common</artifactId>
//			<version>${vertx.version}</version>
//		</dependency>
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-web-api-contract</artifactId>
//			<version>${vertx.version}</version>
//		</dependency>
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-codegen</artifactId>
//			<version>${vertx.version}</version>
//			<scope>provided</scope>
//		</dependency>
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-service-proxy</artifactId>
//			<version>${vertx.version}</version>
//		</dependency>
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-web-api-service</artifactId>
//			<version>${vertx.version}</version>
//		</dependency>
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-mail-client</artifactId>
//			<version>${vertx.version}</version>
//		</dependency>
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-health-check</artifactId>
//			<version>${vertx.version}</version>
//		</dependency>
//		<dependency>
//			<groupId>io.opentracing.contrib</groupId>
//			<artifactId>opentracing-vertx-web</artifactId>
//			<version>0.1.0</version>
//		</dependency>
//		<dependency>
//			<groupId>io.opentracing.contrib</groupId>
//			<artifactId>opentracing-solr-client</artifactId>
//			<version>0.1.0</version>
//		</dependency>
	}

	/**
	 * DisplayName.enUS: JUnit Dependencies
	 * enUS: Setup the JUnit dependencies for unit testing. 
	 */
	public void partDependenciesJunit() {
//
//		<!-- Unit Testing -->
//		<dependency>
//			<groupId>junit</groupId>
//			<artifactId>junit</artifactId>
//			<scope>test</scope>
//			<version>4.13.1</version>
//		</dependency>
//	</dependencies>
	}

	/**
	 * DisplayName.enUS: Source Directory Configuration
	 * enUS: Setup the source directory configuration in the project. 
	 */
	public void partSourceDirectories() {
//
//	<build>
//
//		<!-- Source Directory Configuration -->
//		<resources>
//			<resource>
//				<directory>src/main/resources</directory>
//			</resource>
//		</resources>
//
//		<plugins>
//
//			<plugin>
//				<groupId>org.codehaus.mojo</groupId>
//				<artifactId>build-helper-maven-plugin</artifactId>
//				<version>${build-helper-maven-plugin.version}</version>
//				<executions>
//					<execution>
//						<phase>generate-sources</phase>
//						<goals>
//							<goal>add-source</goal>
//						</goals>
//						<configuration>
//							<sources>
//								<source>src/gen/java</source>
//								<source>src/impl/java</source>
//								<source>target/generated-sources/annotations</source>
//							</sources>
//						</configuration>
//					</execution>
//				</executions>
//			</plugin>
	}

	/**
	 * DisplayName.enUS: Read Project Properties
	 * enUS: Read project properties to configure code signing. 
	 */
	public void partReadProperties() {
//
//			<!-- Read Project Properties -->
//			<plugin>
//				<groupId>org.codehaus.mojo</groupId>
//				<artifactId>properties-maven-plugin</artifactId>
//				<version>1.0.0</version>
//				<executions>
//					<execution>
//						<phase>initialize</phase>
//						<goals>
//							<goal>read-project-properties</goal>
//						</goals>
//						<configuration>
//							<files>
//								<file>/opt/keystore/opendatapolicing-keystore.properties</file>
//							</files>
//						</configuration>
//					</execution>
//				</executions>
//			</plugin>
	}

	/**
	 * DisplayName.enUS: Vert.X Code Generation
	 * enUS: Setup Vert.X Code Generation to generate API code. 
	 */
	public void partVertxCodeGeneration() {
//
//			<!-- Vert.X Code Generation -->
//			<plugin>
//				<artifactId>maven-compiler-plugin</artifactId>
//				<version>${maven-compiler-plugin.version}</version>
//				<configuration>
//					<source>1.8</source>
//					<target>1.8</target>
//					<annotationProcessors>
//						<annotationProcessor>io.vertx.codegen.CodeGenProcessor</annotationProcessor>
//					</annotationProcessors>
//				</configuration>
//			</plugin>
//		</plugins>
//	</build>
//	<profiles>
	}

	/**
	 * DisplayName.enUS: OpenShift Code Signing Plugins
	 * enUS: Configure Code Signing using TLS certificates for secure builds in OpenShift. 
	 */
	public void partCodeSigning() {
//	<profiles>
//
//		<!-- OpenShift Code Signing Plugins -->
//		<profile>
//			<id>openshift</id>
//			<build>
//				<plugins>
//					<plugin>
//						<groupId>org.apache.maven.plugins</groupId>
//						<artifactId>maven-shade-plugin</artifactId>
//						<version>2.3</version>
//						<executions>
//							<execution>
//								<phase>package</phase>
//								<goals>
//									<goal>shade</goal>
//								</goals>
//								<configuration>
//									<filters>
//										<filter>
//											<artifact>*:*</artifact>
//											<excludes>
//												<exclude>META-INF/*.SF</exclude>
//												<exclude>META-INF/*.DSA</exclude>
//												<exclude>META-INF/*.RSA</exclude>
//											</excludes>
//										</filter>
//									</filters>
//									<transformers>
//										<transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
//										</transformer>
//									</transformers>
//									<shadedArtifactAttached>true</shadedArtifactAttached>
//								</configuration>
//							</execution>
//						</executions>
//					</plugin>
//					<plugin>
//						<groupId>org.apache.maven.plugins</groupId>
//						<artifactId>maven-jarsigner-plugin</artifactId>
//						<version>1.4</version>
//						<executions>
//							<execution>
//								<id>sign</id>
//								<goals>
//									<goal>sign</goal>
//								</goals>
//							</execution>
//							<execution>
//								<id>verify</id>
//								<goals>
//									<goal>verify</goal>
//								</goals>
//							</execution>
//						</executions>
//						<configuration>
//							<keystore>${keystore-path}</keystore>
//							<alias>${keystore-alias}</alias>
//							<storepass>${keystore-storepass}</storepass>
//							<keypass>${keystore-keypass}</keypass>
//						</configuration>
//					</plugin>
//				</plugins>
//			</build>
//		</profile>
//	</profiles>
//</project>
	}
}
