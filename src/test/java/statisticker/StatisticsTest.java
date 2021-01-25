package statisticker;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

import alertservice.AlertService;
import alertservice.EmailAlertService;
import alertservice.LEDAlertService;



public class StatisticsTest 
{
    @Test
    public void reportsAverageMinMaxx()
    {
        Float[] numbers = {1.5f, 8.9f, 3.2f, 4.5f};
        List<Float> numberList = Arrays.asList(numbers);

        Statistics.Stats s = Statistics.getStatistics(numberList);

        float epsilon = 0.001f;
        
        assertEquals(s.average, 4.525f, epsilon);
        assertEquals(s.min, 1.5f, epsilon);
        assertEquals(s.max, 8.9f, epsilon);
    }
  
    @Test
    public void reportsNaNForEmptyInput()
    {
    List<Float> emptyList = new ArrayList<>();
    
    Statistics.Stats s = Statistics.getStatistics(emptyList);
    
    //All fields of computedStats (average, max, min) must be
    //Float.NaN (not-a-number), as described in
    //https://www.geeksforgeeks.org/nan-not-number-java/
    //Design the asserts here and implement accordingly.
    
    float epsilon = 0.001f;
    
    assertEquals(s.average, Float.NaN, epsilon);
    assertEquals(s.min, Float.NaN, epsilon);
    assertEquals(s.max, Float.NaN, epsilon);
    }
    
    @Test
    public void reportsAlertsIfMaxIsMoreThanThreshold()
    {
    EmailAlertService emailAlerter = new EmailAlertService();
    LEDAlertService ledAlerter = new LEDAlertService();
    AlertService alerters[] = {emailAlerter, ledAlerter};
   
    float maxThreshold = 10.2f;
    StatsChecker checker = new StatsChecker(maxThreshold, alerters);
    
    Float[] numbers = {11.5f, 6.9f, 7.5f, 6.6f};
    List<Float> numberList = Arrays.asList(numbers);
    checker.checkAndAlert(numberList);
    
    assertTrue(emailAlerter.emailSent);
    assertTrue(ledAlerter.ledGlows);
    }
}