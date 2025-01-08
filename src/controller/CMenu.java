package controller;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;

import model.Municipios;
import model.Provincias;
import model.database.MunicipiosDAO;
import model.database.ProvinciasDAO;
import view.VMenu;

public class CMenu {
	
	ProvinciasDAO provinciasDAO = new ProvinciasDAO();
	VMenu menu;
	
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
			this.insertMunicipio(newProv);
			
		});
		
		btnSelect.addActionListener(e -> {
			Provincias prov = (Provincias) cbProvin.getSelectedItem();
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
	
	private void insertMunicipio(Provincias newProv) {
		MunicipiosDAO municipiosDAO = new MunicipiosDAO();
		int randomId = (int) (Math.random() * 1000);
		String randomName = "Municipio " + randomId;
		String randomDesc = "Descripcion " + randomId;
		Municipios newMuni = new Municipios(newProv, randomName, randomDesc, 1, null, null);
		municipiosDAO.insertMunicipio(newMuni);
	}
	
	
	

}
