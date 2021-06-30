all: clean build exec

run: reload build exec

build:
	mvn package

exec:
	java -jar target/Trex-jar-with-dependencies.jar

clean:
	rm -rf target
