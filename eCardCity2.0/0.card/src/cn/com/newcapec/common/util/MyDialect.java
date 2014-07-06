package cn.com.newcapec.common.util;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.SQLServerDialect;

public class MyDialect extends SQLServerDialect {
	public MyDialect() {
		super();
		registerHibernateType(Types.CHAR, Hibernate.STRING.getName());
		registerHibernateType(Types.NVARCHAR, Hibernate.STRING.getName());
		registerHibernateType(Types.LONGNVARCHAR, Hibernate.STRING.getName());
		registerHibernateType(Types.DECIMAL, Hibernate.DOUBLE.getName());
		registerHibernateType(Types.LONGVARCHAR, Hibernate.TEXT.getName());
	}

}