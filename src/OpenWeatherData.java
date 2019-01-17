/*
 * tiedosto pohjautuu tunnilla 11.12 käydystä esimerkistä 
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OpenWeatherData {
	private double temp;
	private double windSpeed;
	private String weatherDesc;
	private String dateTime;
	private static String bcity;//apumuuttuja varmistamaan että kaupunkia vaihtaessa ArrayListissä jo olevat kaupungit eivät muutu
	private String city = bcity; 
	
	public static void OWDcity( String acity ) {
		bcity = acity;
	}
	
	public OpenWeatherData( double temp, double windSpeed, String weatherDesc, String dateTime ) {
		this.temp = temp;
		this.windSpeed = windSpeed;
		this.weatherDesc = weatherDesc;
		this.dateTime = dateTime;
	}
	
	@Override
	public String toString() {

		//DateFormat dateFormat = new SimpleDateFormat( "HH:mm:ss" );
		//Date date = new Date();
		//String fetchDate = dateFormat.format( date );
		
		//return "Date&Time: " + dateTime + ", Temperature " + temp + "C" + ", Wind Speed " + windSpeed + "m/s" + ", Description " + weatherDesc + ", data collected @ " + fetchDate;
		return city + "	   " + dateTime + "	  " + temp + "		" + windSpeed + "		" + weatherDesc;
	}
}
