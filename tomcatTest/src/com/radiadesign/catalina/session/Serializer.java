package com.radiadesign.catalina.session;

import java.io.IOException;
import javax.servlet.http.HttpSession;

public abstract interface Serializer {
	public abstract void setClassLoader(ClassLoader paramClassLoader);

	public abstract byte[] serializeFrom(HttpSession paramHttpSession)
			throws IOException;

	public abstract HttpSession deserializeInto(byte[] paramArrayOfByte,
			HttpSession paramHttpSession) throws IOException,
			ClassNotFoundException;
}