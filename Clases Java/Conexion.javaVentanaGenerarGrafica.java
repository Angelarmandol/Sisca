package bi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VentanaGenerarGrafica extends JFrame {

	
	
	MainPrincipal  main = new MainPrincipal();
	
	private JPanel contentPane;
	 
	public VentanaGenerarGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(46, 39, 303, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.ocultarVentanaGenerarGrafica();
			}
		});
		btnNewButton.setBounds(263, 208, 99, 43);
		contentPane.add(btnNewButton);
		
		JButton btnGenerarGrafica = new JButton("Generar Grafica");
		btnGenerarGrafica.setBounds(36, 208, 144, 43);
		contentPane.add(btnGenerarGrafica);
		
		JLabel lblNewLabel = new JLabel("Selecciona el mes");
		lblNewLabel.setBounds(46, 14, 134, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaGenerarGrafica.class.getResource("/Imagenes/fondo.png")));
		lblNewLabel_1.setBounds(0, 0, 409, 300);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				VentanaGenerarGrafica.this.setLocation(VentanaGenerarGrafica.this.getX()+e.getX(),VentanaGenerarGrafica.this.getY()+e.getY());
			}
		});
	}
}
