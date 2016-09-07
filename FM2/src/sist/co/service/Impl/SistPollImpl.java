package sist.co.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sist.co.help.PollBean;
import sist.co.model.SistPollDTO;
import sist.co.model.SistPollSub;
import sist.co.model.SistVoter;
import sist.co.service.SistPollDao;
import sist.co.service.SistPollService;

@Service
public class SistPollImpl implements SistPollService {
	
	@Autowired
	private SistPollDao sistPollDao;

	@Override
	public List<SistPollDTO> getPollAllList(String id) {
		
		List<SistPollDTO> plists = sistPollDao.getPollAllList();		
		List<SistPollDTO> plists2 = new ArrayList<SistPollDTO>();
		
		for(SistPollDTO poll:plists){
			
			int pollid = poll.getPollid();
			int count = sistPollDao.isVote(new SistVoter(pollid, -1, id));
			
			if(count > 0){	// 투표했음
				poll.setVote(true);
			}else{			// 안했음
				poll.setVote(false);
			}		
			plists2.add(poll);
		}
		
		return plists2;
	}

	@Override
	public void makePoll(PollBean pBean) {
		
		SistPollDTO poll = new SistPollDTO(
					pBean.getId(),
					pBean.getQuestion(),
					pBean.getSdate(),
					pBean.getEdate(),
					pBean.getItemcount(),
					0
				);
		
		sistPollDao.makePoll(poll);
		
		int itemcount = pBean.getItemcount();
		String answer[] = pBean.getPollnum();
		
		for(int i = 0;i < itemcount; i++){
			SistPollSub pollsub = new SistPollSub();
			pollsub.setAnswer(answer[i]);
			sistPollDao.makePollSub(pollsub);			
		}			
	}

	@Override
	public SistPollDTO getPoll(SistPollDTO poll) {		
		return sistPollDao.getPoll(poll);
	}

	@Override
	public List<SistPollSub> getPollSubList(SistPollDTO poll) {
		// TODO Auto-generated method stub
		return sistPollDao.getPollSubList(poll);		
	}

	@Override
	public void polling(SistVoter voter) {
		sistPollDao.pollingPoll(voter);
		sistPollDao.pollingSub(voter);
		sistPollDao.pollingVote(voter);		
	}		
}





