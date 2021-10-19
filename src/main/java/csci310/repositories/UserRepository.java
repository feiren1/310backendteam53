package csci310.repositories;

import csci310.models.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String>{
    //login request
    public User findByUsername(String username);

    //autocomplete user list
    @Query("{'username':{'$regex':'?0','$options':'i'}}")
    public List<User> searchByUsername(String username);

    public User findByUid(int uid);
    public List<User> findAllByOrderByUsernameDesc();
}
