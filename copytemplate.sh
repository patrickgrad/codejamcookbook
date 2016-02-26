cp -r ./CodeJamTemplate/ ./$1/
mv ./$1/CodeJamTemplate.java ./$1/$1.java
perl -pi -e 's/CodeJamTemplate/'$1'/g' ./$1/$1.java
