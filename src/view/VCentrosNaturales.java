package view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;

import model.CentrosMeteorologicos;
import model.EspaciosNaturales;
import model.Municipios;
import model.Provincias;

public class VCentrosNaturales extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JButton btnSelect;
	private JList list1;
	private JList list2;

	/**
	 * Create the frame.
	 */
	public VCentrosNaturales(List<CentrosMeteorologicos> listCM, List<EspaciosNaturales> listEN) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list1 = new JList<>();
		list1.setListData(listCM.toArray());
		list1.setBounds(10, 26, 166, 186);
		contentPane.add(list1);
		
		list2 = new JList<>();
		list2.setListData(listEN.toArray());
		list2.setBounds(227, 26, 166, 186);
		contentPane.add(list2);
        
		btnSelect = new JButton("Seleccionar");
		btnSelect.setBounds(452, 321, 89, 23);
        contentPane.add(btnSelect);
	}
	
	
	public JButton getBtnSelect() {
		return btnSelect;
	}
	
	
	
	
	
}
