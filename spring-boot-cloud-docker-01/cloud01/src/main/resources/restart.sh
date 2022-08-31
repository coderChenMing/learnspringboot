#!/bin/bash

pid=`ps -ef | grep "cloud01-1.0-SNAPSHOT.jar" | grep -v "grep" | awk '{print $2}'`

for id in $pid
do
 kill -9 $id
 echo "killed $id"
done

nohup java -jar -server /home/project/cloud01-1.0-SNAPSHOT.jar &
echo $(date "+%Y-%m-%d %H:%M:%S") "process has been restarted!"