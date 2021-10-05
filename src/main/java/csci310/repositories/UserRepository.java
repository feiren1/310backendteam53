package csci310.repositories;

import csci310.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{
    public User findByUsername(String username);

}
