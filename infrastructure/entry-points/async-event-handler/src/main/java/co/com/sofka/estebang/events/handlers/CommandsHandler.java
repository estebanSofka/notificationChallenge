package co.com.sofka.estebang.events.handlers;

import co.com.sofka.estebang.model.Notification;
import co.com.sofka.estebang.usecase.NotificationUseCase;
import lombok.AllArgsConstructor;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.async.impl.config.annotations.EnableCommandListeners;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@EnableCommandListeners
public class CommandsHandler {
    private final NotificationUseCase notificationUseCase;


    public Mono<Void> handleNotificationCommand(Command<Notification> command) {
        return notificationUseCase.sendEmail(command.getData());
    }
}
