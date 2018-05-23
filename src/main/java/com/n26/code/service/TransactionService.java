package com.n26.code.service;

import com.n26.code.dto.TransactionRequestDTO;

public interface TransactionService {
	boolean createTransaction(TransactionRequestDTO transReqDTO);
}
