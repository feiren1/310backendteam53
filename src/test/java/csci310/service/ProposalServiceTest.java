package csci310.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import csci310.models.Proposal;
import csci310.models.User;
//import csci310.payload.UserProposalRequest;
import csci310.repositories.ProposalRepository;
import csci310.repositories.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProposalServiceTest {

	@InjectMocks
	ProposalService service;
	
	@Mock
	ProposalRepository proposals;
	
	@Test
	public void testfindByUid() {
		Proposal p = new Proposal(1234);
		int uid = p.getId();
		
		when(proposals.findByUid(uid)).thenReturn(p);
		
		Proposal resultProposal = service.findByUid(uid);
		assertEquals(p, resultProposal);
	}
	
	@Test
	public void testfindByHostuid() {
		User u = new User("un", "pwd");
		int uid = u.getId();
		
		List<Proposal> list = new ArrayList<Proposal>();
		Proposal p1 = new Proposal(uid);
		Proposal p2 = new Proposal(uid);
		list.add(p1);
		list.add(p2);
		
		when(proposals.findByHost(uid)).thenReturn(list);
		
		List<Proposal> result = service.findByHostuid(uid);
        assertEquals(2, result.size());
        assertEquals(list, result);
		
	}
	
	@Test
	public void testsaveOrUpdateProposal() {
		Proposal p = new Proposal(1234);
		
		when(proposals.save(p)).thenReturn(p);
		
		Proposal resultProposal = service.saveOrUpdateProposal(p);
		assertEquals(p, resultProposal);
		
		Proposal resultProposal2 = service.saveOrUpdateProposal(p);
		assertEquals(p, resultProposal2);
	}
	
}
