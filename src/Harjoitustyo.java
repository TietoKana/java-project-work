import javax.swing.JOptionPane;

public class Harjoitustyo implements TimerListener {
	
	public static void main(String[] args) {

		Timer timer = new Timer(60); // m‰‰ritet‰‰n kuinka monen sekunnin v‰lein dataa haetaan
		Thread timerThread = new Thread( timer );
		timerThread.start();

		timer.setTimerListener(new Harjoitustyo());
		
		OUTER:
		while ( true ) {
			String s = JOptionPane.showInputDialog(
				null,
				"Please select what you want to do"
				+ "\n"
				+ "\n"
				+ "1. Select a city"
				+ "\n2. Start gathering data "
				+ "\n3. View collected data "
				+ "\n4. Stop gathering data "
				+ "\n5. Delete all data "
				+ "\n6. Quit"
			);
			
			int response = Integer.parseInt( s );
			
			
			//switch-case menu toimintoja varten
			switch ( response ) {
			case 1:
				System.out.println("Moving to city selection");
				HttpThread.setCity();
				break;
			case 2:
				System.out.println("Getting more data every 60 seconds");
				timer.startTimer();;
				break;
			case 3:
				System.out.println("Collected data");
				OpenWeatherApp.printWeatherAppData();
				break;
			case 4:
				System.out.println("Data collection halted");
				timer.stopTimer();
				break;
			case 5:
				System.out.println("All data deleted");
				OpenWeatherApp.deleteWeatherAppData();
				break;
			case 6:
				break OUTER;
			default:
				break;
			}
			
		}

	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}

