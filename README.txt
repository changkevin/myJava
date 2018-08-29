1.rabbitmq测试   http://localhost:15672
(1)启动服务
cd /usr/local/Cellar/rabbitmq/3.7.5
sbin/rabbitmq-server

(2)新打开终端,先编译代码
cd /zhangchuankai/project/myjava
mvn clean
mvn install

(3)打开多个终端
cd /zhangchuankai/project/myjava/target/classes/
java -Djava.ext.dirs=/zhangchuankai/project/myjava/target/lib com.zhang.myjava.rabbitmq.WorkWithAsk

(4)新建一个终端
cd /zhangchuankai/project/myjava/target/classes/
java -Djava.ext.dirs=/zhangchuankai/project/myjava/target/lib com.zhang.myjava.rabbitmq.NewTask


2.zookeeper测试
（1）zkServer start
（2）cd /zhangchuankai/project/myjava
	mvn clean package -Dmaven.test.skip=true
（3）java -cp myjava-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.zhang.myjava.zookeeper.CreateGroup
	java -jar myjava-0.0.1-SNAPSHOT-jar-with-dependencies.jar goat >/dev/null 2>&1 &
	java -jar myjava-0.0.1-SNAPSHOT-jar-with-dependencies.jar cow >/dev/null 2>&1 &
	java -jar myjava-0.0.1-SNAPSHOT-jar-with-dependencies.jar duck >/dev/null 2>&1 &
（4）zkCli -server localhost:2181
	ls /zoo
（5）java -cp myjava-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.zhang.myjava.zookeeper.DeleteGroup

zk命令：
zkCli -server localhost:2181
ls /

#配置服务
java -cp myjava-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.zhang.myjava.zookeeper.ConfigUpdater localhost
java -cp myjava-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.zhang.myjava.zookeeper.ConfigWatcher localhost


java -jar myjava-0.0.1-SNAPSHOT-jar-with-dependencies.jar work1
java -jar myjava-0.0.1-SNAPSHOT-jar-with-dependencies.jar work2
java -jar myjava-0.0.1-SNAPSHOT-jar-with-dependencies.jar work3
