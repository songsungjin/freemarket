package free.co.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import free.co.model.FreeSaleDTO;
import free.co.service.FreesaleDao;
import free.co.service.FreesaleService;

@Service
public class FreesaleImpl implements FreesaleService {
	
	@Autowired private FreesaleDao freesaleDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<FreeSaleDTO> salelist() throws Exception {
		
		return freesaleDao.salelist();
	}
}
