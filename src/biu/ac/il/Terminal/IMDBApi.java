package biu.ac.il.Terminal;

import javax.script.ScriptException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class IMDBApi {
    private String apiKey;

    public IMDBApi() {
        Map<String, Object> config;
        try {
            // Extract the key from the configuration file
            config = JSONReader.parseJson("config.json");
            this.apiKey = (String) config.get("omdbAPIKey");
        } catch (IOException | ScriptException e) {
            System.out.println("config.json file is missing");
            System.exit(1);
        }
    }

    public Movie getMovieData(String movieName) {
        URL url;
        InputStream is = null;
        Movie m = null;
        try {
            // Create the request to the IDBApi using the request key
            url = new URL("http://www.omdbapi.com/?t=" + movieName + "&apikey=" + this.apiKey);
            // Use streams to work better with arrays - using the arrow anonymous function
            is = url.openStream();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(is));
            String inputLine;
            StringBuilder json = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }

            // Convert the json we got from the IMDBApi into a map
            Map<String, Object> jsonMap = JSONReader.JSONToMap(json.toString());
            // Build the movie object using the map
            m = new Movie(
                    (String) jsonMap.get("Title"),
                    (String) jsonMap.get("Actors"),
                    (String) jsonMap.get("imdbRating"),
                    (String) jsonMap.get("Year"),
                    (String) jsonMap.get("Director"),
                    (String) jsonMap.get("BoxOffice"),
                    (String) jsonMap.get("Country")
            );
        } catch (IOException | ScriptException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return m;
    }

    public Movie[] getMoviesBetweenYears(int from, int to) {
        return null;
    }

    public Movie getRandomMovie() {
        return null;
    }
}
