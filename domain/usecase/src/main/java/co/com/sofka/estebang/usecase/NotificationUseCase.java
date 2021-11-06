package co.com.sofka.estebang.usecase;

import co.com.sofka.estebang.model.Notification;
import co.com.sofka.estebang.model.repository.NotificationRepository;
import reactor.core.publisher.Mono;

public class NotificationUseCase {

    private NotificationRepository notificationRepository;

    public Mono<Void> sendEmail(Notification notification) {
        return notificationRepository.sendEmail(notification);
    }
}
