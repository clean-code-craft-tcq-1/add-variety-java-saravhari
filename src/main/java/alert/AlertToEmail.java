package alert;

import enums.BreachType;
import strategy.AlertStrategy;
import strategy.BreachTypeStrategy;

public class AlertToEmail implements AlertStrategy {

	@Override
	public BreachType sendAlert(BreachTypeStrategy breachTypeStrategy) {
		String recepient = "a.b@c.com";
		breachTypeStrategy.sendMail(recepient);

		return breachTypeStrategy.getBreachType();
	}

}
