package csci310.web;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import csci310.models.User;
import csci310.payload.requests.UserLoginRequest;
import csci310.payload.requests.UserSignupRequest;
import csci310.payload.responses.JwtResponse;
import csci310.security.JwtUtils;
import csci310.repositories.UserRepository;
import csci310.service.UserService;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@InjectMocks
	UserController controller;
	
	@Mock
	UserService users;
	
	@Test
	public void testsearchByUsername() {
		List<User> uList = new ArrayList<User>();
		User u = new User("un", "pwd");
		uList.add(u);
		
		when(users.searchByUsername("un")).thenReturn(uList);
		List<User> result = controller.searchByUsername("un");
		assertEquals(result, uList);
	}
	
	@Test
	public void testsaveOrUpdateUser() {
		UserSignupRequest request = new UserSignupRequest();
		request.setPassword("pwd");
		request.setConfirmPassword("diffpwd");
		assertEquals(controller.saveOrUpdateUser(request), new ResponseEntity<>("Passwords do not match", HttpStatus.BAD_REQUEST));
	}
	
	public void testsaveOrUpdateUser1() {
		UserSignupRequest request = new UserSignupRequest();
		request.setPassword("pwd");
		request.setConfirmPassword("pwd");
		request.setUsername("takenUN");
		
		User u = new User("takenUN", "pwd");
		
		when(users.findByUsername("takenUN")).thenReturn(u);
		assertEquals(controller.saveOrUpdateUser(request), new ResponseEntity<>("Username has been taken", HttpStatus.UNPROCESSABLE_ENTITY));
	}
	
	public void testsaveOrUpdateUser2() {
		UserSignupRequest request = new UserSignupRequest();
		request.setPassword("pwd");
		request.setConfirmPassword("pwd");
		request.setUsername("untakenUN");
		
		when(users.findByUsername("untakenUN")).thenReturn(null);
		User u1 = new User("untakenUN", "pwd");
		
		when(users.saveOrUpdateUser(u1)).thenReturn(u1);
		assertEquals(controller.saveOrUpdateUser(request), new ResponseEntity<>("User signed up successfully", HttpStatus.OK));
	}
	
//	@Test
//	public void testloginAuthentication() {
//		UserLoginRequest request = new UserLoginRequest();
//		request.setUsername("notuser");
//		
//		when(users.findByUsername("notuser")).thenReturn(null);
//		assertEquals(controller.loginAuthentication(request), new ResponseEntity<>(new JwtResponse("Username not found",null), HttpStatus.UNAUTHORIZED));
//	}
//	
//	@Test
//	public void testloginAuthentication1() {
//		UserLoginRequest request = new UserLoginRequest();
//		request.setUsername("user");
//		request.setPassword("wrongpwd");
//		
//		User u = new User("user", "pwd");
//		when(users.findByUsername("user")).thenReturn(u);
//		
//		assertEquals(controller.loginAuthentication(request), new ResponseEntity<>(new JwtResponse("Incorrect Password",null), HttpStatus.UNAUTHORIZED));
//	}
//	
//	@Test
//	public void testloginAuthentication2() {
//		UserLoginRequest request = new UserLoginRequest();
//		request.setUsername("user");
//		request.setPassword("rightpwd");
//		
//		User u = new User("user", "rightpwd");
//		when(users.findByUsername("user")).thenReturn(u);
//		
//		assertEquals(controller.loginAuthentication(request), new ResponseEntity<>(new JwtResponse("User logged in successfully", jwt), HttpStatus.OK));
//	}
	
}
