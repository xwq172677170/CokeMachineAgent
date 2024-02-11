package com.cs7375.CokeMachineAgent.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import domain.Coin;
import domain.State;
import jakarta.annotation.PostConstruct;

@Component
public class CokeMachine {
	private final Logger logger = LoggerFactory.getLogger(CokeMachine.class);
	private State state;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void addCoin(Coin coin) {
		logger.info("Current State Before this operation {}", state);
		logger.info("Adding Coin {}", coin);
		state = state.nextState(coin);
		logger.info("Current State After this operation {}", state);
	}
	
	@PostConstruct
	public void reset() {
		logger.info("Resetting CokeMachine");
		state = State.NEW_0;
	}
	
}
