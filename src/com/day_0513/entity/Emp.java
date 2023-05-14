package com.day_0513.entity;

public class Emp {

	private int empno;
	private String ename;
	private String job;

	public Emp(String ename, int empno, String job, String sal, String comm) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
	}

	private String sal;
	private String comm;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	// null 값을 0 으로 받아오기
	public String getSal() {
		return sal == null ? "0" : sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	// null 값을 0 으로 받아오기
	public String getComm() {
		return comm == null ? "0" : comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

}
