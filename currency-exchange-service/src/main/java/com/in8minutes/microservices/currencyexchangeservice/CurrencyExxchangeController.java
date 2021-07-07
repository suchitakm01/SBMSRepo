package com.in8minutes.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExxchangeController {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExxchange getCurrencyExchange(
			@PathVariable String from,
			@PathVariable String to) {
		return new CurrencyExxchange(1000l, from, to, BigDecimal.valueOf(75));
	}
}
