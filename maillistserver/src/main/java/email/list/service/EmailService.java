package email.list.service;

import email.list.model.User;
import email.list.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public User saveUser(User user) {
        emailRepository.save(user);
        return user;
    }

    public User getUser(Long id) {
        return emailRepository.findById(id).orElse(null);
    }

    public Iterable<User> getAllUsers() {
        return emailRepository.findAll();
    }

    public boolean hasUser(User user) {
        if (emailRepository.getUserByNameAndEmailAddress(user.getName(), user.getEmailAddress()) != null)
            return true;
        return false;
    }

    public User deleteUser(User user) {
        emailRepository.delete(user);
        return user;
    }

    public User getUserByAddress(String address) {
        User user = emailRepository.getUserByEmailAddress(address);
        return user;
    }

    public User getUserByName(String name) {
        User user = emailRepository.getUserByName(name);
        return user;
    }
}
