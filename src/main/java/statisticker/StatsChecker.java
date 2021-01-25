package statisticker;

import java.util.List;

import alertservice.AlertService;

public class StatsChecker {

	private float maxThreshold;
	private AlertService[] alerters;
	private Statistics statistics;

	public StatsChecker(float maxThreshold, AlertService[] alerters, Statistics statistics) {
		this.maxThreshold = maxThreshold;
		this.alerters = alerters;
		this.statistics = statistics;
	}

	public void checkAndAlert(List<Float> numbers) {
		float max = statistics.getMax(numbers);
		if (!Float.isNaN(max) &&  max > this.maxThreshold) {
			for (AlertService alerter : this.alerters) {
				alerter.alert();
			}
		}
	}

}
