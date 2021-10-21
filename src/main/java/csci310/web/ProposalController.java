package csci310.web;

import csci310.security.JwtUtils;
import csci310.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
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

    //create new proposal
    /*@PostMapping("/new-proposal")
    public ResponseEntity<?> (@PathVariable("username") String username){
        return userService.searchByUsername(username);
    }
    */

}
