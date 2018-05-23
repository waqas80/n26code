package com.n26.code.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility= Visibility.ANY, getterVisibility=Visibility.NONE, setterVisibility= Visibility.NONE)
@JsonPropertyOrder({
	"sum",
	"avg",
	"max",
	"min",
	"count"
})
public class StatisticsResponseDTO {
	
	@JsonProperty("sum")
	private double sum;
	
	@JsonProperty("avg")
	private double avg;
	
	@JsonProperty("max")
	private double max;
	
	@JsonProperty("min")
	private double min;
	
	@JsonProperty("count")
	private long count;
	
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
}
