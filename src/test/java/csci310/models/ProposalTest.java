package csci310.models;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ProposalTest {
	
//	@Test
//	public void testgetId() {
//		//TODO
//	}
	
	@Test
	public void testgetHostId() {
		Proposal testProposal1 = new Proposal((long) 1234);
		long hostId1 = testProposal1.getHostId();
		assertEquals(hostId1, (long) 1234);
	}
	
	@Test
	public void testgetFinalized() {
		Proposal testProposal2 = new Proposal((long) 1234);
		assertEquals(testProposal2.getFinalized(), 0);
	}
	
	@Test
	public void testgetUsers() {
		Proposal testProposal3 = new Proposal((long) 1234);
		ArrayList<Integer> testUserList3 = new ArrayList<Integer>();
		assertEquals(testProposal3.getUsers(), testUserList3);
	}
	
	@Test
	public void testgetUsers2() {
		Proposal testProposal4 = new Proposal((long) 1234);
		testProposal4.users.add(1357);
		testProposal4.users.add(2468);
		ArrayList<Integer> testUserList4 = new ArrayList<Integer>();
		testUserList4.add(1357);
		testUserList4.add(2468);
		assertEquals(testProposal4.getUsers(), testUserList4);
	}
	
	@Test
	public void testgetEvents() {
		Proposal testProposal5 = new Proposal((long) 1234);
		ArrayList<Event> testUserList5 = new ArrayList<Event>();
		assertEquals(testProposal5.getEvents(), testUserList5);
	}
	
	@Test
	public void testgetEvents2() {
		Proposal testProposal6 = new Proposal((long) 1234);
		Event testEvent6a = new Event("url6a");
		Event testEvent6b = new Event("url6b");
		Event testEvent6c = new Event("url6c");
		testProposal6.events.add(testEvent6a);
		testProposal6.events.add(testEvent6b);
		testProposal6.events.add(testEvent6c);
		ArrayList<Event> testUserList6 = new ArrayList<Event>();
		testUserList6.add(testEvent6a);
		testUserList6.add(testEvent6b);
		testUserList6.add(testEvent6c);
		assertEquals(testProposal6.getEvents(), testUserList6);
	}
	
	@Test
	public void finalizeProposal() {
		Proposal testProposal7 = new Proposal((long) 1234);
		assertEquals(testProposal7.getFinalized(), 0);
		testProposal7.finalizeProposal();
		assertEquals(testProposal7.getFinalized(), 1);
	}
	
	@Test
	public void testaddUser() {
		Proposal testProposal8 = new Proposal((long) 1234);
		testProposal8.addUser(1357);
		ArrayList<Integer> testUserList8 = new ArrayList<Integer>();
		testUserList8.add(1357);
		assertEquals(testProposal8.users, testUserList8);
	}
	
	@Test
	public void testaddEvent() {
		Proposal testProposal9 = new Proposal((long) 1234);
		testProposal9.addEvent("url9");
		assertEquals(testProposal9.events.get(0).getUrl(), "url9");
		ArrayList<Event> testUserList9 = new ArrayList<Event>();
		testUserList9.add(testProposal9.events.get(0));
		assertEquals(testProposal9.events, testUserList9);
	}
	
//	@Test
//	public void testaddUserResponses() {
//		//TODO
//	}
	
	@Test
	public void testtoString() {
		Proposal testProposal10 = new Proposal((long) 1234);
		assertEquals(testProposal10.toString(), "Proposal[id=" + testProposal10.getId() + ", host id='1234']");
	}

}
