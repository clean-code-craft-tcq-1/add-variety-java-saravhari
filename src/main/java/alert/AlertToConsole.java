package alert;

import strategy.AlertStrategy;
import strategy.BreachTypeStrategy;

public class AlertToConsole implements AlertStrategy {

	@Override
	public void sendAlert(BreachTypeStrategy breachTypeStrategy) {
		System.out.println("Console Output : " + breachTypeStrategy.getBreachType().toString());
	}

}
