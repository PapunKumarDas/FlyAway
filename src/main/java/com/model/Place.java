package com.model;

public class Place {
	
	private int 	placeId;
	private String 	sourceCity;
	private String 	destinationCity;
	
	public Place() {
		
	}
	
	public Place(int placeId, String sourceCity, String destinationCity) {
		super();
		this.placeId = placeId;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
	}
		
	public Place(String sourceCity, String destinationCity) {
		super();
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
	}

	public int getPlaceId() {
		return placeId;
	}
	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}
	public String getSourceCity() {
		return sourceCity;
	}
	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	
	@Override
	public String toString() {
		return "Places [placeId=" + placeId + ", sourceCity=" + sourceCity + ", destinationCity=" + destinationCity
				+ "]";
	}
	
	
}
