package email.list.email;

import javax.mail.MessagingException;

public class GoodByeEmail extends Email {

    public GoodByeEmail(String to, String name, String subject, String text) throws MessagingException {
        super(to, name, subject, text);
    }

    @Override
    public void setup(String subject, String text) throws MessagingException {
        message.setSubject("Ne pare rau ca ne lasi!");
        message.setText("Sper sa ne revedem in curand, " + this.name + "!");
    }
}
