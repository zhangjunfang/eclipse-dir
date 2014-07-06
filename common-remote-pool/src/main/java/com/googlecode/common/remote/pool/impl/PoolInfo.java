package com.googlecode.common.remote.pool.impl;

public class PoolInfo {
	
	private int borrowedNumber;
	private int idleNumber;
	private int totalNumber;
	public PoolInfo(int borrowedNumber, int idleNumber, int totalNumber) {
		super();
		this.borrowedNumber = borrowedNumber;
		this.idleNumber = idleNumber;
		this.totalNumber = totalNumber;
	}
	@Override
	public String toString() {
		return "PoolInfo [borrowedNumber=" + borrowedNumber + ", idleNumber="
				+ idleNumber + ", totalNumber=" + totalNumber + "]";
	}
	public int getBorrowedNumber() {
		return borrowedNumber;
	}
	public void setBorrowedNumber(int borrowedNumber) {
		this.borrowedNumber = borrowedNumber;
	}
	public int getIdleNumber() {
		return idleNumber;
	}
	public void setIdleNumber(int idleNumber) {
		this.idleNumber = idleNumber;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public PoolInfo() {
		super();
	}
	 
}
