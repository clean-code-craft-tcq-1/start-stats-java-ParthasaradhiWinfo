package statisticker;

import java.util.List;

import alertservice.AlertService;

public class StatsChecker {

	private float maxThreshold;
	private AlertService[] alerters;

	public StatsChecker(float maxThreshold, AlertService[] alerters) {
		this.maxThreshold = maxThreshold;
		this.alerters = alerters;
	}

	public void checkAndAlert(List<Float> numbers) {
		Statistics statistics = new Statistics();
		float max = statistics.getMax(numbers);
		if (!Float.isNaN(max) &&  max > this.maxThreshold) {
			for (AlertService alerter : this.alerters) {
				alerter.alert();
			}
		}
	}

}
