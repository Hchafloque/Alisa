package Vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDayChooser;
import mantenimiento.GestionCliente;
import model.Clientes;
import model.TipoRedSocial;
import com.toedter.calendar.JDateChooser;
import java.awt.HeadlessException;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmReservaCitas extends JInternalFrame implements ActionListener, MouseListener{
	
	//JFrame implements ActionListener
	private static final long serialVersionUID = 1L;

	private DefaultTableModel modelo=new DefaultTableModel();
	
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtDniCli;
	private JComboBox<TipoRedSocial> cboRedSocial;
	private JTextField txtCorreo;
	private JTextField txtHora;
	private JTextField txtApellidoCli;
	private JTextField txtTelefonoCli;
	private JTextField txtNombreCli;
	private JDayChooser dayChooser;
	private JLabel lblNewLabel_8;
	private JScrollPane scrollPane;
	private JTable jtblClientes;
	//private JButton btnAgregar;
	//private JButton btnEditar;
	//private JButton btnEliminar;
	private JDateChooser jcFecha;
	private JLabel lblCodigo;
	private JButton btnJINTERNALFRAME;
	private JButton btnAgregar;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnNuevo;

	/**s
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReservaCitas frame = new FrmReservaCitas();
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
	public FrmReservaCitas() {
		setResizable(true);
		setClosable(true);
		setRootPaneCheckingEnabled(false);
		setIconifiable(true);
		setTitle("frm Reservar Citas");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 976, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(23, 54, 234, 298);
		panel.setLayout(null);
		panel.setBorder(UIManager.getBorder("Tree.editorBorder"));
		contentPane.add(panel);
		
		lblNewLabel = new JLabel("DNI:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(10, 46, 46, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(10, 84, 46, 14);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Fecha");
		lblNewLabel_3.setBounds(10, 154, 46, 14);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Telefono");
		lblNewLabel_4.setBounds(10, 115, 46, 14);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Hora");
		lblNewLabel_5.setBounds(10, 192, 46, 14);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Correo");
		lblNewLabel_6.setBounds(10, 227, 46, 14);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Red Social");
		lblNewLabel_7.setBounds(10, 262, 71, 14);
		panel.add(lblNewLabel_7);
		
		txtDniCli = new JTextField();
		txtDniCli.setColumns(10);
		txtDniCli.setBounds(76, 8, 148, 20);
		panel.add(txtDniCli);
		
		cboRedSocial = new JComboBox();
		cboRedSocial.setBounds(76, 258, 148, 22);
		panel.add(cboRedSocial);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(76, 224, 148, 20);
		panel.add(txtCorreo);
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		txtHora.setBounds(76, 189, 148, 20);
		panel.add(txtHora);
		
		txtApellidoCli = new JTextField();
		txtApellidoCli.setColumns(10);
		txtApellidoCli.setBounds(76, 81, 148, 20);
		panel.add(txtApellidoCli);
		
		txtNombreCli = new JTextField();
		txtNombreCli.setColumns(10);
		txtNombreCli.setBounds(76, 43, 148, 20);
		panel.add(txtNombreCli);
		
		txtTelefonoCli = new JTextField();
		txtTelefonoCli.setBounds(76, 112, 148, 20);
		panel.add(txtTelefonoCli);
		txtTelefonoCli.setColumns(10);
		
		jcFecha = new JDateChooser();
		jcFecha.setBounds(76, 154, 148, 20);
		panel.add(jcFecha);
		/*
		lblNewLabel_8 = new JLabel("AGREGAR DATOS DEL CLIENTE");
		lblNewLabel_8.setBounds(188, 11, 244, 26);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_8);*/
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(265, 54, 685, 298);
		contentPane.add(scrollPane);
		
		jtblClientes = new JTable();
		jtblClientes.addMouseListener(this);
		scrollPane.setViewportView(jtblClientes);
	
		//tabla
		modelo.addColumn("CODIGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("DNI");
        modelo.addColumn("FECHA");
        modelo.addColumn("TELEFOFO");
        modelo.addColumn("HORA");
        modelo.addColumn("CORREO");
        modelo.addColumn("RED SOCIAL");
        modelo.addColumn("COD.SOCIAL");
        jtblClientes.setModel(modelo);
        
        jtblClientes.getColumnModel().getColumn(0).setPreferredWidth(55);
        jtblClientes.getColumnModel().getColumn(1).setPreferredWidth(75);
        jtblClientes.getColumnModel().getColumn(2).setPreferredWidth(90);
        jtblClientes.getColumnModel().getColumn(3).setPreferredWidth(60);
        jtblClientes.getColumnModel().getColumn(4).setPreferredWidth(75);
        jtblClientes.getColumnModel().getColumn(5).setPreferredWidth(75);
        jtblClientes.getColumnModel().getColumn(6).setPreferredWidth(50);
        jtblClientes.getColumnModel().getColumn(7).setPreferredWidth(55);
        
        jtblClientes.getColumnModel().getColumn(0).setResizable(false);
        jtblClientes.getColumnModel().getColumn(1).setResizable(false);
        jtblClientes.getColumnModel().getColumn(2).setResizable(false);
        jtblClientes.getColumnModel().getColumn(3).setResizable(false);
        jtblClientes.getColumnModel().getColumn(4).setResizable(false);
        jtblClientes.getColumnModel().getColumn(5).setResizable(false);
        jtblClientes.getColumnModel().getColumn(6).setResizable(false);
        jtblClientes.getColumnModel().getColumn(7).setResizable(false);
        
        jtblClientes.setRowHeight(30);
        //ELIMINO COLUMNA QUE NO DESEO MOSTRAR
        jtblClientes.removeColumn(jtblClientes.getColumnModel().getColumn(9));
        
        lblCodigo = new JLabel("");
        lblCodigo.setEnabled(false);
        lblCodigo.setBounds(23, 33, 46, 14);
        contentPane.add(lblCodigo);

        listarRedSocial();
        generarcodigo();
        listarCli();
        
        lblCodigo.setText(generarcodigo()+"");
        
        jcFecha.setDateFormatString("dd-MM-yyyy");
        
        btnAgregar = new JButton("AGREGAR");
        btnAgregar.addActionListener(this);
        btnAgregar.setBounds(141, 375, 89, 23);
        contentPane.add(btnAgregar);
        
        btnEditar = new JButton("EDITAR");
        btnEditar.addActionListener(this);
        btnEditar.setBounds(261, 375, 89, 23);
        contentPane.add(btnEditar);
        
        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.addActionListener(this);
        btnEliminar.setBounds(364, 375, 89, 23);
        contentPane.add(btnEliminar);
        
        btnNuevo = new JButton("NUEVO");
        btnNuevo.addActionListener(this);
        btnNuevo.setBounds(23, 375, 89, 23);
        contentPane.add(btnNuevo);
        
        bloquearBotones();
        bloquearCajas();
                               
	}

	 void limpiar() {
	        //txtCodigocli.setText("");
	        txtNombreCli.setText("");
	        txtApellidoCli.setText("");
	        txtDniCli.setText("");
	        jcFecha.setDate(null);
	        txtTelefonoCli.setText("");
	        txtHora.setText("");
	        txtCorreo.setText("");
	        txtNombreCli.requestFocus();
	        cboRedSocial.setSelectedIndex(0);
	    }
	    
	    void listarCli() {
	        GestionCliente gc = new GestionCliente();
	        ArrayList<Clientes> lista = gc.listarClientes();
	        
	        modelo.setRowCount(0);
	        for (Clientes c : lista) {
	        	 Object fila[] = {c.getCodCli(), c.getNombre(), c.getApellido(), c.getDni(), c.getFecha(), c.getTelefono(), c.getHora(), c.getCorreo(), c.getNomRedSocial(),c.getTipo()};
		            modelo.addRow(fila);
			}
	    }
	    
	    private void eliminarCliente() {
	        int codigo = Integer.parseInt(lblCodigo.getText());
	        GestionCliente gc = new GestionCliente();
	        
	        int boton = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar clienta?");
	        if (boton == 0) {
	            int ok = gc.eliminar(codigo);
	            if (ok == 0) {
	                JOptionPane.showMessageDialog(null, "Error, codigo no registrado", "AVISO", JOptionPane.WARNING_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "Cliente eliminado");
	                limpiar();
	                bloquearBotones();
	                bloquearCajas();
	                listarCli();
	                lblCodigo.setText(generarcodigo()+"");
	            }
	        }
	    }
	    
	    private void modificarClientes() {
	        //variables

	        try {
	            
	            String nombre, apellido, dni, fecha, telefono, hora, correo;
	            int codigo, tipo;
	            
	            codigo = Integer.parseInt(lblCodigo.getText());
	            nombre = txtNombreCli.getText();
	            if (!nombre.isEmpty()) {
	                
	                apellido = txtApellidoCli.getText();
	                if (!apellido.isEmpty()) {
	                    
	                    dni = txtDniCli.getText();
	                    if (!dni.isEmpty()) {
	                        
	                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                        fecha = sdf.format(jcFecha.getDate());
	                        telefono = txtTelefonoCli.getText();
	                        if (!telefono.isEmpty()) {
	                            
	                            hora = txtHora.getText(); 
	                            
	                            if (!hora.isEmpty()) {
	                                
	                                correo = txtCorreo.getText();
	                                
	                                tipo = cboRedSocial.getSelectedIndex();
	                                if (tipo != 0) {
	                                    
	                                    Clientes c = new Clientes();
	                                    c.setCodCli(codigo);
	                                    c.setNombre(nombre);
	                                    c.setApellido(apellido);
	                                    c.setDni(dni);
	                                    c.setFecha(fecha);
	                                    c.setTelefono(telefono);
	                                    c.setHora(hora);
	                                    c.setCorreo(correo);
	                                    c.setTipo(tipo);
	                                    
	                                    GestionCliente gu = new GestionCliente();
	                                    int ok = gu.modificar(c);
	                                    
	                                    if (ok == 0) {
	                                        JOptionPane.showMessageDialog(null, "Error al actualizar Clienta", "AVISO", JOptionPane.WARNING_MESSAGE);
	                                    } else {
	                                        JOptionPane.showMessageDialog(null, "Registro Actualizado");
	                                        limpiar();
	                                        bloquearCajas();
	                                        bloquearBotones();
	                                        listarCli();
	                                        lblCodigo.setText(generarcodigo()+"");
	                                    }
	                                } else {
	                                    JOptionPane.showMessageDialog(null, "Seleccione un tipo");
	                                }
	                            } else {
	                                
	                                JOptionPane.showMessageDialog(null, "Ingrese Hora de Ciita");                              
	                            }
	                        } else {
	                            
	                            JOptionPane.showMessageDialog(null, "Ingrese Telefono");	                            
	                        }
	                    } else {
	                        
	                        JOptionPane.showMessageDialog(null, "Ingrese DNI");                       
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Ingrese Apellido");
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Ingrese nombre");
	            }
	        } catch (NumberFormatException | HeadlessException e) {
	            JOptionPane.showMessageDialog(null, "Campos vacios", "AVISO", JOptionPane.WARNING_MESSAGE);
	        }
	    }
	    
	    private void RegistrarClientes() {
	        //variables
	        String nombre, apellido, dni, fecha, telefono, hora, correo;
	        int codigo, tipo;
	        
	        try {
	            
	            codigo = Integer.parseInt(lblCodigo.getText());
	            nombre = txtNombreCli.getText();
	            if (!nombre.isEmpty()) {
	                
	                apellido = txtApellidoCli.getText();
	                if (!apellido.isEmpty()) {
	                    dni = txtDniCli.getText();
	                    
	                    if (!dni.isEmpty()) {
	                        
	                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                        fecha = sdf.format(jcFecha.getDate());
	                        
	                        if (fecha != null) {
	                            
	                            telefono = txtTelefonoCli.getText();

	                            //if (!telefono.matches("\d{9}")) {
	                            hora = txtHora.getText();
	                            
	                            if (!hora.isEmpty()) {
	                                
	                                correo = txtCorreo.getText();
	                                
	                                if (!correo.isEmpty()) {
	                                    
	                                    tipo = cboRedSocial.getSelectedIndex();
	                                    	                                 	                                    
	                                    if (tipo != 0) {
	                                        
	                                        Clientes c = new Clientes();
	                                        
	                                        c.setCodCli(codigo);
	                                        c.setNombre(nombre);
	                                        c.setApellido(apellido);
	                                        c.setDni(dni);
	                                        c.setFecha(fecha);
	                                        c.setTelefono(telefono);
	                                        c.setHora(hora);
	                                        c.setCorreo(correo);
	                                        c.setTipo(tipo);
	                                        
	                                        GestionCliente gu = new GestionCliente();
	                                        int ok = gu.registrar(c);
	                                        
	                                        if (ok == 0) {
	                                            JOptionPane.showMessageDialog(null, "Error al registrar Clienta", "AVISO", JOptionPane.WARNING_MESSAGE);
	                                        } else {
	                                            
	                                            JOptionPane.showMessageDialog(null, "Registro exitoso");
	                                            limpiar();
	                                            listarCli();
	                                            bloquearCajas();
	                                            bloquearBotones();
	                                            lblCodigo.setText(generarcodigo()+"");
	                                            
	                                        }
	                                    } else {
	                                        JOptionPane.showMessageDialog(null, "Seleccione el Tipo de Red Social Que Reservo la cita");
	                                    }
	                                } else {
	                                    JOptionPane.showMessageDialog(null, "Ingrese correo");
	                                }
	                            } else {
	                                
	                                JOptionPane.showMessageDialog(null, "Ingrese la hora");
	                                
	                            }
	                            //} else {
	                            //    JOptionPane.showMessageDialog(null, "Error telefonsolo numeros");
	                            //}
	                        } else {
	                            
	                            JOptionPane.showMessageDialog(null, "Ingrese fecha");
	                            
	                        }
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Ingrese el numero de DNI");
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Ingrese Apellido");
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Ingrese nombre");
	            }
	            
	        } catch (NumberFormatException | HeadlessException e) {
	            
	            JOptionPane.showMessageDialog(null, "Campos Vacios");
	        }
	    }
	    
	    void bloquearBotones() {
	        btnAgregar.setEnabled(false);
	        btnEliminar.setEnabled(false);
	        btnEditar.setEnabled(false);
	        btnNuevo.setEnabled(true);
	    }
	    
	    void desbloquearBotones() {
	    	btnAgregar.setEnabled(true);
	        btnEliminar.setEnabled(true);
	        btnEditar.setEnabled(true);
	        btnNuevo.setEnabled(false);
	    }
	    
	    void desbloquearcajas() {
	        txtNombreCli.setEnabled(true);
	        txtApellidoCli.setEnabled(true);
	        txtDniCli.setEnabled(true);
	        jcFecha.setEnabled(true);
	        txtTelefonoCli.setEnabled(true);
	        txtCorreo.setEnabled(true);
	        txtHora.setEnabled(true);
	        cboRedSocial.setEnabled(true);
	    }
	    
	    void bloquearCajas() {
	        txtNombreCli.setEnabled(false);
	        txtApellidoCli.setEnabled(false);
	        txtDniCli.setEnabled(false);
	        jcFecha.setEnabled(false);
	        txtTelefonoCli.setEnabled(false);
	        txtCorreo.setEnabled(false);
	        txtHora.setEnabled(false);	  
	        cboRedSocial.setEnabled(false);
	    }
	    
	    private int generarcodigo() {
	        GestionCliente gc = new GestionCliente();
	        return gc.generarCodigio();
	    }
	    
	    private void listarRedSocial() {
	        GestionCliente gc = new GestionCliente();
	        ArrayList<TipoRedSocial> lista = gc.listarRedSocial();	        
	        cboRedSocial.addItem(new TipoRedSocial(0, "Seleccione"));	        
	        for (TipoRedSocial t : lista) {
	            cboRedSocial.addItem(t);
	        }
	    } 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnEditar) {
			actionPerformedBtnEditar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		limpiar();
		desbloquearBotones();
		desbloquearcajas();
		lblCodigo.setText(generarcodigo()+"");
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		RegistrarClientes();
		listarCli();
	}
	
	protected void actionPerformedBtnEditar(ActionEvent e) {
		modificarClientes();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarCliente();
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
		if (e.getSource() == jtblClientes) {
			mouseReleasedJtblClientes(e);
		}
	}
	protected void mouseReleasedJtblClientes(MouseEvent e) {
		int fila=jtblClientes.getSelectedRow();
		int cod=Integer.parseInt(jtblClientes.getModel().getValueAt(fila, 0).toString());
		String dni=jtblClientes.getModel().getValueAt(fila, 3).toString();
		String nombre=jtblClientes.getModel().getValueAt(fila, 1).toString();
		String apellido=jtblClientes.getModel().getValueAt(fila, 2).toString();
		String telefono=jtblClientes.getModel().getValueAt(fila, 5).toString();
		String hora=jtblClientes.getModel().getValueAt(fila, 6).toString();
		String correo=jtblClientes.getModel().getValueAt(fila, 7).toString();
		int redSocial=Integer.parseInt(jtblClientes.getModel().getValueAt(fila, 9).toString());
		Date fecha=null;
		try {
			fecha= new SimpleDateFormat("yyyy-MM-dd").parse(jtblClientes.getModel().getValueAt(fila, 4).toString());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}		
		
		lblCodigo.setText(cod+"");
		txtDniCli.setText(dni);
		txtNombreCli.setText(nombre);
		txtApellidoCli.setText(apellido);
		txtTelefonoCli.setText(telefono);	
		jcFecha.setDate(fecha);	
		txtHora.setText(hora);
		txtCorreo.setText(correo);
		cboRedSocial.setSelectedIndex(redSocial);

	}
}
