package breach;

import enums.BreachType;
import strategy.BreachTypeStrategy;

public class BreachTypeNormal implements BreachTypeStrategy {

	@Override
	public void sendMail(String recepient) {
		// Nothing to print
	}

	@Override
	public BreachType getBreachType() {
		return BreachType.NORMAL;
	}

}
