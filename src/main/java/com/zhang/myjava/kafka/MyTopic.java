package com.zhang.myjava.kafka;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import org.apache.kafka.common.security.JaasUtils;
import kafka.admin.AdminUtils;
import kafka.admin.RackAwareMode;
import kafka.server.ConfigType;
import kafka.utils.ZkUtils;

public class MyTopic {
	public static void createTopic(String topic) {
		ZkUtils zkUtils = ZkUtils.apply("localhost:2181", 30000, 30000, JaasUtils.isZkSecurityEnabled());
		// 创建一个单分区单副本名为t1的topic
		AdminUtils.createTopic(zkUtils, topic, 1, 1, new Properties(), RackAwareMode.Enforced$.MODULE$);
		zkUtils.close();
	}
	
	public static void deleteTopic(String topic) {
		ZkUtils zkUtils = ZkUtils.apply("localhost:2181", 30000, 30000, JaasUtils.isZkSecurityEnabled());
		// 删除topic 't1'
		AdminUtils.deleteTopic(zkUtils, topic);
		zkUtils.close();
	}
	
	public static void getTopic(String topic) {
		ZkUtils zkUtils = ZkUtils.apply("localhost:2181", 30000, 30000, JaasUtils.isZkSecurityEnabled());
		// 获取topic 'test'的topic属性属性
		Properties props = AdminUtils.fetchEntityConfig(zkUtils, ConfigType.Topic(), topic);
		// 查询topic-level属性
		Iterator it = props.entrySet().iterator();
		while(it.hasNext()){
		    Map.Entry entry=(Map.Entry)it.next();
		    Object key = entry.getKey();
		    Object value = entry.getValue();
		    System.out.println(key + " = " + value);
		}
		zkUtils.close();
	}
	
	public static void changeTopic(String topic) {
		ZkUtils zkUtils = ZkUtils.apply("localhost:2181", 30000, 30000, JaasUtils.isZkSecurityEnabled());
		Properties props = AdminUtils.fetchEntityConfig(zkUtils, ConfigType.Topic(), topic);
		// 增加topic级别属性
		props.put("min.cleanable.dirty.ratio", "0.3");
		// 删除topic级别属性
		props.remove("max.message.bytes");
		// 修改topic 'test'的属性
		AdminUtils.changeTopicConfig(zkUtils, topic, props);
		zkUtils.close();
	}
	
	public static void main(String[] args) {
		MyTopic.createTopic("page_visits");
		MyTopic.getTopic("page_visits");
	}

}
