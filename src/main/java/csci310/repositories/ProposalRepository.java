package csci310.repositories;

import csci310.models.Proposal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProposalRepository extends MongoRepository<Proposal, String>{
    public Proposal findByUid(int uid);
    public List<Proposal> findByHost(int host_id);
}
