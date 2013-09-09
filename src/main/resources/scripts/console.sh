#!/bin/bash
echo "Starting Global configuration process"
#Get the local directory in order to set the full path to the log4j config file
ROQ_BIN=$(dirname "$(readlink -f "$(type -P $0 || echo $0)")")
ROQ_HOME=$(dirname $ROQ_BIN)
echo "ROQ BIN Home= $ROQ_HOME"
java -jar ../lib/roq-swing-console-1.0-SNAPSHOT-jar-with-dependencies.jar

