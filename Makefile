# Change the src to the path of your java source files
JAVA_SRC = $(shell find . -name '*.java')
# Change this to the path of your antlr jar
ANTLR_JAR = antlr/antlr-4.13.0-complete.jar

.PHONY: all
all: Compiler

.PHONY: clean
clean:
	rm -f bin/*.class bin/*.jar

.PHONY: Compiler
Compiler: clean
	javac -d bin $(JAVA_SRC) -cp $(ANTLR_JAR)