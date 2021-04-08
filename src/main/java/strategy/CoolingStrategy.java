package strategy;

import enums.BreachType;

public interface CoolingStrategy {
	public BreachType classifyTemperatureBreach(double value);
}
