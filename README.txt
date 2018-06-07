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