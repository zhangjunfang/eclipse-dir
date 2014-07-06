package cn.com.newcapec.citycard.common.po.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the BASE_CODE_GROUP table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BASE_CODE_GROUP"
 */

public abstract class BaseBaseCodeGroup  implements Comparable, Serializable {

	public static String REF = "BaseCodeGroup";
	public static String PROP_OPSUBLOAD = "opsubload";
	public static String PROP_DIR = "dir";
	public static String PROP_OPSUMCONSUME = "opsumconsume";
	public static String PROP_OPSUMCHARGE = "opsumcharge";
	public static String PROP_LOCATION = "location";
	public static String PROP_SORT_NUM = "sortNum";
	public static String PROP_OPSUMLOAD = "opsumload";
	public static String PROP_OPSUMSAVE = "opsumsave";
	public static String PROP_IFCARD = "ifcard";
	public static String PROP_OPODDFARE = "opoddfare";
	public static String PROP_TYPENAME = "typename";
	public static String PROP_ID = "id";
	public static String PROP_DESCRIBE = "describe";
	public static String PROP_OPODDFAREACC = "opoddfareacc";
	public static String PROP_OPSUMADDFARE = "opsumaddfare";
	public static String PROP_OPSUMBANK = "opsumbank";


	// constructors
	public BaseBaseCodeGroup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBaseCodeGroup (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String typename;
	private java.lang.String describe;
	private java.lang.Integer ifcard;
	private java.lang.Integer opoddfare;
	private java.lang.Integer opoddfareacc;
	private java.lang.Integer opsumaddfare;
	private java.lang.Integer opsumconsume;
	private java.lang.Integer opsumbank;
	private java.lang.Integer opsumload;
	private java.lang.Integer opsumsave;
	private java.lang.Integer opsumcharge;
	private java.lang.Integer dir;
	private java.lang.Integer sortNum;
	private java.lang.Integer location;
	private java.lang.Integer opsubload;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="uuid.hex"
     *  column="ID"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: TYPENAME
	 */
	public java.lang.String getTypename () {
		return typename;
	}

	/**
	 * Set the value related to the column: TYPENAME
	 * @param typename the TYPENAME value
	 */
	public void setTypename (java.lang.String typename) {
		this.typename = typename;
	}



	/**
	 * Return the value associated with the column: DESCRIBE
	 */
	public java.lang.String getDescribe () {
		return describe;
	}

	/**
	 * Set the value related to the column: DESCRIBE
	 * @param describe the DESCRIBE value
	 */
	public void setDescribe (java.lang.String describe) {
		this.describe = describe;
	}



	/**
	 * Return the value associated with the column: IFCARD
	 */
	public java.lang.Integer getIfcard () {
		return ifcard;
	}

	/**
	 * Set the value related to the column: IFCARD
	 * @param ifcard the IFCARD value
	 */
	public void setIfcard (java.lang.Integer ifcard) {
		this.ifcard = ifcard;
	}



	/**
	 * Return the value associated with the column: OPODDFARE
	 */
	public java.lang.Integer getOpoddfare () {
		return opoddfare;
	}

	/**
	 * Set the value related to the column: OPODDFARE
	 * @param opoddfare the OPODDFARE value
	 */
	public void setOpoddfare (java.lang.Integer opoddfare) {
		this.opoddfare = opoddfare;
	}



	/**
	 * Return the value associated with the column: OPODDFAREACC
	 */
	public java.lang.Integer getOpoddfareacc () {
		return opoddfareacc;
	}

	/**
	 * Set the value related to the column: OPODDFAREACC
	 * @param opoddfareacc the OPODDFAREACC value
	 */
	public void setOpoddfareacc (java.lang.Integer opoddfareacc) {
		this.opoddfareacc = opoddfareacc;
	}



	/**
	 * Return the value associated with the column: OPSUMADDFARE
	 */
	public java.lang.Integer getOpsumaddfare () {
		return opsumaddfare;
	}

	/**
	 * Set the value related to the column: OPSUMADDFARE
	 * @param opsumaddfare the OPSUMADDFARE value
	 */
	public void setOpsumaddfare (java.lang.Integer opsumaddfare) {
		this.opsumaddfare = opsumaddfare;
	}



	/**
	 * Return the value associated with the column: OPSUMCONSUME
	 */
	public java.lang.Integer getOpsumconsume () {
		return opsumconsume;
	}

	/**
	 * Set the value related to the column: OPSUMCONSUME
	 * @param opsumconsume the OPSUMCONSUME value
	 */
	public void setOpsumconsume (java.lang.Integer opsumconsume) {
		this.opsumconsume = opsumconsume;
	}



	/**
	 * Return the value associated with the column: OPSUMBANK
	 */
	public java.lang.Integer getOpsumbank () {
		return opsumbank;
	}

	/**
	 * Set the value related to the column: OPSUMBANK
	 * @param opsumbank the OPSUMBANK value
	 */
	public void setOpsumbank (java.lang.Integer opsumbank) {
		this.opsumbank = opsumbank;
	}



	/**
	 * Return the value associated with the column: OPSUMLOAD
	 */
	public java.lang.Integer getOpsumload () {
		return opsumload;
	}

	/**
	 * Set the value related to the column: OPSUMLOAD
	 * @param opsumload the OPSUMLOAD value
	 */
	public void setOpsumload (java.lang.Integer opsumload) {
		this.opsumload = opsumload;
	}



	/**
	 * Return the value associated with the column: OPSUMSAVE
	 */
	public java.lang.Integer getOpsumsave () {
		return opsumsave;
	}

	/**
	 * Set the value related to the column: OPSUMSAVE
	 * @param opsumsave the OPSUMSAVE value
	 */
	public void setOpsumsave (java.lang.Integer opsumsave) {
		this.opsumsave = opsumsave;
	}



	/**
	 * Return the value associated with the column: OPSUMCHARGE
	 */
	public java.lang.Integer getOpsumcharge () {
		return opsumcharge;
	}

	/**
	 * Set the value related to the column: OPSUMCHARGE
	 * @param opsumcharge the OPSUMCHARGE value
	 */
	public void setOpsumcharge (java.lang.Integer opsumcharge) {
		this.opsumcharge = opsumcharge;
	}



	/**
	 * Return the value associated with the column: DIR
	 */
	public java.lang.Integer getDir () {
		return dir;
	}

	/**
	 * Set the value related to the column: DIR
	 * @param dir the DIR value
	 */
	public void setDir (java.lang.Integer dir) {
		this.dir = dir;
	}



	/**
	 * Return the value associated with the column: SORT_NUM
	 */
	public java.lang.Integer getSortNum () {
		return sortNum;
	}

	/**
	 * Set the value related to the column: SORT_NUM
	 * @param sortNum the SORT_NUM value
	 */
	public void setSortNum (java.lang.Integer sortNum) {
		this.sortNum = sortNum;
	}



	/**
	 * Return the value associated with the column: LOCATION
	 */
	public java.lang.Integer getLocation () {
		return location;
	}

	/**
	 * Set the value related to the column: LOCATION
	 * @param location the LOCATION value
	 */
	public void setLocation (java.lang.Integer location) {
		this.location = location;
	}



	/**
	 * Return the value associated with the column: OPSUBLOAD
	 */
	public java.lang.Integer getOpsubload () {
		return opsubload;
	}

	/**
	 * Set the value related to the column: OPSUBLOAD
	 * @param opsubload the OPSUBLOAD value
	 */
	public void setOpsubload (java.lang.Integer opsubload) {
		this.opsubload = opsubload;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.citycard.common.po.BaseCodeGroup)) return false;
		else {
			cn.com.newcapec.citycard.common.po.BaseCodeGroup baseCodeGroup = (cn.com.newcapec.citycard.common.po.BaseCodeGroup) obj;
			if (null == this.getId() || null == baseCodeGroup.getId()) return false;
			else return (this.getId().equals(baseCodeGroup.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public int compareTo (Object obj) {
		if (obj.hashCode() > hashCode()) return 1;
		else if (obj.hashCode() < hashCode()) return -1;
		else return 0;
	}

	public String toString () {
		return super.toString();
	}


}