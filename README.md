## Web Examples

This is a simple project demonstrating the use of the osgi.web.boot bndtools template to boostrap some small web servers.

### To build the project

Use gradle:

`./gradlew build`

### To export the project as an executable jar

Execute the export task on the `*.bndrun` files like so:

```
./gradlew servlet.example:export.run
OR
./gradlew websocket.example:export.run
OR
./gradlew jaxrs.example:export.run
```

The resulting executable jar will end up in `<project>/generated/distributions/executable/`. 
In this case the jars are:

```
servlet.example/generated/distributions/executable/run.jar
websocket.example/generated/distributions/executable/run.jar
jaxrs.example/generated/distributions/executable/run.jar
```
**Note:** the name is derived from the name of the `bndrun` file.

### To execute the jar

Use the command:

```
java -jar servlet.example/generated/distributions/executable/run.jar
OR
java -jar websocket.example/generated/distributions/executable/run.jar
OR
java -jar jaxrs.example/generated/distributions/executable/run.jar

```
