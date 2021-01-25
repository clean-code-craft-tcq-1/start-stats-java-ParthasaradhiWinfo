package alertservice;

public class LEDAlertService implements AlertService {
	
	public boolean ledGlows = false;

	@Override
	public void alert() {
		ledGlows = true;		
	}

}
