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

import mantenimiento.GestionUsuario;
import model.Tipo;
import model.Usuarios;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmUsuario extends JInternalFrame implements ActionListener, MouseListener {

	DefaultTableModel modelo=new DefaultTableModel();
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JTextField txtpass;
	private JDateChooser jcFecha;
	private JComboBox cboTipo;
	private JLabel lblCodigo;
	private JScrollPane scrollPane;
	private JTable jtUsuarios;
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUsuario frame = new FrmUsuario();
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
	public FrmUsuario() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Usuarios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 734, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("REGISTRO DE USUARIOS");
		lblNewLabel.setBounds(204, 11, 136, 14);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBounds(10, 36, 232, 209);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 11, 58, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setBounds(10, 43, 58, 14);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Usuario:");
		lblNewLabel_3.setBounds(10, 75, 58, 14);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_4.setBounds(10, 106, 78, 14);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Fecha Registro:");
		lblNewLabel_5.setBounds(10, 140, 97, 14);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Tipo Usuario:");
		lblNewLabel_6.setBounds(10, 175, 78, 14);
		panel.add(lblNewLabel_6);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setBounds(99, 8, 123, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setEnabled(false);
		txtApellido.setBounds(99, 40, 123, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setEnabled(false);
		txtUsuario.setBounds(99, 72, 123, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtpass = new JTextField();
		txtpass.setEnabled(false);
		txtpass.setBounds(98, 103, 124, 20);
		panel.add(txtpass);
		txtpass.setColumns(10);
		
		jcFecha = new JDateChooser();
		jcFecha.setBounds(99, 134, 123, 20);
		panel.add(jcFecha);
		
		cboTipo = new JComboBox();
		cboTipo.setEnabled(false);
		cboTipo.setBounds(98, 171, 124, 22);
		panel.add(cboTipo);
		
		lblCodigo = new JLabel("");
		lblCodigo.setBounds(10, 21, 46, 14);
		contentPane.add(lblCodigo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(260, 36, 448, 209);
		contentPane.add(scrollPane);
		
		jtUsuarios = new JTable();
		jtUsuarios.addMouseListener(this);
		scrollPane.setViewportView(jtUsuarios);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 258, 122, 28);
		contentPane.add(btnNuevo);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setEnabled(false);
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(153, 258, 122, 28);
		contentPane.add(btnRegistrar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(299, 258, 122, 28);
		contentPane.add(btnEliminar);
		
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDO");
		modelo.addColumn("USUARIO");
		modelo.addColumn("CONTRASEÑA");
		modelo.addColumn("FECHA");
		modelo.addColumn("USUARIO");
		modelo.addColumn("TIPO");
		jtUsuarios.setModel(modelo);
		
		jtUsuarios.setRowHeight(30);
        //ELIMINO COLUMNA QUE NO DESEO MOSTRAR
		jtUsuarios.removeColumn(jtUsuarios.getColumnModel().getColumn(7));
		
		listarTipoUsuario();
		listarUsuarios();
		lblCodigo.setText(generarCodigo()+"");
		jcFecha.setDateFormatString("dd-MM-yyyy");
		
		bloquearBotones();
		BloquearCajas();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		limpiar();
		lblCodigo.setText(generarCodigo()+"");
		listarUsuarios();
		desbloquearBotones();
		desBloquearCajas();
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registrarUsuario();
		listarUsuarios();
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarUsuario();
		listarUsuarios();
	}
	
	 void limpiar() {
	        txtApellido.setText("");
	        jcFecha.setDate(null);
	        txtNombre.setText("");
	        txtpass.setText("");
	        txtUsuario.setText("");
	        cboTipo.setSelectedIndex(0);
	        txtNombre.requestFocus();
	    }

	    private void eliminarUsuario() {
	        String codigo = lblCodigo.getText();
	        GestionUsuario gu = new GestionUsuario();

	        int boton = JOptionPane.showConfirmDialog(null, "seguro que desea elimimar usuario");
	        if (boton == 0) {
	            int ok = gu.eliminar(codigo);
	            if (ok == 0) {
	                JOptionPane.showMessageDialog(null, "Error, codigo no encontrado", "AVISO", JOptionPane.WARNING_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "Usuario Eliminado");
	                limpiar();
	                lblCodigo.setText(generarCodigo() + "");
	                listarUsuarios();
	                BloquearCajas();
	                bloquearBotones();
	            }
	        }
	    }

	    /*private void modificarUsuario() {
	        //variables
	        String nombre, apellido, usuario, pass, fechaSession;
	        int codTipo, codigo;

	        codigo = Integer.parseInt(txtCodigo.getText());
	        nombre = txtNombre.getText();
	        apellido = txtApellido.getText();
	        usuario = txtUsuario.getText();
	        pass = String.valueOf(txtpass.getPassword());
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        fechaSession = sdf.format(txtFecha.getDate());
	        codTipo = cboTipoUsuario.getSelectedIndex();

	        Usuarios u = new Usuarios();
	        u.setCodUsuario(codigo);
	        u.setNombreUsu(nombre);
	        u.setApellidoUsu(apellido);
	        u.setUsuario(usuario);
	        u.setPass(pass);
	        u.setFecha(fechaSession);
	        u.setCodTipoUsu(codTipo);

	        GestionUsuario gu = new GestionUsuario();
	        int ok = gu.modificar(u);

	        if (ok == 0) {
	            JOptionPane.showMessageDialog(null, "Error al modificar usuario", "AVISO", JOptionPane.WARNING_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(null, "Usuario modificado");
	            limpiar();
	            txtCodigo.setText(generarCodigo() + "");
	            listarUsuarios();
	            BloquearCajas();
	            bloquearBotones();
	        }
	    }*/

	    private int generarCodigo() {
	        GestionUsuario gu = new GestionUsuario();
	        return gu.generarCodigio();
	    }

	    private void registrarUsuario() {
	        //variables
	        String nombre, apellido, usuario, pass, fechaSession;
	        int codTipo, codigo;

	        codigo = Integer.parseInt(lblCodigo.getText());
	        nombre = txtNombre.getText();
	        apellido = txtApellido.getText();
	        usuario = txtUsuario.getText();
	        pass = txtpass.getText();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        fechaSession = sdf.format(jcFecha.getDate());
	        codTipo = cboTipo.getSelectedIndex();

	        Usuarios u = new Usuarios();
	        u.setCodUsuario(codigo);
	        u.setNombreUsu(nombre);
	        u.setApellidoUsu(apellido);
	        u.setUsuario(usuario);
	        u.setPass(pass);
	        u.setFecha(fechaSession);
	        u.setCodTipoUsu(codTipo);

	        GestionUsuario gu = new GestionUsuario();
	        int ok = gu.registrar(u);

	        if (ok <= 0) {
	            JOptionPane.showMessageDialog(null, "Error al registrar usuario", "AVISO", JOptionPane.WARNING_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(null, "Usuario Registrado");
	            limpiar();
	            lblCodigo.setText(generarCodigo() +"");
	            listarUsuarios();
	            BloquearCajas();
	            bloquearBotones();
	        }
	    }

	    void BloquearCajas() {
	        txtApellido.setEnabled(false);
	        jcFecha.setEnabled(false);
	        txtNombre.setEnabled(false);
	        txtpass.setEnabled(false);
	        txtUsuario.setEnabled(false);
	        cboTipo.setEnabled(false);
	    }

	    void desBloquearCajas() {
	        txtApellido.setEnabled(true);
	        jcFecha.setEnabled(true);
	        txtNombre.setEnabled(true);
	        txtpass.setEnabled(true);
	        txtUsuario.setEnabled(true);
	        cboTipo.setEnabled(true);
	    }

	    void bloquearBotones() {
	        btnNuevo.setEnabled(true);
	        btnEliminar.setEnabled(false);
	        //btnModificar.setEnabled(false);
	        btnRegistrar.setEnabled(false);
	    }

	    void desbloquearBotones() {
	        btnNuevo.setEnabled(false);
	        btnEliminar.setEnabled(true);
	        //btnModificar.setEnabled(true);
	        btnRegistrar.setEnabled(true);
	    }

	    private void listarUsuarios() {
	        GestionUsuario gu = new GestionUsuario();
	        ArrayList<Usuarios> lista = gu.listarUsuarios();

	        modelo.setRowCount(0);
	        for (Usuarios u : lista) {
	            Object fila[] = {u.getCodUsuario(),
	                u.getNombreUsu(),
	                u.getApellidoUsu(),
	                u.getUsuario(),
	                u.getPass(),
	                u.getFecha(),
	                u.getNomTipoUsu(),
	                u.getCodTipoUsu()};
	            modelo.addRow(fila);
	        }
	    }

	    private void listarTipoUsuario() {
	        GestionUsuario gu = new GestionUsuario();
	        ArrayList<Tipo> lista = gu.listarTipo();
	        cboTipo.addItem(new Tipo(0, "Seleccione Tipo"));
	        for (Tipo u : lista) {
	        	cboTipo.addItem(u);
	        }
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
		if (e.getSource() == jtUsuarios) {
			mouseReleasedJtUsuarios(e);
		}
	}
	protected void mouseReleasedJtUsuarios(MouseEvent e) {
		int fila=jtUsuarios.getSelectedRow();
		int cod=Integer.parseInt(jtUsuarios.getModel().getValueAt(fila, 0).toString());
		String nombre=jtUsuarios.getModel().getValueAt(fila, 1).toString();
		String apellido=jtUsuarios.getModel().getValueAt(fila, 2).toString();
		String usuario=jtUsuarios.getModel().getValueAt(fila, 3).toString();
		String clave=jtUsuarios.getModel().getValueAt(fila, 4).toString();
		Date fecha=null;
		try {
			fecha= new SimpleDateFormat("yyyy-MM-dd").parse(jtUsuarios.getModel().getValueAt(fila, 5).toString());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}		
		int tipo=Integer.parseInt(jtUsuarios.getModel().getValueAt(fila, 7).toString());
		
		lblCodigo.setText(cod+"");
		txtNombre.setText(nombre);
		txtApellido.setText(apellido);
		txtUsuario.setText(usuario);
		txtpass.setText(clave);
		jcFecha.setDate(fecha);
		cboTipo.setSelectedIndex(tipo);
	}
}
