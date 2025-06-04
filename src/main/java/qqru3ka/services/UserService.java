package qqru3ka.services;

import org.springframework.stereotype.Service;
import qqru3ka.entities.User;
import qqru3ka.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Integer id) {
        return userRepository.findByUserId(id);
    }

    public User updateUserNick(Integer id, String nick) {
        User user = findById(id);
        user.setNickname(nick);
        return userRepository.save(user);
    }

    public User updateUserRole(Integer id, String role) {
        User user = findById(id);
        user.setRole(role);
        return userRepository.save(user);
    }

    public User updateUserBalance(Integer id, Integer val) {
        User user = findById(id);
        user.setBalance(user.getBalance()+val);
        return userRepository.save(user);
    }

    public User updateUserInfo(Integer id, String info) {
        User user = findById(id);
        user.setInfo(info);
        return userRepository.save(user);
    }
}
