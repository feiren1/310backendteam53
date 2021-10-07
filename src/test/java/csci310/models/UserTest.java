package csci310.models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UserTest {
	
	@Test
	public void testgetId() {
		User testUser0 = new User("username", "pwd123");
		assertEquals(testUser0.getId(), testUser0.id);
	}
	
	@Test
	public void testgetUsername() {
		User testUser1 = new User("username", "pwd123");
		assertEquals(testUser1.getUsername(), "username");
	}
	
	@Test
	public void testgetPassword() {
		User testUser2 = new User("username", "pwd123");
		assertEquals(testUser2.getPassword(), "pwd123");
	}
	
	@Test
	public void testgetReceivedProposalIds() {
		User testUser3 = new User("username", "pwd123");
		List<Integer> testReceived3 = new ArrayList<Integer>();
		assertEquals(testUser3.getReceivedProposalIds(), testReceived3);
	}
	
	@Test
	public void testgetReceivedProposalIds2() {
		User testUser4 = new User("username", "pwd123");
		testUser4.received_proposal_ids.add(0);
		testUser4.received_proposal_ids.add(1);
		testUser4.received_proposal_ids.add(2);
		List<Integer> testReceived4 = new ArrayList<Integer>();
		testReceived4.add(0);
		testReceived4.add(1);
		testReceived4.add(2);
		assertEquals(testUser4.getReceivedProposalIds(), testReceived4);
	}
	
	@Test
	public void testgetHostedProposalIds() {
		User testUser5 = new User("username", "pwd123");
		List<Integer> testHosted5 = new ArrayList<Integer>();
		assertEquals(testUser5.getHostedProposalIds(), testHosted5);
	}
	
	@Test
	public void testgetHostedProposalIds2() {
		User testUser6 = new User("username", "pwd123");
		testUser6.hosted_proposal_ids.add(0);
		testUser6.hosted_proposal_ids.add(1);
		testUser6.hosted_proposal_ids.add(2);
		List<Integer> testHosted6 = new ArrayList<Integer>();
		testHosted6.add(0);
		testHosted6.add(1);
		testHosted6.add(2);
		assertEquals(testUser6.getHostedProposalIds(), testHosted6);
	}
	
	@Test
	public void testgetFinalizedProposalIds() {
		User testUser7 = new User("username", "pwd123");
		List<Integer> testFinalized7 = new ArrayList<Integer>();
		assertEquals(testUser7.getFinalizedProposalIds(), testFinalized7);
	}
	
	@Test
	public void testgetFinalizedProposalIds2() {
		User testUser8 = new User("username", "pwd123");
		testUser8.finalized_proposal_ids.add(0);
		testUser8.finalized_proposal_ids.add(1);
		testUser8.finalized_proposal_ids.add(2);
		List<Integer> testFinalized8 = new ArrayList<Integer>();
		testFinalized8.add(0);
		testFinalized8.add(1);
		testFinalized8.add(2);
		assertEquals(testUser8.getFinalizedProposalIds(), testFinalized8);
	}
	
	@Test
	public void testtoString() {
		User testUser9 = new User("username", "pwd123");
		String testString9 = "User[id=" + testUser9.getId() + ", username='username', password='pwd123']";
		assertEquals(testUser9.toString(), testString9);
	}

}
