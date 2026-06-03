package notification_service.subscription.interfaces.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import notification_service.subscription.application.internal.commandservices.SubscriptionCommandService;
import notification_service.subscription.domain.model.events.UserRegisteredEvent;
import notification_service.subscription.infrastructure.persistence.jpa.repositories.PlanRepository;

@Component
public class UserRegisteredEventListener {
    private final SubscriptionCommandService subscriptionCommandService;
    private final PlanRepository planRepository;

    public UserRegisteredEventListener(SubscriptionCommandService subscriptionCommandService,
            PlanRepository planRepository) {
        this.subscriptionCommandService = subscriptionCommandService;
        this.planRepository = planRepository;
    }

    @EventListener
    public void on(UserRegisteredEvent event) {
        planRepository.findByName("FREE").ifPresent(plan -> {
            subscriptionCommandService.subscribeUserToPlan(event.userId(), plan.getId());
        });
    }
}
