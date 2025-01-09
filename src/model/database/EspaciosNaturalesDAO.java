package model.database;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.EspaciosNaturales;
import model.Municipios;

public class EspaciosNaturalesDAO {
	public List<EspaciosNaturales> getEspaciosNaturalesByMunicipio(Municipios municipio) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	
		String hql = "Select en from EspaciosNaturales en join en.municipiosEspaciosNats men where men.municipios = ?";
		Query q = session.createQuery(hql);
		q.setParameter(0, municipio);
		
		List<EspaciosNaturales> esp = (List<EspaciosNaturales>) q.list();
		

		session.close();
		return esp;
	}
	
	public void insertEspaciosNaturales(EspaciosNaturales espN) {
		Transaction txt = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		txt = session.beginTransaction();
		session.save(espN);
		txt.commit();
		session.close();
	}
}
