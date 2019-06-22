package email.list.repository;

import email.list.model.User;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<User, Long> {
    public User getUserByNameAndEmailAddress(String name, String emailAddress);
    public User getUserByEmailAddress(String emailAddress);
    public User getUserByName(String name);
}
