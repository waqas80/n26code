package com.n26.code.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.n26.code.bo.TransactionManagerBO;
import com.n26.code.dto.TransactionRequestDTO;

@Service
public class TransactionServiceImpl implements TransactionService {

	
	
	@Autowired
	TransactionManagerBO transManagerBO;
	
	@Override
	public boolean createTransaction(TransactionRequestDTO transReqDTO) {
		boolean isTransacationSave = false;
		if(validateTime(transReqDTO.getTimestamp())) {
			transManagerBO.saveTransaction(transReqDTO);
			isTransacationSave = true;
		}else
			isTransacationSave = false;
			
		return isTransacationSave;
	}

	private boolean validateTime(long transTime) {
		boolean result = false;
		long currentTime = System.currentTimeMillis();
		if(transTime <= 0)
			result = false;
		if(currentTime - transTime > 60000)
			result = false;
		else if(currentTime - transTime < 0)
			result = false;
		else
			result = true;
		return result;
	}
}
