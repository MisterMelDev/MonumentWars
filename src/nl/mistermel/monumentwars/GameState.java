package nl.mistermel.monumentwars;

public enum GameState {
	WAITING(true), STARTING(true), INGAME(false), RESETTING(false);
	
	private boolean joinAble ;
	
	GameState(boolean joinAble) {
		this.joinAble = joinAble;
	}
	
	public boolean joinAble() {
		return joinAble;
	}
}
