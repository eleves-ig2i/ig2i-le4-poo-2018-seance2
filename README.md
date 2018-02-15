# Session 2 [![Build Status](https://travis-ci.org/eleves-ig2i/ig2i-le4-poo-2018-tp-2.svg?branch=master)](https://travis-ci.org/eleves-ig2i/ig2i-le4-poo-2018-tp-2)

## Description

This TP was realized with JPA inheritance and especially with the so-called "join" strategy. It's the continuation of the previous TP and allows to illustrate the following notions : 
	* mapping of inheritance relationships
	* inserted classes
	* JPA query language (JPQL)

## Installation
### Prerequisites
You need to :
	* Java
	* NetBeans

---------------------
#### Java
##### Ressources
* [https://stackoverflow.com/questions/25289482/installing-jdk8-on-ubuntu-unable-to-locate-package-update-doesnt-fix/31869659#31869659](https://stackoverflow.com/questions/25289482/installing-jdk8-on-ubuntu-unable-to-locate-package-update-doesnt-fix/31869659#31869659) 
* [http://www.webupd8.org/2014/03/how-to-install-oracle-java-8-in-debian.html](http://www.webupd8.org/2014/03/how-to-install-oracle-java-8-in-debian.html)
* [https://netbeans.org/kb/docs/ide/java-db.html#registering](https://netbeans.org/kb/docs/ide/java-db.html#registering)
* [https://docs.oracle.com/netbeans/nb82/netbeans/NBDAG/work_app_servers.htm#NBDAG1687](https://docs.oracle.com/netbeans/nb82/netbeans/NBDAG/work_app_servers.htm#NBDAG1687)

##### Install
```bash
sudo aptitude update
sudo aptitude install openjdk-8-jdk
```
```bash
#Probably useless stuff
#sudo apt-get purge openjdk
#sudo apt-get purge oracle-java8-installer
#sudo apt-get purge oracle-java9-installer
#sudo aptitude install libderby-java libderbyclient-java
#sudo apt-get install python-software-properties software-properties-common
#sudo add-apt-repository ppa:webupd8team/java
#sudo apt-get install oracle-java8-installer
#sudo apt-get install oracle-java8-set-default
```

---------------------
#### NetBeans
##### Ressources
* [https://netbeans.org/downloads/](https://netbeans.org/downloads/) 
* [https://netbeans.org/community/releases/80/install.html#installation](https://netbeans.org/community/releases/80/install.html#installation)

##### Install
* Go to [https://netbeans.org/downloads/](https://netbeans.org/downloads/)
* Download `Java EE`

```bash
cd ~
mv Downloads/netbeans-8.2-javaee-linux.sh ./
chmod +x ./netbeans-8.2-javaee-linux.sh
# Select Glassfish AND Tomcat
# For JDK installation path, select /usr/lib/jvm/java-8-openjdk-amd64
./netbeans-8.2-javaee-linux.sht
```

### Installing
#### Create the project
* Open NetBeans
* Create New Project
* Download the sources
* Copy paste content of the [src/](https://github.com/eleves-ig2i/ig2i-le4-poo-2018-tp-2/tree/master/hopital/src) folder in the folder of the new project 

#### Setup Database
* Open Netbeans
* Services > Databases > Java DB > Start Server
* Services > Databases > Java DB > Create Database
	* Database Name : database
	* User Name : username
	* Password : password
	* Password : password
* [OK]
* Services > Databases > jdbc:derby... > connect

#### Setup JDBC
* Projects > ${project name} > Librairies > Add Librairies
	* [Import] > Java DB Driver
	* [Add Library]

#### Setup Persistance
* Projects > ${project name} > Librairies > Add Librairies
	* [Import] > EclipseLink (JPA X.X)
	* [Add Library]	

#### Persistance Unit
* [Open] META-INF > persistence.xml
	* PU name : ${persistance name}
	* Database Connection : jdbc:derby...

## Authors
* [Loïc BOURGOIS](https://github.com/loicbourgois) 
* [Sébastien CORNUEL](https://github.com/Hercules0402)

## License
This TP is licensed under the MIT License - see the [LICENSE](https://github.com/eleves-ig2i/ig2i-le4-poo-2018-tp-2/blob/master/LICENSE) file for details	