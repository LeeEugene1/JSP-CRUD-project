package kr.or.ddit.listener;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import kr.or.ddit.vo.MemberVO;

public class SessionManager implements HttpSessionAttributeListener,
      HttpSessionListener {
   public static SessionManager sessionMGR = null;
   
   public static Hashtable<String, Object> sessionTable;
   
   public SessionManager(){
      if(sessionTable == null){
         sessionTable = new Hashtable<String, Object>();
      }
   }
   
   public static synchronized SessionManager getInstance(){
      if(sessionMGR == null){
         sessionMGR = new SessionManager();
      }
      return sessionMGR;
   }
   
   
   @Override
   public void sessionCreated(HttpSessionEvent event) {
      HttpSession newCreateSession = event.getSession();
      synchronized (sessionTable) {
         sessionTable.put(newCreateSession.getId(), newCreateSession);
      }
   }

   @Override
   public void sessionDestroyed(HttpSessionEvent event) {
      HttpSession removeSession = event.getSession();
      synchronized (sessionTable) {
         sessionTable.remove(removeSession.getId());
      }
   }
   
   //loginCheck.jsp SessionManager.loginDuplicationCheck(session.getId(), 회원아이디);
   public boolean loginDuplicationCheck(String sessionID, String mem_id){
      boolean flag = false;
      
      Enumeration<Object> sessions = sessionTable.elements();
      
      while(sessions.hasMoreElements()){
         HttpSession savedSession = (HttpSession) sessions.nextElement();
         
         MemberVO loginedMemberInfo = (MemberVO) savedSession.getAttribute("LOGIN_MEMBERINFO");
         
         if(loginedMemberInfo != null){
            if(mem_id.intern() == loginedMemberInfo.getMem_id().intern() && 
            		sessionID.intern() != savedSession.getId().intern()){
            	savedSession.invalidate();
            	flag = true;
            }
         }
      }
      return flag;
   }
   
   public int userCount(){
	   return sessionTable.size();
   }
   

   @Override
   public void attributeAdded(HttpSessionBindingEvent arg0) {
      // TODO Auto-generated method stub

   }

   @Override
   public void attributeRemoved(HttpSessionBindingEvent arg0) {
      // TODO Auto-generated method stub

   }

   @Override
   public void attributeReplaced(HttpSessionBindingEvent arg0) {
      // TODO Auto-generated method stub

   }

}