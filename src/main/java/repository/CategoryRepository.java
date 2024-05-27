package repository;

import entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JPAUtil;

import java.util.List;

public class CategoryRepository {
	EntityManager em;
	EntityTransaction tx;

	public CategoryRepository() {
		em = JPAUtil.getEntityManagerFactory().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
	}
	public void saveAll(List<Category> categories) {
		for (Category category : categories) {
			em.persist(category);
		}
		tx.commit();
	}

	public Category findCategory(String categoryName) {
		String sql = "SELECT c FROM Category c WHERE c.name= :name";
        return em.createQuery(sql, Category.class)
				.setParameter("name", categoryName)
				.getSingleResult();
	}

	public List<Category> insertCategory(Integer categoryId) {
		String sql = "INSERT INTO Category (id) VALUES (:id)";
		List<Category> category = em.createQuery(sql, Category.class)
				.setParameter("id",categoryId)
				.getResultList();
		tx.commit();
		return category;

	}
	
	public Category deleteProduct(Integer id) {
		String sql = "DELETE FROM Category c WHERE c.id= :id";
		Category categoryDelete = em.createQuery(sql, Category.class)
				.setParameter("id", id)
				.getSingleResult();
		tx.commit();

		return categoryDelete;
	}

	public void off() {
		em.close();
	}


	public List<Category> findAll() {
		String sql = "SELECT c FROM Category c";
		return em.createQuery(sql, Category.class)
				.getResultList();
	}
}
