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

	public static void createMainCategory(String name) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		MainCategory mainCategory = new MainCategory();
		mainCategory.setName(name);


		session.save(mainCategory);
		session.getTransaction().commit();

	}

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

	public static List<MainCategory> getMainCategories() {


		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<MainCategory> result = session.createQuery("from MainCategory").list();

		session.getTransaction().commit();

		return result;

	}

	public static List<SubCategory> getSubCategories() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<SubCategory> result = session.createQuery("from SubCategory").list();

		session.getTransaction().commit();

		return result;
	}
}

