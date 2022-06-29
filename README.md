# Hadoop + Redis + Springboot DataAnalysis
**The purpose of this project is integrating Hadoop redis and springboot to analysis the [bodyperformance.csv]() data which got on kaggle**  
Brieve description of each tasks.
1. the first task is to work out the average date of each columns, and devided by Gender and class.
2. the second task is to work out for the average performance through ages and gender.
3. the third task calculate the hightest and lowest record of each columns according to class and Gender.

## Required environment on linux and windows
|Tools|Version|
|------|------|
|Docker|1.13.1|
|Maven|3.8.5|
|Hadoop|3.1.4|
|JDK|1.8.0_301|
|Redis|6.2.7|
|SpringBoot|2.6.8|

## The process of setting environment on **LINUX** are list as follow.
### 1. prepare the environment on linux about persuade Hadoop running with docker.
```
docker pull effeerre/hadoop
docker network create --driver bridge hadoop_network
docker run -t -i -p 9863:9864 -d --network=hadoop_network --name=slave1 effeerre/hadoop
docker run -t -i -p 9862:9864 -d --network=hadoop_network --name=slave2 effeerre/hadoop
docker run -t -i -p 9861:9864 -d --network=hadoop_network --name=slave3 effeerre/hadoop
docker run -t -i -p 9870:9870 -p 8088:8088 -p 54310:54310 -p 9866:9866 -p 9864:9864 -p 9867:9867 -p 9869:9869 --network=hadoop_network --name=master -v /home/hadoop/master/archive:/data effeerre/hadoop
```
### 2. after execute upper command will get in master bash and execute following command successively.
```
cd /usr/local/hadoop/bin
hdfs namenode -format
hdfs --daemon start namenode
hdfs --daemon start datanode
yarn --daemon start resourcemanager
yarn --daemon start nodemanager
yarn --daemon start proxyserver
yarn --daemon start resourcemanager
yarn --daemon start nodemanager
yarn --daemon start proxyserver
mapred --daemon start historyserver
```

this the end of install hadoop persuade cluster, type `http://localhost:9870/dfshealth.html#tab-overview` on browser to check whether it is successfull.

### 3. Prepare to install redis with docker.
```
docker run -d --name redis-stack-server -p 6379:6379 -v /home/redis-data/data:/data -v /home/redis-data/config/local-redis-stack.conf:/redis-stack.conf redis/redis-stack-server:latest
```
**Options -- To set redis password**
```
docker exec -it redis-stack-server redis-cli
AUTH %replace with your password%
```

## The process of setting developing environment on **WINDOWS** are list as follow.
 [**OPTION TUTORIAL**](https://brain-mentors.com/hadoopinstallation/)
### 4. download Hadoop 3.1.4 on [archive.apache.org](https://archive.apache.org/dist/hadoop/core/hadoop-3.1.4/)
### 5. download [winuitls](https://github.com/steveloughran/winutils) and replace `$(HADOOOP_HOME)\bin` with `winutils/bin`

