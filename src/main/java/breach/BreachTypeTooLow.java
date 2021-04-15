package breach;

import enums.BreachType;
import strategy.BreachTypeStrategy;

public class BreachTypeTooLow implements BreachTypeStrategy {

	@Override
	public void sendMail(String recepient) {
		System.out.printf("To: %s\n", recepient);
		System.out.println("Hi, the temperature is too low\n");
	}

	@Override
	public BreachType getBreachType() {
		return BreachType.TOO_LOW;
	}

}
