package strategy;

public interface CoolingStrategy {
	public BreachTypeStrategy classifyTemperatureBreach(double value);
}
