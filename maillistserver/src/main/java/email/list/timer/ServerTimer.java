package email.list.timer;

import email.list.controller.EmailController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class ServerTimer {

    @Autowired
    EmailController emailController;

    public ServerTimer() {
        Timer t = new Timer(true);
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                emailController.broadcast("Mesaj periodic", "Va informez ca totul merge bine");
            }
        }, 5000, 10000);
    }
}
