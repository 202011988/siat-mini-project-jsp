package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import mn.entity.Course;
import mn.entity.Student;

public class StudentCourseMappingTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_mapping");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			// Student, Course : insert 
			Student student1 = new Student("sid1", "student1");
			Student student2 = new Student("sid2", "student2");
			Student student3 = new Student("sid3", "student3");
			
			em.persist(student1);
			em.persist(student2);
			em.persist(student3);
			
			Course course1 = new Course("cid1", "course1", "lecturer1");
			Course course2 = new Course("cid2", "course2", "lecturer1");
			Course course3 = new Course("cid3", "course3", "lecturer2");
			
			em.persist(course1);
			em.persist(course2);
			em.persist(course3);

			// @IdClass
//			StudentCourse sc12 = new StudentCourse(student1, course2);
//			StudentCourse sc13 = new StudentCourse(student1, course3);
//			StudentCourse sc22 = new StudentCourse(student2, course2);
//			
//			em.persist(sc12);
//			em.persist(sc13);
//			em.persist(sc22);
			
			// @EmbeddedId
//			StudentCourseId scid23 = new StudentCourseId(student2.getSid(), course3.getCid());
//			StudentCourse sc23 = new StudentCourse(scid23);
//			em.persist(sc23);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		
		emf.close();
	}

}
