package qqru3ka.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import qqru3ka.dto.UserAuthDto;
import qqru3ka.dto.UserLoginDto;
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
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public User updateUserNick(User user, String nick) {
        user.setNickname(nick);
        return userRepository.save(user);
    }

    public User updateUserRole(User user, String role) {
        user.setRole(role);
        return userRepository.save(user);
    }

    public User updateUserBalance(User user, Integer val) {
        user.setBalance(user.getBalance()+val);
        return userRepository.save(user);
    }

    public User updateUserInfo(User user, String info) {
        user.setInfo(info);
        return userRepository.save(user);
    }

    public User isExists(UserLoginDto userLoginDto) {
        return userRepository.findByLoginAndPasswordHash(userLoginDto.getLogin(),
                userLoginDto.getPassword())
                .orElseThrow(EntityNotFoundException::new);
    }

    public User storeUser(UserAuthDto userAuthDto) {
        if(userRepository.findByLogin(userAuthDto.getLogin()).isPresent()) {
            throw new IllegalArgumentException();
        }
        User user = new User();
        user.setEmail(userAuthDto.getEmail());
        user.setLogin(userAuthDto.getLogin());
        user.setNickname(userAuthDto.getLogin());
        user.setPasswordHash(userAuthDto.getPassword());
        return userRepository.save(user);
    }
}
