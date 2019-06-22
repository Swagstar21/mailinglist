package email.list.email;

import lombok.Getter;
import lombok.Setter;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public abstract class Email {
    protected String to;
    protected String name;
    private String from;
    private Properties properties;
    private Session session;
    protected MimeMessage message;

    public Email(String to, String name, String subject, String text) throws MessagingException {
        this.to = to;
        this.name = name;
        this.from = "mareserverdeemail@barosaneala.com";
        String host = "localhost";
        properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        session = Session.getDefaultInstance(properties);
        message = new MimeMessage(session);
        setup(subject, text);
    }

    public abstract void setup(String subject, String text) throws MessagingException;

    public void send() {
        try {
            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
