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
    Statistics.Stats s = Statistics.getStatistics(numbers);
    if(s.max != Float.NaN && s.max > maxThreshold && alerters.length > 0) {
        for(AlertService alerter :  alerters) {
          alerter.alert();
        }
    }
  }

}