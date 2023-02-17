package vidu.hibernate;

import org.hibernate.Session;

import vidu.hibernate.entities.Sinhvien;

public class HibernateTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getFactory().openSession();
		
		Sinhvien sinhvien = new Sinhvien();
		
		sinhvien.setHoten("Huyngonzai");
		sinhvien.setDiachi("Thai Nguyen");
		sinhvien.setLop("KTPM");
		
		session.save(sinhvien);
		
		session.close();
	}
	
}
