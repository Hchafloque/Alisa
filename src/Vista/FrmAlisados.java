package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import mantenimiento.GestionAlisados;
import mantenimiento.GestionProducto;
import model.Alisados;
import model.Producto;
import model.TipoAlisado;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;

public class FrmAlisados extends JInternalFrame implements ActionListener, MouseListener{
//JInternalFrame implements ActionListener
	//JFrame implements ActionListener, MouseListener
	private DefaultTableModel modelo=new DefaultTableModel();
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JTextField txtCodigo;
	private JLabel lblNewLabel_2;
	private JComboBox cboTratamiento;
	private JLabel lblNewLabel_3;
	private JTextField txtPrecio;
	private JScrollPane scrollPane;
	private JTable jtAlisados;
	private JButton btnNuevo;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JDateChooser jcFecha;
	private JLabel lblNewLabel_6;
	private JTextField txtStockTra;
	private JTextField txtPrecioVen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAlisados frame = new FrmAlisados();
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
	public FrmAlisados() {
		setClosable(true);
		setIconifiable(true);
		setTitle("ALISADOS/TRATAMIENTOS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 618, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("REGISTRO DE ALISADOS PERMANENTES Y TRATAMIENTO CAPILAR");
		lblNewLabel.setBounds(114, 11, 377, 14);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBounds(10, 37, 582, 84);
		panel.setBorder(new LineBorder(Color.DARK_GRAY));
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Codigo:");
		lblNewLabel_1.setBounds(10, 11, 51, 14);
		panel.add(lblNewLabel_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(59, 8, 42, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Alisado/Tratamiento:");
		lblNewLabel_2.setBounds(127, 11, 132, 14);
		panel.add(lblNewLabel_2);
		
		cboTratamiento = new JComboBox();
		cboTratamiento.setBounds(255, 7, 141, 22);
		panel.add(cboTratamiento);
		
		lblNewLabel_3 = new JLabel("Precio:");
		lblNewLabel_3.setBounds(427, 11, 62, 14);
		panel.add(lblNewLabel_3);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(484, 8, 86, 20);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 132, 582, 204);
		contentPane.add(scrollPane);
		
		jtAlisados = new JTable();
		jtAlisados.addMouseListener(this);
		//jtAlisados.addMouseListener(this);
		scrollPane.setViewportView(jtAlisados);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 344, 119, 23);
		contentPane.add(btnNuevo);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(162, 344, 119, 23);
		contentPane.add(btnAgregar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(313, 344, 119, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(451, 344, 119, 23);
		contentPane.add(btnEliminar);
		
		modelo.addColumn("CODIGO");
        modelo.addColumn("ALISADO");
        modelo.addColumn("STOCK");
        modelo.addColumn("PRECIO COMPRA");
        modelo.addColumn("PRECIO VENTA");
        modelo.addColumn("FECHA VEMCIMIENTO");
        modelo.addColumn("COD.ALISADO");
		jtAlisados.setModel(modelo);
		
		jtAlisados.setRowHeight(30);
        //ELIMINO COLUMNA QUE NO DESEO MOSTRAR
		jtAlisados.removeColumn(jtAlisados.getColumnModel().getColumn(6));
		
		listarTratamientos();
		listarTipoAlisado();
		txtCodigo.setText(generarCodigoAlisado()+"");
		bloquearBotones();
		//bloquearTextos();
		txtCodigo.setEnabled(false);
		
		lblNewLabel_4 = new JLabel("Stock:");
		lblNewLabel_4.setBounds(10, 56, 46, 14);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Fecha Vencimiento:");
		lblNewLabel_5.setBounds(152, 56, 112, 14);
		panel.add(lblNewLabel_5);
		
		jcFecha = new JDateChooser();
		jcFecha.setBounds(272, 50, 99, 20);
		panel.add(jcFecha);
		
		lblNewLabel_6 = new JLabel("Precio Venta:");
		lblNewLabel_6.setBounds(402, 56, 76, 14);
		panel.add(lblNewLabel_6);
		
		txtStockTra = new JTextField();
		txtStockTra.setBounds(47, 53, 86, 20);
		panel.add(txtStockTra);
		txtStockTra.setColumns(10);
		
		txtPrecioVen = new JTextField();
		txtPrecioVen.setBounds(484, 53, 86, 20);
		panel.add(txtPrecioVen);
		txtPrecioVen.setColumns(10);
	}
	
	private void listarTratamientos(){
        GestionAlisados ga= new GestionAlisados();
        ArrayList<Alisados> lista= ga.listarAlisados();        
        modelo.setRowCount(0);
        for (Alisados a : lista) {
			Object[] fila= {a.getCodAlisado(),a.getNomAli(),a.getStock(),a.getPrecio(),a.getPreciVenta(),a.getFechaVenc(),a.getCodTipo()};
			modelo.addRow(fila);
		}
    }
	
	private void listarTipoAlisado(){
        GestionAlisados ga= new GestionAlisados();
        ArrayList<TipoAlisado> lista= ga.listarTipoAlisados();        
        cboTratamiento.addItem(new TipoAlisado(0,"Seleccione"));
        for (TipoAlisado t : lista) {
			cboTratamiento.addItem(t);
		}
    }
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtmModificar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		limpiar();
		listarTratamientos();
		desbloquearBotones();
		desbloquearTextos();
		txtCodigo.setText(generarCodigoAlisado()+"");		
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		agregarAlisado();
		listarTratamientos();
	}
	protected void actionPerformedBtmModificar(ActionEvent e) {
		modificarAlisado();
		listarTratamientos();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminar();
		listarTratamientos();
	}
	private String generarCodigoAlisado() {
		GestionAlisados ga=new GestionAlisados();
		return ga.generarCodigo();
	}

	void bloquearTextos() {
		cboTratamiento.setEnabled(false);
		txtPrecio.setEnabled(false);
		//txtPrecioVen.setEnabled(false);
		//txtStockTra.setEnabled(false);
	}
	void desbloquearTextos() {
		cboTratamiento.setEnabled(true);
		txtPrecio.setEnabled(true); 
		//txtprecioVen.setEnabled(true);
		//txtStocktra.setEnabled(true);
	}
	
	void bloquearBotones() {
		btnAgregar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnModificar.setEnabled(false);
		btnNuevo.setEnabled(true);
	}
	void desbloquearBotones() {
		btnAgregar.setEnabled(true);
		btnEliminar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnNuevo.setEnabled(false);
	}
	void agregarAlisado() {
		String codigo, fecha;
        int stock,nombreAli;
        double precio, precioVenta;
        
        codigo = txtCodigo.getText();
        nombreAli = cboTratamiento.getSelectedIndex();
        stock = Integer.parseInt(txtStockTra.getText());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        fecha = sf.format(jcFecha.getDate());
        precio = Double.parseDouble(txtPrecio.getText());
        precioVenta = Double.parseDouble(txtPrecioVen.getText());
        								 

		Alisados a= new Alisados();
		a.setCodAlisado(codigo);     
        a.setStock(stock);
        a.setPrecio(precio);
        a.setFechaVenc(fecha);
        a.setCodTipo(nombreAli);
        a.setPreciVenta(precioVenta);		
		GestionAlisados ga=new GestionAlisados();
		int ok=ga.agregar(a);			
		if(ok==0) {
			JOptionPane.showMessageDialog(null, "Error al agregar alisado", "AVISO", JOptionPane.WARNING_MESSAGE);			
		}else {
			JOptionPane.showMessageDialog(null, "Alisado registrado");
			limpiar();
			bloquearBotones();
			bloquearTextos();
			listarTratamientos();
			txtCodigo.setText(generarCodigoAlisado()+"");
		}
	}
	
	void modificarAlisado() {
		String codigo, fecha;
        int stock,nombreAli;
        double precio, precioVenta;
        
        codigo = txtCodigo.getText();
        nombreAli = cboTratamiento.getSelectedIndex();
        stock = Integer.parseInt(txtStockTra.getText());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        fecha = sf.format(jcFecha.getDate());
        precio = Double.parseDouble(txtPrecio.getText());
        precioVenta = Double.parseDouble(txtPrecioVen.getText());

		Alisados a= new Alisados();
		a.setCodAlisado(codigo);     
        a.setStock(stock);
        a.setPrecio(precio);
        a.setFechaVenc(fecha);
        a.setCodTipo(nombreAli);
        a.setPreciVenta(precioVenta);	
        
		GestionAlisados ga=new GestionAlisados();
		
		int ok=ga.modificar(a);			
		if(ok==0) {
			JOptionPane.showMessageDialog(null, "Error al modificar Modificar", "AVISO", JOptionPane.WARNING_MESSAGE);			
		}else {
			JOptionPane.showMessageDialog(null, "Alisado Modificado");
			limpiar();
			bloquearBotones();
			bloquearTextos();
			listarTratamientos();
			txtCodigo.setText(generarCodigoAlisado()+"");
		}
	}
	
	void eliminar() {
		int cod;
		cod=Integer.parseInt(txtCodigo.getText());
		GestionAlisados ga=new GestionAlisados();
		
		int boton=JOptionPane.showConfirmDialog(null, "Seguro que dese eiminar ");
		if(boton==0) {
			int ok=ga.eliminar(cod);
			if(ok<0) {
				JOptionPane.showMessageDialog(null, "Error al eliminar Alisado/Tatamiento","SISTEMA",JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Alisado/Tatamiento eliminado");
				limpiar();
				bloquearBotones();
				bloquearTextos();
				listarTratamientos();
				txtCodigo.setText(generarCodigoAlisado()+"");
			}
		}
	}
	
	void limpiar() {
		cboTratamiento.setSelectedIndex(0);
		txtPrecio.setText("");
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == jtAlisados) {
			mouseReleasedJtAlisados(e);
		}
	}
	protected void mouseReleasedJtAlisados(MouseEvent e) {
		int fila=jtAlisados.getSelectedRow();
		int codigo=Integer.parseInt(jtAlisados.getModel().getValueAt(fila, 0).toString()); 	    
		int alisado=Integer.parseInt(jtAlisados.getModel().getValueAt(fila, 3).toString());
		double precio=Double.parseDouble(jtAlisados.getModel().getValueAt(fila, 2).toString());
				
		txtCodigo.setText(codigo+"");
		txtPrecio.setText(precio+"");
		cboTratamiento.setSelectedIndex(alisado);
	}
}
