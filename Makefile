# All source files
SRCS := $(wildcard algorithms/*.java)

# Flags to pass to Java compilations (include debugging info and report
# "unsafe" operations.)
JFLAGS = -g -Xlint:unchecked -Xlint:deprecation

CLASSES = $(SRCS:.java=.class)

# Tell make that these are not really files.
.PHONY: clean default check regression-test unit-test style

# By default, make sure all classes are present and check if any sources have
# changed since the last build.
default: $(CLASSES)

# If any class is missing, or any source changed since the main classes were
# compiled, remove all class files and recompile.
$(CLASSES): $(SRCS)
	$(RM) $(CLASSES)
	javac $(JFLAGS) $(SRCS) || { $(RM) $(CLASSES); false; }

check: $(CLASSES)
	$(MAKE) -C algorithms check

# Find and remove all *~, *.class, and testing output files.
# Do not touch .svn directories.
clean :
	$(RM) *~
	$(MAKE) -C algorithms clean
