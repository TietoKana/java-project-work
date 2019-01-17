
interface TimerListener{
	public void tick();
}

public class Timer implements Runnable {
	private boolean timerRunning = false;
	private int interval = 1;
	private TimerListener listener;
	
	public Timer( int interval ) {
		this.interval = interval;
	}
	
	public void setTimerListener( TimerListener listener) {
		this.listener = listener;
	}
	
	public void startTimer() {
		timerRunning = true;
		OpenWeatherApp.getWeatherAppData();
	}
	
	public void stopTimer() {
		timerRunning = false;
	}
	
	@Override
	public void run() {
		while( true ) {
			if( timerRunning ) {
				listener.tick();
				OpenWeatherApp.getWeatherAppData(); // kutsutaan datan hakua 60sec välein
			}
			try {
				Thread.sleep( 1000 * interval );
			}
			catch (InterruptedException ex) {
				System.out.println( "Thread interrupted" );
				break;
			}
		}
		
	}
	
}
