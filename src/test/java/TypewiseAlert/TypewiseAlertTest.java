package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import alert.AlertToConsole;
import alert.AlertToController;
import alert.AlertToEmail;
import character.BatteryCharacter;
import enums.BreachType;
import enums.CoolingType;
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
	public void checkAndAlertEmail() {
		BatteryCharacter batteryChar = new BatteryCharacter();
		AlertStrategy alertStrategy = Mockito.mock(AlertToEmail.class);

		batteryChar.coolingType = CoolingType.HI_ACTIVE_COOLING;
		TypewiseAlert.checkAndAlert(alertStrategy, batteryChar, 46.0F);

		batteryChar.coolingType = CoolingType.MED_ACTIVE_COOLING;
		TypewiseAlert.checkAndAlert(alertStrategy, batteryChar, 46.0F);

		batteryChar.coolingType = CoolingType.PASSIVE_COOLING;
		TypewiseAlert.checkAndAlert(alertStrategy, batteryChar, 46.0F);
	}

	@Test
	public void checkAndAlertController() {
		BatteryCharacter batteryChar = new BatteryCharacter();
		AlertStrategy alertStrategy = Mockito.mock(AlertToController.class);

		batteryChar.coolingType = CoolingType.HI_ACTIVE_COOLING;
		TypewiseAlert.checkAndAlert(alertStrategy, batteryChar, 46.0F);

		batteryChar.coolingType = CoolingType.MED_ACTIVE_COOLING;
		TypewiseAlert.checkAndAlert(alertStrategy, batteryChar, 46.0F);

		batteryChar.coolingType = CoolingType.PASSIVE_COOLING;
		TypewiseAlert.checkAndAlert(alertStrategy, batteryChar, 46.0F);
	}

	@Test
	public void checkAndAlertConsole() {
		BatteryCharacter batteryChar = new BatteryCharacter();
		AlertStrategy alertStrategy = Mockito.mock(AlertToConsole.class);

		batteryChar.coolingType = CoolingType.HI_ACTIVE_COOLING;
		TypewiseAlert.checkAndAlert(alertStrategy, batteryChar, 46.0F);

		batteryChar.coolingType = CoolingType.MED_ACTIVE_COOLING;
		TypewiseAlert.checkAndAlert(alertStrategy, batteryChar, 46.0F);

		batteryChar.coolingType = CoolingType.PASSIVE_COOLING;
		TypewiseAlert.checkAndAlert(alertStrategy, batteryChar, 46.0F);
	}
}
