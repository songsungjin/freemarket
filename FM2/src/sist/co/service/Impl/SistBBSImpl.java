package sist.co.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sist.co.model.SistBBSDTO;
import sist.co.model.SistBBSParam;
import sist.co.service.SistBBSDao;
import sist.co.service.SistBBSService;

@Service
public class SistBBSImpl implements SistBBSService {

	@Autowired
	private SistBBSDao sistBBSDao;

	@Override
	@Transactional(readOnly=true)
	public List<SistBBSDTO> getBBSList() throws Exception {		
		return sistBBSDao.getBBSList();
	}

	@Override
	@Transactional
	public boolean writeBBS(SistBBSDTO bbs) throws Exception {		
		return sistBBSDao.writeBBS(bbs);
	}

	@Override
	@Transactional(readOnly=true)
	public SistBBSDTO getBBS(SistBBSDTO bbs) throws Exception {		
		return sistBBSDao.getBBS(bbs);
	}

	@Override
	@Transactional
	public boolean readcount(int seq) throws Exception {		
		return sistBBSDao.readcount(seq);		
	}

	@Override
	@Transactional
	public int getBBSCount(SistBBSParam param) throws Exception {
		return sistBBSDao.getBBSCount(param);		
	}

	@Override
	@Transactional
	public List<SistBBSDTO> getBBSPagingList(SistBBSParam param) throws Exception {
		// TODO Auto-generated method stub
		return sistBBSDao.getBBSPagingList(param);		
	}

	@Override
	@Transactional
	public void reply(SistBBSDTO bbs) throws Exception {
		sistBBSDao.replyBBSUpdate(bbs);
		sistBBSDao.replyBBSInsert(bbs);		
	}

	@Override
	@Transactional
	public void updateBBS(SistBBSDTO bbs) {
		sistBBSDao.updateBBS(bbs);		
	}

	@Override
	public void deleteBBS(SistBBSDTO bbs) {
		// TODO Auto-generated method stub
		sistBBSDao.deleteBBS(bbs);		
	}	
	
	
	
}










