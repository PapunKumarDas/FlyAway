package com.model;

public class Airline {
	
	private int 	airlineId;
	private String 	airlineName;
	private String 	code;
	private int 	capacity;
	
	
	public Airline() {
		
	}
	
	public Airline(int airlineId, String airlineName, String code, int capacity) {
		super();
		this.airlineId = airlineId;
		this.airlineName = airlineName;
		this.code = code;
		this.capacity = capacity;
	}
	
	public Airline(String airlineName, String code, int capacity) {
		super();
		this.airlineName = airlineName;
		this.code = code;
		this.capacity = capacity;
	}


	public int getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		return "Airlines [airlineId=" + airlineId + ", airlineName=" + airlineName + ", code=" + code + ", capacity="
				+ capacity + "]";
	}
	

}
