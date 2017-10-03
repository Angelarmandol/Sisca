package bi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class VentanaBaseDeDatos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public VentanaBaseDeDatos() {
		setTitle("Base de datos - Sistema de control");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 517);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				contentPane.setLocation(contentPane.getX() + e.getX(),
						contentPane.getY() + e.getY());
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("Buscar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton buscar
			}
		});
		button.setBounds(10, 11, 89, 23);
		contentPane.add(button);

		JLabel label = new JLabel("Matricula");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(10, 45, 75, 14);
		contentPane.add(label);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 69, 103, 20);
		contentPane.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 143, 103, 20);
		contentPane.add(textField_1);

		JLabel label_1 = new JLabel("Grupo");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(10, 118, 75, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Hora Entrada");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(10, 205, 108, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Hora Salida");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(10, 291, 103, 14);
		contentPane.add(label_3);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 234, 103, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 316, 103, 20);
		contentPane.add(textField_3);

		JButton btnAgreagarAlumno = new JButton("Agregar Alumno");
		btnAgreagarAlumno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton agregar alumno
			}
		});
		btnAgreagarAlumno.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAgreagarAlumno.setBounds(151, 344, 153, 45);
		contentPane.add(btnAgreagarAlumno);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton eliminar
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar.setBounds(314, 265, 163, 45);
		contentPane.add(btnEliminar);

		JLabel label_4 = new JLabel("Nombre Encargado");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(10, 375, 147, 14);
		contentPane.add(label_4);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 401, 103, 20);
		contentPane.add(textField_4);

		JButton button_3 = new JButton("Copiar");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton copiar
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_3.setBounds(487, 265, 163, 45);
		contentPane.add(button_3);

		JButton button_4 = new JButton("OK");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton ok
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_4.setBounds(688, 414, 89, 45);
		contentPane.add(button_4);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton modificar
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificar.setBounds(151, 265, 153, 45);
		contentPane.add(btnModificar);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(151, 11, 626, 243);
		contentPane.add(tabbedPane);

		JButton btnImportarBaseDe = new JButton("Importar base de datos");
		btnImportarBaseDe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton importar base de datos
			}
		});
		btnImportarBaseDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnImportarBaseDe.setBounds(151, 414, 197, 45);
		contentPane.add(btnImportarBaseDe);

		JButton btnAgregarGrupo = new JButton("Agregar Grupo");
		btnAgregarGrupo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton agregar grupo
			}
		});
		btnAgregarGrupo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAgregarGrupo.setBounds(314, 344, 163, 45);
		contentPane.add(btnAgregarGrupo);

		JButton btnExportarBaseDe = new JButton("Exportar base de datos");
		btnExportarBaseDe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton exportar base de datos
			}
		});
		btnExportarBaseDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExportarBaseDe.setBounds(358, 414, 193, 45);
		contentPane.add(btnExportarBaseDe);

		JButton btnAgregarMaestro = new JButton("Agregar Maestro");
		btnAgregarMaestro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton agregar maestro
			}
		});
		btnAgregarMaestro.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAgregarMaestro.setBounds(487, 344, 163, 45);
		contentPane.add(btnAgregarMaestro);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton cancelar
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(561, 414, 119, 45);
		contentPane.add(btnCancelar);
	}

}
