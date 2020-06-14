package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;

@WebSevlet("/Main")
public class Main {
 private static final long serialVersionUID = 1l;

 private static void testSlack(){
	    String json = "{\n" +
	            "    \"channel\":\"bot−test\"," +
	            "    \"username\":\"テスト\",\n" +
	            "    \"text\": \"テスト\",\n" +
	            "    \"attachments\": [\n" +
	            "        {\n" +
	            "            \"color\": \"#89ceeb\",\n" +
	            "            \"text\": \"テスト\"\n" +
	            "        }\n" +
	            "    ]\n" +
	            "}";
	    try {
	        URL url = new URL("https://slack.com/api/chat.postMessage?token=トークン");
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("POST");
	        connection.setDoOutput(true);
	        connection.setRequestProperty("Content-type", "application/json");
	        OutputStream stream = connection.getOutputStream();
	        PrintStream ps = new PrintStream(stream);
	        ps.print(json);
	        ps.close();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String str = "";
	        String body;
	        while ((body = reader.readLine()) != null) {
	            str += body + "\n";
	        }
	        System.out.println(str);
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    } catch (ProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
