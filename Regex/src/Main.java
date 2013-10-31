
/**
 * Created with IntelliJ IDEA.
 * User: rmetri
 * Date: 10/25/13
 * Time: 1:18 AM
 * To change this template use File | Settings | File Templates.
 */
import java.io.File;
import java.util.regex.*;
import java.util.*;

import static java.util.regex.Pattern.*;

public class Main {



    public static void main(String[] args){
        Scanner read = null;
        String text = null;

        try{
            read = new Scanner(new File("Fish.txt"));
            read.useDelimiter("$");
            text = read.next();
            read.close();
        }
        catch(Exception e){
            System.out.println("There was a problem scanning your file");
        }

        printUrls(text);
    }

    public static void printUrls(String text){
        Pattern regex = Pattern.compile("\"(https?://)?(((\\w|-|-_)+\\.)?){2}(((\\w|-|-_)+\\.)?)(([A-Z]|[a-z]){3})(/((\\w|-|-_|.))+)?\\\"", Pattern.CASE_INSENSITIVE);
        Matcher search = regex.matcher(text);
        int count = 0;
        while (search.find()){
            System.out.printf("Match %d: %s @ %d%n", ++ count, search.group(), search.start());
        }
    }
}