package csci310.service;

import csci310.models.Proposal;
import csci310.models.User;
import csci310.repositories.ProposalRepository;
import csci310.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProposalService {
    @Autowired
    ProposalRepository proposalRepository;
    @Autowired
    UserRepository userRepository;

    public List<Proposal> getUserProposals(String Uname)
    {
        User user = userRepository.findByUsername(Uname);
        List<Integer> userproposalids = user.getReceivedProposalIds();
        List<Proposal> proplist= new ArrayList<Proposal>();
        for(int i : userproposalids)
        {
            Proposal p = proposalRepository.findByUid(i);
            proplist.add(p);
        }

        return proplist;
    }
}
