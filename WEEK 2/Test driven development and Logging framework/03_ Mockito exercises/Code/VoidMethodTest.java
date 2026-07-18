import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class VoidMethodTest {

	@Test
	public void testSendNotification() {
		Notifier mockNotifier = mock(Notifier.class);
		doNothing().when(mockNotifier).send("hello");

		mockNotifier.send("hello");

		verify(mockNotifier).send("hello");
	}
}
