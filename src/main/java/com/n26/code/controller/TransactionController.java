package com.n26.code.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.n26.code.dto.TransactionRequestDTO;
import com.n26.code.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transService;
	
	@RequestMapping(method=RequestMethod.POST, value="/transactions")
	public String createTransaction(@Valid @RequestBody TransactionRequestDTO tranReqDTO) {
		String responseStatus = "204";
		boolean isTranSave = transService.createTransaction(tranReqDTO);
		if(isTranSave)
			responseStatus = "201";
		return responseStatus;
	}
}
