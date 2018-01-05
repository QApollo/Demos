import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo {

    public static void main(String[] args) {
        PoemProperties poemProperties = new PoemProperties("poem.txt");
        Path poemPath = poemProperties.getPoemPath();
        Path currentPath = Paths.get("Poem");

        PathOperations.cleanPath(currentPath);
        PathOperations.createPath(currentPath, poemPath);
    }
}
