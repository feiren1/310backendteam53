package csci310.web;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import csci310.models.Proposal;
import csci310.models.User;
import csci310.payload.UserProposalRequest;
import csci310.repositories.UserRepository;
import csci310.service.UserProposalService;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainPageControllerTest {

	@InjectMocks
	MainPageController controller;
	
	@Mock
	UserProposalService users;
	
	@Test
	public void testgetProposals() {
		UserProposalRequest request = new UserProposalRequest();
		request.setKey("un");
		
		User u = new User("un", "pwd");
		Proposal p = new Proposal(u.getId());
		List<Proposal> pList = new ArrayList<Proposal>();
		pList.add(p);
		
		when(users.getUserProposals("un")).thenReturn(pList);
		List<Proposal> result = controller.getProposals(request);
		assertEquals(result, pList);
	}
	
	public void testgetTest() {
		String hello = controller.getTest();
		assertEquals("HELLO WORLD", hello);
	}
	
}
