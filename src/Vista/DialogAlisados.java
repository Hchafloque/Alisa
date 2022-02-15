package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mantenimiento.GestionAlisados;
import mantenimiento.GestionTratamiento;
import model.Alisados;
import model.Tratamiento;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DialogAlisados extends JInternalFrame implements ActionListener {
	
	DefaultTableModel modelo=new DefaultTableModel();
	
	private JScrollPane scrollPane;
	private JTable jtAlisados;
	private JButton btnEnviar;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogAlisados frame = new DialogAlisados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 

	public DialogAlisados() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Lista de Tratamientos");
		setBounds(100, 100, 558, 285);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 517, 163);
		getContentPane().add(scrollPane);
		
		jtAlisados = new JTable();
		//jtAlisados.addMouseListener(this);
		scrollPane.setViewportView(jtAlisados);
        
        btnEnviar = new JButton("ENVIAR");
        btnEnviar.addActionListener(this);
        btnEnviar.setBounds(10, 196, 89, 23);
        getContentPane().add(btnEnviar);
        
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        jtAlisados.setModel(modelo);
        jtAlisados.setRowHeight(30);
        
        listarTratamientos();		
	}

	void listarTratamientos(){
		/*GestionTratamiento gt= new GestionTratamiento();
        ArrayList<Tratamiento> lista= gt.listarTratamientos();
        
        modelo.setRowCount(0);
        for (Tratamiento t : lista) {
            Object fila[]={t.getCodTratamiento(),t.getNomTratami(),t.getPrecio()};
            modelo.addRow(fila);
        }*/
		GestionAlisados ga= new GestionAlisados();
        ArrayList<Alisados> lista= ga.listarAlisados();        
        modelo.setRowCount(0);
        for (Alisados a : lista) {
			Object[] fila= {a.getCodAlisado(),a.getNomAli(),a.getPrecio(),a.getCodTipo()};
			modelo.addRow(fila);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviar) {
			actionPerformedBtnEnviar(e);
		}
	}
	protected void actionPerformedBtnEnviar(ActionEvent e) {	
		
		try {
			int fila=jtAlisados.getSelectedRow();
	        String codigo=jtAlisados.getModel().getValueAt(fila, 0).toString();
	        String tratamiento=jtAlisados.getModel().getValueAt(fila, 1).toString();
	        double precio=Double.parseDouble(jtAlisados.getModel().getValueAt(fila, 2).toString());
	        
	        //FrmBoleta.txtCodAlisado.setText(codigo+"");
	        //FrmBoleta.txtPrecioAlisado.setText(precio+"");
	        //FrmBoleta.txtAlisado.setText(tratamiento);
	        
	        dispose();
	             
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un Tratamiento","AVISO",JOptionPane.WARNING_MESSAGE);
		}
	}
}
