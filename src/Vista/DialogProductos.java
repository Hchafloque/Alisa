package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mantenimiento.GestionProducto;
import model.Producto;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DialogProductos extends JInternalFrame implements ActionListener {
	
	DefaultTableModel modelo = new DefaultTableModel();	
	
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JTable jtbProductos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogProductos frame = new DialogProductos();
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
	public DialogProductos() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Productos");
		setBounds(100, 100, 592, 255);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 553, 163);
		getContentPane().add(scrollPane);
		
		jtbProductos = new JTable();
		scrollPane.setViewportView(jtbProductos);
		
		btnNewButton = new JButton("AGREGAR");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(10, 191, 89, 23);
		getContentPane().add(btnNewButton);
		
		modelo.addColumn("Codigo");
        modelo.addColumn("Producto");
        modelo.addColumn("Stock");
        modelo.addColumn("Precio");
        jtbProductos.setModel(modelo);
        
        listarProductos();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	
	private void listarProductos() {
        GestionProducto gp = new GestionProducto();
        ArrayList<Producto> lista = gp.listarProductos();
        
        modelo.setRowCount(0);
        for (Producto p : lista) {
            Object fila[] = {p.getCodigoPro(), p.getNomPro(), p.getStock(), p.getPreciVenta()};
            modelo.addRow(fila);
        }
    }
	
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		
		try {
            
	        int fila=jtbProductos.getSelectedRow();
	        String codigoPro=jtbProductos.getModel().getValueAt(fila, 0).toString();
	        String producto=jtbProductos.getModel().getValueAt(fila, 1).toString();
	        int stock=Integer.parseInt(jtbProductos.getModel().getValueAt(fila, 2).toString());
	        double precio=Double.parseDouble(jtbProductos.getModel().getValueAt(fila, 3).toString());
	        
	        FrmBoleta.txtCodProducto.setText(codigoPro);
	        FrmBoleta.txtProducto.setText(producto);
	        FrmBoleta.txtStockPro.setText(stock+"");
	        FrmBoleta.txtPrecioProducto.setText(precio+"");  
	        
	        dispose();
	        } catch (Exception e1) {
	             JOptionPane.showMessageDialog(null, "Debe seleccionar un PRODUCTO","AVISO",JOptionPane.WARNING_MESSAGE);
	        }
	}
}
