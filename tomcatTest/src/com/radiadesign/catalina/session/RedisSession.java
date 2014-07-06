package com.radiadesign.catalina.session;

import java.security.Principal;
import java.util.HashMap;
import java.util.logging.Logger;
import org.apache.catalina.Manager;
import org.apache.catalina.session.StandardSession;

public class RedisSession extends StandardSession {
	private static Logger log = Logger.getLogger("RedisSession");

	protected static Boolean manualDirtyTrackingSupportEnabled = Boolean
			.valueOf(false);

	protected static String manualDirtyTrackingAttributeKey = "__changed__";
	protected HashMap<String, Object> changedAttributes;
	protected Boolean dirty;

	public static void setManualDirtyTrackingSupportEnabled(Boolean enabled) {
		manualDirtyTrackingSupportEnabled = enabled;
	}

	public static void setManualDirtyTrackingAttributeKey(String key) {
		manualDirtyTrackingAttributeKey = key;
	}

	public RedisSession(Manager manager) {
		super(manager);
		resetDirtyTracking();
	}

	public Boolean isDirty() {
		if ((!this.dirty.booleanValue()) && (this.changedAttributes.isEmpty()))
			return Boolean.valueOf(false);
		return Boolean.valueOf(true);
	}

	public HashMap<String, Object> getChangedAttributes() {
		return this.changedAttributes;
	}

	public void resetDirtyTracking() {
		this.changedAttributes = new HashMap();
		this.dirty = Boolean.valueOf(false);
	}

	public void setAttribute(String key, Object value) {
		if ((manualDirtyTrackingSupportEnabled.booleanValue())
				&& (manualDirtyTrackingAttributeKey.equals(key))) {
			this.dirty = Boolean.valueOf(true);
			return;
		}

		Object oldValue = getAttribute(key);
		if (((value == null) && (oldValue != null))
				|| ((oldValue == null) && (value != null))
				|| (!value.getClass().isInstance(oldValue))
				|| (!value.equals(oldValue))) {
			this.changedAttributes.put(key, value);
		}

		super.setAttribute(key, value);
	}

	public void removeAttribute(String name) {
		this.dirty = Boolean.valueOf(true);
		super.removeAttribute(name);
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPrincipal(Principal principal) {
		this.dirty = Boolean.valueOf(true);
		super.setPrincipal(principal);
	}
}