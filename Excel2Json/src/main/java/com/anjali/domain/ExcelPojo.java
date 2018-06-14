package com.anjali.domain;

import java.util.List;

public class ExcelPojo {
	
	List<String> corpEndCode;
	List<String> specializeCd;
	String unSolicatedInd;
	String providerType;
	public List<String> getCorpEndCode() {
		return corpEndCode;
	}
	public void setCorpEndCode(List<String> corpEndCode) {
		this.corpEndCode = corpEndCode;
	}
	public List<String> getSpecializeCd() {
		return specializeCd;
	}
	public void setSpecializeCd(List<String> specializeCd) {
		this.specializeCd = specializeCd;
	}
	public String getUnSolicatedInd() {
		return unSolicatedInd;
	}
	public void setUnSolicatedInd(String unSolicatedInd) {
		this.unSolicatedInd = unSolicatedInd;
	}
	public String getProviderType() {
		return providerType;
	}
	public void setProviderType(String providerType) {
		this.providerType = providerType;
	}
	@Override
	public String toString() {
		return "ExcelPojo [corpEndCode=" + corpEndCode + ", specializeCd=" + specializeCd + ", unSolicatedInd="
				+ unSolicatedInd + ", providerType=" + providerType + "]";
	}
	public ExcelPojo(List<String> corpEndCode, List<String> specializeCd, String unSolicatedInd, String providerType) {
		super();
		this.corpEndCode = corpEndCode;
		this.specializeCd = specializeCd;
		this.unSolicatedInd = unSolicatedInd;
		this.providerType = providerType;
	}
	public ExcelPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
