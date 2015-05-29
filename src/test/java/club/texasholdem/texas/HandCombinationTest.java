package club.texasholdem.texas;

import junit.framework.TestCase;

import org.junit.Test;

public class HandCombinationTest extends TestCase {

	@Test
	public void testThereAreTenRanks() {
		assertEquals(10, HandCombination.values().length);
	}

}
