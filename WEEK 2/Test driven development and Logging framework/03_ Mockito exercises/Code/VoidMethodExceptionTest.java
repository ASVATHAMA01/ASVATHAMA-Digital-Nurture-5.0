import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VoidMethodExceptionTest {

    @Test
    public void testSendThrowsException() {
        Notifier mockNotifier = mock(Notifier.class);
        doThrow(new RuntimeException("send failed")).when(mockNotifier).send("hello");

        assertThrows(RuntimeException.class, () -> mockNotifier.send("hello"));

        verify(mockNotifier).send("hello");
    }
}
