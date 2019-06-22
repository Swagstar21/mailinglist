package email.list.email;

import javax.mail.MessagingException;

public class WelcomeEmail extends Email{

    public WelcomeEmail(String to, String name, String subject, String text) throws MessagingException {
        super(to, name, subject, text);
    }

    @Override
    public void setup(String subject, String Text) throws MessagingException {
        message.setSubject("Bine ati venit!");

        message.setText("Ne bucuram ca ni te-ai alaturat " + this.name + "!");
    }
}
