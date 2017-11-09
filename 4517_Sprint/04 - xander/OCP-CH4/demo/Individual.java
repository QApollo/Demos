import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Individual {

  private String name;
  private int age;
  private List<Vinyl> vinylCollection = new ArrayList<>();

  public Individual(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void addVinylToCollection(Vinyl vinyl) {
    vinylCollection.add(vinyl);
  }

  public void addVinylToCollection(Vinyl[] vinyls) {
    for (Vinyl vinyl : vinyls) {
      vinylCollection.add(vinyl);
    }
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public List<Vinyl> getVinylCollection() {
    List<Vinyl> collectionCopy = new ArrayList<>();

    vinylCollection.forEach(collectionCopy::add);

    return collectionCopy;
  }
}
