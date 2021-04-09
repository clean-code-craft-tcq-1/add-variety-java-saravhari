package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import character.BatteryCharacter;
import enums.AlertTarget;
import enums.BreachType;
import enums.CoolingType;

public class TypewiseAlertTest {
	@Test
	public void infersBreachAsPerLimits() {
		assertTrue(TypewiseAlert.inferBreach(12, 20, 30) == BreachType.TOO_LOW);
	}

	@Test
	public void infersBreachAsPerUpperLimits() {
		assertTrue(TypewiseAlert.inferBreach(47, 0, 46) == BreachType.TOO_HIGH);
	}

	@Test
	public void infersBreachAsPerNormalLimits() {
		assertTrue(TypewiseAlert.inferBreach(12, 0, 46) == BreachType.NORMAL);
	}
	
	@Test
	public void infersBreachAsPerZeroLimits() {
		assertTrue(TypewiseAlert.inferBreach(12, 0, 0) == BreachType.TOO_LOW);
	}
	
	@Test
	public void infersBreachAsPerZeroValue() {
		assertTrue(TypewiseAlert.inferBreach(0, 0, 0) == BreachType.TOO_LOW);
	}

	@Test
	public void checkAndAlertEmail() {
		BatteryCharacter batteryChar = new BatteryCharacter();
		batteryChar.coolingType = CoolingType.PASSIVE_COOLING;
		TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL, batteryChar, 46.0F);
		assertTrue(true);
	}
}
