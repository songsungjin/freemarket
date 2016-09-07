package sist.co.service;

import sist.co.model.SistMemberDTO;

public interface SistMemberService {

	SistMemberDTO login(SistMemberDTO member)throws Exception;	
	boolean addMember(SistMemberDTO member)throws Exception;
	
	int getID(SistMemberDTO member);
}
