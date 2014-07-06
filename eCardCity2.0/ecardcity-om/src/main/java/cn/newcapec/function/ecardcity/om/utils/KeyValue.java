/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author wj
 * @category 键值对容器
 * @version 1.0
 * @date 2014年5月8日 下午1:52:24
 */
public class KeyValue {
    public static final String RELATION_EQ = "eq";// 等于
    public static final String RELATION_NE = "ne";// 不等于
    public static final String RELATION_LIKE = "like";// 模糊匹配
    public static final String RELATION_IN = "in";// 集合
    public static final String RELATION_GT = "gt";// 大于
    public static final String RELATION_GE = "ge";// 大于等于
    public static final String RELATION_LT = "lt";// 小于
    public static final String RELATION_LE = "le";// 小于等于

    private Object name;// 名
    private Object value;// 值
    private String relation;// 关系

    public KeyValue() {
	this.relation = RELATION_EQ;
    }

    public KeyValue(Object name, Object value) {
	this.name = name;
	this.value = value;
	this.relation = RELATION_EQ;
    }

    public KeyValue(Object name, Object value, String relation) {
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
    
    /*
     * 转换map为KeyValue，默认关系符为eq
     * @param attrMap		属性Map
     * @return KeyValue[]	返回KeyValue数组
     * */
    public static KeyValue[] map2keyValue(Map<String, Object> map){
	List<KeyValue> list=new ArrayList<KeyValue>();
	if(map!=null){
	    Iterator<Entry<String, Object>> iter = map.entrySet().iterator();
	    Map.Entry<String, Object> entry = null;
	    while (iter.hasNext()) {
		entry = iter.next();
		list.add(new KeyValue(entry.getKey(),entry.getValue(),RELATION_EQ));
	    }
	}
	return (KeyValue[]) list.toArray();
    }
    
    public String toString() {
	return new StringBuilder().append("{name:'").append(name)
		.append("',value:'").append(value).append("',relation:'")
		.append(relation).append("'}").toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((value == null) ? 0 : value.hashCode());
	result = prime * result
		+ ((relation == null) ? 0 : relation.hashCode());
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof KeyValue))
	    return false;
	final KeyValue other = (KeyValue) obj;
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