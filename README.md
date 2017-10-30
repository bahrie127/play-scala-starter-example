[<img src="https://img.shields.io/travis/playframework/play-scala-starter-example.svg"/>](https://travis-ci.org/playframework/play-scala-starter-example)

# Play Scala + Twitter Bootstrap + Arangodb

This is a starter application that shows how Play works.  Please see the documentation at https://www.playframework.com/documentation/latest/Home for more details.

## Prerequisites

    Play Framework 2.6.6
    Scala 2.12.2
    SBT 1.0.2
    ArangoDB 3.2.6
    JQuery 3.2.1
    Twitter Bootstrap v4.0.0-alpha.6

## Arangodb

Open browser http://localhost:8529/ and login with root, password blank. create new user and then create
new database with new user, change to new database, and create new colleetion with name person and then import
data with below:

    [{"_key":"471","_id":"person/471","_rev":"_V02DXaC---","name":"rozak","address":"Yogyakarta","phone":"34332423"},
    {"_key":"431","_id":"person/431","_rev":"_V02C6ee---","name":"yuki","address":"kendal","phone":"53454233"},
    {"_key":"373","_id":"person/373","_rev":"_V02CfRO---","name":"bahri","address":"semarang","phone":"534543543"}]

## Configuration

Adding below config to conf/application.conf

    db{
         name = "example"  #your new database
         host = "http://localhost"
         port = 8529
         user = "user" #your new user
         password = "root" #your new password user
      }
## Running

Run this using [sbt](http://www.scala-sbt.org/).  If you downloaded this project from http://www.playframework.com/download then you'll find a prepackaged version of sbt in the project directory:

```
sbt run
```


Open your browser and get http://localhost:9000/example


Enjoy it..

