package alert;

import enums.BreachType;
import strategy.AlertStrategy;
import strategy.BreachTypeStrategy;

public class AlertToController implements AlertStrategy {

	@Override
	public BreachType sendAlert(BreachTypeStrategy breachTypeStrategy) {
		int header = 0xfeed;
		System.out.printf("%d : %s\n", header, breachTypeStrategy.getBreachType().toString());
		 
		return breachTypeStrategy.getBreachType();
	}

}
