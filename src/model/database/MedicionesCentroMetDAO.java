package model.database;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.MedicionesCentroMet;

public class MedicionesCentroMetDAO {
	public List<MedicionesCentroMet> getMedicionesCentroMet() {
		Session session = HibernateUtil.getSessionFactory().openSession();
	
		String hql = "from MedicionesCentroMet";
		Query q = session.createQuery(hql);
		
	
		List<MedicionesCentroMet> mcm = (List<MedicionesCentroMet>) q.list();

		session.close();
		return mcm;
	}
	
	public void insertMedicionesCentroMet(MedicionesCentroMet mcm) {
		Transaction txt = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		txt = session.beginTransaction();
		session.save(mcm);
		txt.commit();
		session.close();
	}
}
