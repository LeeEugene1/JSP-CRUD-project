package kr.or.ddit.qnada.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.qnada.dao.IQnadaDao;
import kr.or.ddit.qnada.dao.IQnadaDaoImpl;
import kr.or.ddit.vo.QandaVO;

public class IQnadaServiceImpl implements IQnadaService {
	
	private static IQnadaService service = new IQnadaServiceImpl();
	private IQnadaDao dao;
	
	private IQnadaServiceImpl() {
		dao = IQnadaDaoImpl.getInstance();
	}

	public static IQnadaService getInstance(){
		return(service == null) ? service = new IQnadaServiceImpl() : service;
	}
	
	@Override
	public QandaVO qandaInfo(Map<String, String> params) {
		QandaVO qandaInfo = null;
		try {
			qandaInfo = dao.qandaInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qandaInfo;
	}

	@Override
	public List<QandaVO> qnadaList(Map<String, String> params) {
		List<QandaVO> qnadaList = null;
		try {
			qnadaList = dao.qnadaList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qnadaList;
	}

	@Override
	public List<QandaVO> qnadaList() {
		List<QandaVO> qnadaList = null;
		try {
			qnadaList = dao.qnadaList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qnadaList;
	}

	@Override
	public String insertQnadaInfo(QandaVO qnadaInfo) {
		String qa_no = null;
		try {
			qa_no = dao.insertQnadaInfo(qnadaInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qa_no;
	}


	@Override
	public void updateQnadaInfo(QandaVO qnadaInfo) {
		try {
			dao.updateQnadaInfo(qnadaInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteQnadaInfo(Map<String, String> params) {
		try {
			dao.deleteQnadaInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount = "0";
		try {
			totalCount = dao.totalCount(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCount;
	}

	@Override
	public void insertQandaReply(QandaVO qandaInfo) {
		
		try{
			dao.insertQandaReply(qandaInfo);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
