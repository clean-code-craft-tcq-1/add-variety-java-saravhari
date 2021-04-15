package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import alert.AlertToEmail;
import character.BatteryCharacter;
import cooling.CoolingTypeHiActive;
import enums.BreachType;
import strategy.AlertStrategy;

public class TypewiseAlertTest {
	@Mock
	TypewiseAlert typewiseAlert;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

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
	public void infersBreachAsPerZeroValue() {
		assertTrue(TypewiseAlert.inferBreach(0, 0, 0) == TypewiseAlert.BreachMap.get(BreachType.NORMAL));
	}

	@Test
	public void checkAndAlertEmail() {
		BatteryCharacter batteryChar = new BatteryCharacter();
		AlertStrategy alertEmailStrategy = new AlertToEmail();
		batteryChar.coolingStrategy = new CoolingTypeHiActive();
		Mockito.doNothing().when(typewiseAlert);
		TypewiseAlert.checkAndAlert(alertEmailStrategy, batteryChar, 46.0F);
	}
}
