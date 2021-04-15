package strategy;

import enums.BreachType;

public interface CoolingStrategy {
	public BreachTypeStrategy classifyTemperatureBreach(double value);
}
