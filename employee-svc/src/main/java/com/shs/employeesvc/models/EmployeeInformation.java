/**
 * 
 */
package com.shs.employeesvc.models;

/**
 * @author snehithgoud
 *
 */
public class EmployeeInformation {
	
	private String id;
	private String firstName;
	private String lastName;
	private String dob;
	
	
	public EmployeeInformation(String id, String firstName, String lastName, String dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	

}
