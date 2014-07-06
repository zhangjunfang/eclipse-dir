package com.iisquare.smh.frame.hibernate;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.cfg.NamingStrategy;
import org.hibernate.internal.util.StringHelper;

/**
 * 修改数据关系映射默认规则
 */
public class DaoNamingStrategy extends ImprovedNamingStrategy implements NamingStrategy {
	private static final long serialVersionUID = 1L;
	private String tablePrefix = "";

	public String getTablePrefix() {
		return tablePrefix;
	}

	public void setTablePrefix(String tablePrefix) {
		this.tablePrefix = tablePrefix;
	}

	public String classToTableName(String className) {
        return tablePrefix + addUnderscores(StringHelper.unqualify(className));
    }

	@Override
	public String tableName(String tableName) {
		return tablePrefix + addUnderscores(StringHelper.unqualify(tableName));
	}
}
