package email.list.email;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class EmailFactory {
    public Email createEmail(EmailTypes type, String to, String name, String subject, String text) throws MessagingException {
        if (type == EmailTypes.ANNOUNCEMENT)
            return new AnnouncementEmail(to, name, subject, text);
        else if (type == EmailTypes.GOODBYE) {
            return new GoodByeEmail(to, name, subject, text);
        }
        else if (type == EmailTypes.WELCOME) {
            return new WelcomeEmail(to, name, subject, text);
        }
        else return null;
    }
}
