/*
 * tiedosto pohjautuu tunnilla 11.12 k‰ydyst‰ esimerkist‰ 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpThread implements Runnable {
	private HttpThreadListener listener;
	private static String city;
	
	// M‰‰ritet‰‰n appID ja mink‰ kaupungin s‰‰ dataa haetaan
	public static void setCity() {
		city = CitySelection.selectCity();
		OpenWeatherData.OWDcity(city);
	}
	
	private final String url = "http://api.openweathermap.org/data/2.5/forecast?q="+city+"&units=metric&mode=json&appid=982c54e6f5ed5ceaee4995b58387e2ef";
	
	
    public void setHttpThreadListener( HttpThreadListener listener ) {
    	this.listener = listener;
    }
    
	@Override
	public void run() {
		// Tehd‰‰n REST -kutsu ja haetaan data jsonResponse -merkkijonoon
        String jsonResponse = "";
        try {        	
            URL openWeatherMapUrl = new URL( url );
            BufferedReader in = new BufferedReader( new InputStreamReader( openWeatherMapUrl.openStream() ));
            String line;
            while( (line = in.readLine()) != null ){  // Luetaan puskurista rivi kerrallaan koko response
                jsonResponse += line;
            }
            in.close();
            listener.jsonResponseReady( jsonResponse );
        } catch (MalformedURLException ex) {

        } catch (IOException ex) {

        }
    }
	
}


interface HttpThreadListener {
	public void jsonResponseReady( String jsonResponse );
}

