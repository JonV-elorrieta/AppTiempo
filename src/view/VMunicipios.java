package view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.Municipios;

public class VMunicipios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton btnSelect;
	private JList listMunicipios;


	/**
	 * Create the frame.
	 */
	public VMunicipios(List<Municipios> municipios) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		listMunicipios = new JList<>();
		listMunicipios.setListData(municipios.toArray(new Municipios[0]));

		JScrollPane scrollPane = new JScrollPane(listMunicipios);
		scrollPane.setBounds(191, 45, 303, 236);
		contentPane.add(scrollPane);
        
		btnSelect = new JButton("Seleccionar");
		btnSelect.setBounds(452, 321, 89, 23);
        contentPane.add(btnSelect);
	}
	
	public JButton getBtnSelect() {
		return btnSelect;
	}
	
	public JList getListMunicipios() {
		return listMunicipios;
	}
	
	public void ShowErrorDialog() {
		JOptionPane.showMessageDialog(null, "No municipality selected.");
	}

}
