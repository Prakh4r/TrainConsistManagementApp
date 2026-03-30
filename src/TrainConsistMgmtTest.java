import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtTest {

    private List<Bogie> getBogies() {
        return List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70)
        );
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        int result = TrainConsistManagementApp.calculateTotalCapacity(getBogies());
        assertEquals(222, result);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        int result = TrainConsistManagementApp.calculateTotalCapacity(getBogies());
        assertTrue(result > 0);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        int result = TrainConsistManagementApp.calculateTotalCapacity(
                List.of(new Bogie("Sleeper",72))
        );
        assertEquals(72, result);
    }

    @Test
    void testReduce_EmptyBogieList() {
        int result = TrainConsistManagementApp.calculateTotalCapacity(new ArrayList<>());
        assertEquals(0, result);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        int result = TrainConsistManagementApp.calculateTotalCapacity(getBogies());
        assertEquals(72+56+24+70, result);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        int result = TrainConsistManagementApp.calculateTotalCapacity(getBogies());
        assertEquals(222, result);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(getBogies());
        TrainConsistManagementApp.calculateTotalCapacity(original);
        assertEquals(4, original.size());
    }
}