package email.list.controller;

import email.list.email.EmailManager;
import email.list.email.EmailTypes;
import email.list.model.User;
import email.list.service.EmailService;
import email.list.timer.ServerTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping(path = "/user")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailManager emailManager;


    @GetMapping
    public Iterable<User> getUsers() {
        return emailService.getAllUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        User sameAddressUser = emailService.getUserByAddress(user.getEmailAddress());
        if (sameAddressUser != null)
            return null;

        emailService.saveUser(user);
        emailManager.sendEmail(EmailTypes.WELCOME, user.getEmailAddress(), user.getName(), null, null);

        return user;
    }

    @DeleteMapping(path = "/delete")
    public User deleteUser(@RequestParam(name = "email") String emailAddress) {
        User user = emailService.getUserByAddress(emailAddress);
        if (user != null) {
            emailService.deleteUser(user);
            emailManager.sendEmail(EmailTypes.GOODBYE, user.getEmailAddress(), user.getName(), null, null);
        }
        return user;
    }

    @PostMapping(path = "/broadcast")
    public void broadcast(@RequestBody String message, @RequestParam(name = "subject") String subject) {
        Iterable<User> userList = emailService.getAllUsers();

        Iterator iterator = userList.iterator();

        while (iterator.hasNext()) {
            User user = (User)iterator.next();
            emailManager.sendEmail(EmailTypes.ANNOUNCEMENT, user.getEmailAddress(), user.getName(), subject, message);
        }
    }
}
