.PHONY := build

bin/Database.class: src/Database.java 
	javac -d bin -cp .:lib/sqlite-jdbc-3.39.3.0.jar src/Database.java

bin/GroupProject.class: src/GroupProject.java bin/Database.class
	javac -d bin -cp .:lib/sqlite-jdbc-3.39.3.0.jar:bin src/GroupProject.java

build: bin/GroupProject.class 

run: clean build
	java -cp .:lib/sqlite-jdbc-3.39.3.0.jar:bin GroupProject

clean:
	rm -f bin/*.class
