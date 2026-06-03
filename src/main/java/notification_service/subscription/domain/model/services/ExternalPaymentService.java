package notification_service.subscription.domain.model.services;

import notification_service.subscription.domain.model.valueobjects.Currency;
import notification_service.subscription.domain.model.valueobjects.PaymentStatus;

/**
 * Puerto de salida (Interface) del Dominio.
 * Define qué necesitamos del pago sin mencionar a Stripe.
 */
public interface ExternalPaymentService {
    PaymentStatus processPayment(Long userId, Double amount, Currency currency, String paymentMethodId);
}