# All source files
SRCS := $(wildcard *.java)

# Unit test files.
TESTING_SRCS = Testing.java

# Flags to pass to Java compilations (include debugging info and report
# "unsafe" operations.)
JFLAGS = -g -Xlint:unchecked -Xlint:deprecation \
	-sourcepath .. -classpath ..:$(CLASSPATH)

CLASSES = $(SRCS:.java=.class)
TESTING_CLASSES = $(TESTING_SRCS:.java=.class)

# Tell make that these are not really files.
.PHONY: clean default check regression-test unit-test style

# By default, make sure all classes are present and check if any sources have
# changed since the last build.
default: $(CLASSES)

# Classes must exist and be up to date with a marker file indicating the time
# of last compilation.  We do it this way as a trick to prevent multiple
# recompilations when there are errors.
$(CLASSES): sentinel

# If any class is missing, or any source changed since the main classes were
# compiled, remove all class files and recompile.
sentinel: $(SRCS)
	$(RM) $@
	$(RM) $(CLASSES)
	javac $(JFLAGS) $(SRCS) || { $(RM) $(CLASSES); false; }
	touch $@

# Run Tests.
check: unit-test

# Run Junit tests.
unit-test: $(CLASSES)
	java -ea -classpath ..:$(CLASSPATH) algorithms.Testing

# Find and remove all *~, *.class, and testing output files.
# Do not touch .svn directories.
clean :
	$(RM) *~ *.class sentinel
