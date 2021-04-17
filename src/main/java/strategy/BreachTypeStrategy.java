package strategy;

import enums.BreachType;

public interface BreachTypeStrategy {
	public void sendMail(String recepient);
	
	public BreachType getBreachType();
}
