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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaGrupos extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaGrupos frame = new VentanaGrupos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaGrupos() {
		setTitle("Grupo-Sistema de control");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 513);
		contentPane = new JPanel();
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

		JLabel label_1 = new JLabel("Matricula");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(10, 45, 75, 14);
		contentPane.add(label_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 69, 103, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 143, 103, 20);
		contentPane.add(textField_2);

		JLabel label_2 = new JLabel("Grupo");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(10, 118, 75, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Hora Entrada");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(10, 205, 108, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Hora Salida");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(10, 291, 103, 14);
		contentPane.add(label_4);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 234, 103, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 316, 103, 20);
		contentPane.add(textField_4);

		JButton btnExportarPdf = new JButton("Exportar PDF");
		btnExportarPdf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton exportar PDF
			}
		});
		btnExportarPdf.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExportarPdf.setBounds(428, 425, 142, 45);
		contentPane.add(btnExportarPdf);

		JButton btnExpandir = new JButton("Expandir");
		btnExpandir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton expandir
			}
		});
		btnExpandir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExpandir.setBounds(317, 425, 101, 45);
		contentPane.add(btnExpandir);

		JLabel lblNombreEncargado = new JLabel("Nombre Encargado");
		lblNombreEncargado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreEncargado.setBounds(10, 375, 147, 14);
		contentPane.add(lblNombreEncargado);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 401, 103, 20);
		contentPane.add(textField);

		JButton button_3 = new JButton("Copiar");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// evento boton copiar
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_3.setBounds(580, 425, 89, 45);
		contentPane.add(button_3);

		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				// evento boton OK
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOk.setBounds(688, 425, 89, 45);
		contentPane.add(btnOk);

		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// evento boton sin nombre
			}
		});
		button_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_5.setBounds(218, 425, 89, 45);
		contentPane.add(button_5);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(151, 11, 626, 403);
		contentPane.add(tabbedPane);
	}
}
