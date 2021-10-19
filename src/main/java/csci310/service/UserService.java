package csci310.service;

import csci310.models.User;
import csci310.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    //autocomplete user list
    public List<User> searchByUsername(String username){
        return userRepository.searchByUsername(username);
    }

    public User findById(int uid){
        return userRepository.findByUid(uid);
    }

    public List<User> findAllByOrderByUsernameDesc(){
        return userRepository.findAllByOrderByUsernameDesc();
    }

    public User saveOrUpdateUser(User user){
        return userRepository.save(user);
    }

    /*public void deleteUserByUid(String uid){
    }*/


}
