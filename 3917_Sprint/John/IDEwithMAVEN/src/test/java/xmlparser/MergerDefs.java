package xmlparser;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class MergerDefs {
    private static Path inputFilesDirEng = Paths.get("src/main/resources/res/values/");

    private static String[] fileNames = {
            "strings2.xml",
            "ads.xml",
            "extra.xml",
            "strings.xml"};

    private static String outFileName = "output/English_output.txt";
    private static String outFileNameMulti = "output/English_output_m.txt";


    @Given("^files from multithread with singlethreaded xmlparser is generated$")
    public void files_from_multithread_with_singlethreaded_xmlparser_is_generated() throws Throwable {
        List<Path> inputFiles = Arrays.stream(fileNames)
                .map(fname -> inputFilesDirEng.resolve(fname))
                .collect(Collectors.toList());

        // single threaded version
        String logFileName = "output/log.txt";
        try (PrintStream outStreamEng =
                     new PrintStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(outFileName, false)));
             PrintStream logFile =
                     new PrintStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(logFileName, false))))
        {
            XmlToPlainParser parser = new XmlToPlainParser();
            for (Path fileName : inputFiles) {
                parser.parse(fileName.toString(),logFile);
            }
            parser.print(outStreamEng);
        }

        // multithreaded version
        ExecutorService service = null;
        String logFileNameMulti = "output/log_m.txt";
        try (PrintStream outStreamEng = new PrintStream(new FileOutputStream(outFileNameMulti, false));
             PrintStream logFile = new PrintStream(new FileOutputStream(logFileNameMulti, false)))
        {
            XmlToPlainParserSync parser = new XmlToPlainParserSync();
            service = Executors.newFixedThreadPool(4);

            List<Callable<Map<String,String>>> tasks = new ArrayList<>();

            for (Path fileName : inputFiles) {
                tasks.add(() -> parser.parse(fileName.toString()));
            }

            List<Future<Map<String,String>>> results = service.invokeAll(tasks);

            Map<String, Map<String,String>> fileToResultsMap = new HashMap<>();

            for (int i = 0; i < inputFiles.size(); i++) {
                fileToResultsMap.put(inputFiles.get(i).toString(), results.get(i).get());
            }

            Map<String,String> allStringToValue = Merger.mergeLog(fileToResultsMap, logFile);

            Translator.translateAndWrite(allStringToValue, outStreamEng);
        }
        finally {
            if (service != null) service.shutdown();
        }
    }


    @Then("^the number of lines in files is same$")
    public void theNumberOfLinesInFilesIsSame() throws Throwable {
        Path toSingleResult = Paths.get(outFileName);
        Path toMultiResult = Paths.get(outFileNameMulti);
        List<String> singleList = Files.readAllLines(toSingleResult);
        List<String> multiList = Files.readAllLines(toMultiResult);

        Assertions.assertEquals(singleList.size(), multiList.size(),
                "singlethreaded and multithreaded has different length");
    }


    @Then("^the contents if files is same$")
    public void theContentsIfFilesIsSame() throws Throwable {
        Path toSingleResult = Paths.get(outFileName);
        Path toMultiResult = Paths.get(outFileNameMulti);
        List<String> singleList = Files.readAllLines(toSingleResult);
        List<String> multiList = Files.readAllLines(toMultiResult);

        singleList.sort(String::compareTo);
        multiList.sort(String::compareTo);

//        for (int i = 0; i < singleList.size(); i++) {
//            if (!singleList.get(i).equals(multiList.get(i))) {
//                String single = singleList.get(i);
//                String multy = multiList.get(i);
//                System.out.println("GOTCHA: " + i + " : \n\t" + single + "\n != \n\t" + multy);
//            }
//        }

        Assertions.assertEquals(singleList, multiList,
                "singlethreaded and multithreaded outputs differ");
    }

    @When("^file lines are sorted$")
    public void fileLinesAreSorted() throws Throwable {
    }
}
