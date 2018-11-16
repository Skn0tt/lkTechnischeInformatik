import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexImpl implements ContainsInfoAboutJamesBondParser {

    private Pattern p = Pattern.compile(".*007.*");

    public boolean containsInfo(String msg) {
        Matcher m = p.matcher(msg);
        return m.matches();
    }

}
