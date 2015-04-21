package Service;



public abstract class Driver {

	public static Bridge getBridge() {
		//BridgeProxy bridge = new BridgeProxy();
		BridgeReal bridge = new BridgeReal(); 
		return bridge;
	}	
}