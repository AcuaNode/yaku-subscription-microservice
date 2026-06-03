package notification_service.subscription.infrastructure.persistence.jpa.seeding;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import notification_service.subscription.domain.model.entities.Plan;
import notification_service.subscription.domain.model.valueobjects.Currency;
import notification_service.subscription.infrastructure.persistence.jpa.repositories.PlanRepository;

@Component
public class PlanSeeder implements CommandLineRunner {
    private final PlanRepository planRepository;

    public PlanSeeder(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public void run(String... args) {
        if (planRepository.count() == 0) {
            planRepository.save(new Plan("FREE", 0.0, Currency.USD, 1, 3650));
            planRepository.save(new Plan("PREMIUM", 19.99, Currency.USD, 10, 30));
            System.out.println("Default plans seeded.");
        }
    }
}
