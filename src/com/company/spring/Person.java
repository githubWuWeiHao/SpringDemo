package com.company.spring;

public class Person {
private int id;
private String pname;
private Phone phone;
public Person() {
	// TODO Auto-generated constructor stub
}
public Person(int id, String pname, Phone phone) {
	super();
	this.id = id;
	this.pname = pname;
	this.phone = phone;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public Phone getPhone() {
	return phone;
}
public void setPhone(Phone phone) {
	this.phone = phone;
}
@Override
public String toString() {
	return "Person [id=" + id + ", pname=" + pname + ", phone=" + phone + "]";
}

}
