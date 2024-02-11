package domain;

public enum State {
	NEW_0(0) {
		@Override
		public State nextState(Coin coin) {
			return coin == Coin.NICKEL ?
				 WAITING_FOR_MORE_COIN_5
				 : WAITING_FOR_MORE_COIN_10;
		}
	},
	WAITING_FOR_MORE_COIN_5(5){
		@Override
		public State nextState(Coin coin) {
			return coin == Coin.NICKEL ?
				 WAITING_FOR_MORE_COIN_10
				 : FULFILLED_15;
		}
	},
	WAITING_FOR_MORE_COIN_10(10){
		@Override
		public State nextState(Coin coin) {
			return FULFILLED_15;
		}
	},
	FULFILLED_15(15) {
		@Override
		public State nextState(Coin coin) {
			return FULFILLED_15;
		}
	};
	
	public Integer value;
	
	State(Integer value) {
		this.value = value;
	}

    public abstract State nextState(Coin coin); 
}
