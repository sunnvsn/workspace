package com.lianlife.demo.model.velocity;

import java.util.Map;

public interface VelocityService {
	
	public String mergeTemplateIntoString(String res, Map model);
	public String evaluate(String str, Map model);

}
