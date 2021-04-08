package strategy;

import enums.BreachType;

public interface AlertStrategy {
	public void sendAlert(BreachType breachType);
}
