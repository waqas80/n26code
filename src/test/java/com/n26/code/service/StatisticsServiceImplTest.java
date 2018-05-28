package com.n26.code.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.n26.code.bo.TransactionManagerBO;
import com.n26.code.dto.StatisticsResponseDTO;
import com.n26.code.dto.TransactionRequestDTO;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StatisticsServiceImplTest {

	@Autowired
	private StatisticsServiceImpl statisticsServiceImpl;
	
	@Autowired
	private TransactionManagerBO transactionManagerBO;
	
	@Test
	public void getStatistics() {
		
		TransactionRequestDTO transaction1 = new TransactionRequestDTO();
		transaction1.setAmount(100.10);
		transaction1.setTimestamp(System.currentTimeMillis());
		transactionManagerBO.saveTransaction(transaction1);
		
		TransactionRequestDTO transaction2 = new TransactionRequestDTO();
		transaction2.setAmount(200.25);
		transaction2.setTimestamp(System.currentTimeMillis());
		transactionManagerBO.saveTransaction(transaction2);
		
		TransactionRequestDTO transaction3 = new TransactionRequestDTO();
		transaction3.setAmount(100.10);
		transaction3.setTimestamp(System.currentTimeMillis());
		transactionManagerBO.saveTransaction(transaction3);
		
		StatisticsResponseDTO statisticsResponseDTO = statisticsServiceImpl.getStatistics();
		
		assertEquals(Long.valueOf(3), statisticsResponseDTO.getCount(),0.001);
		assertEquals(Double.valueOf(400.45), statisticsResponseDTO.getSum(),0.0001);
		assertEquals(Double.valueOf(200.25), statisticsResponseDTO.getMax(),0.0001);
		assertEquals(Double.valueOf(100.10), statisticsResponseDTO.getMin(),0.0001);
		assertEquals(Double.valueOf(133.48333), statisticsResponseDTO.getAvg(),0.0001);
	}

}
