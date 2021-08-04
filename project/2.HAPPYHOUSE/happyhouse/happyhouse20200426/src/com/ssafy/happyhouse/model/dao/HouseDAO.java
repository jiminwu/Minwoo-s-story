package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.HousePageBean;
import com.ssafy.happyhouse.model.dto.Notice;

public interface HouseDAO {
	/**
	 * 아파트 거래 정보를 xml 파일에서 로딩하는 기능 
	 */
	public void loadData();
		
	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 아파트 거래 정보(HouseInfo)를  검색해서 반환.  
	 * @param bean  검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 목록
	 */
	public List<HouseDeal> searchAll(HousePageBean  bean) throws SQLException;
	
	/**
	 * 아파트 식별 번호에 해당하는 아파트 거래 정보를 검색해서 반환. 
	 * @param no	검색할 아파트 식별 번호
	 * @return		아파트 식별 번호에 해당하는 아파트 거래 정보를 찾아서 리턴한다, 없으면 null이 리턴됨
	 */
	public HouseDeal search(int no) throws SQLException;	
	public int getSize(HousePageBean bean) throws SQLException; // 아파트 정보의 총 갯수를 리턴.
	public HouseDeal searchByName(String AptName) throws SQLException;
	public List<Notice> searchNotice() throws SQLException;

	public Notice searchNoticeByNo(int no) throws SQLException;
}
