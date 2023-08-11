# Change the src to the path of your java source files
JAVA_SRC = $(shell find . -name '*.java')
# Change this to the path of your antlr jar
ANTLR_JAR = antlr/antlr-4.13.0-complete.jar
ANTLR_G4 = $(shell find -name '*.g4')
G4_DIR = $(shell find -name '*.g4' | xargs dirname | uniq)

.PHONY: all
all: Compiler

.PHONY: clean
clean:
	rm -f ./antlr/*.java ./out/production/Mx/antlr/*.java
	rm -f ./antlr/*.tokens ./out/production/Mx/antlr/*.tokens
	rm -f ./antlr/*.interp ./out/production/Mx/antlr/*.interp
	rm -f bin/*.class bin/*.jar

# replace the antlr4 command with your own
.PHONY: antlr-parser
antlr-parser: $(ANTLR_G4)
	# Just generate from the antlr directory .g4 files
	antlr4 antlr/MxLexer.g4 antlr/MxParser.g4 -visitor -listener

.PHONY: Compiler
Compiler: clean antlr-parser
	javac -d bin $(JAVA_SRC) -cp $(ANTLR_JAR)
