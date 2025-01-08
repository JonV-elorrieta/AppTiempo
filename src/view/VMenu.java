package view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import model.Provincias;

public class VMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnInclude;
	private JButton btnSelect;
	private JComboBox cbProvin;

	/**
	 * Create the frame.
	 */
	public VMenu(List<Provincias> provicias) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnInclude = new JButton("Incluir");
		btnInclude.setBounds(40, 21, 89, 23);
		contentPane.add(btnInclude);
		
		cbProvin = new JComboBox();
		cbProvin.setBounds(214, 179, 259, 36);
		contentPane.add(cbProvin);
		
		for (Provincias prov : provicias) {
			cbProvin.addItem(prov);
		}
		
		btnSelect = new JButton("Seleccionar");
		btnSelect.setBounds(288, 272, 89, 23);
		contentPane.add(btnSelect);
	}
	
	public JButton getBtnInclude() {
        return btnInclude;
    }
	
	public JButton getBtnSelect() {
		return btnSelect;
	}
	
	public JComboBox getCbProvin() {
		return cbProvin;
	}
	
	public void newProvincia(Provincias prov) {
		cbProvin.addItem(prov);
	}
	
	
	
	
}
