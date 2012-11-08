package Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import tables.*;


public class CreateTables {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Profile.class);
		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(MainCategory.class);
		config.addAnnotatedClass(SubCategory.class);
		config.addAnnotatedClass(Feedback.class);
		config.addAnnotatedClass(Rating.class);
		config.addAnnotatedClass(Topic.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		System.out.println("taofmaofonfjanfjnjoafnjoanfjonajfnjanfjanjofnajonfjoan");
		
		

	}
}
