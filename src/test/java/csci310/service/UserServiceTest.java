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
public class UserServiceTest {

	@InjectMocks
	UserService service;
	
	@Mock
	UserRepository users;
	
	@Test
	public void testfindAll() {
		User u1 = new User("un", "pwd");
		User u2 = new User("un1", "pwd1");
		User u3 = new User("un11", "pwd11");
		
		List<User> all = new ArrayList<User>();
		all.add(u1);
		all.add(u2);
		all.add(u3);
		
		when(users.findAll()).thenReturn(all);
		
		List<User> allResult = service.findAll();
		assertEquals(all, allResult);
	}
	
	@Test
	public void testfindByUsername() {
		User u1 = new User("un", "pwd");
		User u2 = new User("un1", "pwd1");
		User u3 = new User("un11", "pwd11");
		
		List<User> all = new ArrayList<User>();
		all.add(u1);
		all.add(u2);
		all.add(u3);
		
		when(users.findByUsername("un")).thenReturn(u1);
		User r1 = service.findByUsername("un");
		assertEquals(r1, u1);
		
		when(users.findByUsername("un1")).thenReturn(u2);
		User r2 = service.findByUsername("un1");
		assertEquals(r2, u2);
		
		when(users.findByUsername("un2")).thenReturn(null);
		User r3 = service.findByUsername("un2");
		assertEquals(r3, null);
	}
	
	@Test
	public void testsearchByUsername() {
		User u1 = new User("un", "pwd");
		User u2 = new User("un1", "pwd1");
		User u3 = new User("un11", "pwd11");
		
		List<User> all = new ArrayList<User>();
		when(users.searchByUsername("x")).thenReturn(all);
		List<User> l1 = service.searchByUsername("x");
		assertEquals(l1, all);
		
		all.add(u1);
		when(users.searchByUsername("un")).thenReturn(all);
		List<User> l2 = service.searchByUsername("un");
		assertEquals(l2, all);
		
		all.add(u2);
		all.add(u3);
		when(users.searchByUsername("un")).thenReturn(all);
		List<User> l3 = service.searchByUsername("un");
		assertEquals(l3, all);
	}
	
	@Test
	public void testfindById() {
		User u1 = new User("un", "pwd");
		int uid = u1.getId();
		
		when(users.findByUid(uid)).thenReturn(u1);
		User r1 = service.findById(uid);
		assertEquals(r1, u1);
		
		when(users.findByUid(uid+1)).thenReturn(null);
		User r2 = service.findById(uid+1);
		assertEquals(r2, null);
	}
	
	@Test
	public void testfindAllByOrderByUsernameDesc() {
		User u1 = new User("un", "pwd");
		User u2 = new User("un1", "pwd1");
		User u3 = new User("un11", "pwd11");
		
		List<User> allDesc = new ArrayList<User>();
		allDesc.add(u3);
		allDesc.add(u2);
		allDesc.add(u1);
		
		when(users.findAllByOrderByUsernameDesc()).thenReturn(allDesc);
		
		List<User> allResult = service.findAllByOrderByUsernameDesc();
		assertEquals(allDesc, allResult);
	}
	
	@Test
	public void testsaveOrUpdateUser() {
		User u = new User("un", "pwd");
		
		when(users.save(u)).thenReturn(u);
		
		User resultUser = service.saveOrUpdateUser(u);
		assertEquals(u, resultUser);
	}
	
}
