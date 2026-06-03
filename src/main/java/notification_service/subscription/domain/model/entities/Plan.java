package notification_service.subscription.domain.model.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import notification_service.shared.domain.model.entities.AuditableModel;
import notification_service.subscription.domain.model.valueobjects.Currency;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "plans")
public class Plan extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Currency currency;

    @Column(nullable = false)
    private Integer maxPonds;

    @Column(nullable = false)
    private Integer durationInDays;

    public Plan(String name, Double price, Currency currency, Integer maxPonds, Integer durationInDays) {
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.maxPonds = maxPonds;
        this.durationInDays = durationInDays;
    }
}
