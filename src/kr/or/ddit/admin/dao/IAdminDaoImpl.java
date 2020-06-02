package kr.or.ddit.admin.dao;

import java.sql.SQLException;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.AdminVO;

public class IAdminDaoImpl implements IAdminDao {
	
	private static IAdminDao dao = new IAdminDaoImpl();
	private SqlMapClient client;
	
	private IAdminDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IAdminDao getInstance() {
		return (dao == null) ? dao = new IAdminDaoImpl() : dao;
	}

	@Override
	public AdminVO adminInfo(Map<String, String> params) throws SQLException {
		return (AdminVO) client.queryForObject("admin.adminInfo", params);
	}

}
