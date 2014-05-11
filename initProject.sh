#!/bin/bash

cd logging

#limpio toda dependencia anterior
mvn clean

#creo el proyecto para eclipse
mvn eclipse:eclipse -Dwtpversion=2.0

#compilo el proyecto existente
mvn clean package
