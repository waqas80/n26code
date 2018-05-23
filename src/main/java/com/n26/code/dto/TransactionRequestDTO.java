package com.n26.code.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonAutoDetect(fieldVisibility= Visibility.ANY, getterVisibility=Visibility.NONE, setterVisibility= Visibility.NONE)
@JsonPropertyOrder({
	"amount",
	"timestamp"
})
public class TransactionRequestDTO {

	@JsonProperty("amount")
	protected double amount;
	
	@JsonProperty("timestamp")
	protected long timestamp;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
