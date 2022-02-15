package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class MenuPrincipal extends JFrame implements ActionListener {

	private FrmReservaCitas frmCitas;
	private FrmBoleta frmBoleta;
	private FrmCitaFechaHoy frmHoy;
	private FrmProductoBaor baor;
	private FrmAlisados ali;
	private FrmUsuario usuario;
	
	
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	public static JDesktopPane contenedor;
	public static JLabel lblApellido;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenu mnNewMenu_3;
	private JMenuItem mntmNewMenuItem_5;
	private JMenu mnNewMenu_4;
	private JMenuItem mntmNewMenuItem_6;
	private JMenu mnNewMenu_5;
	private JMenuItem mntmNewMenuItem_7;
	private JMenu mnNewMenu_6;
	private JMenu mnNewMenu_7;
	private JMenuItem mntmNewMenuItem_8;
	private JMenuItem mntmNewMenuItem_9;
	public static JLabel lblNombre;
	public static JLabel lblCodigo;
	//private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 414);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("CITAS");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Reservar");
		mntmNewMenuItem.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Reservadas");
		mntmNewMenuItem_1.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mnNewMenu_1 = new JMenu("VENTAS");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Boleta");
		mntmNewMenuItem_2.addActionListener(this);
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		mnNewMenu_2 = new JMenu("PRODUCTOS");
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_3 = new JMenuItem("Baor");
		mntmNewMenuItem_3.addActionListener(this);
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_4 = new JMenuItem("Alisados");
		mntmNewMenuItem_4.addActionListener(this);
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		mnNewMenu_3 = new JMenu("LISTA");
		menuBar.add(mnNewMenu_3);
		
		mntmNewMenuItem_5 = new JMenuItem("Clientes");
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		mnNewMenu_4 = new JMenu("USUARIO");
		menuBar.add(mnNewMenu_4);
		
		mntmNewMenuItem_6 = new JMenuItem("Agregar Usuario");
		mntmNewMenuItem_6.addActionListener(this);
		mnNewMenu_4.add(mntmNewMenuItem_6);
		
		mnNewMenu_5 = new JMenu("PERSONAL");
		menuBar.add(mnNewMenu_5);
		
		mntmNewMenuItem_7 = new JMenuItem("Trabajadores");
		mnNewMenu_5.add(mntmNewMenuItem_7);
		
		mnNewMenu_6 = new JMenu("EGRESOS");
		menuBar.add(mnNewMenu_6);
		
		mntmNewMenuItem_8 = new JMenuItem("Producto Baor");
		mnNewMenu_6.add(mntmNewMenuItem_8);
		
		mntmNewMenuItem_9 = new JMenuItem("Producto Alisado");
		mnNewMenu_6.add(mntmNewMenuItem_9);
		
		mnNewMenu_7 = new JMenu("REPORTES");
		menuBar.add(mnNewMenu_7);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		contenedor = new JDesktopPane();
		contenedor.setBackground(Color.LIGHT_GRAY);
		
		lblApellido = new JLabel("");
		lblApellido.setBounds(101, 34, 129, 14);
		contenedor.add(lblApellido);
		
		lblNombre = new JLabel("");
		lblNombre.setBounds(10, 34, 81, 14);
		contenedor.add(lblNombre);
		
		lblCodigo = new JLabel("");
		lblCodigo.setBounds(240, 34, 46, 14);
		contenedor.add(lblCodigo);
		contentPane.add(contenedor, "name_9347413971500");
	}
	
	void cargaReservaCitas(){
		frmCitas= new FrmReservaCitas();
		contenedor.add(frmCitas);
		frmCitas.show();
	}
	
	void cargaBoleta(){
		frmBoleta= new FrmBoleta();
		contenedor.add(frmBoleta);
		frmBoleta.show();
	}

	void cargaCitaHoy(){
		frmHoy= new FrmCitaFechaHoy();
		contenedor.add(frmHoy);
		frmHoy.show();
	}
	
	void cargaProBaor(){
		baor= new FrmProductoBaor();
		contenedor.add(baor);
		baor.show();
	}
		
	void cargaAlisados(){
		ali= new FrmAlisados();
		contenedor.add(ali);
		ali.show();
	}
	
	void cargaUsuario(){
		usuario= new FrmUsuario();
		contenedor.add(usuario);
		usuario.show();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNewMenuItem_6) {
			actionPerformedMntmNewMenuItem_6(e);
		}
		if (e.getSource() == mntmNewMenuItem_4) {
			actionPerformedMntmNewMenuItem_4(e);
		}
		if (e.getSource() == mntmNewMenuItem_3) {
			actionPerformedMntmNewMenuItem_3(e);
		}
		if (e.getSource() == mntmNewMenuItem_1) {
			actionPerformedMntmNewMenuItem_1(e);
		}
		if (e.getSource() == mntmNewMenuItem_2) {
			actionPerformedMntmNewMenuItem_2(e);
		}
		if (e.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(e);
		}
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		cargaReservaCitas();
	}
	protected void actionPerformedMntmNewMenuItem_2(ActionEvent e) {
		cargaBoleta();
	}
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent e) {
		cargaCitaHoy();
	}
	protected void actionPerformedMntmNewMenuItem_3(ActionEvent e) {
		cargaProBaor();
	}
	protected void actionPerformedMntmNewMenuItem_4(ActionEvent e) {
		cargaAlisados();
	}
	protected void actionPerformedMntmNewMenuItem_6(ActionEvent e) {
		cargaUsuario();
	}
}
