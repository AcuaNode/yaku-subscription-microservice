package notification_service.subscription.application.internal.queryservices;


import java.util.List;
import java.util.Optional;

import notification_service.subscription.domain.model.aggregates.Subscription;
import notification_service.subscription.domain.model.entities.Plan;

public interface SubscriptionQueryService {
    Optional<Subscription> getUserSubscriptionStatus(Long userId);

    List<Plan> getAvailablePlans();
    Optional<Plan> getPlanById(Long planId);
}
