import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorAAATest {

	Calculator calc;

	@Before
	public void setUp() {
		calc = new Calculator();
		System.out.println("setting up before test");
	}

	@After
	public void tearDown() {
		calc = null;
		System.out.println("cleaning up after test");
	}

	@Test
	public void testAdd() {
		// Arrange
		int a = 10;
		int b = 20;

		// Act
		int result = calc.add(a, b);

		// Assert
		assertEquals(30, result);
	}
}
