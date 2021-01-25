package alertservice;

public class EmailAlertService implements AlertService {

	public boolean emailSent = false;

	@Override
	public void alert() {
		emailSent = true;
	}
	

}
