package bi;

import java.awt.EventQueue;

public class MainPrincipal {

	public static boolean pasar = false;

	static VentanaAgregarAlumno frame1 = new VentanaAgregarAlumno();

	static VentanaAgregarGrupo frame2 = new VentanaAgregarGrupo();

	static VentanaAgregarMaestro frame3 = new VentanaAgregarMaestro();

	static VentanaBaseDeDatos frame4 = new VentanaBaseDeDatos();

	static VentanaConsultar frame5 = new VentanaConsultar();

	static VentanaGrupos frame6 = new VentanaGrupos();

	static VentanaPrincipal frame7 = new VentanaPrincipal();

	static VentanaMain frame8 = new VentanaMain();

	static MeinRealReal lareal = new MeinRealReal();
	
	static VentanaGenerarGrafica frame9 = new VentanaGenerarGrafica();

	public static void MonstrarVentanaAgregarAlumno() {

		frame1.setVisible(true);
	}

	public void OcultarVentanaAgregarAlumno() {

		frame1.setVisible(false);
	}

	public static void MostrarVentanaAgregarGrupo() {

		frame2.setVisible(true);
	}

	public static void OcultarVentanaAgregarGrupo() {

		frame2.setVisible(false);
	}

	public static void MostrarVentanaAgregarMaestro() {

		frame3.setVisible(true);
	}

	public static void OcultarVentanaAgregarMaestro() {

		frame3.setVisible(false);
	}

	public static void MostrarVentanaBaseDeDatos() {

		frame4.setVisible(true);
	}

	public static void OcultarVentanaBaseDeDatos() {

		frame4.setVisible(false);
	}

	public static void MostrarVentanaConsultar() {

		frame5.setVisible(true);
	}

	public static void OcultarVentanaConsultar() {

		frame5.setVisible(false);
	}

	public static void MostrarVentanaGrupos() {

		frame6.setVisible(true);
	}

	public static void OcultarVentanaGrupos() {

		frame6.setVisible(false);
	}

	public static void MostrarVentanaPrincipal() {

		frame7.setVisible(true);
		frame7.setEnabled(true);

	}

	public static void OcultarVentanaPrincipal() {

		frame7.setVisible(false);
		frame7.enable(false);
		frame7.hide();

	}

	public static void MostrarVentanaMain() {

		frame8.setVisible(true);// ///////// ---- aqui se nesesitan instanciar
								// todas las cosas para el frame
	}

	public static void OcultarVentanaMain() {

		frame8.panel.setVisible(false);

		frame8.setVisible(false);

		frame8.panel.enable(false);
		frame8.panel.hide();
		System.exit(0);

	}
	public static void MostrarVentanaGenerarGrafica(){
		frame9.setVisible(true);
	}
	public static void ocultarVentanaGenerarGrafica(){
		frame9.setVisible(false);
	}
}
