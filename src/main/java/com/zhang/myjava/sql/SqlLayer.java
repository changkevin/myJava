package com.zhang.myjava.sql;

import java.util.List;

/**
 * 层：用来存放具有多种嵌套的sql的层数信息
 */
public class SqlLayer {
	String name; //层的名称
	long sqlId; //sql id
	List<SqlTable> sourceList; //源表列表
	List<SqlTable> targetList; //目标表列表
	int depth; //层的深度
	SqlLayer parent; //所属的上一层
	byte sourceParseStatus; //select语句的解析状态
	byte targetParseStatus; //insert语句的解析状态
	String sourceErrorMsg; //select语句解析出错信息
	String targetErrorMsg; //insert语句解析出错信息
}


