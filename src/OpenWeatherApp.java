/*
 * tiedosto pohjautuu tunnilla 11.12 käydystä esimerkistä 
 */
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenWeatherApp {
	private static ArrayList<OpenWeatherData> weatherDataArray = new ArrayList();
	
	public static void main(String[] args){
		
	}
	
	public static void getWeatherAppData() {
		HttpThread httpThread = new HttpThread();
		httpThread.setHttpThreadListener( ( String jsonResponse ) -> {
			
			// Parsetaan saadusta jsoninsta tarvittava tieto: lämpötila, tuulennopeus, sään kuvaus ja ennusteen pvm/klo
			try {
				JSONObject weatherObject = new JSONObject( jsonResponse );
				JSONArray weatherList = weatherObject.getJSONArray( "list" );
				for( int i = 0; i < weatherList.length(); i++ ) {
					JSONObject weatherElement = weatherList.getJSONObject(i);
					double temp = weatherElement.getJSONObject( "main" ).getDouble( "temp" );
					double windSpeed = weatherElement.getJSONObject( "wind" ).getDouble( "speed" );
					String weatherDesc = 
							weatherElement.getJSONArray( "weather" ).getJSONObject(0).getString( "description" );
					String dateTime = weatherElement.getString( "dt_txt" );
					weatherDataArray.add(new OpenWeatherData( temp, windSpeed, weatherDesc, dateTime ));
				}
			} catch (JSONException ex) {
				Logger.getLogger(OpenWeatherApp.class.getName()).log(Level.SEVERE, null, ex);
			}
		});
		new Thread( httpThread ).start();
	}
	
	// tulostetaan tallennetut tiedot - ei keskeytä datan hakua
	public static void printWeatherAppData() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("City		Date 	  Time		Temperature °C	Wind Speed m/s	Description");
		for( OpenWeatherData d : weatherDataArray ) {
			System.out.println( d );
		}
	}
	
	// tyhjennetään arraylist - ei keskeytä datan hakua
	public static void deleteWeatherAppData() {
		weatherDataArray = new ArrayList();
	}
}