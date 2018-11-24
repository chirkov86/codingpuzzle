import com.achirkov.codingpuzzle.game.GameState;
import com.achirkov.codingpuzzle.io.ConsoleReader;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleReaderTest {

    @InjectMocks
    private ConsoleReader consoleReader = new ConsoleReader();

    @Mock
    private GameState GameState;

//    @Before
//    void setup() {
//        MockitoAnnotations.initMocks(this);
//    }

}