import xmlparser.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static java.lang.Integer.min;

public class Demo {
    static Path inputFilesDirEng = Paths.get("src/main/resources/res/values/");
    static Path inputFilesDirIta = Paths.get("src/main/resources/res/values-it/");

    static String[] fileNamesEnglish = {
            "strings2.xml",
            "ads.xml",
            "extra.xml",
            "strings.xml"};

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 3; i++) {
            System.out.println("run #" + i + ":");

//            singleThreadRun();
            multiThreadRun(4);
            multiThreadRun(2);
            multiThreadRun(1);
            multiThreadRun(2);
            multiThreadRun(4);
        }
    }

    static void singleThreadRun() throws Exception {
        long startTime = System.currentTimeMillis();

        System.out.print("\t\t Single  \t");
        translateEnglishSingleThread();

        long timeElapsed = System.currentTimeMillis() - startTime;
        System.out.print("ms elapsed: " + timeElapsed + "\t");
        printBar((int)timeElapsed);
        System.out.println();
    }


    static void multiThreadRun(int nThreads) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.print("\t\t Multi " + nThreads + "\t");
        translateEnglishParalel(nThreads);

        long timeElapsed = System.currentTimeMillis() - startTime;
        System.out.print("ms elapsed: " + timeElapsed + "\t");
        printBar((int)timeElapsed);
        System.out.println();
    }


    static void translateEnglishSingleThread() throws Exception {
        List<Path> inputFiles = Arrays.stream(fileNamesEnglish)
                .map(fname -> inputFilesDirEng.resolve(fname))
                .collect(Collectors.toList());

        String outFileName = "output/English_output.txt";
        String logFileName = "output/log.txt";
        try (PrintStream outStreamEng =
                     new PrintStream(new FileOutputStream(outFileName, false));
                PrintStream logFile =
                        new PrintStream(new FileOutputStream(logFileName, false))) {
            XmlToPlainParser parser = new XmlToPlainParser();
            for (Path fileName : inputFiles) {
                parser.parse(fileName.toString(),logFile);
            }
            parser.print(outStreamEng);
        }
    }

    static void translateEnglishParalel(int nThreads) throws Exception {
        List<Path> inputFiles = Arrays.stream(fileNamesEnglish)
                .map(fname -> inputFilesDirEng.resolve(fname))
                .collect(Collectors.toList());

        Path outDir = Paths.get("output");
        if (!Files.exists(outDir)) {
            Files.createDirectory(outDir);
        }

        Path outFileNameMulti = outDir.resolve("English_output_m.txt");
        Path logFileName = outDir.resolve("log_m.txt");

        ExecutorService service = null;
        try (PrintStream outStreamEng = new PrintStream(new BufferedOutputStream(
                     new FileOutputStream(outFileNameMulti.toString(), false)));
             PrintStream logFile = new PrintStream(new BufferedOutputStream(
                     new FileOutputStream(logFileName.toString(), false))))
        {
            XmlToPlainParserSync parser = new XmlToPlainParserSync();

            service = Executors.newFixedThreadPool(nThreads);

            List<Callable<Map<String, String>>> tasks = new ArrayList<>();

            for (Path fileName : inputFiles) {
                tasks.add(() -> parser.parse(fileName.toString()));
            }

            List<Future<Map<String, String>>> results = service.invokeAll(tasks);

            Map<String, Map<String, String>> fileToResultsMap = new HashMap<>();

            for (int i = 0; i < inputFiles.size(); i++) {
                fileToResultsMap.put(inputFiles.get(i).toString(), results.get(i).get());
            }

            Map<String, String> allStringToValue = Merger.mergeLog(fileToResultsMap, logFile);

            Translator.translateAndWrite(allStringToValue, outStreamEng);
        }
        finally {
            if (service != null) service.shutdown();
        }
    }

    static void printBar(int length) {
        int macroStep = 5;
        length = Math.round(length / 10f);

        StringBuilder builder = new StringBuilder(length);

        int pixelLeft = length;
        for (int i = 0; i < min(macroStep,pixelLeft); i++) {
            builder.append(blue(" "));
        }

        pixelLeft -= macroStep;
        for (int i = 0; i < min(macroStep,pixelLeft); i++) {
            builder.append(green(" "));
        }

        pixelLeft -= macroStep;
        for (int i = 0; i < min(macroStep,pixelLeft); i++) {
            builder.append(yellow(" "));
        }

        pixelLeft -= macroStep;
        for (int i = 0; i < pixelLeft; i++) {
            builder.append(red(" "));
        }

        System.out.print(builder.toString());
    }


    static String green(String str){
        return "\u001B[42m" + str + "\u001B[0m";
    }

    static String yellow(String str){
        return "\u001B[43m" + str + "\u001B[0m";
    }

    static String red(String str){
        return "\u001B[41m" + str + "\u001B[0m";
    }

    static String blue(String str){
        return "\u001B[46m" + str + "\u001B[0m";
    }
}