package csci310.service;

import csci310.models.Proposal;
import csci310.models.User;
import csci310.repositories.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalService {
    @Autowired
    private ProposalRepository proposalRepository;

    public Proposal findByUid(int uid){
        return proposalRepository.findByUid(uid);
    }

    public List<Proposal> findByHostuid(int host_id){
        return proposalRepository.findByHostId(host_id);
    }

    public Proposal saveOrUpdateProposal(Proposal proposal){
        return proposalRepository.save(proposal);
    }
}
