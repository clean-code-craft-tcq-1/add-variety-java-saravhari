package enums;

import strategy.BreachTypeStrategy;

public enum BreachType implements BreachTypeStrategy {
	NORMAL {

		@Override
		public void sendMail(String recepient) {
			// Nothing to print
		}

	},
	TOO_LOW {

		@Override
		public void sendMail(String recepient) {
			System.out.printf("To: %s\n", recepient);
			System.out.println("Hi, the temperature is too low\n");
		}

	},
	TOO_HIGH {

		@Override
		public void sendMail(String recepient) {
			System.out.printf("To: %s\n", recepient);
			System.out.println("Hi, the temperature is too high\n");
		}

	}
};