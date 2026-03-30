import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase8TrainConsistMgmtTest {

    // Helper method to create sample bogies
    private List<Bogie> getSampleBogies() {
        return List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("General", 90)
        );
    }

    // Test: Capacity greater than threshold
    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = TrainConsistManagementApp
                .filterBogiesByCapacity(getSampleBogies(), 70);

        assertTrue(result.stream().allMatch(b -> b.capacity > 70));
        assertEquals(2, result.size()); // Sleeper, General
    }

    // Test: Capacity equal to threshold should NOT be included
    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> result = TrainConsistManagementApp
                .filterBogiesByCapacity(getSampleBogies(), 72);

        assertTrue(result.stream().noneMatch(b -> b.capacity == 72));
    }

    // Test: Capacity less than threshold should NOT be included
    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result = TrainConsistManagementApp
                .filterBogiesByCapacity(getSampleBogies(), 70);

        assertTrue(result.stream().noneMatch(b -> b.capacity < 70));
    }

    // Test: Multiple bogies matching
    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> result = TrainConsistManagementApp
                .filterBogiesByCapacity(getSampleBogies(), 50);

        assertEquals(3, result.size()); // Sleeper, AC Chair, General
    }

    // Test: No bogies matching
    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> result = TrainConsistManagementApp
                .filterBogiesByCapacity(getSampleBogies(), 100);

        assertTrue(result.isEmpty());
    }

    // Test: All bogies matching
    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> result = TrainConsistManagementApp
                .filterBogiesByCapacity(getSampleBogies(), 10);

        assertEquals(4, result.size());
    }

    // Test: Empty list
    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> result = TrainConsistManagementApp
                .filterBogiesByCapacity(new ArrayList<>(), 50);

        assertTrue(result.isEmpty());
    }

    // Test: Original list unchanged
    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(getSampleBogies());

        TrainConsistManagementApp.filterBogiesByCapacity(original, 60);

        // original should remain unchanged
        assertEquals(4, original.size());
        assertEquals("Sleeper", original.get(0).name);
    }
}