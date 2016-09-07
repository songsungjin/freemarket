package sist.co.service;

import java.util.List;

import sist.co.model.SistBBSDTO;
import sist.co.model.SistBBSParam;

public interface SistBBSService {

	List<SistBBSDTO> getBBSList()throws Exception;
	boolean writeBBS(SistBBSDTO bbs)throws Exception;
	
	SistBBSDTO getBBS(SistBBSDTO bbs) throws Exception;
	boolean readcount(int seq) throws Exception;
	
	int getBBSCount(SistBBSParam param) throws Exception;
	List<SistBBSDTO> getBBSPagingList(SistBBSParam param)throws Exception;
	
	void reply(SistBBSDTO bbs)throws Exception;
	
	void updateBBS(SistBBSDTO bbs);
	
	void deleteBBS(SistBBSDTO bbs);
}


