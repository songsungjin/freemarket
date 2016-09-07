package sist.co.service;

import java.util.List;

import sist.co.help.PollBean;
import sist.co.model.SistPollDTO;
import sist.co.model.SistPollSub;
import sist.co.model.SistVoter;

public interface SistPollService {

	public List<SistPollDTO> getPollAllList(String id);		
	public void makePoll(PollBean pBean);
	
	public SistPollDTO getPoll(SistPollDTO poll);
	public List<SistPollSub> getPollSubList(SistPollDTO poll);
	
	void polling(SistVoter voter);
	
}






