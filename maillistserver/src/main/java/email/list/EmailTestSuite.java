package email.list;

import email.list.model.User;
import email.list.service.EmailService;
import email.list.timer.ServerTimer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailTestSuite {

    @Autowired
    private EmailService emailService;

    @Autowired
    private ServerTimer serverTimer;

    public void run() {
        log.info("Aplicatia a pornit cu succes!");

    }

}
