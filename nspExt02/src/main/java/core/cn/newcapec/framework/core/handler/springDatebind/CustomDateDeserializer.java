package cn.newcapec.framework.core.handler.springDatebind;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class CustomDateDeserializer extends JsonDeserializer<Date> {
	Logger logger = Logger.getLogger(CustomDateDeserializer.class);
	private static final String[] DATE = { "yyyy-MM-dd" };

	@Override
	public Date deserialize(JsonParser parser, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		try {
			return DateUtils.parseDate(parser.getText(), DATE);
		} catch (ParseException e) {
			logger.error("ParseException: ", e);
		}
		return null;
	}

}