package me.partharaj.prescription.apiprocessor;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

@Service
public class ApiProcessorService {

    public String resolveData(String endPoint) throws Exception {
        URL url = new URL(endPoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Response code: " + responseCode);
        }

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(url.openStream());
        while (sc.hasNext()) {
            sb.append(sc.nextLine());
        }
        sc.close();
        conn.disconnect();
        return sb.toString();
    }
}
