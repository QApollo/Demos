package xmlparser;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Merger {
    public static Map<String, String> mergeLog(
            Map<String,Map<String,String>> parseResults,
            PrintStream logStream) {
        Map<String, String> retVal = new HashMap<>();
        if (parseResults.size() > 0) {
            String[] inputFileNames = parseResults.keySet().toArray(new String[0]);
            retVal = parseResults.get(inputFileNames[0]);

            for (int i = 1; i < inputFileNames.length; i++) {
                String fileName = inputFileNames[i];
                Map<String, String> mapToMerge = parseResults.get(fileName);

                for (Map.Entry<String, String> entry : mapToMerge.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();

                    boolean isDuplicate = null != retVal.putIfAbsent(key, value);
                    if (isDuplicate) {
                        String oldValue = retVal.get(key);
                        report(key, oldValue, value, fileName, logStream);
                    }
                }
            }
        }

        return  retVal;
    }


    private static void report(String key,
                               String oldValue,
                               String newValue,
                               String fileName,
                               PrintStream logStream) {
        if (oldValue.equals(newValue)) {
            logStream.println("!Duplication for entry: \"" + key
                    + "\"\t in file " + fileName);
        } else {
            logStream.println("WARNING! Different values for entry: \""
                    + key + "\"\n"
                    + "\t version one: \"" + oldValue + "\"\n"
                    + "\t version two: \"" + newValue + "\"\t location: " + fileName);
        }
    }
}