package kr.or.ddit.qnada.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.QandaVO;

public interface IQnadaService {
	public QandaVO qandaInfo(Map<String, String> params);
	public List<QandaVO> qnadaList(Map<String, String> params);
	public List<QandaVO> qnadaList();
	public String insertQnadaInfo(QandaVO qnadaInfo);
	public void updateQnadaInfo(QandaVO qnadaInfo);
	public void deleteQnadaInfo(Map<String, String> params);
	public String totalCount(Map<String, String> params);
	public void insertQandaReply(QandaVO qandaInfo);
}
