package com.n26.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.n26.code.dto.StatisticsResponseDTO;
import com.n26.code.service.StatisticsService;

@RestController
public class StatisticsController {

	@Autowired
	StatisticsService statisticsService;
	
	@RequestMapping(method=RequestMethod.GET, value="/statistics")
	public StatisticsResponseDTO statistics() {
		return statisticsService.getStatistics();
	}
}
