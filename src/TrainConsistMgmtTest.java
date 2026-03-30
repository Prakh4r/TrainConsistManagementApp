import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtTest {

    private List<TrainConsistManagementApp.Bogie> getBogies() {
        return List.of(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC", 40),
                new TrainConsistManagementApp.Bogie("General", 90),
                new TrainConsistManagementApp.Bogie("Chair", 30)
        );
    }

    @Test
    void testLoopFilteringLogic() {
        List<?> result = TrainConsistManagementApp.filterUsingLoop(getBogies(), 50);
        assertEquals(2, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<?> result = TrainConsistManagementApp.filterUsingStream(getBogies(), 50);
        assertEquals(2, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<?> loop = TrainConsistManagementApp.filterUsingLoop(getBogies(), 50);
        List<?> stream = TrainConsistManagementApp.filterUsingStream(getBogies(), 50);

        assertEquals(loop.size(), stream.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", i));
        }

        long start = System.nanoTime();
        TrainConsistManagementApp.filterUsingStream(bogies, 500);
        long end = System.nanoTime();

        assertTrue(end > start);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", i));
        }

        List<?> result = TrainConsistManagementApp.filterUsingStream(bogies, 5000);
        assertTrue(result.size() > 0);
    }
}