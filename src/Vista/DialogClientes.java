package Vista;

import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import mantenimiento.GestionCliente;
import model.Clientes;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class DialogClientes extends JInternalFrame implements ActionListener {

	private DefaultTableModel modelo=new DefaultTableModel();
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable jtbClientesVenta;
	private JButton btnEnviar;
	private JLabel lblNewLabel_1;
	private JDateChooser jcFechaBuscar;
	private JButton btnBuscarPorFecha;
	private JPanel panel;
	private JPanel panel_1;
	private JRadioButton rbNombre;
	private JRadioButton rbApellido;
	private JButton btnBuscarRadioB;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtNonmbreApellido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogClientes frame = new DialogClientes();
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
	public DialogClientes() {
		setIconifiable(true);
		setClosable(true);
		setTitle("CLIENTES");
		setBounds(100, 100, 553, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 517, 163);
		contentPane.add(scrollPane);
		
		jtbClientesVenta = new JTable();
		scrollPane.setViewportView(jtbClientesVenta);
		
		btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(this);
		btnEnviar.setBounds(406, 179, 121, 37);
		contentPane.add(btnEnviar);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 179, 386, 37);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Fecha:");
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel_1);
		
		jcFechaBuscar = new JDateChooser();
		jcFechaBuscar.setBounds(66, 7, 151, 23);
		panel.add(jcFechaBuscar);
		
		btnBuscarPorFecha = new JButton("BUSCAR");
		btnBuscarPorFecha.addActionListener(this);
		btnBuscarPorFecha.setBounds(252, 7, 111, 23);
		panel.add(btnBuscarPorFecha);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 221, 517, 37);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		rbNombre = new JRadioButton("Nombre");
		buttonGroup.add(rbNombre);
		rbNombre.setBounds(31, 7, 75, 18);
		panel_1.add(rbNombre);
		
		rbApellido = new JRadioButton("Apellido");
		buttonGroup.add(rbApellido);
		rbApellido.setBounds(138, 7, 75, 18);
		panel_1.add(rbApellido);
		
		btnBuscarRadioB = new JButton("BUSCAR");
		btnBuscarRadioB.addActionListener(this);
		btnBuscarRadioB.setBounds(396, 5, 111, 23);
		panel_1.add(btnBuscarRadioB);
		
		txtNonmbreApellido = new JTextField();
		txtNonmbreApellido.setBounds(235, 8, 136, 20);
		panel_1.add(txtNonmbreApellido);
		txtNonmbreApellido.setColumns(10);
		
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRES/APELLIDOS");
		modelo.addColumn("FECHA");
		modelo.addColumn("HORA");
		jtbClientesVenta.setModel(modelo);
		
		jtbClientesVenta.getColumnModel().getColumn(0).setPreferredWidth(45);
		jtbClientesVenta.getColumnModel().getColumn(0).setResizable(false);
		jtbClientesVenta.getColumnModel().getColumn(1).setPreferredWidth(150);
		jtbClientesVenta.getColumnModel().getColumn(1).setResizable(false);
		jtbClientesVenta.getColumnModel().getColumn(2).setPreferredWidth(70);
		jtbClientesVenta.getColumnModel().getColumn(2).setResizable(false);
		jtbClientesVenta.getColumnModel().getColumn(3).setPreferredWidth(40);
		jtbClientesVenta.getColumnModel().getColumn(3).setResizable(false);
		jtbClientesVenta.setRowHeight(30);
		
		jcFechaBuscar.setDateFormatString("dd/MM/yyyy");
		jcFechaBuscar.setDate(new Date());
		listarClientes();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviar) {
			actionPerformedBtnEnviar(e);
		}
		if (e.getSource() == btnBuscarRadioB) {
			actionPerformedBtnBuscarRadioB(e);
		}
		if (e.getSource() == btnBuscarPorFecha) {
			actionPerformedBtnBuscarPorFecha(e);
		}
	}
	protected void actionPerformedBtnBuscarPorFecha(ActionEvent e) {
		listarPorFecha();
	}
	protected void actionPerformedBtnBuscarRadioB(ActionEvent e) {
		buscarNombrePorApellido();
	}
	protected void actionPerformedBtnEnviar(ActionEvent e) {
		AgregarCliente();
	}
	
	 private void listarPorFecha() {

	        try {
	            DateFormat d = new SimpleDateFormat("yyyy-MM-dd");
	            String fecha = d.format(jcFechaBuscar.getDate());
	            GestionCliente gc = new GestionCliente();
	            ArrayList<Clientes> lista = gc.ReportePorFecha(fecha);

	            modelo.setRowCount(0);
	            for (Clientes c : lista) {
	                Object fila[] = {c.getCodCli(), c.getNombre()+" "+c.getApellido(), c.getFecha(), c.getHora()};
	                modelo.addRow(fila);
	            }
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Seleccione una fecha ");
	        }
	    }

	    private void AgregarCliente() {

	        try {
	            int fila = jtbClientesVenta.getSelectedRow();
	            String codigoCli = jtbClientesVenta.getModel().getValueAt(fila, 0).toString();
	            String nombresCli = jtbClientesVenta.getModel().getValueAt(fila, 1).toString();
	            
	            FrmBoleta.lblCodCliente.setText(codigoCli);
	            FrmBoleta.txtCliente.setText(nombresCli);
	            dispose();
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Debe seleccionar un CLIENTE", "AVISO", JOptionPane.WARNING_MESSAGE);
	        }
	    }

	    private void listarClientes() {
	    	 DateFormat d = new SimpleDateFormat("yyyy-MM-dd");
	         String fecha = d.format(jcFechaBuscar.getDate());
	        GestionCliente gc = new GestionCliente();
	        ArrayList<Clientes> lista = gc.ReportePorFecha(fecha);

	        for (Clientes c : lista) {
	            Object[] fila = {c.getCodCli(), c.getNombre() + " " + c.getApellido(), c.getFecha(), c.getHora()};
	            modelo.addRow(fila);
	        }
	    }

	    private void buscarNombrePorApellido() {

	        String nombre = txtNonmbreApellido.getText();
	        GestionCliente gc = new GestionCliente();
	        ArrayList<Clientes> lista = gc.buscarPorNombre(nombre);
	        String apellido = txtNonmbreApellido.getText();
	        ArrayList<Clientes> lis = gc.buscarPorApellido(apellido);
	        modelo.setRowCount(0);
	        if (rbNombre.isSelected() == true) {
	            for (Clientes c : lista) {
	                Object[] fila = {c.getCodCli(), c.getNombre() + " " + c.getApellido(), c.getFecha(), c.getHora()};
	                modelo.addRow(fila);
	            }
	        }
	        if (rbApellido.isSelected() == true) {
	            for (Clientes c : lis) {
	                Object[] fila = {c.getCodCli(), c.getNombre() + " " + c.getApellido(), c.getFecha(), c.getHora()};
	                modelo.addRow(fila);
	            }
	        }
	        if (nombre.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Agrege un nombre o un apellido a la caja de texto");
	        }
	    }	
}
