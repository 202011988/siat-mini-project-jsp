package service;

import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;

import repository.UserRepository;
import util.JPAUtil;

public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public void save(User user) {
        userRepository.save(user);
    }


    public User findUserByUserIdAndPassword(String userId, String password) {
        return userRepository.findUserByUserIdAndPassword(userId, password);
    }


    public User findUserById(int userId) {
        return userRepository.findUserById(userId);
    }


    public void off() {
        userRepository.off();
    }

}
