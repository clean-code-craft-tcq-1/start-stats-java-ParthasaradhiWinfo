package statisticker;

import java.util.List;

public class Statistics {

	public class Stats {

		public float average;
		public float min;
		public float max;

	}

	public static Stats getStatistics(List<Float> numbers) {
		Statistics statistics = new Statistics();
		Stats s = statistics.new Stats();
		s.average = statistics.getAverage(numbers);
		s.min = statistics.getMin(numbers);
		s.max = statistics.getMax(numbers);
		return s;
	}

	float getAverage(List<Float> numbers) {
		float sum = 0.0f;
		for (float number : numbers) {
			sum += number;
		}
		float average = sum / (numbers.size());
		return average;
	}

	float getMin(List<Float> numbers) {
		float min = Float.NaN;
		for (float number : numbers) {
			if (Float.isNaN(min)) {
				min = number;
			} else if (number < min) {
				min = number;
			}
		}
		return min;
	}

	float getMax(List<Float> numbers) {
		float max = Float.NaN;
		for (float number : numbers) {
			if (Float.isNaN(max)) {
				max = number;
			} else if (number > max) {
				max = number;
			}
		}
		return max;
	}

}
