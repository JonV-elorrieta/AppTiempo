package controller;

import java.util.List;

import model.CentrosMeteorologicos;
import model.EspaciosNaturales;
import model.Municipios;
import model.Provincias;
import model.database.CentrosMeteorologicosDAO;
import model.database.EspaciosNaturalesDAO;
import model.database.MunicipiosDAO;
import view.VCentrosNaturales;
import view.VMunicipios;

public class CCentrosNaturales {
	Municipios municipio;
	VCentrosNaturales vCentrosNaturales;
	
	public CCentrosNaturales(Municipios municipio) {
        this.municipio = municipio;
        this.index();
	}
	
	public void index() {
		CentrosMeteorologicosDAO centrosMeteorologicosDAO = new CentrosMeteorologicosDAO();
		EspaciosNaturalesDAO espaciosNaturalesDAO = new EspaciosNaturalesDAO();
		List<EspaciosNaturales> listEN = espaciosNaturalesDAO.getEspaciosNaturalesByMunicipio(municipio);
		List<CentrosMeteorologicos> listCM = centrosMeteorologicosDAO.getCentrosMeteorologicosByMunicipio(municipio);
		
		this.vCentrosNaturales = new VCentrosNaturales(listCM, listEN);
		this.vCentrosNaturales.setVisible(true);

		
	} 
}
