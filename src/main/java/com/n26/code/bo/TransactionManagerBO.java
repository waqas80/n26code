package com.n26.code.bo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.n26.code.dto.StatisticsResponseDTO;
import com.n26.code.dto.TransactionRequestDTO;

@Component
public class TransactionManagerBO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	static List<TransactionRequestDTO> transactionList = new ArrayList();
	static double sum;
	static double maximum;
	static double minimum;
	static long count;
	
	public synchronized void saveTransaction(TransactionRequestDTO transReqDTO) {
		transactionList.add(transReqDTO);
	}
	
	public StatisticsResponseDTO getStatistics() {
		StatisticsResponseDTO obj = new StatisticsResponseDTO();
		removeOldTransactions();
		resetStatistics();
		for(TransactionRequestDTO transRequestDTO: transactionList) {
			calculateTransaction(transRequestDTO.getAmount());
		}
		obj.setCount(count);
		obj.setSum(sum);
		obj.setAvg(calculateAverage());
		obj.setMax(maximum);
		obj.setMin(minimum);
		return obj;
	}
	
	private void calculateTransaction(double amount) {
		count++;
		sum += amount;
		if(amount > maximum)
			maximum = amount;
		if((minimum == 0) || (amount < minimum))
			minimum = amount;
	}
	
	private static double calculateAverage() {
        return (count > 0) ? (sum / count) : 0.0;
    }
	
	private void resetStatistics() {
		sum = 0;
		maximum = 0;
		minimum = 0;
		count = 0;
	}
	private synchronized void removeOldTransactions() {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<TransactionRequestDTO> listToRemove = new ArrayList();
		long currentTime = System.currentTimeMillis();
		for(TransactionRequestDTO itemToRemove: transactionList){
		    if(currentTime - itemToRemove.getTimestamp() > 60000){
		    		listToRemove.add(itemToRemove);
		    }
		}
		transactionList.removeAll(listToRemove);
	}
}
