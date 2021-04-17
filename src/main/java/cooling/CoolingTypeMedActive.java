package cooling;

import TypewiseAlert.TypewiseAlert;
import constants.CoolingConstants;
import strategy.BreachTypeStrategy;
import strategy.CoolingStrategy;

public class CoolingTypeMedActive implements CoolingStrategy {

	@Override
	public BreachTypeStrategy classifyTemperatureBreach(double value) {
		return TypewiseAlert.inferBreach(value, CoolingConstants.LOWER_LIMIT,
				CoolingConstants.MED_ACTIVE_COOLING_UPPER);
	}

}
