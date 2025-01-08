package model.database;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Municipios;

public class MunicipiosDAO {
	public List<Municipios> getMunicipios() {
		Session session = HibernateUtil.getSessionFactory().openSession();
	
		String hql = "from Provincias";
		Query q = session.createQuery(hql);
	
		List<Municipios>provs = (List<Municipios>) q.list();

		session.close();
		return provs;
	}
	
	public void insertMunicipio(Municipios muni) {
		Transaction txt = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		txt = session.beginTransaction();
		session.save(muni);
		txt.commit();
		session.close();
	}
}
