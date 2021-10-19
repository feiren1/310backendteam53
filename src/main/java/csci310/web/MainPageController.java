package csci310.web;

import csci310.models.Proposal;
import csci310.payload.requests.UserProposalRequest;
import csci310.service.UserProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/app")
public class MainPageController
{
    @Autowired
    UserProposalService service;

    @PostMapping("/userproposal")
    public List<Proposal> getClubPage(@RequestBody UserProposalRequest UserProposalRequest)
    {
        List<Proposal> cp = service.getUserProposals(UserProposalRequest.getKey());
        return cp;
    }
}