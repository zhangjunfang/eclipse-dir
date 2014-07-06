package cn.com.newcapec.common.domain;

import java.io.Serializable;

/**
 * <p>
 * 功能描述:名值对
 *   
 * Author : Wangjian 
 * Date	  : 2007-11-12
 * Time   : 13:39:15
 * Version:1.0
 * </p>
 */
public class NameValue implements Serializable {
	private static final long serialVersionUID = 8812905561043887847L;
	public static final String RELATION_EQ="eq";//等于
	public static final String RELATION_LIKE="like";//模糊匹配
	public static final String RELATION_IN="in";//集合
	public static final String RELATION_GT="gt";//大于
	public static final String RELATION_GE="ge";//大于等于
	public static final String RELATION_LT="le";//小于
	public static final String RELATION_LE="le";//小于等于
	
	private Object name;//名
	private Object value;//值
	private String relation;//关系

	public NameValue() {
		this.relation = RELATION_EQ;
	}

	public NameValue(Object name, Object value) {
		this.name = name;
		this.value = value;
		this.relation = RELATION_EQ;
	}
	
	public NameValue(Object name, Object value,String relation) {
		this.name = name;
		this.value = value;
		this.relation = relation;
	}
	
	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Object getName() {
		return name;
	}

	public void setName(Object name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String toString() {
		return new StringBuilder().append("{name:'").append(name).append(
				"',value:'").append(value).append("',relation:'").append(relation).append("'}").toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((relation == null) ? 0 : relation.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof NameValue))
			return false;
		final NameValue other = (NameValue) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (relation == null) {
			if (other.relation != null)
				return false;
		} else if (!relation.equals(other.relation))
			return false;
		return true;
	}

}
