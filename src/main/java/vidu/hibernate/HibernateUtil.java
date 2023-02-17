package vidu.hibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import vidu.hibernate.entities.Sinhvien;

public class HibernateUtil {
	private static final SessionFactory FACTORY;

	static {
		Configuration conf = new Configuration();
		
		Properties props = new Properties();
		
		props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		props.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		props.put(Environment.URL, "jdbc:mysql://localhost:3306/myjdbc");
		props.put(Environment.USER, "root");
		props.put(Environment.PASS, "123456");
		props.put(Environment.SHOW_SQL, "true");
		props.put("hibernate.bytecode.use_reflection_optimizer", "false");
		
		conf.setProperties(props);
		conf.addAnnotatedClass(Sinhvien.class);
		
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		
		
		FACTORY = conf.buildSessionFactory(registry);
		
	}
	
	public static SessionFactory getFactory() {
		return FACTORY;
	}
	
}
