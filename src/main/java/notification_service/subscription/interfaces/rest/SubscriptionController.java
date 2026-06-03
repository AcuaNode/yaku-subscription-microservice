package notification_service.subscription.interfaces.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import notification_service.subscription.application.internal.commandservices.SubscriptionCommandService;
import notification_service.subscription.application.internal.queryservices.SubscriptionQueryService;
import notification_service.subscription.domain.model.aggregates.Subscription;
import notification_service.subscription.interfaces.rest.resources.SubscribeToPlanResource;
import notification_service.subscription.interfaces.rest.resources.SubscriptionResource;
import notification_service.subscription.interfaces.rest.transform.SubscriptionResourceFromEntityAssembler;

@RestController
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionController {
    private final SubscriptionCommandService subscriptionCommandService;
    private final SubscriptionQueryService subscriptionQueryService;

    public SubscriptionController(SubscriptionCommandService subscriptionCommandService,
            SubscriptionQueryService subscriptionQueryService) {
        this.subscriptionCommandService = subscriptionCommandService;
        this.subscriptionQueryService = subscriptionQueryService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<SubscriptionResource> getSubscriptionByUserId(@PathVariable Long userId) {
        return subscriptionQueryService.getUserSubscriptionStatus(userId)
                .map(subscription -> ResponseEntity
                        .ok(SubscriptionResourceFromEntityAssembler.toResourceFromEntity(subscription)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{userId}")
    public ResponseEntity<SubscriptionResource> subscribeUser(@PathVariable Long userId,
            @RequestBody SubscribeToPlanResource resource) {
        Subscription subscription = subscriptionCommandService.subscribeUserToPlan(userId, resource.planId());
        return ResponseEntity.ok(SubscriptionResourceFromEntityAssembler.toResourceFromEntity(subscription));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> cancelSubscription(@PathVariable Long userId) {
        subscriptionCommandService.cancelSubscription(userId);
        return ResponseEntity.noContent().build();
    }
}
