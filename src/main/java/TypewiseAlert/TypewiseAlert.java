package TypewiseAlert;

import java.util.HashMap;
import java.util.Map;

import breach.BreachTypeNormal;
import breach.BreachTypeTooHigh;
import breach.BreachTypeTooLow;
import character.BatteryCharacter;
import enums.BreachType;
import strategy.AlertStrategy;
import strategy.BreachTypeStrategy;

public class TypewiseAlert {

	public static Map<BreachType, BreachTypeStrategy> BreachMap = new HashMap<BreachType, BreachTypeStrategy>() {

		private static final long serialVersionUID = 1L;

		{
			put(BreachType.TOO_LOW, new BreachTypeTooLow());
			put(BreachType.NORMAL, new BreachTypeNormal());
			put(BreachType.TOO_HIGH, new BreachTypeTooHigh());
		}
	};

	public static BreachTypeStrategy inferBreach(double value, double lowerLimit, double upperLimit) {
		if (value < lowerLimit) {
			return BreachMap.get(BreachType.TOO_LOW);
		}
		if (value > upperLimit) {
			return BreachMap.get(BreachType.TOO_HIGH);
		}
		return BreachMap.get(BreachType.NORMAL);
	}

	public static void checkAndAlert(AlertStrategy alertStrategy, BatteryCharacter batteryChar, double temperatureInC) {

		BreachTypeStrategy breachTypeStrategy = batteryChar.coolingStrategy.classifyTemperatureBreach(temperatureInC);
		alertStrategy.sendAlert(breachTypeStrategy);
	}
}
