import java.io.File;
import java.nio.file.Path;

public class PoemProperties {

    private final File poemFile;
    private final Path poemPath;

    public PoemProperties(String path){
        this.poemFile = new File(path);
        this.poemPath = poemFile.toPath();
    }

    public File getPoemFile() {
        return poemFile;
    }

    public Path getPoemPath() {
        return poemPath;
    }
}
