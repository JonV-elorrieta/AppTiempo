package model.database;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Municipios;
import model.Provincias;

public class MunicipiosDAO {
	public List<Municipios> getMunicipiosByProvincia(Provincias provincia) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	
		String hql = "from Municipios where provincias = ? ";
		Query q = session.createQuery(hql);
		q.setParameter(0, provincia);
		
		List<Municipios> munis = (List<Municipios>) q.list();

		session.close();
		return munis;
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
