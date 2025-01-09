package controller;

import java.util.Date;
import java.sql.Time;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;

import model.CentrosMeteorologicos;
import model.EspaciosNaturales;
import model.MedicionesCentroMet;
import model.MedicionesCentroMetId;
import model.Municipios;
import model.Provincias;
import model.database.CentrosMeteorologicosDAO;
import model.database.EspaciosNaturalesDAO;
import model.database.MedicionesCentroMetDAO;
import model.database.MunicipiosDAO;
import model.database.ProvinciasDAO;
import view.VMenu;

public class CMenu {
	
	ProvinciasDAO provinciasDAO = new ProvinciasDAO();
	VMenu menu;

	public CMenu() {
		this.index();
	}
	
	public void index() {
		List<Provincias> provincias = provinciasDAO.getProvincias();
				
		menu = new VMenu(provincias);
		menu.setVisible(true);
		this.setListeners();
	}
	
	private void setListeners() {
		JButton btnInclude = menu.getBtnInclude();
		JButton btnSelect = menu.getBtnSelect();
		JComboBox cbProvin = menu.getCbProvin();
		
		btnInclude.addActionListener(e -> {
			Provincias newProv = this.insertProvincia();
			Municipios newMuni = this.insertMunicipio(newProv);
			this.insertEspaciosNaturales();
			CentrosMeteorologicos newCM = this.insertCentrosMeteorologicos(newMuni);
			this.insertMedicionesCentroMet(newCM);
			
		});
		
		btnSelect.addActionListener(e -> {
			Provincias prov = (Provincias) cbProvin.getSelectedItem();
			menu.setVisible(false);
			CMunicipios cMunicipios = new CMunicipios(prov);
		});
	}
	
	private Provincias insertProvincia() {
		int randomId = (int) (Math.random() * 1000);
		String randomName = "Provincia " + randomId;
		Provincias newProv = new Provincias(randomId, randomName, null);
		provinciasDAO.insertProvincia(newProv);
		menu.newProvincia(newProv);
		return newProv;
	}
	
	private Municipios insertMunicipio(Provincias newProv) {
		MunicipiosDAO municipiosDAO = new MunicipiosDAO();
		int randomId = (int) (Math.random() * 1000);
		String randomName = "Municipio " + randomId;
		String randomDesc = "Descripcion " + randomId;
		Municipios newMuni = new Municipios(newProv, randomName, randomDesc, 1, null, null);
		municipiosDAO.insertMunicipio(newMuni);
		return newMuni;
	}
	
	private void insertEspaciosNaturales() {
		EspaciosNaturalesDAO espaciosNaturalesDAO = new EspaciosNaturalesDAO();
		EspaciosNaturales newEsp = new EspaciosNaturales("JvaEspaciosNaturales", "Jvadescripcion",
                "Jvatipo", "jvacat",1.1,1.1, null);
		espaciosNaturalesDAO.insertEspaciosNaturales(newEsp);
	}
	
	private CentrosMeteorologicos insertCentrosMeteorologicos(Municipios newMuni) {
		CentrosMeteorologicosDAO centrosMeteorologicosDAO = new CentrosMeteorologicosDAO();
		CentrosMeteorologicos newCm = new CentrosMeteorologicos(newMuni, "JonvaCM", "JonvaCM", 1.1, 1.1, "JonvaCM", "JonvaCM", null);
		Integer newId = centrosMeteorologicosDAO.insertCentrosMeteorologicos(newCm);
		newCm.setIdCentroMet(newId);
		return newCm;
	}
	
	private void insertMedicionesCentroMet(CentrosMeteorologicos newCM) {
		MedicionesCentroMetDAO medicionesCentroMetDAO = new MedicionesCentroMetDAO();
		Random random = new Random();
        long currentTimeMillis = System.currentTimeMillis();
        long randomTimeMillis = (long) (random.nextDouble() * currentTimeMillis);
		java.util.Date utilDate = new Date(randomTimeMillis);
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Time time = new Time(0);
        
        System.out.println(newCM.getIdCentroMet());
        MedicionesCentroMetId medicionesCentroMetId = new MedicionesCentroMetId(sqlDate, time, 1);
        
        MedicionesCentroMet newMCM = new MedicionesCentroMet(medicionesCentroMetId, newCM, 1, 1, 1.12f, 1.12f, 1.12f, 1.12f, 1.12f , "JvaIca");
        medicionesCentroMetDAO.insertMedicionesCentroMet(newMCM);

    }
	
	
	

}
