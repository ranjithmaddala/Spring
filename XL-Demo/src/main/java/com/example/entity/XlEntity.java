package com.example.entity;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;

@Entity
public class XlEntity {
	@Id
	private Integer entityId;
	private Integer customerId;
	private String serviceGroupId;
	private String serviceIdAccess;
	private String serviceIdCatv;
	private String serviceIdEquipment;
	private String paid;
	private String serviceIdDtv;
	private String serviceIdStb;
	private String serialStb;
	private String serialSc;
	private String entitlements;
	private String serviceIdInt;
	private String serviceIdEmta;
	private String serialEmta;
	
	public Integer getEntityId() {
		return entityId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public String getServiceGroupId() {
		return serviceGroupId;
	}
	public String getServiceIdAccess() {
		return serviceIdAccess;
	}
	public String getServiceIdCatv() {
		return serviceIdCatv;
	}
	public String getServiceIdEquipment() {
		return serviceIdEquipment;
	}
	public String getPaid() {
		return paid;
	}
	public String getServiceIdDtv() {
		return serviceIdDtv;
	}
	public String getServiceIdStb() {
		return serviceIdStb;
	}
	public String getSerialStb() {
		return serialStb;
	}
	public String getSerialSc() {
		return serialSc;
	}
	public String getEntitlements() {
		return entitlements;
	}
	public String getServiceIdInt() {
		return serviceIdInt;
	}
	public String getServiceIdEmta() {
		return serviceIdEmta;
	}
	public String getSerialEmta() {
		return serialEmta;
	}
	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public void setServiceGroupId(String serviceGroupId) {
		this.serviceGroupId = serviceGroupId;
	}
	public void setServiceIdAccess(String serviceIdAccess) {
		this.serviceIdAccess = serviceIdAccess;
	}
	public void setServiceIdCatv(String serviceIdCatv) {
		this.serviceIdCatv = serviceIdCatv;
	}
	public void setServiceIdEquipment(String serviceIdEquipment) {
		this.serviceIdEquipment = serviceIdEquipment;
	}
	public void setPaid(String paid) {
		this.paid = paid;
	}
	public void setServiceIdDtv(String serviceIdDtv) {
		this.serviceIdDtv = serviceIdDtv;
	}
	public void setServiceIdStb(String serviceIdStb) {
		this.serviceIdStb = serviceIdStb;
	}
	public void setSerialStb(String serialStb) {
		this.serialStb = serialStb;
	}
	public void setSerialSc(String serialSc) {
		this.serialSc = serialSc;
	}
	public void setEntitlements(String entitlements) {
		this.entitlements = entitlements;
	}
	public void setServiceIdInt(String serviceIdInt) {
		this.serviceIdInt = serviceIdInt;
	}
	public void setServiceIdEmta(String serviceIdEmta) {
		this.serviceIdEmta = serviceIdEmta;
	}
	public void setSerialEmta(String serialEmta) {
		this.serialEmta = serialEmta;
	}
}
