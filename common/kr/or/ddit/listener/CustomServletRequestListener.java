package kr.or.ddit.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class CustomServletRequestListener implements
		ServletRequestAttributeListener, ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// HttpServletRequest이 GC되기 직전에 전파되는 이벤트 청취자
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// HttpServletRequest이 인스턴스화 직후에 전파되는 이벤트 청취자
	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		// HttpServletRequest.setAttribute(키,값) 저장시 전파되는 이벤트 청취자
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		// HttpServletRequest.removeAttribute(키) 삭제시 전파되는 이벤트 청취자

	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		// HttpServletRequest.setAttribute(동일키, 상이값) 갱신시 전파되는 이벤트 청취자
	}

}
