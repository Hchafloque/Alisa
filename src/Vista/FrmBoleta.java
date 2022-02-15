package Vista;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import mantenimiento.GestionBoleta;
import mantenimiento.GestionVenta;
import model.Boleta;
import model.DetalleBoleta;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FrmBoleta extends JInternalFrame implements ActionListener {

	DefaultTableModel modelo = new DefaultTableModel();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	public static JTextField txtCliente; //
	public static JLabel lblCodCliente;  // 
	private JLabel lblNewLabel_3;
	private JTextField txtUsuario;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField txtNumeroBol;
	private JTextField txtFecha;
	private JPanel panel_3;
	private JLabel lblNewLabel_2;
	public static JTextField txtProducto;
	private JLabel lblNewLabel_10;
	public static JTextField txtStockPro;
	private JLabel lblNewLabel_11;
	public static JTextField txtCantidadPro;
	private JButton btnBuscarProducto;
	private JButton btnAgregarProducto;
	private JScrollPane scrollPane;
	private JTable jtbBoleta;
	private JTextField txtTotal;
	private JLabel lblNewLabel_12;
	private JButton btnNuevo;
	private JButton btnGenerarVenta;
	private JTextField txtcodUsuario;
	public static JTextField txtPrecioProducto;
	public static JTextField txtCodProducto;
	private JButton btnBuscaCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBoleta frame = new FrmBoleta();
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
	public FrmBoleta() {
		setClosable(true);
		setIconifiable(true);
		setTitle("BOLETA");
		setBounds(100, 100, 596, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("BOLETA DE VENTA");
		lblNewLabel.setBounds(243, 11, 141, 14);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 34, 309, 95);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Cliente:");
		lblNewLabel_1.setBounds(10, 22, 46, 14);
		panel.add(lblNewLabel_1);
		
		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setBounds(77, 19, 156, 20);
		panel.add(txtCliente);
		txtCliente.setColumns(10);
		
		lblCodCliente = new JLabel("");
		lblCodCliente.setBounds(54, 22, 25, 14);
		panel.add(lblCodCliente);
		
		lblNewLabel_3 = new JLabel("Usuario:");
		lblNewLabel_3.setBounds(10, 58, 56, 14);
		panel.add(lblNewLabel_3);
		
		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setBounds(77, 55, 156, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtcodUsuario = new JTextField();
		txtcodUsuario.setEditable(false);
		txtcodUsuario.setBounds(243, 55, 56, 20);
		panel.add(txtcodUsuario);
		txtcodUsuario.setColumns(10);
		
		btnBuscaCliente = new JButton("New button");
		btnBuscaCliente.addActionListener(this);
		btnBuscaCliente.setBounds(241, 18, 58, 26);
		panel.add(btnBuscaCliente);
		
		panel_1 = new JPanel();
		panel_1.setBounds(323, 23, 244, 106);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Boleta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_5 = new JLabel("R.U.C");
		lblNewLabel_5.setBounds(10, 22, 46, 14);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("10486599150");
		lblNewLabel_6.setBounds(107, 22, 103, 14);
		panel_1.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Numero:");
		lblNewLabel_7.setBounds(10, 47, 65, 14);
		panel_1.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Fecha:");
		lblNewLabel_8.setBounds(10, 78, 65, 14);
		panel_1.add(lblNewLabel_8);
		
		txtNumeroBol = new JTextField();
		txtNumeroBol.setEditable(false);
		txtNumeroBol.setBounds(71, 44, 152, 20);
		panel_1.add(txtNumeroBol);
		txtNumeroBol.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(71, 75, 152, 20);
		panel_1.add(txtFecha);
		txtFecha.setColumns(10);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Productos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setToolTipText("");
		panel_3.setBounds(10, 129, 557, 77);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Producto:");
		lblNewLabel_2.setBounds(10, 20, 64, 14);
		panel_3.add(lblNewLabel_2);
		
		txtProducto = new JTextField();
		txtProducto.setEditable(false);
		txtProducto.setBounds(72, 17, 231, 20);
		panel_3.add(txtProducto);
		txtProducto.setColumns(10);
		
		lblNewLabel_10 = new JLabel("Stock:");
		lblNewLabel_10.setBounds(10, 42, 46, 14);
		panel_3.add(lblNewLabel_10);
		
		txtStockPro = new JTextField();
		txtStockPro.setEditable(false);
		txtStockPro.setBounds(72, 42, 86, 20);
		panel_3.add(txtStockPro);
		txtStockPro.setColumns(10);
		
		lblNewLabel_11 = new JLabel("Cantidad:");
		lblNewLabel_11.setBounds(313, 48, 64, 14);
		panel_3.add(lblNewLabel_11);
		
		txtCantidadPro = new JTextField();
		txtCantidadPro.setBounds(364, 42, 106, 20);
		panel_3.add(txtCantidadPro);
		txtCantidadPro.setColumns(10);
		
		btnBuscarProducto = new JButton("Buscar");
		btnBuscarProducto.addActionListener(this);
		//btnBuscarProducto.addActionListener(this);
		btnBuscarProducto.setBounds(480, 16, 67, 23);
		panel_3.add(btnBuscarProducto);
		
		btnAgregarProducto = new JButton("+");
		btnAgregarProducto.addActionListener(this);
		//tbnAgregarProducto.addActionListener(this);
		btnAgregarProducto.setBounds(480, 41, 67, 23);
		panel_3.add(btnAgregarProducto);
		
		txtPrecioProducto = new JTextField();
		txtPrecioProducto.setEditable(false);
		txtPrecioProducto.setBounds(364, 17, 106, 20);
		panel_3.add(txtPrecioProducto);
		txtPrecioProducto.setColumns(10);
		
		txtCodProducto = new JTextField();
		txtCodProducto.setEditable(false);
		txtCodProducto.setBounds(227, 42, 76, 20);
		panel_3.add(txtCodProducto);
		txtCodProducto.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Precio: ");
		lblNewLabel_4.setBounds(313, 20, 46, 14);
		panel_3.add(lblNewLabel_4);
		
		lblNewLabel_9 = new JLabel("Codigo:");
		lblNewLabel_9.setBounds(171, 48, 46, 14);
		panel_3.add(lblNewLabel_9);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 217, 557, 189);
		contentPane.add(scrollPane);
		
		jtbBoleta = new JTable();
		scrollPane.setViewportView(jtbBoleta);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(481, 417, 86, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		lblNewLabel_12 = new JLabel("TOTAL:");
		lblNewLabel_12.setBounds(433, 420, 46, 14);
		contentPane.add(lblNewLabel_12);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 416, 102, 28);
		contentPane.add(btnNuevo);
		
		btnGenerarVenta = new JButton("GENERAR VENTA");
		btnGenerarVenta.addActionListener(this);
		btnGenerarVenta.setBounds(229, 416, 141, 28);
		contentPane.add(btnGenerarVenta);
		
		txtNumeroBol.setText(generarCodigo());
		
		//this.setLocationRelativeTo(null);
        modelo.addColumn("COD.pro");
        modelo.addColumn("COD.trata");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("PRE.UNITARIO");
        modelo.addColumn("IMPORTE");
        jtbBoleta.setModel(modelo);

        txtNumeroBol.setText(generarCodigo());

        txtFecha.setText(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));

        txtcodUsuario.setText(codigoUsu() + "");
        txtUsuario.setText(nombreUsuario());
        //txtNumeroBol
        bloquerBotones();
	}
	
	private int codigoUsu() {
        return Integer.parseInt(MenuPrincipal.lblCodigo.getText());
    }
	
	private String nombreUsuario() {
        return MenuPrincipal.lblNombre.getText() + " " + MenuPrincipal.lblApellido.getText();
    }
	
	String generarCodigo() {
		GestionBoleta gb=new GestionBoleta();
		return gb.generarCodigo();
	}
	
	double total;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_9;
	
	/*private void agregarAlisadosAlaBoleta() {
        int cantidad = 1;

        try {

            String CodAli = txtCodAlisado.getText();
            //cantidad=Integer.parseInt(txtCantidad.getText());
            String nomAlisado = txtAlisado.getText();
            double precioAlisado = Double.parseDouble(txtPrecioAlisado.getText());
            double importe = cantidad * precioAlisado;
            total += importe;
            txtTotal.setText(total + "");

            Object fila[] = {" ",CodAli, cantidad, nomAlisado, precioAlisado, importe};

            modelo.addRow(fila);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Campos ALISADOS vacios", "AVISO", JOptionPane.WARNING_MESSAGE);
        }
    }*/
	
	private void agregarProductosAlaBoleta() {
        String producto, codProducto;
        int cantidad = 0;
        double precioVenta, importe;
        try {

            codProducto = txtCodProducto.getText();
            producto = txtProducto.getText();
            cantidad = Integer.parseInt(txtCantidadPro.getText());
            if (cantidad == 0) {
                JOptionPane.showMessageDialog(null, "Indique la cantidad");
            } else {
                precioVenta = Double.parseDouble(txtPrecioProducto.getText());
                importe = cantidad * precioVenta;
                total += importe;
                txtTotal.setText(total + "");

                Object fila[] = {codProducto," ", cantidad, producto, precioVenta, importe};
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Campos PRODUCTOS vacios", "AVISO", JOptionPane.WARNING_MESSAGE);
        }
    }
	
	/*void limpiarAlisados() {
        //txtCodigoCli.setText("");
        //txtNombreCli.setText("");
        txtCodAlisado.setText("");
        txtAlisado.setText("");
        txtPrecioAlisado.setText("");
    }*/
	
	void bloquerBotones() {
		btnGenerarVenta.setEnabled(false);
		btnBuscaCliente.setEnabled(false);
		btnBuscarProducto.setEnabled(false);
		btnAgregarProducto.setEnabled(false);
    }

	void desbloquerBotones() {
		btnGenerarVenta.setEnabled(true);
		btnBuscaCliente.setEnabled(true);
		btnBuscarProducto.setEnabled(true);
		//btnAgregarProducto.setEnabled(true);
    }	
	
    void limpiarProductos() {
        txtProducto.setText("");
        txtCodProducto.setText("");
        txtStockPro.setText("");
        txtPrecioProducto.setText("");
        txtCantidadPro.setText("");
    }
    
    void LimpiarTodo() {
        lblCodCliente.setText("");
        txtCliente.setText("");
        txtNumeroBol.setText("");
        //txtCodAlisado.setText("");
        //txtAlisado.setText("");
        //txtPrecioAlisado.setText("");
        txtCodProducto.setText("");
        txtStockPro.setText("");
        txtProducto.setText("");
        txtPrecioProducto.setText("");
        txtCantidadPro.setText("");
        txtTotal.setText("");

    }
    
    private void realizarVenta() {
        try {
            String numbol = txtNumeroBol.getText(); 
            String fechabol = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            int codCliente = Integer.parseInt(lblCodCliente.getText());
            int codusuario = Integer.parseInt(codigoUsu() + "");
            double totalbol = this.total;
            if (totalbol > 0) {
                Boleta b = new Boleta();
                b.setNumBoleta(numbol);
                b.setFecBoleta(fechabol);
                b.setCodCliente(codCliente);
                b.setCodUsuario(codusuario);
                b.setTotalBoleta(totalbol);
                ArrayList<DetalleBoleta> det = new ArrayList<DetalleBoleta>();
                for (int row = 0; row < modelo.getRowCount(); row++) {
                    String codProducto = modelo.getValueAt(row, 0).toString();
                    String codTratamiento=modelo.getValueAt(row, 1).toString();
                    int cantidad = Integer.parseInt(modelo.getValueAt(row, 2).toString());
                    //String producto=modelo.getValueAt(row, 2).toString();
                    double preUnitario = Double.parseDouble(modelo.getValueAt(row, 4).toString());
                    double importe = Double.parseDouble(modelo.getValueAt(row, 5).toString());

                    DetalleBoleta d = new DetalleBoleta();
                    d.setCantidad(cantidad);
                    d.setCodProducto(codProducto);
                    d.setCodAlisado(codTratamiento);
                    d.setImporte(importe);
                    d.setNumBol(numbol);
                    d.setPrecioVenta(preUnitario);
                    det.add(d);
                }
                GestionVenta gv = new GestionVenta();
                int ok = gv.generarVenta(b, det);
                if (ok == -1) {
                    JOptionPane.showMessageDialog(null, "Ocurrio un Error en la venta ");
                } else {
                    JOptionPane.showMessageDialog(null, "Transaccion exitosa ");
                    LimpiarTodo();
                    modelo.setRowCount(0);
                    txtNumeroBol.setText(generarCodigo());
                    btnGenerarVenta.setEnabled(false);
                    //btnAgregarAlisado.setEnabled(false);
                    //btnAgregarAlisado.setEnabled(false);
                    btnAgregarProducto.setEnabled(false);
                    btnBuscarProducto.setEnabled(false);
                    total=0;

                }
            } else {
                JOptionPane.showMessageDialog(null, "Monto incorrecto");
            }
        } catch (NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error, pago no precesado"+e.getMessage());
        }
    }
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGenerarVenta) {
			actionPerformedBtnGenerarVenta(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnAgregarProducto) {
			actionPerformedTbnAgregarProducto(e);
		}
		if (e.getSource() == btnBuscarProducto) {
			actionPerformedBtnBuscarProducto(e);
		}
		if (e.getSource() == btnBuscaCliente) {
			actionPerformedBtnBuscaCliente(e);
		}
	}
	protected void actionPerformedBtnBuscaCliente(ActionEvent e) {
		DialogClientes dcliente = new DialogClientes();
		MenuPrincipal.contenedor.add(dcliente);
		dcliente.toFront();
		dcliente.setVisible(true);
	}
	protected void actionPerformedBtnBuscarProducto(ActionEvent e) {
		DialogProductos dpro = new DialogProductos();
		MenuPrincipal.contenedor.add(dpro);
		dpro.toFront();
		dpro.setVisible(true);
		btnAgregarProducto.setEnabled(true);
	}
	protected void actionPerformedTbnAgregarProducto(ActionEvent e) {
		agregarProductosAlaBoleta();
		limpiarProductos(); 
		btnAgregarProducto.setEnabled(false);
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		LimpiarTodo();
        txtNumeroBol.setText(generarCodigo());
        btnGenerarVenta.setEnabled(true);
        //btnBuscarAlisado.setEnabled(true);
        //btnAgregarAlisado.setEnabled(true);
        btnBuscaCliente.setEnabled(true);
        btnBuscarProducto.setEnabled(true);
        modelo.setRowCount(0);
        total=0;
        //btnAgregarProducto.setEnabled(true);
	}
	protected void actionPerformedBtnGenerarVenta(ActionEvent e) {
		realizarVenta();
	}
}
