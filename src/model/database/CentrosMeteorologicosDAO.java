package model.database;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.CentrosMeteorologicos;
import model.Municipios;


public class CentrosMeteorologicosDAO {
	public List<CentrosMeteorologicos> getCentrosMeteorologicosByMunicipio(Municipios municipio) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	
		String hql = "from CentrosMeteorologicos where municipios = ? ";
		Query q = session.createQuery(hql);
		q.setParameter(0, municipio);
		
	
		List<CentrosMeteorologicos> cm = (List<CentrosMeteorologicos>) q.list();

		session.close();
		return cm;
	}
	
	public Integer insertCentrosMeteorologicos(CentrosMeteorologicos cm) {
		Transaction txt = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		txt = session.beginTransaction();
		Integer id = (Integer) session.save(cm);
		txt.commit();
		session.close();
		return id;
	}
}



