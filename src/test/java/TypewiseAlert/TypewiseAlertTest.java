package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

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
import enums.BreachType;
import strategy.AlertStrategy;

@RunWith(MockitoJUnitRunner.class)
public class TypewiseAlertTest {

	@Test
	public void infersBreachAsPerLimits() {
		assertTrue(TypewiseAlert.inferBreach(12, 20, 30) == TypewiseAlert.BreachMap.get(BreachType.TOO_LOW));
	}

	@Test
	public void infersBreachAsPerUpperLimits() {
		assertTrue(TypewiseAlert.inferBreach(47, 0, 46) == TypewiseAlert.BreachMap.get(BreachType.TOO_HIGH));
	}

	@Test
	public void infersBreachAsPerNormalLimits() {
		assertTrue(TypewiseAlert.inferBreach(12, 0, 46) == TypewiseAlert.BreachMap.get(BreachType.NORMAL));
	}

	@Test
	public void infersBreachAsPerZeroLimits() {
		assertTrue(TypewiseAlert.inferBreach(12, 0, 0) == TypewiseAlert.BreachMap.get(BreachType.TOO_HIGH));
	}

	@Test
	public void checkBreachType() {
		assertTrue(TypewiseAlert.inferBreach(12, 0, 0).getBreachType() == BreachType.TOO_HIGH);
		assertTrue(TypewiseAlert.inferBreach(12, 20, 30).getBreachType() == BreachType.TOO_LOW);
		assertTrue(TypewiseAlert.inferBreach(12, 0, 46).getBreachType() == BreachType.NORMAL);
	}

	@Test
	public void infersBreachAsPerZeroValue() {
		assertTrue(TypewiseAlert.inferBreach(0, 0, 0) == TypewiseAlert.BreachMap.get(BreachType.NORMAL));
	}

	@Test
	public void classifyTemperatureBreachHigh() {
		BatteryCharacter batteryChar = new BatteryCharacter();

		batteryChar.coolingStrategy = new CoolingTypePassive();
		assertTrue(batteryChar.coolingStrategy.classifyTemperatureBreach(46.0F).getBreachType() == BreachType.TOO_HIGH);

		batteryChar.coolingStrategy = new CoolingTypeHiActive();
		assertTrue(batteryChar.coolingStrategy.classifyTemperatureBreach(46.0F).getBreachType() == BreachType.TOO_HIGH);

		batteryChar.coolingStrategy = new CoolingTypeMedActive();
		assertTrue(batteryChar.coolingStrategy.classifyTemperatureBreach(46.0F).getBreachType() == BreachType.TOO_HIGH);
	}

	@Test
	public void classifyTemperatureBreachLow() {
		BatteryCharacter batteryChar = new BatteryCharacter();

		batteryChar.coolingStrategy = new CoolingTypePassive();
		assertTrue(batteryChar.coolingStrategy.classifyTemperatureBreach(-1.0F).getBreachType() == BreachType.TOO_LOW);

		batteryChar.coolingStrategy = new CoolingTypeHiActive();
		assertTrue(batteryChar.coolingStrategy.classifyTemperatureBreach(-1.0F).getBreachType() == BreachType.TOO_LOW);

		batteryChar.coolingStrategy = new CoolingTypeMedActive();
		assertTrue(batteryChar.coolingStrategy.classifyTemperatureBreach(-1.0F).getBreachType() == BreachType.TOO_LOW);
	}

	@Test
	public void classifyTemperatureBreachNormal() {
		BatteryCharacter batteryChar = new BatteryCharacter();

		batteryChar.coolingStrategy = new CoolingTypePassive();
		assertTrue(batteryChar.coolingStrategy.classifyTemperatureBreach(1.0F).getBreachType() == BreachType.NORMAL);

		batteryChar.coolingStrategy = new CoolingTypeHiActive();
		assertTrue(batteryChar.coolingStrategy.classifyTemperatureBreach(1.0F).getBreachType() == BreachType.NORMAL);

		batteryChar.coolingStrategy = new CoolingTypeMedActive();
		assertTrue(batteryChar.coolingStrategy.classifyTemperatureBreach(1.0F).getBreachType() == BreachType.NORMAL);
	}

	@Test
	public void sendAlertCheckEmail() {
		AlertStrategy alertEmailStrategy = new AlertToEmail();
		BreachTypeTooHigh breachTypeTooHigh = new BreachTypeTooHigh();
		assertTrue(alertEmailStrategy.sendAlert(breachTypeTooHigh) == BreachType.TOO_HIGH);

		BreachTypeTooLow breachTypeTooLow = new BreachTypeTooLow();
		assertTrue(alertEmailStrategy.sendAlert(breachTypeTooLow) == BreachType.TOO_LOW);

		BreachTypeNormal breachTypeNormal = new BreachTypeNormal();
		assertTrue(alertEmailStrategy.sendAlert(breachTypeNormal) == BreachType.NORMAL);
	}

	@Test
	public void sendAlertCheckConsole() {
		AlertStrategy alertConsoleStrategy = new AlertToConsole();
		BreachTypeTooHigh breachTypeTooHigh = new BreachTypeTooHigh();
		assertTrue(alertConsoleStrategy.sendAlert(breachTypeTooHigh) == BreachType.TOO_HIGH);

		BreachTypeTooLow breachTypeTooLow = new BreachTypeTooLow();
		assertTrue(alertConsoleStrategy.sendAlert(breachTypeTooLow) == BreachType.TOO_LOW);

		BreachTypeNormal breachTypeNormal = new BreachTypeNormal();
		assertTrue(alertConsoleStrategy.sendAlert(breachTypeNormal) == BreachType.NORMAL);
	}

	@Test
	public void sendAlertCheckController() {
		AlertStrategy alertControllerStrategy = new AlertToController();
		BreachTypeTooHigh breachTypeTooHigh = new BreachTypeTooHigh();
		assertTrue(alertControllerStrategy.sendAlert(breachTypeTooHigh) == BreachType.TOO_HIGH);

		BreachTypeTooLow breachTypeTooLow = new BreachTypeTooLow();
		assertTrue(alertControllerStrategy.sendAlert(breachTypeTooLow) == BreachType.TOO_LOW);

		BreachTypeNormal breachTypeNormal = new BreachTypeNormal();
		assertTrue(alertControllerStrategy.sendAlert(breachTypeNormal) == BreachType.NORMAL);
	}

	@Test
	public void checkAndAlertEmailHiActive() {
		BatteryCharacter batteryChar = new BatteryCharacter();
		AlertStrategy alertEmailStrategy = new AlertToEmail();

		batteryChar.coolingStrategy = new CoolingTypeHiActive();
		TypewiseAlert typewiseAlert = Mockito.mock(TypewiseAlert.class,
				Mockito.withSettings().defaultAnswer(Mockito.CALLS_REAL_METHODS));
		Mockito.doReturn(BreachType.TOO_HIGH).when(typewiseAlert).checkAndAlert(alertEmailStrategy, batteryChar, 46.0F);
	}
}
