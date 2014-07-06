package cn.newcapec.function.citycard.platform.privilege.model;

import cn.newcapec.framework.support.model.AppBaseModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 资源角色关联表
 * @author andy.li
 *
 */

@Entity
@Table(name = "t_role_resource")
public class RoleResource  extends AppBaseModel implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -4704292831161148871L;
	/*角色编号*/
	private String roleId;
	/*资源编号*/
	private String resourceId;
	/*操作人*/
	private String operationId;
	/*操作时间*/
	private Date createDatetime;
	/*更新人*/
	private String updateUserId;
	/*更新时间*/
	private Date updateTime;
	
	public  RoleResource(){
		
	}
	

	@Column(name = "role_id",length=32)
	public String getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "resource_id",length=32)
	public String getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	  @Temporal(TemporalType.TIMESTAMP)
		@Column(name = "create_datetime")
		public Date getCreateDatetime() {
			return this.createDatetime;
		}

		public void setCreateDatetime(Date createDatetime) {
			this.createDatetime = createDatetime;
		}
		
		
		@Column(name = "operation_id", length = 32)
		public String getOperationId() {
			return operationId;
		}

		public void setOperationId(String operationId) {
			this.operationId = operationId;
		}

		@Column(name = "update_user_id", length = 32)
		public String getUpdateUserId() {
			return updateUserId;
		}

		public void setUpdateUserId(String updateUserId) {
			this.updateUserId = updateUserId;
		}

	    @Temporal(TemporalType.TIMESTAMP)
		@Column(name = "update_time")
		public Date getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
		}



}
