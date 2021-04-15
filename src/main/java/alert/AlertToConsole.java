package alert;

import enums.BreachType;
import strategy.AlertStrategy;
import strategy.BreachTypeStrategy;

public class AlertToConsole implements AlertStrategy {

	@Override
	public BreachType sendAlert(BreachTypeStrategy breachTypeStrategy) {
		System.out.println("Console Output : " + breachTypeStrategy.getBreachType().toString());
		return breachTypeStrategy.getBreachType();
	}

}
