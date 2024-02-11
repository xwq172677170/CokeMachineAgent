package com.cs7375.CokeMachineAgent.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cs7375.CokeMachineAgent.model.CokeMachine;
import domain.Coin;
import domain.State;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("api/coke-machine")
public class CokeMachineController {
	
	private final CokeMachine cokeMachine;
	private final Logger logger = LoggerFactory.getLogger(CokeMachineController.class);
	
    public CokeMachineController(CokeMachine cokeMachine) {
		super();
		this.cokeMachine = cokeMachine;
	}

	@GetMapping(value = "/state")
    public State getState() {
		checkOrder();
        return cokeMachine.getState();
    }
	
	@PostMapping(value = "/add-coin")
    public void addCoin(@RequestParam("coin") Coin coin) {
		cokeMachine.addCoin(coin);
		checkOrder();
    }	
	
	@GetMapping(value = "/reset")
    public void reset() {
		cokeMachine.reset();
    }
	
	private void checkOrder() {
		if(cokeMachine.getState() == State.FULFILLED_15) {
			logger.info("Received 15 cents worth of coins. Releasing the Item");
			logger.info("Resetting the state machine");
			cokeMachine.reset();
		}
	}
}
