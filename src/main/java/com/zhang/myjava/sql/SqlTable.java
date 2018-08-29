package com.zhang.myjava.sql;

import java.util.List;


/**
 * 表：存放表的信息
 */
public class SqlTable {
	String name; //表的名称
	String alias; //表的别名
	List<SqlField> fieldList; //表的字段列表
	boolean isSubQuery; //是否是子查询
	String parent; //所属的上一层的路径名
	String mode; //对表的操作类型
	String joinType; //join类型
	String schema; //该表所属的数据库名称
	String pos; //该表在sql中出现的位置
}



