package csci310.repositories;

import csci310.models.Proposal;
import csci310.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProposalRepository extends MongoRepository<Proposal, String>{
    public Proposal findByProposalId(int proposalId);
}
