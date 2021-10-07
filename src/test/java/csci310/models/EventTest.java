package csci310.models;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class EventTest {

	@Test
	public void testgetUrl() {
		Event testEvent1 = new Event("url");
		assertEquals(testEvent1.getUrl(), "url");
	}
	
	@Test
	public void testgetAvailabilities() {
		Event testEvent2 = new Event("url");
		Map<Integer, Integer> testMap2 = new HashMap<Integer,Integer>();
		assertEquals(testEvent2.getAvailabilities(), testMap2);
	}
	
	@Test
	public void testgetAvailabilities2() {
		Event testEvent3 = new Event("url");
		testEvent3.addUserInfo(0, 0, 0);
		Map<Integer, Integer> testMap3 = new HashMap<Integer,Integer>();
		testMap3.put(0, 0);
		assertEquals(testEvent3.getAvailabilities(), testMap3);
	}
	
	@Test
	public void testgetRatings() {
		Event testEvent4 = new Event("url");
		Map<Integer, Integer> testMap4 = new HashMap<Integer,Integer>();
		assertEquals(testEvent4.getRatings(), testMap4);
	}
	
	@Test
	public void testgetRatings2() {
		Event testEvent5 = new Event("url");
		testEvent5.addUserInfo(0, 0, 0);
		Map<Integer, Integer> testMap5 = new HashMap<Integer,Integer>();
		testMap5.put(0, 0);
		assertEquals(testEvent5.getRatings(), testMap5);
	}
	
	@Test
	public void testaddUserInfo() {
		Event testEvent6 = new Event("url");
		testEvent6.addUserInfo(0, 0, 0);
		testEvent6.addUserInfo(1, 1, 1);
		testEvent6.addUserInfo(2, 2, 2);
		testEvent6.addUserInfo(3, 3, 3);
		Map<Integer, Integer> testMap6 = new HashMap<Integer,Integer>();
		testMap6.putIfAbsent(0, 0);
		testMap6.putIfAbsent(1, 1);
		testMap6.putIfAbsent(2, 2);
		testMap6.putIfAbsent(3, 3);
		assertEquals(testEvent6.getAvailabilities(), testMap6);
		assertEquals(testEvent6.getRatings(), testMap6);
	}
	
	@Test
	public void testaddUserInfo2() {
		Event testEvent7 = new Event("url");
		testEvent7.addUserInfo(0, 0, 0);
		testEvent7.addUserInfo(0, 1, 1);
		testEvent7.addUserInfo(1, 1, 1);
		testEvent7.addUserInfo(2, 2, 2);
		testEvent7.addUserInfo(3, 3, 3);
		Map<Integer, Integer> testMap7 = new HashMap<Integer,Integer>();
		testMap7.putIfAbsent(0, 0);
		testMap7.putIfAbsent(0, 1);
		testMap7.putIfAbsent(1, 1);
		testMap7.putIfAbsent(2, 2);
		testMap7.putIfAbsent(3, 3);
		assertEquals(testEvent7.getAvailabilities(), testMap7);
	}
	
	@Test
	public void testtoString() {
		Event testEvent8 = new Event("url");
		assertEquals(testEvent8.toString(), "Event[url=url]");
	}
	
}
