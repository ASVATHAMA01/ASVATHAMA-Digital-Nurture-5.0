import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

public class InteractionOrderTest {

	@Test
	public void testCallOrder() {
		Notifier mockNotifier = mock(Notifier.class);

		mockNotifier.send("first");
		mockNotifier.send("second");

		InOrder inOrder = inOrder(mockNotifier);
		inOrder.verify(mockNotifier).send("first");
		inOrder.verify(mockNotifier).send("second");
	}
}
