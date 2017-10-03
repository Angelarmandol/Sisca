package bi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import java.awt.Choice;
import java.awt.Label;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaAgregarAlumno extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public VentanaAgregarAlumno() {
		setTitle("Agregar Alumnos-Sistema de control");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(25, 31, 95, 21);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(24, 63, 226, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(24, 131, 226, 21);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(330, 63, 198, 21);
		contentPane.add(textField_2);

		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMatricula.setBounds(335, 31, 95, 21);
		contentPane.add(lblMatricula);

		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGrupo.setBounds(330, 95, 95, 21);
		contentPane.add(lblGrupo);

		Choice choice = new Choice();
		choice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento textfield con triangulito
			}
		});
		choice.setBounds(330, 131, 198, 21);
		contentPane.add(choice);

		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton agregar
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(222, 323, 107, 47);
		contentPane.add(btnNewButton);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton cancelar
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(340, 323, 107, 47);
		contentPane.add(btnCancelar);

		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOk.setBounds(459, 323, 107, 47);
		contentPane.add(btnOk);
	}
}
