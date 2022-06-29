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

## Before running the project
* Complement or Replace the parameter on `src/main/resources/application.properties` 
* check `src/main/resources/core-site.xml` and `src/main/resources/hdfs-site.xml` are same to the hadoop folder.
* creat the folder of `/bodyPerformance` on HDFS and upload the file.

## Example result
1. executeTaskOne
<img src="https://user-images.githubusercontent.com/29159859/176542709-9978bd9a-c469-4965-9c69-779a7b85f1f9.png" width = "60%">
2. executeTaskTwo
<img src="https://user-images.githubusercontent.com/29159859/176542740-49ddbfdd-2a84-4abd-bff3-995a66adfdb9.png" width = "60%">
3. executeTaskThree
<img src="https://user-images.githubusercontent.com/29159859/176542768-bcfc7425-56f6-48ce-927e-2a004cc31aa2.png" width = "60%">
4. GetValueByKey
<img src="https://user-images.githubusercontent.com/29159859/176542832-da429805-fd39-4707-b5e3-b4fe0c2bb449.png" width = "60%">

## Example Output
1. Task One
<img src="https://user-images.githubusercontent.com/29159859/176542998-fd2a1c47-b9a3-43db-b06b-d9acf90cc487.png" width = "60%">
2. Task Two
<img src="https://user-images.githubusercontent.com/29159859/176543110-d0060c27-6176-4084-b477-8031a4edfaa8.png" width = "60%">
3. Task Three
<img src="https://user-images.githubusercontent.com/29159859/176543528-bb8d6358-69da-44a8-948f-55d43b43e16b.png" width="60%">

