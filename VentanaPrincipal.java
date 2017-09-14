package bi;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import java.awt.event.MouseMotionAdapter;


public class VentanaPrincipal extends JFrame {
	 private JTextField textField;
	private JPasswordField passwordField;
	private JLayeredPane contentPane;
	public boolean SeEncontro = false;
	Conexion conectar = new Conexion();
	MainPrincipal maestro = new MainPrincipal();
    String matricula;
	String codigoDeBarras;
	
	
	
	public VentanaPrincipal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("J:\\logo gatito,perrito.jpg"));
		setTitle("Login-Sistema de control");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 406, 520);
		contentPane = new JLayeredPane();
		contentPane.setBackground(Color.black);
		this.setOpacity(1);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);

		
		JLabel lblMatricula = new JLabel("Usuario");
		lblMatricula.setForeground(new Color(255, 255, 255));
		lblMatricula.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblMatricula.setBounds(64, 190, 152, 25);
		contentPane.add(lblMatricula);
		
		textField = new JTextField();
		String codigodeTextfield;
		textField.setBounds(64, 212, 282, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblContrasea.setBounds(64, 258, 88, 25);
		contentPane.add(lblContrasea);
		
		final String varUsuariocorrecto="";
		final JLabel lblUsuarioCorrecto = new JLabel(varUsuariocorrecto );
		lblUsuarioCorrecto.setEnabled(false);
		lblUsuarioCorrecto.setForeground(new Color(25, 25, 112));
		lblUsuarioCorrecto.setBounds(64, 325, 260, 25);
		contentPane.add(lblUsuarioCorrecto);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String codigo = textField.getText();
				
				
				conectar.acceso(codigo);
				
				
				
			}
				
				
			}
		);
		btnOk.setForeground(new Color(25, 25, 112));
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOk.setBounds(64, 341, 69, 52);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnCancelar.setForeground(new Color(25, 25, 112));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancelar.setBounds(143, 341, 112, 52);
		contentPane.add(btnCancelar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(64, 281, 282, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnNewButton.setForeground(new Color(139, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(265, 341, 81, 52);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Imagenes/dos.png")));
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				VentanaPrincipal.this.setLocation(VentanaPrincipal.this.getX()+e.getX(),VentanaPrincipal.this.getY()+e.getY());
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Imagenes/TRES.png")));

		lblNewLabel_1.setBounds(46, 23, 396, 183);
		contentPane.add(lblNewLabel_1);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 0, 406, 535);;
		contentPane.add(lblNewLabel);
		//lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/bin/dos.png")));

	}
}
