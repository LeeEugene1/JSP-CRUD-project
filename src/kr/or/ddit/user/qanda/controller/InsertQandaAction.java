package kr.or.ddit.user.qanda.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import kr.or.ddit.qnada.service.IQnadaService;
import kr.or.ddit.qnada.service.IQnadaServiceImpl;
import kr.or.ddit.vo.QandaVO;

import com.opensymphony.xwork2.ModelDriven;

public class InsertQandaAction implements ModelDriven<QandaVO> {
	
	private QandaVO qandaInfo;
	private String message;
	
	public String insertQandaInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		try {
			BeanUtils.populate(qandaInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		IQnadaService service = IQnadaServiceImpl.getInstance();
		service.insertQnadaInfo(qandaInfo);
		
		try {
			this.message = URLEncoder.encode("게시물 작성이 완료되었습니다", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "success";
	}

	@Override
	public QandaVO getModel() {
		this.qandaInfo = new QandaVO();
		return qandaInfo;
	}

	public String getMessage() {
		return message;
	}

}
