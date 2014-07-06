package com.radiadesign.catalina.session;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.servlet.http.HttpSession;
import org.apache.catalina.util.CustomObjectInputStream;

public class JavaSerializer implements Serializer {
	private ClassLoader loader;

	public void setClassLoader(ClassLoader loader) {
		this.loader = loader;
	}

	public byte[] serializeFrom(HttpSession session) throws IOException {
		RedisSession redisSession = (RedisSession) session;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Object localObject1 = null;
		Object localObject4 = null;
		Object localObject3 = null;
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(bos));
		} finally {
			ObjectOutputStream oos;
			localObject3 = localThrowable;
			break label107;
			if (localObject3 != localThrowable)
				localObject3.addSuppressed(localThrowable);
		}
		return bos.toByteArray();
	}

	public HttpSession deserializeInto(byte[] data, HttpSession session)
			throws IOException, ClassNotFoundException {
		RedisSession redisSession = (RedisSession) session;

		BufferedInputStream bis = new BufferedInputStream(
				new ByteArrayInputStream(data));

		ObjectInputStream ois = new CustomObjectInputStream(bis, this.loader);
		redisSession.setCreationTime(ois.readLong());
		redisSession.readObjectData(ois);

		return session;
	}
}