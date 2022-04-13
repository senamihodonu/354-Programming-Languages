
#---------------------------------------------------------------
# Using this Makefile
#
#   To compile your java source (and generate documentation)
#
#   make
#
#   To clean up your directory
#
#   make clean
#
#---------------------------------------------------------------

JFLAGS=

# Recognize files with .class and .java extensions
.SUFFIXES: .class .java

# This is a rule to convert a file with .java extension
# into a file with a .class extension. The macro $< just
# supplies the name of the file (without the extension)
# that invoked this rule.

.java.class:
	javac $(JFLAGS) $<


all: Customer.class Account.class CheckingAccount.class SavingAccount.class Bank.class
		
clean:
	/bin/rm -f *.class
