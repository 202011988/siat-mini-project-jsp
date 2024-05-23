package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class shoppingProductTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_mapping");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			
			// Album : insert
//			Album album1 = new Album("album1 : name", 1000, "album1 : artist");
//			em.persist(album1);
//			
			// Film : insert
//			Film film1 = new Film("film1 : name", 1100, "film1 : director", "film1 : actor");
//			em.persist(film1);

			// Album : select

//			Album foundAlbum1 = em.find(Album.class, 1L);
//			System.out.println(foundAlbum1);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		
		emf.close();
	}

}
