package co.escuelaing.edu.co.examen2.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpService {

    private static final String USER_AGENT = "Mozilla/5.0";

    public String get(String urlStr) {

        try {
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();

            if (responseCode == 200) {

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));

                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
                return response.toString();

            } else {
                throw new RuntimeException("Error: " + responseCode);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}