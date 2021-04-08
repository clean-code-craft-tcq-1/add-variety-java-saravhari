package enums;

import TypewiseAlert.TypewiseAlert;
import constants.CoolingConstants;
import strategy.CoolingStrategy;

public enum CoolingType implements CoolingStrategy {
	PASSIVE_COOLING {

		@Override
		public BreachType classifyTemperatureBreach(double value) {
			return TypewiseAlert.inferBreach(value, CoolingConstants.LOWER_LIMIT,
					CoolingConstants.PASSIVE_COOLING_UPPER);
		}

	},
	HI_ACTIVE_COOLING {

		@Override
		public BreachType classifyTemperatureBreach(double value) {
			return TypewiseAlert.inferBreach(value, CoolingConstants.LOWER_LIMIT,
					CoolingConstants.HI_ACTIVE_COOLING_UPPER);
		}

	},
	MED_ACTIVE_COOLING {

		@Override
		public BreachType classifyTemperatureBreach(double value) {
			return TypewiseAlert.inferBreach(value, CoolingConstants.LOWER_LIMIT,
					CoolingConstants.MED_ACTIVE_COOLING_UPPER);
		}

	};
};
