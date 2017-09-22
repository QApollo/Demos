package xmlparser;

import java.io.PrintStream;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translator {
    public static void translateAndWrite(Map<String,String> stringResourceMap,
                                         PrintStream outStream) {
        StringJoiner joiner = new StringJoiner("\n");

        stringResourceMap.forEach((k,v) -> {
            String entry = k + " = " + adaptText(v);
            joiner.add(entry);
        });

        outStream.print(joiner.toString());
    }

    private static String adaptText(String strIn) {
        String regex1 = "%d";
        String regex2 = "%(\\d)\\$\\w";
        if (!strIn.matches(String.format(".*(%s|%s).*", regex1, regex2))) {
            return strIn;
        }
        // here I suppose that special combination "%d" and "%\d$\w" appear only
        // separately (in different records). And they are!

        StringBuffer sbuf = new StringBuffer();
        if (strIn.matches(".*" + regex1 + ".*")) {
            Matcher mInput = Pattern.compile(regex1, Pattern.DOTALL).matcher(strIn);
            for (int i = 0; mInput.find(); i++) {
                mInput.appendReplacement(sbuf, "{" + i + "}");
            }
            mInput.appendTail(sbuf);
        }
        else if (strIn.matches(".*" + regex2 + ".*")) {
            Matcher mInput = Pattern.compile(regex2, Pattern.DOTALL).matcher(strIn);
            while (mInput.find()) {
                mInput.appendReplacement(sbuf, "{" + (char)(mInput.group(1).charAt(0) - 1) + "}");
            }
            mInput.appendTail(sbuf);
        }

        return sbuf.toString();
    }
}
