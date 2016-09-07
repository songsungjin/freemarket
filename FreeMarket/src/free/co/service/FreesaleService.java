package free.co.service;

import java.util.List;

import free.co.model.FreeSaleDTO;

public interface FreesaleService {
	
	List<FreeSaleDTO> salelist() throws Exception;
}
