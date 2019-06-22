package email.list.email;

import javax.mail.MessagingException;

public class AnnouncementEmail extends Email {

    public AnnouncementEmail(String to, String name, String subject, String text) throws MessagingException {
        super(to, name, subject, text);
    }

    @Override
    public void setup(String subject, String text) throws MessagingException {
        message.setSubject(subject);
        message.setText(text);
    }
}
