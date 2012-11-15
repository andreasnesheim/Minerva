package Connection;

import java.sql.Connection;
import tables.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.hibernate.Session;

public class CategoryCon {

	// Lager et MainCategory objekt og lagrer det i databasen, med navnet på kategorien som innparameter
	public static void createMainCategory(String name) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		MainCategory mainCategory = new MainCategory();
		mainCategory.setName(name);


		session.save(mainCategory);
		session.getTransaction().commit();

	}
	
	// Lager et SubCategory objekt og lagrer det i databasen, med navnet på kategorien som inparameter og hvilke MainCategory den ligger under
	public static void createSubCategory(String name, long mainCategory) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		MainCategory main = (MainCategory) session.get(MainCategory.class, mainCategory);
		SubCategory subCategory = new SubCategory();
		subCategory.setName(name);
		subCategory.setMainCategory(main);

		session.save(subCategory);
		session.getTransaction().commit();

	}
	
	// Henter ut SubCategory'en med id
	public static SubCategory getSubCategory(long id) {


		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();


		SubCategory subCategory = (SubCategory) session.get(SubCategory.class, id);
		session.getTransaction().commit();  

		return subCategory;

	}
	
	// Henter ut MainCategory'en med id
	public static MainCategory getMainCategory(long id) {


		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();


		MainCategory mainCategory = (MainCategory) session.get(MainCategory.class, id);
		session.getTransaction().commit();  

		return mainCategory;

	}
	
	// Henter ut alle MainCategory'ene
	public static List<MainCategory> getMainCategories() {


		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<MainCategory> result = session.createQuery("from MainCategory").list();

		session.getTransaction().commit();

		return result;

	}
	
	// Henter ut alle SubCategory'ene
	public static List<SubCategory> getSubCategories() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<SubCategory> result = session.createQuery("from SubCategory").list();

		session.getTransaction().commit();

		return result;
	}
}

