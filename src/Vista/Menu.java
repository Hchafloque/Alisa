package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Frame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu_4;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenu mnNewMenu_5;
	private JMenu mnNewMenu_6;
	private JMenu mnNewMenu_7;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem mntmNewMenuItem_8;
	private JMenuItem mntmNewMenuItem_9;
	private JMenu mnNewMenu_8;
	private JMenuItem mntmNewMenuItem_10;
	private JMenuItem mntmNewMenuItem_11;
	public static JLabel lblNombre;
	public static JLabel lblApellido;
	public static JLabel lblCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("MENU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 365);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Agendar/Citas");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Reservar Cita");
		mntmNewMenuItem.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_10 = new JMenuItem("Citas de hoy");
		mntmNewMenuItem_10.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem_10);
		
		mnNewMenu_1 = new JMenu("Ventas");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_1 = new JMenuItem("Boleta");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		mnNewMenu_2 = new JMenu("Inventario");
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_2 = new JMenuItem("Productos Baor");
		mntmNewMenuItem_2.addActionListener(this);
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_3 = new JMenuItem("Producto Alisados");
		mntmNewMenuItem_3.addActionListener(this);
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		mnNewMenu_3 = new JMenu("Clientes");
		menuBar.add(mnNewMenu_3);
		
		mntmNewMenuItem_4 = new JMenuItem("Listado de clientes");
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		mnNewMenu_4 = new JMenu("Usuarios");
		menuBar.add(mnNewMenu_4);
		
		mntmNewMenuItem_5 = new JMenuItem("Agregar Usuario");
		mntmNewMenuItem_5.addActionListener(this);
		mnNewMenu_4.add(mntmNewMenuItem_5);
		
		mnNewMenu_5 = new JMenu("Personal");
		menuBar.add(mnNewMenu_5);
		
		mntmNewMenuItem_11 = new JMenuItem("Personal Salon");
		mntmNewMenuItem_11.addActionListener(this);
		mnNewMenu_5.add(mntmNewMenuItem_11);
		
		mnNewMenu_6 = new JMenu("Egresos");
		menuBar.add(mnNewMenu_6);
		
		mntmNewMenuItem_7 = new JMenuItem("Producto Baor");
		mnNewMenu_6.add(mntmNewMenuItem_7);
		
		mntmNewMenuItem_8 = new JMenuItem("Producto Alisado");
		mnNewMenu_6.add(mntmNewMenuItem_8);
		
		mntmNewMenuItem_9 = new JMenuItem("Otros");
		mnNewMenu_6.add(mntmNewMenuItem_9);
		
		mnNewMenu_7 = new JMenu("Reportes");
		menuBar.add(mnNewMenu_7);
		
		mnNewMenu_8 = new JMenu("Salir");
		menuBar.add(mnNewMenu_8);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("");
		lblNombre.setBounds(32, 33, 79, 14);
		contentPane.add(lblNombre);
		
		lblApellido = new JLabel("");
		lblApellido.setBounds(110, 33, 91, 14);
		contentPane.add(lblApellido);
		
		lblCodigo = new JLabel("");
		lblCodigo.setBounds(219, 33, 68, 14);
		contentPane.add(lblCodigo);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNewMenuItem_5) {
			actionPerformedMntmNewMenuItem_5(e);
		}
		if (e.getSource() == mntmNewMenuItem_3) {
			actionPerformedMntmNewMenuItem_3(e);
		}
		if (e.getSource() == mntmNewMenuItem_2) {
			actionPerformedMntmNewMenuItem_2(e);
		}
		if (e.getSource() == mntmNewMenuItem_11) {
			actionPerformedMntmNewMenuItem_11(e);
		}
		if (e.getSource() == mntmNewMenuItem_10) {
			actionPerformedMntmNewMenuItem_10(e);
		}
		if (e.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(e);
		}
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		FrmReservaCitas reserva=new FrmReservaCitas();
		reserva.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_10(ActionEvent e) {
		FrmCitaFechaHoy hoy=new FrmCitaFechaHoy();
		hoy.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_11(ActionEvent e) {
		FrmPeronsonalSalon personal=new FrmPeronsonalSalon();
		personal.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_2(ActionEvent e) {
		FrmProductoBaor baor=new FrmProductoBaor();
		baor.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_3(ActionEvent e) {
		FrmAlisados ali=new FrmAlisados();
		ali.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_5(ActionEvent e) {
		FrmUsuario usu=new FrmUsuario();
		usu.setVisible(true);
	} 
}
