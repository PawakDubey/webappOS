package com.openshift.test.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentDetails {
	@Id
	private int studentId;
	
	private String studentName;
	
	private String studentSubject;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentSubject() {
		return studentSubject;
	}
	public void setStudentSubject(String studentSubject) {
		this.studentSubject = studentSubject;
	}

}
