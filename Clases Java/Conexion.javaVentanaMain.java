package bi;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class VentanaMain extends JPanel {

	/**
	 * Este codigo esta optimizado para que aparezca correctamente en Windows
	 * Builder, si solo aparece una ventana gris dar muchos clics en "repase" o
	 * si no quitar el comentario en el constructor. si se quita este comentario
	 * y asi se guarda se ejecutara con errores.
	 */

	// public VentanaMain() {
	// initialize();
	// }

	Float matriculalocal;
	String nombrelocal;
	int contadorGeneralDeAlumnos = 0;
	MainPrincipal main = new MainPrincipal();
	MeinRealReal real = new MeinRealReal();
	boolean usuarioSalio = false;
	String horadesalida = "";
	Object elRegistro = new Object();
	JLabel label = new JLabel("-------------------");
	JPanel panel = new JPanel();
	JTable mitable = new JTable();
	String horadeentrada = "";
	Autoguardado autosave = new Autoguardado();
	int Meces[] = new int[12];
	static JOptionPane jop = new JOptionPane();
	int contadorparafila1Excel = 0;

	Date date = new Date();
	String gafeteABuscar;

	BufferedReader tlc = new BufferedReader(new InputStreamReader(System.in));

	Object[] fila = { "Numero", "Apellido paterno", "Apellido materno",
			"Nombre", "Carrera", "Matricula", "Trabajo o practica", "Notas",
			"Hr Entrada", "Hr Salida" };

	Object[] titulos =

	{ fila[0], "Apellido paterno", "Apellido paterno", "Nombre", "Carrera",
			"Turno", "Matricula", "Trabajo o practica", "Notas", "Hr Entrada" };

	DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
	DefaultTableModel model = new DefaultTableModel(titulos, 0);

	JTextField lectora;

	public void initialize() {

		JFrame frmSistemaDeControl;
		frmSistemaDeControl = new JFrame();
		frmSistemaDeControl
				.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmSistemaDeControl.setAutoRequestFocus(false);
		frmSistemaDeControl.setVisible(true);
		frmSistemaDeControl.getContentPane().setBackground(
				new Color(119, 136, 153));

		frmSistemaDeControl.getContentPane().setForeground(new Color(0, 0, 0));

		JMenuBar menuBar = new JMenuBar(); // esta es la barra de menus
		menuBar.setBackground(new Color(192, 192, 192));
		frmSistemaDeControl.setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo ");
		menuBar.add(mnArchivo);

		JMenu mnGrupos = new JMenu("Grupos");
		mnGrupos.setEnabled(false);
		menuBar.add(mnGrupos);

		JMenu mnHerramientas = new JMenu("Herramientas");
		menuBar.add(mnHerramientas);

		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		JMenu mnVer = new JMenu("Ver");
		menuBar.add(mnVer);

		JMenu mnBarraDeHerramientas = new JMenu("Barra de Herramientas");
		mnVer.add(mnBarraDeHerramientas);

		JLabel lblPutas = new JLabel(""); // buscar la variables putas
		mnArchivo.add(lblPutas);

		JLabel lblAbrir = new JLabel("Abrir");
		lblAbrir.setEnabled(false);
		lblAbrir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		mnArchivo.add(lblAbrir);

		JLabel lblCerrar = new JLabel("Cerrar");
		lblCerrar.setEnabled(false);
		lblCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});

		///--------- Menu Archivo
		mnArchivo.add(lblCerrar);

		JLabel lblGuardar = new JLabel("Guardar");
		lblGuardar.setEnabled(false);
		lblGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		mnArchivo.add(lblGuardar);

		JLabel lblCerrarSesion = new JLabel("Cerrar sesi\u00F3n");
		lblCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				real.ejecutar2();
				main.OcultarVentanaMain();
				main.MostrarVentanaPrincipal();
				panel.enable(false);
				panel.show(false);
				panel.hide();

				real.ejecutar();

			}
		});
		mnArchivo.add(lblCerrarSesion);

		JLabel lblConsultar = new JLabel("Consultar");
		lblConsultar.setEnabled(false);
		lblConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});


		///--------- Herramientas
		mnHerramientas.add(lblConsultar);

		JLabel lblExportarAPdf = new JLabel("Exportar a PDF");
		lblExportarAPdf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}

				try {

					// tabla1.print();//envia los datos de la tabla a la
					// impresora

					MessageFormat headerFormat = new MessageFormat("Grupo ");
					MessageFormat footerFormat = new MessageFormat(
							"- Página {0} -");
					mitable.print(null, headerFormat, footerFormat);
				} catch (PrinterException ex) {
					JOptionPane
							.showMessageDialog(null,
									"No se ha podido imprimir correctamente, intentalo más tarde.");
				}

			}
		});

		JLabel lblGenerarGraficaMensual = new JLabel("Generar grafica mensual");
		lblGenerarGraficaMensual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				main.MostrarVentanaGenerarGrafica();
			}
		});

		JLabel lblEliminarFila = new JLabel("Eliminar fila");
		lblEliminarFila.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				eliminarUno();
			}
		});
		mnHerramientas.add(lblEliminarFila);
		mnHerramientas.add(lblGenerarGraficaMensual);

		JLabel lblAbrirAutoguardados = new JLabel("Abrir autoguardados");
		mnHerramientas.add(lblAbrirAutoguardados);
		mnHerramientas.add(lblExportarAPdf);

		JSeparator separator = new JSeparator();
		mnHerramientas.add(separator);

		JLabel lblDispositivos = new JLabel("Dispositivos ...");
		lblDispositivos.setEnabled(false);
		lblDispositivos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		mnHerramientas.add(lblDispositivos);

		JSeparator separator_1 = new JSeparator();
		mnHerramientas.add(separator_1);

		JLabel lblpersonalizar = new JLabel("Personalizar");
		lblpersonalizar.setEnabled(false);
		lblpersonalizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		mnHerramientas.add(lblpersonalizar);

		JLabel lblBarraDeEstado = new JLabel("Barra de estado");
		lblBarraDeEstado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		mnBarraDeHerramientas.add(lblBarraDeEstado);

		JLabel lblBarraDeBotones = new JLabel("Barra de botones");
		lblBarraDeBotones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		mnBarraDeHerramientas.add(lblBarraDeBotones);

		JLabel lblLectorDeCodigo = new JLabel("Lector de Codigo ...");
		lblLectorDeCodigo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});

		///--------- Menu Ver
		mnVer.add(lblLectorDeCodigo);

		JLabel lblPantallaCompleta = new JLabel("Pantalla completa");
		lblPantallaCompleta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		mnVer.add(lblPantallaCompleta);

		JLabel lblManualDeUsuario = new JLabel("Manual de usuario tecnico");
		lblManualDeUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});


		///----------------Ayuda
		mnAyuda.add(lblManualDeUsuario);

		JLabel lblManulDeUsuario = new JLabel("Manual de usuario");
		lblManulDeUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		mnAyuda.add(lblManulDeUsuario);

		JLabel lblAgregarGrupo = new JLabel("Agregar grupo");
		lblAgregarGrupo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				main.MostrarVentanaAgregarGrupo();
			}
		});

		///--------- Menu Grupos
		mnGrupos.add(lblAgregarGrupo);

		JLabel lblBorrarGrupo = new JLabel("Borrar grupo");
		lblBorrarGrupo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		mnGrupos.add(lblBorrarGrupo);

		JLabel lblGuardarGrupo = new JLabel("Guardar grupo");
		lblGuardarGrupo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		mnGrupos.add(lblGuardarGrupo);

		JLabel lblSeleccionarTodo = new JLabel("Seleccionar todo");
		lblSeleccionarTodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		mnGrupos.add(lblSeleccionarTodo);

		JLabel lblDeseleccionar = new JLabel("Deseleccionar");
		lblDeseleccionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		mnGrupos.add(lblDeseleccionar);

		JLabel lblTodosLosGrupos = new JLabel("Todos los grupos ...");
		lblTodosLosGrupos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		mnGrupos.add(lblTodosLosGrupos);

		Class[] columnTypes = new Class[] { Integer.class, Object.class,
				Boolean.class, String.class, String.class, Long.class,
				String.class, String.class, Double.class, Double.class };

		boolean[] columnEditables = new boolean[] { false, true, true, true,
				true, true, true, true, true, true };
		;

		JPanel panel_de_paneles = new JPanel();
		panel_de_paneles.setBackground(Color.LIGHT_GRAY);

		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		JMenuBar menuBar_1 = new JMenuBar(); //

		JLabel lblNombreDelMaestro = new JLabel("      Nombre del maestro: ");
		menuBar_1.add(lblNombreDelMaestro);

		menuBar_1.add(label);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addComponent(menuBar_1,
				GroupLayout.DEFAULT_SIZE, 1189, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addComponent(menuBar_1, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(2)));
		panel.setLayout(gl_panel);

		JPanel panel_2 = new JPanel();

		panel_2.setOpaque(false);

		JButton btnNewButton_1 = new JButton("Eliminar Grupo");
		btnNewButton_1
				.setIcon(new ImageIcon(
						"C:\\Users\\Yodemi\\Desktop\\nuevos_iconos\\varios\\delete_square16_h.ico"));   /// verificar 

		JButton btnNewButton_4 = new JButton("Generar Reporte");

		JButton btnNewButton_3 = new JButton("Abrir Sesion");
		btnNewButton_3.setEnabled(false);

		JButton btnNewButton_2 = new JButton("Guardar Sesion");
		btnNewButton_2.setEnabled(false);

		JButton btnNewButton = new JButton("Agregar Grupo");
		btnNewButton.setEnabled(false);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		lectora = new JTextField();
		lectora.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				int key = e.getKeyCode();

				if (key == KeyEvent.VK_ENTER) {
					gafeteABuscar = lectora.getText();
					agregarUno(gafeteABuscar);

				}
			}
		});
		lectora.setColumns(10);

		JLabel lblIngresoManual = new JLabel("Gafete");

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_2
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnNewButton_1,
								GroupLayout.PREFERRED_SIZE, 129,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnNewButton_4)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnNewButton_3)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnNewButton_2)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE,
								137, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lectora, GroupLayout.PREFERRED_SIZE, 159,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblIngresoManual).addGap(231)));
		gl_panel_2
				.setVerticalGroup(gl_panel_2
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_2
										.createSequentialGroup()
										.addGap(5)
										.addGroup(
												gl_panel_2
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnNewButton_1)
														.addComponent(
																btnNewButton_4)
														.addComponent(
																btnNewButton_3)
														.addComponent(
																btnNewButton_2)
														.addComponent(
																btnNewButton)
														.addComponent(
																lectora,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblIngresoManual))
										.addContainerGap()));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(UIManager.getBorder("EditorPane.border"));
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		mitable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		mitable.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.CENTER,
				TitledBorder.TOP, null, null));

		mitable.setModel(new DefaultTableModel());
		scrollPane.setViewportView(mitable);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_1
						.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								1165, Short.MAX_VALUE).addGap(9)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(
				Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE));
		panel_1.setLayout(gl_panel_1);
		GroupLayout groupLayout = new GroupLayout(
				frmSistemaDeControl.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addComponent(panel_de_paneles,
				GroupLayout.DEFAULT_SIZE, 1172, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addComponent(panel_de_paneles,
								GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
						.addContainerGap()));
		GroupLayout gl_panel_de_paneles = new GroupLayout(panel_de_paneles);
		gl_panel_de_paneles.setHorizontalGroup(gl_panel_de_paneles
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel_de_paneles
								.createSequentialGroup()
								.addComponent(panel, GroupLayout.DEFAULT_SIZE,
										1155, Short.MAX_VALUE).addGap(17))
				.addGroup(
						gl_panel_de_paneles
								.createSequentialGroup()
								.addGap(10)
								.addComponent(panel_1,
										GroupLayout.DEFAULT_SIZE, 1145,
										Short.MAX_VALUE).addGap(17))
				.addGroup(
						gl_panel_de_paneles
								.createSequentialGroup()
								.addGap(18)
								.addComponent(panel_2,
										GroupLayout.PREFERRED_SIZE, 1107,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(47, Short.MAX_VALUE)));
		gl_panel_de_paneles.setVerticalGroup(gl_panel_de_paneles
				.createParallelGroup(Alignment.LEADING).addGroup(
						gl_panel_de_paneles
								.createSequentialGroup()
								.addGap(20)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE,
										23, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_2,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_1,
										GroupLayout.DEFAULT_SIZE, 568,
										Short.MAX_VALUE).addGap(29)));
		panel_de_paneles.setLayout(gl_panel_de_paneles);
		frmSistemaDeControl.getContentPane().setLayout(groupLayout);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int seleccion = jop.showOptionDialog(null,
						"Selecione opcion a exportar", "Generar reporte",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, new Object[] {
								"PDF", "Excel" }, null);

				if (seleccion != -1) {
					System.out.println(" seleccionada la opcion "
							+ (seleccion + 1));

					if (seleccion == 1) {
						GenerarReporteExcel();
					} else {

						GenerarREportePorPDF();
					}
				}

			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				VaciarElModelo();
			}
		});

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(646, 50, 46, 14);
		frmSistemaDeControl.getContentPane().add(lblNewLabel);

		frmSistemaDeControl.setBackground(new Color(192, 192, 192));
		frmSistemaDeControl.setForeground(new Color(0, 0, 0));
		frmSistemaDeControl
				.setIconImage(Toolkit
						.getDefaultToolkit()
						.getImage(
								"C:\\Users\\Angel\\Pictures\\302-iconos\\nuevos_iconos\\varios\\user_properties16_h.ico"));
		frmSistemaDeControl.setTitle("Sistema de control");
		frmSistemaDeControl.setBounds(100, 100, 1188, 759);
		frmSistemaDeControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lectora.requestFocus();

	}

	public void AgregarModelo() {
		this.mitable.setModel(model);
	}

	public void VaciarElModelo() {
		DefaultTableModel modeloVacio;
		modeloVacio = new DefaultTableModel(titulos, 0);

		this.mitable.setModel(modeloVacio);

		while (model.getRowCount() > 0) {

			model.removeRow(model.getRowCount() - 1);
		}

		contadorGeneralDeAlumnos = 0;

	}

	public void agregarUno(String gafeteABuscar2) {
		Connection conn;
		java.sql.Statement sent;
		conn = Conexion.getConnection();
		Calendar hora = new GregorianCalendar();

		try {
			sent = conn.createStatement();
			ResultSet rs = sent
					.executeQuery("select * from alumnos where row_id = " + "("
							+ gafeteABuscar2 + ")");

			horadeentrada = hora.get(Calendar.HOUR_OF_DAY) + ":"
					+ hora.get(Calendar.MINUTE) + ":"
					+ hora.get(Calendar.SECOND);

			while (rs.next()) {
				fila[0] = contadorGeneralDeAlumnos;
				fila[1] = rs.getString("alumno_apell_pat");
				fila[2] = rs.getString("alumno_apell_mat");
				fila[3] = rs.getString("alumno_nombre");
				fila[4] = rs.getString("esp_nombre");
				fila[5] = rs.getString("gpo_turno");
				fila[6] = rs.getString("alumno_no_control");
				fila[7] = "BIBLIOTECA";
				fila[8] = " ";
				fila[9] = horadeentrada;
			}
				// aqui se agrega fila por fila, modificando
			model.addRow(fila);
				horadesalida = "";
				horadeentrada = "";
				contadorGeneralDeAlumnos = contadorGeneralDeAlumnos + 1;

			
		 mitable.setModel(model);

			lectora.setText("");

		} catch (Exception e) {
			e.printStackTrace();
		}
		// autosaveConexion();
		try {

			lectora.setText("Agregando...");
			lectora.setEnabled(true);
			Thread.sleep(500);
			lectora.setText("");
			lectora.setEnabled(true);

			lectora.requestFocus();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void eliminarUno() {

		String rowAEliminar;

		try {
			int rowEliminar = Integer.parseInt(rowAEliminar = jop
					.showInputDialog("Inserte el numero de fila a eliminar"));
			model.removeRow(rowEliminar);

			int cantidadDeRows = model.getRowCount();
			for (int variableParaReasignarNumero = 0; variableParaReasignarNumero < cantidadDeRows; variableParaReasignarNumero++) {
				model.setValueAt(variableParaReasignarNumero,
						variableParaReasignarNumero, 0);

			}
			contadorGeneralDeAlumnos = contadorGeneralDeAlumnos - 1;
		} catch (Exception e) {
			jop.showMessageDialog(null,
					"Error, el valor no es un numero o no existe",
					"Error de valores", jop.ERROR_MESSAGE);
		}

	}

	public void autosaveConexion() {

		Connection conn;
		java.sql.Statement sent;
		conn = Conexion.getConnection();
		// String sql =
		// "INSERT INTO respaldo (Numero, Apellido Paterno, Apellido Materno, Nombre, Carrera, Turno, Matricula, Trabajo o practica, Notas, Hora de entrada) VALUES ('?','?','?','?','?','?','?','?','?','?')";
		try {
			// PreparedStatement pst = conn.prepareStatement(sql);
			Statement statement = (Statement) conn.createStatement();

			statement
					.execute("INSERT into respaldo "
							+ "(`Numero`, `Apellido_Paterno`, `Apellido_Materno`,`Nombre`, `Carrera`, `Turno`, `Matricula`, `Trabajo_o_practica`, `Notas`, `Hora_de_entrada`) VALUES ('"
							+ model.getValueAt(0, 0) + "','"
							+ model.getValueAt(0, 1) + "','"
							+ model.getValueAt(0, 2) + "','"
							+ model.getValueAt(0, 3) + "','"
							+ model.getValueAt(0, 4) + "','"
							+ model.getValueAt(0, 5) + "','"
							+ model.getValueAt(0, 6) + "','"
							+ model.getValueAt(0, 7) + "','"
							+ model.getValueAt(0, 8) + "','"
							+ model.getValueAt(0, 9) + "'");

			// for(int x=0; x <= (model.getRowCount()); x++){
			//
			//

			// }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void GenerarREportePorPDF() {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		try {

			// tabla1.print();//envia los datos de la tabla a la
			// impresora

			MessageFormat headerFormat = new MessageFormat("Grupo ");
			MessageFormat footerFormat = new MessageFormat("- Página {0} -");
			mitable.print(null, headerFormat, footerFormat);
		} catch (PrinterException ex) {
			JOptionPane
					.showMessageDialog(null,
							"No se ha podido imprimir correctamente, intentalo más tarde.");
		}
	}

	HSSFWorkbook libro = new HSSFWorkbook();
	HSSFSheet hoja1 = libro.createSheet("Reporte");
	HSSFRow filaexcel = hoja1.createRow(1);

	public void crearfila(int numerodeiteracion) {
		filaexcel = hoja1.createRow(numerodeiteracion + 1);
	}

	public void GenerarReporteExcel() {

		HSSFRow fila0 = hoja1.createRow(0);

		HSSFCell celda0x0 = fila0.createCell(0);
		String txt0x0 = "Numero";
		HSSFRichTextString texto0x0 = new HSSFRichTextString(txt0x0);
		celda0x0.setCellValue(texto0x0);

		HSSFCell celda0x1 = fila0.createCell(1);
		String txt0x1 = "Apellido paterno";
		HSSFRichTextString texto0x1 = new HSSFRichTextString(txt0x1);
		celda0x1.setCellValue(texto0x1);

		HSSFCell celda0x2 = fila0.createCell(2);
		String txt0x2 = "Apellido materno";
		HSSFRichTextString texto0x2 = new HSSFRichTextString(txt0x2);
		celda0x2.setCellValue(texto0x2);

		HSSFCell celda0x3 = fila0.createCell(3);
		String txt0x3 = "Nombre";
		HSSFRichTextString texto0x3 = new HSSFRichTextString(txt0x3);
		celda0x3.setCellValue(texto0x3);

		HSSFCell celda0x4 = fila0.createCell(4);
		String txt0x4 = "Carrera";
		HSSFRichTextString texto0x4 = new HSSFRichTextString(txt0x4);
		celda0x4.setCellValue(texto0x4);

		HSSFCell celda0x5 = fila0.createCell(5);
		String txt0x5 = "Turno";
		HSSFRichTextString texto0x5 = new HSSFRichTextString(txt0x5);
		celda0x5.setCellValue(texto0x5);

		HSSFCell celda0x6 = fila0.createCell(6);
		String txt0x6 = "Matricula";
		HSSFRichTextString texto0x6 = new HSSFRichTextString(txt0x6);
		celda0x6.setCellValue(texto0x6);

		HSSFCell celda0x7 = fila0.createCell(7);
		String txt0x7 = "Trabajo o practica";
		HSSFRichTextString texto0x7 = new HSSFRichTextString(txt0x7);
		celda0x7.setCellValue(texto0x7);

		HSSFCell celda0x8 = fila0.createCell(8);
		String txt0x8 = "Notas";
		HSSFRichTextString texto0x8 = new HSSFRichTextString(txt0x8);
		celda0x8.setCellValue(texto0x8);

		HSSFCell celda0x9 = fila0.createCell(9);
		String txt0x9 = "Hr Entrada";
		HSSFRichTextString texto0x9 = new HSSFRichTextString(txt0x9);
		celda0x9.setCellValue(texto0x9);

		int tamañodemodelo = model.getRowCount();
		int contadorParaExcel = 0;

		// para apellido paterno
		while (contadorparafila1Excel < tamañodemodelo) {

			crearfila(contadorparafila1Excel);

			HSSFCell celda0 = filaexcel.createCell(0);
			String txt0 = contadorParaExcel + "";
			HSSFRichTextString texto0 = new HSSFRichTextString(txt0);
			celda0.setCellValue(texto0);
			contadorParaExcel++;

			HSSFCell celda1 = filaexcel.createCell(1);
			String txt = (String) model.getValueAt(contadorparafila1Excel, 1);
			HSSFRichTextString texto = new HSSFRichTextString(txt);
			celda1.setCellValue(texto);

			HSSFCell celda2 = filaexcel.createCell(2);
			String txt1 = (String) model.getValueAt(contadorparafila1Excel, 2);
			HSSFRichTextString texto1 = new HSSFRichTextString(txt1);
			celda2.setCellValue(texto1);

			HSSFCell celda3 = filaexcel.createCell(3);
			String txt3 = (String) model.getValueAt(contadorparafila1Excel, 3);
			HSSFRichTextString texto3 = new HSSFRichTextString(txt3);
			celda3.setCellValue(texto3);

			HSSFCell celda4 = filaexcel.createCell(4);
			String txt4 = (String) model.getValueAt(contadorparafila1Excel, 4);
			HSSFRichTextString texto4 = new HSSFRichTextString(txt4);
			celda4.setCellValue(texto4);

			HSSFCell celda5 = filaexcel.createCell(5);
			String txt5 = (String) model.getValueAt(contadorparafila1Excel, 5);
			HSSFRichTextString texto5 = new HSSFRichTextString(txt5);
			celda5.setCellValue(texto5);

			HSSFCell celda6 = filaexcel.createCell(6);
			String txt6 = (String) model.getValueAt(contadorparafila1Excel, 6);
			HSSFRichTextString texto6 = new HSSFRichTextString(txt6);
			celda6.setCellValue(texto6);

			HSSFCell celda7 = filaexcel.createCell(7);
			String txt7 = (String) model.getValueAt(contadorparafila1Excel, 7);
			HSSFRichTextString texto7 = new HSSFRichTextString(txt7);
			celda7.setCellValue(texto7);

			HSSFCell celda8 = filaexcel.createCell(8);
			String txt8 = (String) model.getValueAt(contadorparafila1Excel, 8);
			HSSFRichTextString texto8 = new HSSFRichTextString(txt8);
			celda8.setCellValue(texto8);

			HSSFCell celda9 = filaexcel.createCell(9);
			String txt9 = (String) model.getValueAt(contadorparafila1Excel, 9);
			HSSFRichTextString texto9 = new HSSFRichTextString(txt9);
			celda9.setCellValue(texto9);

			contadorparafila1Excel++;
		}

		// contadorparafila1Excel = 0;
		//
		// while (contadorparafila1Excel < tamañodemodelo){
		//
		// contadorparafila1Excel++;
		//
		// }

		try {
			FileOutputStream arch = new FileOutputStream(
					jop.showInputDialog("Inserte el nombre de el archivo")
							+ ".xls");
			libro.write(arch);
			jop.showMessageDialog(null, "Archivo creado correctamente");
		} catch (Exception e) {
			System.out.println("Error al escribir en Excel");
		}

	}
}
