package model.database;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import model.Provincias;


public class ProvinciasDAO {
	public List<Provincias> getProvincias() {
		Session session = HibernateUtil.getSessionFactory().openSession();
	
		String hql = "from Provincias";
		Query q = session.createQuery(hql);
	
		List<Provincias>provs = (List<Provincias>) q.list();

		session.close();
		return provs;
	}
	
	public void insertProvincia(Provincias prov) {
		Transaction txt = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		txt = session.beginTransaction();
		session.save(prov);
		txt.commit();
		session.close();
	}
}
