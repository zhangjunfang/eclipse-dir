package cn.newcapec.function.ecardcity.om.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.newcapec.framework.core.rest.BaseRequest;
import cn.newcapec.framework.core.rest.BaseResource;
import cn.newcapec.framework.core.rest.BaseResourceHandler;
import cn.newcapec.framework.core.rest.BaseResponse;
import cn.newcapec.framework.core.rest.Msg;
@SuppressWarnings("all")
@Component(value="collectResource")
//@Scope("prototype")
public class CollectResource extends BaseResource implements
		BaseResourceHandler, Serializable {

	private static final long serialVersionUID = -7865679842672072786L;

	public void getIndustryList(BaseRequest request, BaseResponse response) {
		List<String> list = new ArrayList<String>(30);
		for (int i = 0; i < 30; i++) {
			list.add(i+"");
		}
		Msg msg = new Msg();
		msg.setMsg("dempartment Item");
		msg.setData(list);
		response.print(msg.toJSONObjectPresention());
	}

	
}
