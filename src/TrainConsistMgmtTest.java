@Test
void testSearch_ThrowsExceptionWhenEmpty() {
    String[] arr = {};

    Exception exception = assertThrows(
            IllegalStateException.class,
            () -> TrainConsistManagementApp.safeSearchBogie(arr, "BG101")
    );

    assertTrue(exception.getMessage().contains("No bogies available"));
}

@Test
void testSearch_AllowsSearchWhenDataExists() {
    String[] arr = {"BG101","BG205"};

    assertDoesNotThrow(() -> {
        TrainConsistManagementApp.safeSearchBogie(arr, "BG101");
    });
}

@Test
void testSearch_BogieFoundAfterValidation() {
    String[] arr = {"BG101","BG205","BG309"};

    boolean result = TrainConsistManagementApp.safeSearchBogie(arr, "BG205");

    assertTrue(result);
}

@Test
void testSearch_BogieNotFoundAfterValidation() {
    String[] arr = {"BG101","BG205","BG309"};

    boolean result = TrainConsistManagementApp.safeSearchBogie(arr, "BG999");

    assertFalse(result);
}

@Test
void testSearch_SingleElementValidCase() {
    String[] arr = {"BG101"};

    boolean result = TrainConsistManagementApp.safeSearchBogie(arr, "BG101");

    assertTrue(result);
}