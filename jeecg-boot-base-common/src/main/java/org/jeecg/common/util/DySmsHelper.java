package org.jeecg.common.util;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 17/6/7.
 * 短信API产品的DEMO程序,工程中包含了一个SmsDemo类，直接通过
 * 执行main函数即可体验短信产品API功能(只需要将AK替换成开通了云通信-短信产品功能的AK即可)
 * 工程依赖了2个jar包(存放在工程的libs目录下)
 * 1:aliyun-java-sdk-core.jar
 * 2:aliyun-java-sdk-dysmsapi.jar
 *
 * 备注:Demo工程编码采用UTF-8
 * 国际短信发送请勿参照此DEMO
 */
@Slf4j
public class DySmsHelper {
	
	private final static Logger logger=LoggerFactory.getLogger(DySmsHelper.class);

    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static  String accessKeyId = "LTAI4Fr4ysX4vF3hWjuAPYVm";
    static  String accessKeySecret = "3EXLsJQyZ3Sc49oyAZgzxQhjxtVGZv";

    public static void setAccessKeyId(String accessKeyId) {
        DySmsHelper.accessKeyId = accessKeyId;
    }

    public static void setAccessKeySecret(String accessKeySecret) {
        DySmsHelper.accessKeySecret = accessKeySecret;
    }

    public static String getAccessKeyId() {
        return accessKeyId;
    }

    public static String getAccessKeySecret() {
        return accessKeySecret;
    }
    
    
    public static boolean sendSms(String phone,JSONObject templateParamJson,DySmsEnum dySmsEnum) throws ClientException {
    	//可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        
        //验证json参数
        validateParam(templateParamJson,dySmsEnum);

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest("Sms","2017-05-25","SendSms");
        request.setMethod(MethodType.POST);
        request.setVersion("2017-05-25");
        request.setActionName("SendSms");

		request.putQueryParameter("PhoneNumbers", phone);
		request.putQueryParameter("TemplateCode",dySmsEnum.getTemplateCode());
		request.putQueryParameter("SignName",dySmsEnum.getSignName() );
		request.putQueryParameter("TemplateParam", templateParamJson.toJSONString());
        log.info(phone+":"+templateParamJson.toJSONString());

        CommonResponse response = client.getCommonResponse(request);
        return true;

    }

    private static void validateParam(JSONObject templateParamJson,DySmsEnum dySmsEnum) {
    	String keys = dySmsEnum.getKeys();
    	String [] keyArr = keys.split(",");
    	for(String item :keyArr) {
    		if(!templateParamJson.containsKey(item)) {
    			throw new RuntimeException("模板缺少参数："+item);
    		}
    	}
    }
    

    public static void main(String[] args) throws ClientException, InterruptedException {
        JSONObject obj = new JSONObject();
        obj.put("code", "344112");
        DySmsHelper.sendSms("13800138000",obj,DySmsEnum.LOGIN_TEMPLATE_CODE);
    }
}
