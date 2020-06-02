package kr.or.ddit.zipcode.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.ZipcodeVO;

public class IZipcodeDaoImpl implements IZipcodeDao {
	private static IZipcodeDao dao = new IZipcodeDaoImpl();
	private SqlMapClient client;
	
	private IZipcodeDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IZipcodeDao getInstance(){
		return (dao == null) ? dao = new IZipcodeDaoImpl() : dao;
	}
	
	@Override
	public List<ZipcodeVO> zipcodeList(Map<String, String> params) throws SQLException {
		return client.queryForList("zipcode.zipcodeList", params);
	}

}
