package notification_service.subscription.domain.model.events;

public record UserRegisteredEvent(Long userId, String username, String email, Long farmId) {
}
