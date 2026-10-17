
package com.app.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer vehicleId;
	private String vehicleName;
	private String vehicleNumber;
	private String vehicleType;
	private Double price;
	
	@OneToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name = "insurance_id", unique = true)
	private Insurance insurance;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
	private List<ServiceRecord> servicerecord=new ArrayList<>();

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public List<ServiceRecord> getServicerecord() {
		return servicerecord;
	}

	public void setServicerecord(List<ServiceRecord> servicerecord) {
		this.servicerecord = servicerecord;
	}
	
	
	
	
}
  