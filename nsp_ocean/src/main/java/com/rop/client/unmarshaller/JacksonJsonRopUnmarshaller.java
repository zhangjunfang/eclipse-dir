
package com.rop.client.unmarshaller;

import com.rop.RopException;
import com.rop.client.RopUnmarshaller;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import java.io.IOException;

/**
 * <pre>
 * 功能说明：
 * </pre>
 */
public class JacksonJsonRopUnmarshaller implements RopUnmarshaller {

    private static ObjectMapper objectMapper;

    @Override
    public <T> T unmarshaller(String content, Class<T> objectType) {
        try {
            return getObjectMapper().readValue(content, objectType);
        } catch (IOException e) {
            throw new RopException(e);
        }
    }

    private ObjectMapper getObjectMapper() throws IOException {
        if (JacksonJsonRopUnmarshaller.objectMapper == null) {
            ObjectMapper objectMapper = new ObjectMapper();
            AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
            SerializationConfig serializationConfig = objectMapper.getSerializationConfig();
            serializationConfig = serializationConfig.without(SerializationConfig.Feature.WRAP_ROOT_VALUE)
                                                     .withAnnotationIntrospector(introspector);
            objectMapper.setSerializationConfig(serializationConfig);
            JacksonJsonRopUnmarshaller.objectMapper = objectMapper;
        }
        return JacksonJsonRopUnmarshaller.objectMapper;
    }
}

