#!/bin/bash

apache-maven-3.8.5\bin\mvn.cmd clean
apache-maven-3.8.5\bin\mvn.cmd compiler:compile
apache-maven-3.8.5\bin\mvn.cmd compiler:testCompile