
class SassySiri extends Siri {
  public void outputTime() {
    System.out.println("It's time to kick your ass.");
  }

  public void response() {
    System.out.println("Your mama "
                        .concat(verbs.get(randIndex.nextInt(verbs.size())))
                        .concat(" ").concat(objects.get(randIndex.nextInt(objects.size()))));
                      }
}
