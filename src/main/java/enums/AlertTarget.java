package enums;

import strategy.AlertStrategy;

public enum AlertTarget implements AlertStrategy {
	TO_CONTROLLER {
		@Override
		public void sendAlert(BreachType breachType) {
			int header = 0xfeed;
			System.out.printf("%i : %i\n", header, breachType);
		}
	},
	TO_EMAIL {
		@Override
		public void sendAlert(BreachType breachType) {
			String recepient = "a.b@c.com";
			breachType.sendMail(recepient);
		}
	},
	TO_CONSOLE {
		@Override
		public void sendAlert(BreachType breachType) {
			System.out.println("Console Output : " + breachType.toString());
		}
	};
};
