import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.anyString;
import org.junit.jupiter.api.Test;

public class ArgumentMatchingTest {

	@Test
	public void testArgumentMatching() {
		Greeter mockGreeter = mock(Greeter.class);

		mockGreeter.greet("Asvathama");

		verify(mockGreeter).greet("Asvathama");
		verify(mockGreeter).greet(anyString());
	}
}
