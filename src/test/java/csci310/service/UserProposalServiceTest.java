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
public class UserProposalServiceTest {

	@InjectMocks
	UserProposalService service;
	
	@Mock
	ProposalRepository proposals;
	@Mock
	UserRepository users;
	
	@Test
	public void testTestTest() {
		assertTrue(true);
	}
	
	@Test
	public void testgetUserProposals() {
		
		List<Proposal> list = new ArrayList<Proposal>();
		Proposal p1 = new Proposal((long) 1111);
		Proposal p2 = new Proposal((long) 2222);
		Proposal p3 = new Proposal((long) 3333);
         
        list.add(p1);
        list.add(p2);
        list.add(p3);
        
        User u1 = new User("username1", "pwd1");
        u1.addReceivedProposal(p1.getId());
        u1.addReceivedProposal(p2.getId());
        u1.addReceivedProposal(p3.getId());
         
        when(proposals.findByProposalId(p1.getId())).thenReturn(p1);
        when(proposals.findByProposalId(p2.getId())).thenReturn(p2);
        when(proposals.findByProposalId(p3.getId())).thenReturn(p3);
        
        when(users.findByUsername("username1")).thenReturn(u1);
         
        //test
        List<Proposal> result = service.getUserProposals("username1");
         
        assertEquals(3, result.size());
        verify(users, times(1)).findByUsername("username1");
		
	}
	
}
