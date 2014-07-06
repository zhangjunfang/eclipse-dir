package com.googlecode.common.remote.pool.client;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;



/**
 *
 * @author jiafu
 *
 */
public class CommonRemotePoolClient {

    /**
     * http://10.224.38.166:8080/common-remote-pool/
     */
    private String url;

    /**
     * @param url such as http://10.224.38.166/common-remote-pool/
     */
    public CommonRemotePoolClient(String url) {
        super();
        if(!url.endsWith("/"))
            url+="/";
        this.url = url;

    }

    /**
     * @param classType
     * @return return null if now object can be borrowed.
     */
    public <T> T borrowObject(Class<T> classType) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        try {
            ResteasyWebTarget target = client.target(url + "service/object/borrow");
            Response response = target.request().get();
            if (response.getStatus() == 404)
                return null;

            T readEntity = response.readEntity(classType);
            return readEntity;
         } finally {
            client.close();
        }

    }

    public <T> boolean returnObject(Object object) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        try {
            ResteasyWebTarget target = client.target(url + "service/object/return");
            Response response = target.request().post(Entity.json(object));

            return response.getStatus() <= 204 && response.getStatus()>=200;
         } finally {
            client.close();
        }
    }

    public <T> boolean addObject(Object... objects) {
         ResteasyClient client = new ResteasyClientBuilder().build();
        try {
        	for (Object object2 : objects) {
                ResteasyWebTarget target = client.target(url + "service/object/add");
                Response response = target.request().post(Entity.json(object2));
                if(response.getStatus() >204)
                	return false;
			}
              return true;
         } finally {
            client.close();
        }
    }

}
