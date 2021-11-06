package co.com.sofka.estebang.emailsender;

import co.com.sofka.estebang.model.Notification;
import co.com.sofka.estebang.model.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class NotificationRepositoryAdapter implements NotificationRepository {

    @Autowired
    private JavaMailSender sender;

    @Override
    public Mono<Void> sendEmail(Notification notification) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(notification.getEmail());
        message.setSubject("Job Execution Result");
        message.setText("Status: ".concat(notification.getTask().getStatus()));
        sender.send(message);
        return Mono.empty();
    }
}
