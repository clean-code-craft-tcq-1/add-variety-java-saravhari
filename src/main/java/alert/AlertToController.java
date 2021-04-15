package alert;

import strategy.AlertStrategy;
import strategy.BreachTypeStrategy;

public class AlertToController implements AlertStrategy {

	@Override
	public void sendAlert(BreachTypeStrategy breachTypeStrategy) {
		int header = 0xfeed;
		System.out.printf("%i : %i\n", header, breachTypeStrategy.getBreachType());
	}

}
