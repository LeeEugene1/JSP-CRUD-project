package kr.or.ddit.admin.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.admin.dao.IAdminDao;
import kr.or.ddit.admin.dao.IAdminDaoImpl;
import kr.or.ddit.vo.AdminVO;

public class IAdminServiceImpl implements IAdminService {
	
	private static IAdminService service = new IAdminServiceImpl();
	private IAdminDao dao;
	
	private IAdminServiceImpl() {
		dao = IAdminDaoImpl.getInstance();
	}
	
	public static IAdminService getInstance() {
		return (service == null) ? service = new IAdminServiceImpl() : service;
	}

	@Override
	public AdminVO adminInfo(Map<String, String> params) {
		AdminVO info = null;
		
		try {
			info = dao.adminInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return info;
	}

}
