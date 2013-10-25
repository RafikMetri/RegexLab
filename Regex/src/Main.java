/**
 * Created with IntelliJ IDEA.
 * User: rmetri
 * Date: 10/25/13
 * Time: 1:18 AM
 * To change this template use File | Settings | File Templates.
 */
import java.util.regex.*;
import java.util.*;

import static java.util.regex.Pattern.*;

public class Main {



    public static void main(String[] args){
        String text = "<html>\n" +
                "<head>\\n" +
                "    <meta content=\"text/html; charset=ISO-8859-1\"\n" +
                "          http-equiv=\"content-type\">\n" +
                "    <title>All About Fish</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>All About Fish</h1>\n" +
                "Fish are facinating animals that live under the\n" +
                "<a href=\"http://www.ocean.com/\">sea</a>.\n" +
                "They have <a href=\"http://www.fish.ocean.com/scales/scale.1.jpg\">scales</a>\n" +
                "and <a href=\"http://marinebiology.org/fins//fin-0.GIF\">fins</a>.<br> There are many good\n" +
                "<a href=\"http://www.seafood-recipes.com/directory/salmon.asp\">recipes</a> to cook fish.<br>\n" +
                "Fish make excellent <a href=\"http://www.petfish.net/index.php\">pets</a>,\n" +
                "and many people are interested in <a href=\"http://www.tropfish.com\">tropical fish</a>.\n" +
                "My favorite fish-related website is http://www.fish.com/tropical.<br>\n" +
                "Some people think that \"http://fish/fish.html\" would be a good URL, but they are wrong!\n" +
                "Others think that starfish should have a URL of \"http://fish.com/*fish\" but that's bad too!\n" +
                "<br>\n" +
                "</body>\n" +
                "</html>";
        printUrls(text);
    }

    public static void printUrls(String text){
        //System.out.println(Arrays.toString(compile("\"(https?://)?(((\\w|-|-_)+\\.)?){2}(((\\w|-|-_)+\\.)?)(([A-Z]|[a-z]){3})(/((\\w|-|-_|.)?))?\"").split(text)));
        Pattern regex = Pattern.compile("\"(https?://)?(((\\w|-|-_)+\\.)?){2}(((\\w|-|-_)+\\.)?)(([A-Z]|[a-z]){3})(/((\\w|-|-_|.))+)?\\\"", Pattern.CASE_INSENSITIVE);
        Matcher search = regex.matcher(text);
        int count = 0;
        while (search.find()){
            System.out.printf("Match %d: %s @ %d%n", ++ count, search.group(), search.start());
        }
    }
}
