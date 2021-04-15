package strategy;

import enums.BreachType;

public interface AlertStrategy {
	public BreachType sendAlert(BreachTypeStrategy breachTypeStrategy);
}
