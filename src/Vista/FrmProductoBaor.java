package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import mantenimiento.GestionProducto;
import model.CategoriaProducto;
import model.Producto;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmProductoBaor extends JInternalFrame implements ActionListener, MouseListener {

	private DefaultTableModel modelo=new DefaultTableModel();
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtCodigo;
	private JTextField txtStock;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtPrecioCompra;
	private JDateChooser jcFecha;
	private JTextField txtPrecioVenta;
	private JLabel lblNewLabel_6;
	private JScrollPane scrollPane;
	private JButton btnNuevo;
	private JTable jtProductos;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JComboBox cboProducto;
	private JLabel lblCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProductoBaor frame = new FrmProductoBaor();
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
	public FrmProductoBaor() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Registro de Productos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 610, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(10, 62, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Stock:");
		lblNewLabel_1.setBounds(10, 96, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(66, 59, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(66, 93, 86, 20);
		contentPane.add(txtStock);
		txtStock.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Producto:");
		lblNewLabel_2.setBounds(162, 62, 76, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Precio Venta:");
		lblNewLabel_3.setBounds(412, 96, 76, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Precio compra:");
		lblNewLabel_4.setBounds(402, 62, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Fecha Vencimiento:");
		lblNewLabel_5.setBounds(162, 96, 112, 14);
		contentPane.add(lblNewLabel_5);
		
		txtPrecioCompra = new JTextField();
		txtPrecioCompra.setBounds(498, 59, 86, 20);
		contentPane.add(txtPrecioCompra);
		txtPrecioCompra.setColumns(10);
		
		jcFecha = new JDateChooser();
		jcFecha.setBounds(282, 90, 99, 20);
		contentPane.add(jcFecha);
		
		txtPrecioVenta = new JTextField();
		txtPrecioVenta.setBounds(498, 93, 86, 20);
		contentPane.add(txtPrecioVenta);
		txtPrecioVenta.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Lista de Productos");
		lblNewLabel_6.setBounds(210, 11, 112, 14);
		contentPane.add(lblNewLabel_6);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 141, 574, 169);
		contentPane.add(scrollPane);
		
		jtProductos = new JTable();
		jtProductos.addMouseListener(this);
		scrollPane.setViewportView(jtProductos);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 321, 89, 23);
		contentPane.add(btnNuevo);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(121, 321, 89, 23);
		contentPane.add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(233, 321, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(344, 321, 89, 23);
		contentPane.add(btnEliminar);
	
        modelo.addColumn("CODIGO");
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("STOCK");
        modelo.addColumn("PRECIO COMPRA");
        modelo.addColumn("PRECIO VENTA");
        modelo.addColumn("FECHA VEMCIMIENTO");
        modelo.addColumn("COD.PRODUCTO");
                
        jtProductos.setModel(modelo);

        jtProductos.setRowHeight(30);
        //ELIMINO COLUMNA QUE NO DESEO MOSTRAR
        jtProductos.removeColumn(jtProductos.getColumnModel().getColumn(6));
        
        cboProducto = new JComboBox();
        cboProducto.setBounds(238, 58, 143, 22);
        contentPane.add(cboProducto);
		
        listarCBOCategoria();
        listarProductos();
        
        jcFecha.setDateFormatString("dd-MM-yyyy");
        
        txtCodigo.setText(generarCodigo());
        
        lblCodigo = new JLabel("");
        lblCodigo.setBounds(403, 121, 46, 14);
        contentPane.add(lblCodigo);
		bloquearBotones();
		bloquearCajas();
		txtCodigo.setEnabled(false);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		desbloquearBotones();
		desbloquearCajas();
		limpiar();
		txtCodigo.setText(generarCodigo());
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {		
		agregarProducto();
		listarProductos();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		modificarProducto();
		listarProductos();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {		
		eliminarProducto();
		listarProductos();		
	}
	
	private void listarCBOCategoria(){
		GestionProducto gp=new GestionProducto();
		ArrayList<CategoriaProducto>lista= gp.ListarCategoria();		
		cboProducto.addItem(new CategoriaProducto(0,"Seleccione"));	
		for (CategoriaProducto cate : lista) {
			cboProducto.addItem(cate);
		}
	}
	
	private void listarProductos() {
        GestionProducto gp = new GestionProducto();
        ArrayList<Producto> lista = gp.listarProductos();
        modelo.setRowCount(0);
        for (Producto p : lista) {
            Object[] fila = {p.getCodigoPro(),p.getNomPro(),p.getStock(), p.getPrecio(),p.getPreciVenta(), p.getFechaVenc(),p.getCod_cate(),};
            modelo.addRow(fila);
            
        }
    }

                                          
    void eliminarProducto() {
        String codigo = txtCodigo.getText();
        GestionProducto gp = new GestionProducto();
        int boton = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar Producto?");
        if (boton == 0) {
            int ok = gp.eliminar(codigo);
            if (ok == 0) {
                JOptionPane.showMessageDialog(null, "Error, codigo no encontrado", "AVISO", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Producto eliminado");
                limpiar();
                txtCodigo.setText(generarCodigo());
                listarProductos();
                bloquearBotones();
                bloquearCajas();
                txtCodigo.setText(generarCodigo());
            }
        }
    }

    void modificarProducto() {
        String codigo, fecha;
        int stock,nombrePro;
        double precio, precioVenta;

        codigo = txtCodigo.getText();
        nombrePro = cboProducto.getSelectedIndex();
        stock = Integer.parseInt(txtStock.getText());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        fecha = sf.format(jcFecha.getDate());
        precio = Double.parseDouble(txtPrecioCompra.getText());
        precioVenta = Double.parseDouble(txtPrecioVenta.getText());

        Producto p = new Producto();
        p.setCodigoPro(codigo);     
        p.setStock(stock);
        p.setPrecio(precio);
        p.setFechaVenc(fecha);
        p.setCodCatePro(nombrePro);
        p.setPreciVenta(precioVenta);

        GestionProducto gp = new GestionProducto();

        int ok = gp.modificar(p);
        if (ok == 0) {
            JOptionPane.showMessageDialog(null, "Error al modificar producto", "AVISO", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Producto modificado");
            limpiar();
            txtCodigo.setText(generarCodigo());
            listarProductos();
            bloquearBotones();
            bloquearCajas();
        }
    }

    void agregarProducto() {

        String codigo, fecha;
        int stock,nombrePro;
        double precio, precioVenta;

        codigo = txtCodigo.getText();
        nombrePro = cboProducto.getSelectedIndex();
        stock = Integer.parseInt(txtStock.getText());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        fecha = sf.format(jcFecha.getDate());
        precio = Double.parseDouble(txtPrecioCompra.getText());
        precioVenta = Double.parseDouble(txtPrecioVenta.getText());

        Producto p = new Producto();
        p.setCodigoPro(codigo);     
        p.setStock(stock);
        p.setPrecio(precio);
        p.setFechaVenc(fecha);
        p.setCodCatePro(nombrePro);
        p.setPreciVenta(precioVenta);

        GestionProducto gp = new GestionProducto();

        int ok = gp.registrar(p);
        if (ok == 0) {
            JOptionPane.showMessageDialog(null, "Error al registrar producto", "AVISO", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Producto Registrado");
            limpiar();
            txtCodigo.setText(generarCodigo());
            listarProductos();
            bloquearBotones();
            bloquearCajas();
        }
    }

    String generarCodigo() {
        GestionProducto gp = new GestionProducto();
        return gp.generarCodigio();
    }

    void bloquearCajas() {
    	cboProducto.setSelectedIndex(0);
        txtStock.setEnabled(false);
        txtPrecioCompra.setEnabled(false);
        jcFecha.setEnabled(false);
        txtPrecioVenta.setEnabled(false);
        cboProducto.setEnabled(false);
    }

    void desbloquearCajas() {
        cboProducto.setSelectedIndex(0);
        txtStock.setEnabled(true);
        txtPrecioCompra.setEnabled(true);
        jcFecha.setEnabled(true);
        txtPrecioVenta.setEnabled(true);
        cboProducto.setEnabled(true);
    }

    void bloquearBotones() {
        btnNuevo.setEnabled(true);
        btnAgregar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
    }

    void desbloquearBotones() {
    	btnNuevo.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnModificar.setEnabled(true);
    }
    
    void limpiar() {
        cboProducto.setSelectedIndex(0);
        txtStock.setText("");
        txtPrecioCompra.setText("");
        txtPrecioVenta.setText("");
        jcFecha.setDate(null);
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
		if (e.getSource() == jtProductos) {
			mouseReleasedJtProductos(e);
		}
	}
	protected void mouseReleasedJtProductos(MouseEvent e) {
		int fila = jtProductos.getSelectedRow();
        String codigo = jtProductos.getModel().getValueAt(fila, 0).toString();
        int stock = Integer.parseInt(jtProductos.getModel().getValueAt(fila, 2).toString());
        double precio = Double.parseDouble(jtProductos.getModel().getValueAt(fila, 3).toString());
        Date fechaBD = null;     
        try {
			fechaBD = new SimpleDateFormat("yyyy-MM-dd").parse(jtProductos.getModel().getValueAt(fila, 5).toString());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
       // String nomProducto = jtProductos.getModel().getValueAt(fila, 1).toString();
        int codProducto = Integer.parseInt(jtProductos.getModel().getValueAt(fila, 6).toString());
        double precioVenta = Double.parseDouble(jtProductos.getModel().getValueAt(fila, 4).toString());
                        
        txtCodigo.setText(codigo);
        cboProducto.setSelectedIndex(codProducto);
        txtStock.setText(stock + "");
        txtPrecioCompra.setText(precio + "");
        jcFecha.setDate(fechaBD);
        txtPrecioVenta.setText(precioVenta + "");
        
	}
}
