# Séance 2 [![Build Status](https://travis-ci.org/eleves-ig2i/ig2i-le4-poo-2018-tp-2.svg?branch=master)](https://travis-ci.org/eleves-ig2i/ig2i-le4-poo-2018-tp-2)

## IMPORTANT !!!

- TP realized with JPA inheritance and especially with the so-called "join" strategy

### Setup Database
- Open Netbeans
- Services > Databases > Java DB > Start Server
- Services > Databases > Java DB > Create Database
  - Database Name : database
  - User Name : username
  - Password : password
  - Password : password
- [OK]
- Services > Databases > jdbc:derby... > connect

### Setup JDBC
- Projects > ${project name} > Librairies > Add Librairies
  - [Import] > Java DB Driver
  - [Add Library]

### Setup Persistance
- Projects > ${project name} > Librairies > Add Librairies
  - [Import] > EclipseLink (JPA X.X)
  - [Add Library]  

### Persistance Unit
- [Open] META-INF > persistence.xml
  - PU name : ${persistance name}
  - Database Connection : jdbc:derby...