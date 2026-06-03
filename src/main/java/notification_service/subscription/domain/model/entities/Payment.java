package notification_service.subscription.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import notification_service.shared.domain.model.entities.AuditableModel;
import notification_service.subscription.domain.model.valueobjects.Currency;
import notification_service.subscription.domain.model.valueobjects.PaymentStatus;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "payments")
public class Payment extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;

    private String transactionReference;

    public Payment(Long userId, Double amount, Currency currency, PaymentStatus status, String transactionReference) {
        this.userId = userId;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.transactionReference = transactionReference;
    }
}
