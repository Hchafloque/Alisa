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
import javax.swing.UIManager;
import com.toedter.calendar.JDateChooser;

import mantenimiento.GestionPersonal;
import model.Personal;

import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmPeronsonalSalon extends JInternalFrame implements ActionListener, MouseListener {

	DefaultTableModel modelo=new DefaultTableModel();
	
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtCodigo;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JLabel lblNewLabel_4;
	private JTextField txtDireccion;
	private JLabel lblNewLabel_5;
	private JTextField txtCorreo;
	private JLabel lblNewLabel_6;
	private JTextField txtTelefono;
	private JLabel lblNewLabel_7;
	private JTextField txtDni;
	private JLabel lblNewLabel_8;
	private JDateChooser jcFecha;
	private JScrollPane scrollPane;
	private JButton btnNuevo;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable tbPersonal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPeronsonalSalon frame = new FrmPeronsonalSalon();
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
	public FrmPeronsonalSalon() {
		setClosable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 696, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panel.setBounds(10, 42, 660, 113);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Codigo:");
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("");
		txtCodigo.setBounds(66, 8, 86, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Nombres:");
		lblNewLabel_2.setBounds(195, 11, 73, 14);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Apellidos:");
		lblNewLabel_3.setBounds(437, 11, 62, 14);
		panel.add(lblNewLabel_3);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(267, 8, 141, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(509, 8, 141, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_4.setBounds(10, 48, 73, 14);
		panel.add(lblNewLabel_4);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(76, 45, 180, 20);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Correo:");
		lblNewLabel_5.setBounds(312, 48, 46, 14);
		panel.add(lblNewLabel_5);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(372, 45, 278, 20);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Telefono:");
		lblNewLabel_6.setBounds(10, 84, 73, 14);
		panel.add(lblNewLabel_6);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(86, 81, 105, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		lblNewLabel_7 = new JLabel("DNI:");
		lblNewLabel_7.setBounds(222, 84, 46, 14);
		panel.add(lblNewLabel_7);
		
		txtDni = new JTextField();
		txtDni.setBounds(271, 81, 111, 20);
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Fecha Ingreso:");
		lblNewLabel_8.setBounds(419, 84, 105, 14);
		panel.add(lblNewLabel_8);
		
		jcFecha = new JDateChooser();
		jcFecha.setBounds(509, 81, 141, 20);
		panel.add(jcFecha);
		
		lblNewLabel = new JLabel("REGISTRO DE PERSONAL");
		lblNewLabel.setBounds(257, 11, 146, 14);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 166, 660, 210);
		contentPane.add(scrollPane);
		
		tbPersonal = new JTable();
		tbPersonal.addMouseListener(this);
		scrollPane.setViewportView(tbPersonal);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 387, 89, 23);
		contentPane.add(btnNuevo);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(127, 387, 89, 23);
		contentPane.add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(243, 387, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(354, 387, 89, 23);
		contentPane.add(btnEliminar);
		
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDO");
		modelo.addColumn("DIRECCION");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("CORREO");
		modelo.addColumn("DNI");
		modelo.addColumn("FECHA");
		tbPersonal.setModel(modelo);
		
		tbPersonal.setRowHeight(30);
		
		txtCodigo.setText(generarcodigo()+"");
		listarPersonal();
		jcFecha.setDateFormatString("dd-MM-yyyy");
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
		generarcodigo();
		listarPersonal();
		desbloquearBotones();
		desbloquearCajas();
		limpiar();
		txtCodigo.setText(generarcodigo()+"");
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		txtCodigo.setText(generarcodigo()+"");
		registrarPersonal();
		listarPersonal();
		bloquearBotones();
		bloquearCajas();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		modificarPersonal();
		listarPersonal();
		bloquearBotones();
		bloquearCajas();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminar();
		listarPersonal();
		bloquearBotones();
		bloquearCajas();
		txtCodigo.setText(generarcodigo()+"");
	}
	
	private void eliminar() {
        int codigo = Integer.parseInt(txtCodigo.getText());
        GestionPersonal gc = new GestionPersonal();

        int boton = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar Personal?");
        if (boton == 0) {
            int ok = gc.eliminar(codigo);
            if (ok == 0) {
                JOptionPane.showMessageDialog(null, "Error, codigo no registrado", "AVISO", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Personal eliminado");
                limpiar();
                txtCodigo.setText(generarcodigo()+"");
            }
        }
    }
	
	private void listarPersonal() {
        GestionPersonal gc = new GestionPersonal();
        ArrayList<Personal> lista = gc.listarPersonal();

        modelo.setRowCount(0);
        for (Personal p : lista) {
            Object fila[] = {p.getCodEmpleado(), p.getNombre(), p.getApelido(), p.getDireccion(), p.getTelefono(), p.getCorreo(), p.getDni(),p.getFecha()};
            modelo.addRow(fila);
        }
    }

    private void modificarPersonal() {

        int codigo, dni;
        String nombre, apellido, direccion, telefono, correo,fecha;

        codigo = Integer.parseInt(txtCodigo.getText());
        nombre = txtNombre.getText();
        apellido = txtApellido.getText();
        direccion = txtDireccion.getText();
        telefono = txtTelefono.getText();
        correo = txtCorreo.getText();
        dni = Integer.parseInt(txtDni.getText());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        fecha=sdf.format(jcFecha.getDate());

        Personal p = new Personal();
        p.setCodEmpleado(codigo);
        p.setNombre(nombre);
        p.setApelido(apellido);
        p.setDireccion(direccion);
        p.setTelefono(telefono);
        p.setCorreo(correo);
        p.setDni(dni+"");
        p.setFecha(fecha);

        GestionPersonal gp = new GestionPersonal();
        int ok = gp.modificar(p);
        if (ok == 0) {
            JOptionPane.showMessageDialog(null, "Error al modificar personal", "AVISO", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Personal modificado");
            limpiar();
            txtCodigo.setText(generarcodigo()+"");
        }
    }

    private void registrarPersonal() {
        int codigo, dni;
        String nombre, apellido, direccion, telefono, correo,fecha;

        codigo = Integer.parseInt(txtCodigo.getText());
        nombre = txtNombre.getText();
        apellido = txtApellido.getText();
        direccion = txtDireccion.getText();
        telefono = txtTelefono.getText();
        correo = txtCorreo.getText();
        dni = Integer.parseInt(txtDni.getText());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        fecha=sdf.format(jcFecha.getDate());
        
        Personal p = new Personal();
        p.setCodEmpleado(codigo);
        p.setNombre(nombre);
        p.setApelido(apellido);
        p.setDireccion(direccion);
        p.setTelefono(telefono);
        p.setCorreo(correo);
        p.setDni(dni+"");
        p.setFecha(fecha);
        
        GestionPersonal gp = new GestionPersonal();
        int ok = gp.registrar(p);
        if (ok == 0) {
            JOptionPane.showMessageDialog(null, "Error, codigo no registrado", "AVISO", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Personal Registrado");
            limpiar();
            txtCodigo.setText(generarcodigo()+"");
        }
    }

    private int generarcodigo() {
        GestionPersonal gp = new GestionPersonal();
        return gp.generarCodigio();
    }

    void bloquearCajas() {

        txtNombre.setEnabled(false);
        txtApellido.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtCorreo.setEnabled(false);
        txtDni.setEnabled(false);

    }

    void desbloquearCajas() {

        txtNombre.setEnabled(true);
        txtApellido.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtCorreo.setEnabled(true);
        txtDni.setEnabled(true);
    }
    
    void bloquearBotones(){
        btnNuevo.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnAgregar.setEnabled(false);
    }
    void desbloquearBotones(){
    	btnNuevo.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnAgregar.setEnabled(true);
    }
	void limpiar() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtDireccion.setText("");
		txtCorreo.setText("");
		jcFecha.setDate(null);
		txtTelefono.setText("");
		txtDni.setText("");
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
		if (e.getSource() == tbPersonal) {
			mouseReleasedTbPersonal(e);
		}
	}
	protected void mouseReleasedTbPersonal(MouseEvent e) {
		int fila = tbPersonal.getSelectedRow();
        int codigo = Integer.parseInt(tbPersonal.getModel().getValueAt(fila, 0).toString());
        String nombre = tbPersonal.getModel().getValueAt(fila, 1).toString();
        String apellido = tbPersonal.getModel().getValueAt(fila, 2).toString();
        String direccion = tbPersonal.getModel().getValueAt(fila, 3).toString();
        String telefono = tbPersonal.getModel().getValueAt(fila, 4).toString();
        String correo = tbPersonal.getModel().getValueAt(fila, 5).toString();
        String dni = tbPersonal.getModel().getValueAt(fila, 6).toString();
        Date fecha=null;
        try {
			fecha = new SimpleDateFormat("yyyy-MM-dd").parse(tbPersonal.getModel().getValueAt(fila, 7).toString());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
        
        txtCodigo.setText(codigo + "");
        txtNombre.setText(nombre);
        txtApellido.setText(apellido);
        txtDireccion.setText(direccion);
        txtTelefono.setText(telefono);
        txtCorreo.setText(correo);
        txtDni.setText(dni);
        jcFecha.setDate(fecha);
	}
}
