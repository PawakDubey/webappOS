package com.openshift.test.db;

import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import com.openshift.test.dto.StudentDetails;
import com.openshift.test.util.HibernateUtil;

public class DBService {
	private static Session session = null;

	public static void main(String args[]) {
		List<StudentDetails> students = DBService.getStudents();
		Iterator<StudentDetails> sIterator = students.iterator();
		while (sIterator.hasNext()) {
			StudentDetails sobj = sIterator.next();
			System.out.println(sobj.getStudentName());
			System.out.println(sobj.getStudentSubject());
		}
	}

	public static boolean studentSave(String sName, String sSubject) {
		boolean isSaveSuccessful = false;
		StudentDetails sd = new StudentDetails();
		System.out.println("sName: " + sName);
		sd.setStudentName(sName);
		sd.setStudentId((int) (Math.random() * 1000));
		sd.setStudentSubject(sSubject);
		try {
			session = HibernateUtil.currentSession();
			session.beginTransaction();
			session.save(sd);
			session.getTransaction().commit();
			isSaveSuccessful = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return isSaveSuccessful;
	}

	public static List<StudentDetails> getStudents() {
		List<StudentDetails> students = null;
		try {
			session = HibernateUtil.currentSession();
			// Get Criteria Builder
			CriteriaBuilder builder = session.getCriteriaBuilder();
			// Create Criteria
			CriteriaQuery<StudentDetails> criteria = builder.createQuery(StudentDetails.class);
			Root<StudentDetails> studentDetailsRoot = criteria.from(StudentDetails.class);
			criteria.select(studentDetailsRoot);
			// Use criteria to query with session to fetch all contacts
			students = session.createQuery(criteria).getResultList();
			if (students != null)
				System.out.println("Total students: " + students.size());
			else {
				System.out.println("Student list is null ");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			 session.close();
		}
		return students;
	}
}
