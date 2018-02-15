# Session 2 [![Build Status](https://travis-ci.org/eleves-ig2i/ig2i-le4-poo-2018-tp-2.svg?branch=master)](https://travis-ci.org/eleves-ig2i/ig2i-le4-poo-2018-tp-2)

## DESCRIPTION !!!

This TP was realized with JPA inheritance and especially with the so-called "join" strategy. It's the continuation of the previous TP and allows to illustrate the following notions : 
  * mapping of inheritance relationships
  * inserted classes
  * JPA query language (JPQL)

### Setup Database
* Open Netbeans
* Services > Databases > Java DB > Start Server
* Services > Databases > Java DB > Create Database
  * Database Name : database
  * User Name : username
  * Password : password
  * Password : password
* [OK]
* Services > Databases > jdbc:derby... > connect

### Setup JDBC
* Projects > ${project name} > Librairies > Add Librairies
  * [Import] > Java DB Driver
  * [Add Library]

### Setup Persistance
* Projects > ${project name} > Librairies > Add Librairies
  * [Import] > EclipseLink (JPA X.X)
  * [Add Library]  

### Persistance Unit
* [Open] META-INF > persistence.xml
  * PU name : ${persistance name}
  * Database Connection : jdbc:derby...

## Authors
-----------------------------
* [Loïc BOURGOIS](https://github.com/loicbourgois) 
* [Sébastien CORNUEL](https://github.com/Hercules0402)

## License
-----------------------------
This TP is licensed under the MIT License - see the [LICENSE(https://github.com/eleves-ig2i/ig2i-le4-poo-2018-tp-2/blob/master/LICENSE)] file for details  