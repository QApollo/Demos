private List<String> speciesList = new ArrayList<>();
private LocalTime currentTime = LocalTime.now();

cpuMon.getSpecies().equals("Rupspie")

LocalTime morningTime = LocalTime.of(12,00);
LocalTime noonTime = LocalTime.of(18,00);
LocalTime testTime = LocalTime.of(21,00);

if (testTime.isBefore(morningTime)) {
  speciesList.add("Tulpasaur");
  speciesList.add("Aangebrander");
  speciesList.add("Spuitle");
} else if (testTime.isBefore(noonTime)) {
  speciesList.add("Rupspie");
  speciesList.add("Duifgey");
  speciesList.add("Bellspruit");
} else if (testTime.isAfter(noonTime)) {
  speciesList.add("OehoeOhoe");
  speciesList.add("Noctuil");
  speciesList.add("Paraneon");
}

private String selectZakmon() {
  boolean valid = false;
  int input = 0;
  while (!valid) {
    try {
      input = sc.nextInt();

      /* chose to take an value from an array instead of hard coding the zakmon in a if or switch case
        would make it easier to add other zakmon by just adding them to the array and in the zakmon class add anothercase in the switch case
      */
      if (input <= speciesList.size() && input > 0) {
        valid = true;
      } else {
        System.out.println("Invalid zakmon chosen choose: 1) 2) or 3)");
      }
    } catch (Exception e) {
      System.out.println("This isn't an ABC question. Please respect that."
      +System.lineSeparator()+
      "Choose: 1) 2) or 3)");
      sc.nextLine();
    }
  }
  /* since arrays are zero indexed and the user can input 1 to 3 which in an array would be 0 to 2
     I take the input decrement it by one to get the correct index from the user choice
     Example user inputs 2 which is Aangebrander. Aangebrander is the second zakmon in the array at index[1] input 2 - 1 = 1
  */
  selectedZakmonMessage(input-1);
  return speciesList.get(input-1);
}

private String cpuSelectZakmon() {
  Random r = new Random();
  int index = r.nextInt(3) +0;
  System.out.println("Your opponent selected "+ speciesList.get(index) + System.lineSeparator());
  return speciesList.get(index);
}
