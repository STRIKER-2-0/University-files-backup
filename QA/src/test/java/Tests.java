import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Tests {
    private Double coreTest(double first, double second, String operation)throws Exception{
        String query = "http://localhost:8080/Zolotukhin/send?first="+
                first+"&second="+second+"&operation="+operation;
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
                if(line.contains("<h2>")) {
                    String []tmp = line.split(" ");
                    sb.append(tmp[1]);
                }
            }
        }
        connection.disconnect();
        return Double.parseDouble(sb.toString());
    }

    @Test
    public void test1() throws Exception{
        double current = coreTest(10,0.5,"addition");
        double expected = 10.5;
        Assert.assertEquals(expected,current,0);
    }

    @Test
    public void test2() throws Exception{
        double current = coreTest(10,0.5,"subtraction");
        double expected = 9.5;
        Assert.assertEquals(expected,current,0);
    }

    @Test
    public void test3() throws Exception{
        double current = coreTest(10,0.5,"multiplication");
        double expected = 5;
        Assert.assertEquals(expected,current,0);
    }

    @Test
    public void test4() throws Exception{
        double current = coreTest(10,0.5,"division");
        double expected = 20;
        Assert.assertEquals(expected,current,0);
    }

}
