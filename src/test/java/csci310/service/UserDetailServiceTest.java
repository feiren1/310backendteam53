package csci310.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import csci310.models.Proposal;
import csci310.models.User;
import csci310.models.UserPrincipal;
//import csci310.payload.UserProposalRequest;
import csci310.repositories.ProposalRepository;
import csci310.repositories.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailServiceTest {

	@InjectMocks
	UserDetailService service;
	
	@Mock
	UserRepository users;
	
	@Test
	public void testloadUserByUsername() {
		User u1 = new User("un", "pwd");
		
		when(users.findByUsername("un")).thenReturn(u1);
		UserDetails r1 = service.loadUserByUsername("un");
		assertEquals(r1.getUsername(), u1.getUsername());
		assertEquals(r1.getPassword(), u1.getPassword());
	}
	
	@Test(expected = UsernameNotFoundException.class)
	public void testloadUserByUsername2() {
		when(users.findByUsername("dne")).thenReturn(null);
		UserDetails r3 = service.loadUserByUsername("dne");
		assertEquals(r3, null);
	}
	
}
