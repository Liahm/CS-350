#Eric Lee Makefile for HW2

JAVA = java
JAR = jar
JC = javac
FLAGS = cfm

FILES = Bool.java \
	Choices.java \
	Create.java \
	Display.java \
	Edit.java \
	EssayAns.java \
	Exit.java \
	Grade.java \
	Load.java \
	Matching.java \
	Output.java \
	Ranking.java \
	Save.java \
	ShortAns.java \
	Survey.java \
	SurveyC.java \
	Take.java \
	Test.java \
	WriteToFile.java

MAIN = Survey.jar

.PHONY: run view clean

run:
	@$(JC) $(FILES)
	@$(JAR) -$(FLAGS) $(MAIN) Main.txt *.class
	$(JAVA) -$(JAR) $(MAIN)

clean:
	@rm *.class $(MAIN)
