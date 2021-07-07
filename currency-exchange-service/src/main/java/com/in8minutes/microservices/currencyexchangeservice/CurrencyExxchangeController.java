package com.in8minutes.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExxchangeController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepo;
	
	
//	@GetMapping("/currency-exchange/from/{from}/to/{to}")
//	public CurrencyExxchange getCurrencyExchange(
//			@PathVariable String from,
//			@PathVariable String to) {
//		CurrencyExxchange currencyExxchange = new CurrencyExxchange(1000l, from, to, BigDecimal.valueOf(75));
//		currencyExxchange.setEnvironment(env.getProperty("local.server.port"));
//		return currencyExxchange;
//	}
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getCurrencyExchange(
			@PathVariable String from,
			@PathVariable String to) {
		CurrencyExchange currencyExchange = currencyExchangeRepo.findByFromAndTo(from, to);
		if(currencyExchange == null) {
			throw new RuntimeException("Unable to find data for "+from+" to "+to);
		}
		
		currencyExchange.setEnvironment(env.getProperty("local.server.port"));
		
		return currencyExchange;
	}
}
