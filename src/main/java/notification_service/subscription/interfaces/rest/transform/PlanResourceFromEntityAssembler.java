package notification_service.subscription.interfaces.rest.transform;

import notification_service.subscription.domain.model.entities.Plan;
import notification_service.subscription.interfaces.rest.resources.PlanResource;

public class PlanResourceFromEntityAssembler {
    public static PlanResource toResourceFromEntity(Plan entity) {
        return new PlanResource(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getCurrency().name(),
                entity.getMaxPonds(),
                entity.getDurationInDays());
    }
}
