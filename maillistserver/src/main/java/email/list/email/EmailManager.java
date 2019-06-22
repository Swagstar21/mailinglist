package email.list.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
@Slf4j
public class EmailManager {

    @Autowired
    private EmailFactory emailFactory;

    public void sendEmail(EmailTypes type, String to, String name, String subject, String text) {

        try {
            Email email = emailFactory.createEmail(type, to, name, subject, text);
            email.send();
            log.info("S-a trimis un email de tipul " + type + " catre " + to + "!");
        } catch (MessagingException e) {
            log.info("Nu s-a putut trimite email-ul catre " + to + "...");
        }
    }
}
