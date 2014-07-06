package cn.com.newcapec.common.util;

import java.sql.Types;

import org.hibernate.dialect.SQLServerDialect;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;
import org.hibernate.type.TextType;

public class MyDialect extends SQLServerDialect {
	public MyDialect() {
		super();
		registerHibernateType(Types.CHAR, StringType.INSTANCE.getName());
		registerHibernateType(Types.NVARCHAR, StringType.INSTANCE.getName());
		registerHibernateType(Types.LONGNVARCHAR, StringType.INSTANCE.getName());
		registerHibernateType(Types.DECIMAL, DoubleType.INSTANCE.getName());
		registerHibernateType(Types.LONGVARCHAR, TextType.INSTANCE.getName());
	}

}