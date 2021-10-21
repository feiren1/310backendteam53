package csci310.models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.cucumber.java.sl.In;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserPrincipalTest {

	UserPrincipal principal;

	@Before
	public void setUp() throws Exception {
		principal = new UserPrincipal("username","password");
	}

	@Test
	public void testgetUsername() {
		String un = principal.getUsername();
		assertEquals(un, "username");
	}
	
	@Test
	public void testgetPassword() {
		String pwd = principal.getPassword();
		assertEquals(pwd, "password");
	}
	
	@Test
	public void testisAccountNonExpired() {
		principal = new UserPrincipal(new User("username","password"));
		assertTrue(principal.isAccountNonExpired());
	}
	
	@Test
	public void testisAccountNonLocked() {
		assertTrue(principal.isAccountNonLocked());
	}
	
	@Test
	public void testisCredentialsNonExpired() {
		assertTrue(principal.isCredentialsNonExpired());
	}
	
	@Test
	public void testisEnabled() {
		assertTrue(principal.isEnabled());
	}
	
	@Test
	public void testgetAuthorities() {
		Collection<GrantedAuthority> authList = new ArrayList<>();
		authList.add(new SimpleGrantedAuthority("USER"));
		assertEquals(principal.getAuthorities(), authList);
	}

}
