package com.app.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_record")
public class ServiceRecord
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer serviceId;
	private LocalDate serviceDate;
	private String serviceType;
	private Double seriveCost;
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public LocalDate getServiceDate() {
		return serviceDate;
	}
	public void setServiceDate(LocalDate serviceDate) {
		this.serviceDate = serviceDate;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public Double getSeriveCost() {
		return seriveCost;
	}
	public void setSeriveCost(Double seriveCost) {
		this.seriveCost = seriveCost;
	}
	

}
