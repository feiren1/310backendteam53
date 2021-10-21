package csci310.repositories;

import csci310.models.Proposal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProposalRepository extends MongoRepository<Proposal, String>{
    public Proposal findByUid(int uid);
    public List<Proposal> findByHostId(int host_id);
}
