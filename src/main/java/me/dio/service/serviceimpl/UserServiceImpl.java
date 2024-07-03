package me.dio.service.serviceimpl;

import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void createUser(User user) {
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException("This account number already exists");
        }
        userRepository.save(user);
    }

    @Override
    public Iterable<User> getAll() {
        Iterable<User> user = userRepository.findAll();
        if (!user.iterator().hasNext()) {
            throw new RuntimeException("No records saved.");
        }
        return user;
    }

    @Override
    public void updateUser(Long id, User user) {
        Optional<User> userBd = userRepository.findById(id);
        if (userBd.isEmpty()) {
            throw new RuntimeException("ID not found.");
        }
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }
}
