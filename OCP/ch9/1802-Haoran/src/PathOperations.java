import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PathOperations {
    public static void cleanPath(Path path){
        try {
            List<String> nameList = Files.walk(path).map(Path::toString).collect(Collectors.toList());
            Collections.reverse(nameList);
            nameList.stream().map(Paths::get).forEach(p -> {
                try {
                    Files.deleteIfExists(p);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createPath(Path createPath, Path poemPath){
        try {
            List<String> fileNames = Files.readAllLines(poemPath);
            for (String name: fileNames) {
                System.out.println(name);
                createPath = createPath.resolve(name);
            }
            Files.createDirectories(createPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
