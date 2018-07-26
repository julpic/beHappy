package utilities;

import javax.ejb.Stateless;
import java.util.Base64;
import java.util.StringTokenizer;

@Stateless
public class AuthParser {
    private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";

    public String[] parse(String s) {
        String[] retString = new String[2];
        s = s.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
        String decodedString = new String(Base64.getDecoder().decode(s));
        StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
        retString[0] = tokenizer.nextToken();
        retString[1] = tokenizer.nextToken();
        return retString;
    }
}
