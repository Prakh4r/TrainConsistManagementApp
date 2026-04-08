@Test
void testSearch_BogieFound() {
    String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

    boolean result = TrainConsistManagementApp.searchBogieById(arr, "BG309");

    assertTrue(result);
}

@Test
void testSearch_BogieNotFound() {
    String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

    boolean result = TrainConsistManagementApp.searchBogieById(arr, "BG999");

    assertFalse(result);
}

@Test
void testSearch_FirstElementMatch() {
    String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

    boolean result = TrainConsistManagementApp.searchBogieById(arr, "BG101");

    assertTrue(result);
}

@Test
void testSearch_LastElementMatch() {
    String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

    boolean result = TrainConsistManagementApp.searchBogieById(arr, "BG550");

    assertTrue(result);
}

@Test
void testSearch_SingleElementArray() {
    String[] arr = {"BG101"};

    boolean result = TrainConsistManagementApp.searchBogieById(arr, "BG101");

    assertTrue(result);
}