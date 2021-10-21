package csci310.web;

import csci310.models.User;
import csci310.payload.requests.UserLoginRequest;
import csci310.payload.requests.UserSignupRequest;
import csci310.payload.responses.JwtResponse;
import csci310.security.JwtUtils;
import csci310.service.ProposalService;
import csci310.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hangouts")
public class ProposalController {
    @Autowired
    private ProposalService proposalService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    //autocomplete user list
    /*@PostMapping("/new-proposal")
    public ResponseEntity<?> (@PathVariable("username") String username){
        return userService.searchByUsername(username);
    }

    //signup
    @PostMapping("/signup")
    public ResponseEntity<?> saveOrUpdateUser(@RequestBody UserSignupRequest userSignupRequest){
        if(userSignupRequest.getPassword().compareTo(userSignupRequest.getConfirmPassword()) != 0){
            return new ResponseEntity<>("Passwords do not match", HttpStatus.BAD_REQUEST);
        }

        User findUser = userService.findByUsername(userSignupRequest.getUsername());
        if(findUser != null){
            return new ResponseEntity<>("Username has been taken", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        User newUser = new User(userSignupRequest.getUsername(),userSignupRequest.getPassword());
        userService.saveOrUpdateUser(newUser);
        return new ResponseEntity<>("User signed up successfully", HttpStatus.OK);
    }

    //login
    @PostMapping("/login")
    public ResponseEntity<?> loginAuthentication(@RequestBody UserLoginRequest userLoginRequest){
        User findUser = userService.findByUsername(userLoginRequest.getUsername());
        if(findUser == null){
            return new ResponseEntity<>(new JwtResponse("Username not found",null),HttpStatus.UNAUTHORIZED);
        }
        if(findUser.getPassword().compareTo(userLoginRequest.getPassword()) != 0){
            return new ResponseEntity<>(new JwtResponse("Incorrect Password",null),HttpStatus.UNAUTHORIZED);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginRequest.getUsername(),userLoginRequest.getPassword()));
        String jwt = jwtUtils.generateJwtToken(authentication);
        return new ResponseEntity<>(new JwtResponse("User logged in successfully", jwt), HttpStatus.OK);
    }*/

}
