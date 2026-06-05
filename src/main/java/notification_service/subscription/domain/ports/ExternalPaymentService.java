package notification_service.subscription.domain.ports;

import notification_service.subscription.domain.model.valueobjects.Currency;
import notification_service.subscription.domain.model.valueobjects.PaymentStatus;

public interface ExternalPaymentService {
    PaymentStatus processPayment(Long userId, Double amount, Currency currency, String paymentMethodId);


}