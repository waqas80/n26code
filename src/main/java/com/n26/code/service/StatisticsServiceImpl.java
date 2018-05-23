package com.n26.code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.n26.code.bo.TransactionManagerBO;
import com.n26.code.dto.StatisticsResponseDTO;

@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	TransactionManagerBO transManagerBO;
	
	@Override
	public StatisticsResponseDTO getStatistics() {
		return transManagerBO.getStatistics();
	}

}
