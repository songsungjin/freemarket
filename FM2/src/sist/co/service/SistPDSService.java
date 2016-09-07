package sist.co.service;

import java.util.List;
import sist.co.model.SistPDSDTO;

public interface SistPDSService {
	
	public List<SistPDSDTO> getPDSList();
	public void uploadPDS(SistPDSDTO dto);
	
	public void pdsReadCount(int seq);
	public SistPDSDTO getPDS(int seq);
	
	public void pdsdel(int seq);
	
	public void downloadCount(int seq);
	
	public void updatePDS(SistPDSDTO pdsdto);
}
