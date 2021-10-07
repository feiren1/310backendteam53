package csci310.service;

import csci310.models.Proposal;
import csci310.models.User;
import csci310.repositories.ProposalRepository;
import csci310.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class UserProposalService {
    @Autowired
    ProposalRepository pr;
    @Autowired
    UserRepository ur;

    public List<Proposal> getUserProposals(String Uname)
    {
        User user = ur.findByUsername(Uname);
        List<Integer> userproposalids = user.getReceivedProposalIds();
        List<Proposal> proplist= new ArrayList<Proposal>();
        for(int i : userproposalids)
        {
            Proposal p = pr.findByProposalId(i);
            proplist.add(p);
        }

        return proplist;
    }
}
