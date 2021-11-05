package csci310.web;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import csci310.models.User;
import csci310.payload.requests.UserSignupRequest;
import csci310.service.UserService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testsearchByUsername() {
		List<User> uList = new ArrayList<User>();
		User u = new User("un", "pwd");
		uList.add(u);
		
		when(userService.searchByUsername("un")).thenReturn(uList);
		List<User> result = userController.searchByUsername("un");
		verify(userService).searchByUsername("un");

		assertEquals(result, uList);
	}
	
	@Test
	public void testsaveOrUpdateUser() {
		UserSignupRequest request = new UserSignupRequest();
		request.setUsername("user");
		request.setPassword("pw");
		request.setConfirmPassword("diffpw");
		assertEquals(userController.saveOrUpdateUser(request), new ResponseEntity<>("Passwords do not match", HttpStatus.BAD_REQUEST));

		//if user already exists in database
		/*request.setConfirmPassword("pw");
		User user = new User("user","pw");
		when(userService.findByUsername("user")).thenReturn(user);
		assertEquals(userController.saveOrUpdateUser(request), new ResponseEntity<>("Username has been taken", HttpStatus.UNPROCESSABLE_ENTITY));
		verify(userService).findByUsername("user");

		//if user does not exist in database
		when(userService.findByUsername("user")).thenReturn(null);
		when(userService.saveOrUpdateUser(user)).thenReturn(user);
		assertEquals(userController.saveOrUpdateUser(request), new ResponseEntity<>("User signed up successfully", HttpStatus.OK));
		verify(userService).findByUsername("user");
		verify(userService).saveOrUpdateUser(user);*/
	}
	
	@Test
	public void testsaveOrUpdateUser1() {
		UserSignupRequest request = new UserSignupRequest();
		request.setPassword("pwd");
		request.setConfirmPassword("pwd");
		request.setUsername("takenUN");
		
		User u = new User("takenUN", "pwd");
		
		when(userService.findByUsername("takenUN")).thenReturn(u);
		assertEquals(userController.saveOrUpdateUser(request), new ResponseEntity<>("Username has been taken", HttpStatus.UNPROCESSABLE_ENTITY));
		verify(userService).findByUsername("takenUN");
	}
	
	@Test
	public void testsaveOrUpdateUser2() {
		UserSignupRequest request = new UserSignupRequest();
		request.setPassword("pwd");
		request.setConfirmPassword("pwd");
		request.setUsername("untakenUN");

		User u = new User("takenUN", "pwd");

		when(userService.findByUsername("untakenUN")).thenReturn(null);
		assertEquals(userController.saveOrUpdateUser(request), new ResponseEntity<>("User signed up successfully", HttpStatus.OK));
		verify(userService).findByUsername("untakenUN");
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
