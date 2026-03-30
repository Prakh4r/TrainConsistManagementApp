import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtTest {

    // Helper method to create GoodsBogie list
    private List<TrainConsistManagementApp.GoodsBogie> getValidBogies() {
        return List.of(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistManagementApp.GoodsBogie("Open", "Coal"),
                new TrainConsistManagementApp.GoodsBogie("Box", "Grain"),
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum")
        );
    }

    // ================= TEST CASES =================

    @Test
    void testSafety_AllBogiesValid() {
        boolean result = TrainConsistManagementApp.isSafeComposition(getValidBogies());
        assertTrue(result);
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = List.of(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal") // invalid
        );

        boolean result = TrainConsistManagementApp.isSafeComposition(bogies);
        assertFalse(result);
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = List.of(
                new TrainConsistManagementApp.GoodsBogie("Open", "Coal"),
                new TrainConsistManagementApp.GoodsBogie("Box", "Grain")
        );

        boolean result = TrainConsistManagementApp.isSafeComposition(bogies);
        assertTrue(result);
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = List.of(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal"), // violation
                new TrainConsistManagementApp.GoodsBogie("Open", "Grain")
        );

        boolean result = TrainConsistManagementApp.isSafeComposition(bogies);
        assertFalse(result);
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = new ArrayList<>();

        boolean result = TrainConsistManagementApp.isSafeComposition(bogies);
        assertTrue(result); // empty list = safe
    }
}