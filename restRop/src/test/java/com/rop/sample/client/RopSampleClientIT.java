
package com.rop.sample.client;

import com.rop.client.CompositeResponse;
import com.rop.sample.request.CreateUserRequest;
import com.rop.sample.request.Telephone;
import com.rop.sample.response.CreateUserResponse;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class RopSampleClientIT {
    public static final String APP_KEY = "00001";
    public static final String APP_SECRET = "abcdeabcdeabcdeabcdeabcde";

    RopSampleClient ropSampleClient = new RopSampleClient(APP_KEY,APP_SECRET);

    @Test
    public void testLogon() throws Exception {
        String sessionId = ropSampleClient.logon("tomson", "123456");
        assertNotNull(sessionId);
    }

    @Test
    public void testLogout() throws Exception {
        ropSampleClient.logout();
    }

    @SuppressWarnings("rawtypes")
	@Test
    public void addUser() {

        ropSampleClient.logon("tomson", "123456");

        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setUserName("katty");
        createUserRequest.setSalary(2500L);

        Telephone telephone = new Telephone();
        telephone.setZoneCode("010");
        telephone.setTelephoneCode("12345678");
        createUserRequest.setTelephone(telephone);

        CompositeResponse response = ropSampleClient.buildClientRequest()
                                                      .post(createUserRequest, CreateUserResponse.class, "user.add", "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertTrue(response.getSuccessResponse() instanceof CreateUserResponse);
    }
}

