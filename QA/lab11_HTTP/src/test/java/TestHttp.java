import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class TestHttp {
    private Double coreTest(double a, String operator, double b)throws Exception{
        String query = "http://localhost:8080/Servlet_student_2019/calculate?a="+a+"&operator="+operator+"&b="+b;
        HttpURLConnection connection = null;
        connection = (HttpURLConnection) new URL(query).openConnection();
        connection.setRequestMethod("GET");
        connection.setUseCaches(false);
        connection.setConnectTimeout(2500);
        connection.setReadTimeout(2500);
        connection.connect();
        StringBuilder sb = new StringBuilder();
        if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        }
        connection.disconnect();
        String[] words = sb.toString().split(" ");
        return Double.parseDouble(words[words.length-2]);
    }

    private double a = 1025.0;
    private double b = 23.5;

    @Test
    public void first() throws Exception{
        Assert.assertEquals(a+b, coreTest(a,"%2B", b),0);
    }

    @Test
    public void second() throws Exception{
        Assert.assertEquals(a-b, coreTest(a,"-", b) ,0);
    }

    @Test
    public void third() throws Exception{
        Assert.assertEquals(a*b, coreTest(a,"*", b),0);
    }

    @Test
    public void fourth() throws Exception{
        Assert.assertEquals(a/b, coreTest(a,"/", b),0);
    }
}
