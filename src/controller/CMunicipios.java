package controller;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;

import model.Municipios;
import model.Provincias;
import model.database.MunicipiosDAO;
import view.VMunicipios;

public class CMunicipios {
	Provincias provincia;
	VMunicipios vMunicipios;
	
	public CMunicipios(Provincias provincia) {
        this.provincia = provincia;
        this.index();
	}
	
	public void index() {
		MunicipiosDAO municipiosDAO = new MunicipiosDAO();
		List<Municipios> municipios = municipiosDAO.getMunicipiosByProvincia(provincia);
		this.vMunicipios = new VMunicipios(municipios);
		this.vMunicipios.setVisible(true);
		this.setListeners();
	}
	
	private void setListeners() {
		JButton btnSelect = vMunicipios.getBtnSelect();
		JList listMunicipios = vMunicipios.getListMunicipios();
		
		btnSelect.addActionListener(e -> {
			Municipios muni = (Municipios) listMunicipios.getSelectedValue();
			if (muni == null) {
				vMunicipios.ShowErrorDialog();
				return;
			}else {
				this.vMunicipios.setVisible(false);
				CCentrosNaturales cCentrosNaturales = new CCentrosNaturales(muni);
			}
			
		});
		
	}

}
