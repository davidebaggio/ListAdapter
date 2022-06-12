#!/bin/bash

apache-maven-3.8.5/bin/mvn clean
apache-maven-3.8.5/bin/mvn compiler:compile
apache-maven-3.8.5/bin/mvn compiler:testCompile