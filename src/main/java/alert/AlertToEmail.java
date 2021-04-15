package alert;

import strategy.AlertStrategy;
import strategy.BreachTypeStrategy;

public class AlertToEmail implements AlertStrategy {

	@Override
	public void sendAlert(BreachTypeStrategy breachTypeStrategy) {
		String recepient = "a.b@c.com";
		breachTypeStrategy.sendMail(recepient);
	}

}
