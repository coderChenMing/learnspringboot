#!/bin/bash

ps -ef | grep "cloud01-1.0-SNAPSHOT.jar" | grep -v "grep"

if [ "$&#63;" -eq 0 ]
then

# sleep
echo $(date "+%Y-%m-%d %H:%M:%S") "process already started!"

else

nohup java -jar -server /home/project/cloud01-1.0-SNAPSHOT.jar &
echo $(date "+%Y-%m-%d %H:%M:%S") "process has been started!"

fi