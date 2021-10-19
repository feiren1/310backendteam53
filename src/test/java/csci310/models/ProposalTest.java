package csci310.models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ProposalTest {

	/*@Test
	public void testgetId() {
		Long id = (long)1234;
		Proposal testProposal0 = new Proposal(id);
		assertEquals(testProposal0.getId(),id);
	}

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
		testProposal4.addUser(1357);
		testProposal4.addUser(2468);
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
		testProposal6.addEvent("testEvent6a");
		testProposal6.addEvent("testEvent6b");
		testProposal6.addEvent("testEvent6c");
		ArrayList<Event> testUserList6 = new ArrayList<Event>();
		testUserList6.add(testEvent6a);
		testUserList6.add(testEvent6b);
		testUserList6.add(testEvent6c);
		assertEquals(testProposal6.getEvents(), testUserList6);
	}*/

	@Test
	public void testfinalizeProposal() {
		Proposal testProposal7 = new Proposal(1234);
		testProposal7.setFinalized(1);
		assertFalse(testProposal7.finalizeProposal());
		testProposal7.setFinalized(0);
		assertTrue(testProposal7.finalizeProposal());
		assertEquals(1, testProposal7.getFinalized());
	}

	@Test
	public void testaddUser() {
		Proposal testProposal8 = new Proposal(1234);
		testProposal8.addUser(1357);
		ArrayList<Integer> testUserList8 = new ArrayList<Integer>();
		testUserList8.add(1357);
		assertEquals(testUserList8, testProposal8.getUsers());
	}

	@Test
	public void testaddEvent() {
		Proposal testProposal9 = new Proposal(1234);
		testProposal9.addEvent("url9");
		ArrayList<Event> testEventList9 = new ArrayList<Event>();
		Event testEvent = new Event("url9");
		testEventList9.add(testEvent);
		assertEquals(testEventList9.size(), testProposal9.getEvents().size());
		for(int i=0;i<testProposal9.getEvents().size();i++) {
			assertEquals(testEventList9.get(i).getUrl(), testProposal9.getEvents().get(i).getUrl());
		}
	}

//	@Test
//	public void testaddUserResponses() {
//		//TODO
//	}

	@Test
	public void testtoString() {
		Proposal testProposal10 = new Proposal(1234);
		assertEquals(testProposal10.toString(), "Proposal[id=" + testProposal10.getId() + ", host id='1234']");
	}

}