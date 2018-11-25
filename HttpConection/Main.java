import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
    URL url = new URL("https://www.baeldung.com/java-http-request");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    int status = con.getResponseCode();


    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer content = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
    }
    in.close();

    System.out.println(content.toString());
    }
}