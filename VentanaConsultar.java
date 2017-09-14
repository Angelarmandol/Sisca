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
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaConsultar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public VentanaConsultar() {
		setTitle("Consulta de alumnos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton buscar
			}
		});
		btnBuscar.setBounds(10, 11, 89, 23);
		contentPane.add(btnBuscar);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(10, 57, 89, 14);
		contentPane.add(lblNombre);

		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMatricula.setBounds(10, 129, 75, 14);
		contentPane.add(lblMatricula);

		textField = new JTextField();
		textField.setBounds(10, 83, 103, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 153, 103, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 227, 103, 20);
		contentPane.add(textField_2);

		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGrupo.setBounds(10, 202, 75, 14);
		contentPane.add(lblGrupo);

		JLabel lblHoraEntrada = new JLabel("Hora Entrada");
		lblHoraEntrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHoraEntrada.setBounds(10, 289, 108, 14);
		contentPane.add(lblHoraEntrada);

		JLabel lblHoraSalida = new JLabel("Hora Salida");
		lblHoraSalida.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHoraSalida.setBounds(10, 375, 103, 14);
		contentPane.add(lblHoraSalida);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 318, 103, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 400, 103, 20);
		contentPane.add(textField_4);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(130, 0, 656, 420);
		contentPane.add(tabbedPane);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton ok
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(687, 425, 89, 45);
		contentPane.add(btnNewButton);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton no se acuerda
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(554, 425, 107, 45);
		contentPane.add(btnCancelar);

		JButton btnCopiar = new JButton("Copiar");
		btnCopiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton copiar
			}
		});
		btnCopiar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCopiar.setBounds(455, 425, 89, 45);
		contentPane.add(btnCopiar);
	}
}
