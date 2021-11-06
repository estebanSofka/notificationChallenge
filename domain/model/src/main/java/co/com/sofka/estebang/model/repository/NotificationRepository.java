package co.com.sofka.estebang.model.repository;

import co.com.sofka.estebang.model.Notification;
import reactor.core.publisher.Mono;

public interface NotificationRepository {
    Mono<Void> sendEmail(Notification notification);
}
