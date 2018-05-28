package com.n26.code.service;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.n26.code.dto.TransactionRequestDTO;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionServiceImplTest {
	
	@Autowired
	private TransactionServiceImpl transacationServiceImpl;
	
	
	@Test
	public void validateOldTime() {
		long oldTime = System.currentTimeMillis() - 70000;
		TransactionRequestDTO transactionRequestDTO = new TransactionRequestDTO();
		transactionRequestDTO.setTimestamp(oldTime);
		transactionRequestDTO.setAmount(100.10);
		assertEquals(false, transacationServiceImpl.createTransaction(transactionRequestDTO));
	}
	
	@Test
	public void validateFutureTime() {
		long futureTime = System.currentTimeMillis() + 70000;
		TransactionRequestDTO transactionRequestDTO = new TransactionRequestDTO();
		transactionRequestDTO.setTimestamp(futureTime);
		transactionRequestDTO.setAmount(101.10);
		assertEquals(false, transacationServiceImpl.createTransaction(transactionRequestDTO));	
	}
	
	@Test
	public void saveTransaction() {
		long currentTime = System.currentTimeMillis();
		TransactionRequestDTO transactionRequestDTO = new TransactionRequestDTO();
		transactionRequestDTO.setTimestamp(currentTime);
		transactionRequestDTO.setAmount(101.10);
		assertEquals(true, transacationServiceImpl.createTransaction(transactionRequestDTO));
	}
}
