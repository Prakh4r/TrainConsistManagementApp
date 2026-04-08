@Test
void testSort_BasicAlphabeticalSorting() {
    String[] arr = {"Sleeper","AC Chair","First Class","General","Luxury"};

    TrainConsistManagementApp.sortBogieNames(arr);

    assertArrayEquals(
            new String[]{"AC Chair","First Class","General","Luxury","Sleeper"},
            arr
    );
}

@Test
void testSort_UnsortedInput() {
    String[] arr = {"Luxury","General","Sleeper","AC Chair"};

    TrainConsistManagementApp.sortBogieNames(arr);

    assertArrayEquals(
            new String[]{"AC Chair","General","Luxury","Sleeper"},
            arr
    );
}

@Test
void testSort_AlreadySortedArray() {
    String[] arr = {"AC Chair","First Class","General"};

    TrainConsistManagementApp.sortBogieNames(arr);

    assertArrayEquals(
            new String[]{"AC Chair","First Class","General"},
            arr
    );
}

@Test
void testSort_DuplicateBogieNames() {
    String[] arr = {"Sleeper","AC Chair","Sleeper","General"};

    TrainConsistManagementApp.sortBogieNames(arr);

    assertArrayEquals(
            new String[]{"AC Chair","General","Sleeper","Sleeper"},
            arr
    );
}

@Test
void testSort_SingleElementArray() {
    String[] arr = {"Sleeper"};

    TrainConsistManagementApp.sortBogieNames(arr);

    assertArrayEquals(new String[]{"Sleeper"}, arr);
}