import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Celestial on 6/26/17.
 */
public class Logger {


    public static void logmap(String message) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("/Users/Celestial/Desktop/Java_Logs/Map.txt",true),true);
        out.write(message);
        out.close();
    }


    public static void logred(String message) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("/Users/Celestial/Desktop/Java_Logs/Red.txt",true),true);
        out.write(message);
        out.close();
    }
}
