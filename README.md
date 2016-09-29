## Http Example

This is a simple project demonstrating the use of the osgi.web.boot bndtools template to boostrap a small http server.

### To build the project

Use gradle:

`./gradlew build`

### To export the project as an executable jar

Execute the export task on the `*.bndrun` files like so:

`./gradlew http.example:export.run`

The resulting executable jar will end up in `<project>/generated/distributions/executable/`. In this case the jar is `http.example/generated/distributions/executable/run.jar` (the name is derived from the name of the `bndrun` file).

### To execute the jar

Use the command:

`java -jar run.jar`
