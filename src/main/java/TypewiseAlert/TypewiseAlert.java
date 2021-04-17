package TypewiseAlert;

import java.util.HashMap;
import java.util.Map;

import alert.AlertToConsole;
import alert.AlertToController;
import alert.AlertToEmail;
import breach.BreachTypeNormal;
import breach.BreachTypeTooHigh;
import breach.BreachTypeTooLow;
import character.BatteryCharacter;
import cooling.CoolingTypeHiActive;
import cooling.CoolingTypeMedActive;
import cooling.CoolingTypePassive;
import enums.AlertTarget;
import enums.BreachType;
import enums.CoolingType;
import strategy.AlertStrategy;
import strategy.BreachTypeStrategy;
import strategy.CoolingStrategy;

public class TypewiseAlert {

	public static Map<BreachType, BreachTypeStrategy> BreachMap = new HashMap<BreachType, BreachTypeStrategy>() {

		private static final long serialVersionUID = 1L;

		{
			put(BreachType.TOO_LOW, new BreachTypeTooLow());
			put(BreachType.NORMAL, new BreachTypeNormal());
			put(BreachType.TOO_HIGH, new BreachTypeTooHigh());
		}
	};

	public static Map<CoolingType, CoolingStrategy> cooligMap = new HashMap<CoolingType, CoolingStrategy>() {

		private static final long serialVersionUID = 1L;

		{
			put(CoolingType.HI_ACTIVE_COOLING, new CoolingTypeHiActive());
			put(CoolingType.MED_ACTIVE_COOLING, new CoolingTypeMedActive());
			put(CoolingType.PASSIVE_COOLING, new CoolingTypePassive());
		}
	};

	public static Map<AlertTarget, AlertStrategy> alertMap = new HashMap<AlertTarget, AlertStrategy>() {

		private static final long serialVersionUID = 1L;

		{
			put(AlertTarget.TO_EMAIL, new AlertToEmail());
			put(AlertTarget.TO_CONTROLLER, new AlertToController());
			put(AlertTarget.TO_CONSOLE, new AlertToConsole());
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

		BreachTypeStrategy breachTypeStrategy = cooligMap.get(batteryChar.coolingType)
				.classifyTemperatureBreach(temperatureInC);

		alertStrategy.sendAlert(breachTypeStrategy);
	}

}
