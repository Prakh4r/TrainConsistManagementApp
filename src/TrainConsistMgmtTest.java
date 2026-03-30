import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtTest {

    private List<Bogie> getSampleBogies() {
        return List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );
    }

    @Test
    void testGrouping() {
        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(getSampleBogies());

        assertTrue(result.containsKey("Sleeper"));
    }
}