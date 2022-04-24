package com.model;

import java.util.Date;

public class Route {
	
	private int 	routeId;
	private String 	fromCity;
	private String 	toCity;
	private String 	airline;
	private Date	fromDate;
	private Date	toDate;
	private long 	price;
	
	public Route() {
		
	}
	
	public Route(int routeId, String fromCity, String toCity, String airline, Date fromDate, Date toDate,long price) {
		super();
		this.routeId = routeId;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.airline = airline;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.price = price;
	}
	
	
	public Route(String fromCity, String toCity, String airline, int capacity, Date fromDate, Date toDate, long price) {
		super();
		
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.airline = airline;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.price = price;
	}



	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}

	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", fromCity=" + fromCity + ", toCity=" + toCity + ", airline=" + airline
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", price=" + price + "]";
	}

}
