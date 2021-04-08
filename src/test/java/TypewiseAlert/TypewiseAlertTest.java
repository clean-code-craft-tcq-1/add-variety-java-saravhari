package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import enums.BreachType;

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
}
