package kr.or.ddit.utiles;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CryptoInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		
     	Map<String, String> publicKeyMap = CryptoGenerator.getGeneratePairKey(session);
     	request.setAttribute("publicKeyMap", publicKeyMap);
     	
     	String returnValue = actionInvocation.invoke();
     	
		return returnValue;
	}

}
