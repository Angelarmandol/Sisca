package bi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Color;
import java.sql.SQLException;

public class VentanaAgregarGrupo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	MainPrincipal main = new MainPrincipal();
	VentanaMain ventana = new VentanaMain();
	Conexion conectar = new Conexion();

	public VentanaAgregarGrupo() {
		setBackground(new Color(240, 248, 255));
		setAlwaysOnTop(true);
		setTitle("Agregar Grupo");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 670, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {

				VentanaAgregarGrupo.this.setLocation(
						VentanaAgregarGrupo.this.getX() + e.getX(),
						VentanaAgregarGrupo.this.getY() + e.getY());
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(10, 29, 91, 22);
		contentPane.add(lblNombre);

		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMatricula.setBounds(223, 29, 91, 22);
		contentPane.add(lblMatricula);

		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGrupo.setBounds(410, 29, 91, 22);
		contentPane.add(lblGrupo);

		textField = new JTextField();
		textField.setBounds(10, 62, 171, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(223, 63, 155, 22);
		contentPane.add(textField_1);

		final Choice choice = new Choice();
		choice.setBounds(410, 64, 128, 20);
		choice.addItem("grupo_3btps");
		choice.addItem("grupo_3bmt");
		contentPane.add(choice);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(0, 110, 654, 112);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnImportarBasededatos = new JButton("Importar BD");
		btnImportarBasededatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnImportarBasededatos.setBounds(10, 27, 151, 50);
		panel.add(btnImportarBasededatos);

		JButton btnExportarBd = new JButton("Exportar BD");
		btnExportarBd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExportarBd.setBounds(171, 27, 151, 50);
		panel.add(btnExportarBd);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				main.OcultarVentanaAgregarGrupo();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(332, 27, 151, 50);
		panel.add(btnCancelar);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAgregar.setBounds(493, 27, 151, 50);
		panel.add(btnAgregar);
	}
}
