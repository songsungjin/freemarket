package sist.co.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sist.co.model.SistPDSDTO;
import sist.co.service.SistPDSDao;
import sist.co.service.SistPDSService;

@Service
public class SistPDSImpl implements SistPDSService {
	
	@Autowired
	private SistPDSDao sistPDSDao;

	@Override
	public List<SistPDSDTO> getPDSList() {
		
		return sistPDSDao.getPDSList();
	}

	@Override
	public void uploadPDS(SistPDSDTO dto) {
		sistPDSDao.uploadPDS(dto);		
	}

	@Override
	public void pdsReadCount(int seq) {		
		sistPDSDao.pdsReadCount(seq);
	}

	@Override
	public SistPDSDTO getPDS(int seq) {		
		return sistPDSDao.getPDS(seq);		
	}

	@Override
	public void pdsdel(int seq){
		sistPDSDao.pdsdel(seq);
	}

	@Override
	public void downloadCount(int seq) {
		sistPDSDao.downloadCount(seq);		
	}

	@Override
	public void updatePDS(SistPDSDTO pdsdto) {
		sistPDSDao.updatePDS(pdsdto);		
	}
	

	
}
