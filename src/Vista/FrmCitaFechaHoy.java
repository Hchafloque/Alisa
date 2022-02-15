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

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import mantenimiento.GestionCitasCCR;
import mantenimiento.GestionCliente;
import model.CitasCCR;
import model.Clientes;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmCitaFechaHoy extends JInternalFrame implements ActionListener, MouseListener {
//JFrame implements ActionListener, MouseListener
	DefaultTableModel modelo=new DefaultTableModel();
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JDateChooser jcFecha;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private JTable jtReporteFecha;
	private JButton btnCitaConfirmada;
	private JButton btnCitaReagendada;
	private JButton btnCitaCancelada;
	private JButton btnMorosos;
	private JButton btnPosAlisado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCitaFechaHoy frame = new FrmCitaFechaHoy();
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
	public FrmCitaFechaHoy() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Citas a la Fecha Actual");
	
		//this.setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 743, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Reporte por Fecha:");
		lblNewLabel.setBounds(10, 25, 123, 14);
		contentPane.add(lblNewLabel);
		
		jcFecha = new JDateChooser();
		jcFecha.setBounds(119, 19, 123, 20);
		contentPane.add(jcFecha);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(283, 16, 89, 23);
		contentPane.add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 707, 252);
		contentPane.add(scrollPane);
		
		jtReporteFecha = new JTable();
		jtReporteFecha.addMouseListener(this);
		scrollPane.setViewportView(jtReporteFecha);
		
		btnCitaConfirmada = new JButton("Cita Confirmada");
		btnCitaConfirmada.addActionListener(this);
		btnCitaConfirmada.setBounds(10, 331, 170, 23);
		contentPane.add(btnCitaConfirmada);
		
		btnCitaReagendada = new JButton("Reagendar Cita");
		btnCitaReagendada.addActionListener(this);
		btnCitaReagendada.setBounds(190, 331, 170, 23);
		contentPane.add(btnCitaReagendada);
		
		btnCitaCancelada = new JButton("Cita Cancelada");
		btnCitaCancelada.addActionListener(this);
		btnCitaCancelada.setBounds(370, 331, 170, 23);
		contentPane.add(btnCitaCancelada);
		
		btnMorosos = new JButton("Enviar a Clientes Morosos");
		btnMorosos.addActionListener(this);
		btnMorosos.setBounds(10, 365, 215, 23);
		contentPane.add(btnMorosos);
		
		btnPosAlisado = new JButton("Enviar a Pos Alisado");
		btnPosAlisado.addActionListener(this);
		btnPosAlisado.setBounds(550, 331, 167, 23);
		contentPane.add(btnPosAlisado);
		
		// this.setLocationRelativeTo(null);
	        modelo.addColumn("CODIGO");
	        modelo.addColumn("NOMBRE");
	        modelo.addColumn("APELLIDO");
	        modelo.addColumn("DNI");
	        modelo.addColumn("FECHA CITA");
	        modelo.addColumn("TELEFONO");
	        modelo.addColumn("HORA");
	        modelo.addColumn("CORREO");
	        jtReporteFecha.setModel(modelo);
	                    
	        jtReporteFecha.setRowHeight(30);
	        
	        jcFecha.setDateFormatString("dd-MM-yyyy");	        
	        jcFecha.setDate(new Date());    
	        
	        listarPorFecha();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMorosos) {
			actionPerformedBtnMorosos(e);
		}
		if (e.getSource() == btnPosAlisado) {
			actionPerformedBtnPosAlisado(e);
		}
		if (e.getSource() == btnCitaCancelada) {
			actionPerformedBtnCitaCancelada(e);
		}
		if (e.getSource() == btnCitaReagendada) {
			actionPerformedBtnCitaReagendada(e);
		}
		if (e.getSource() == btnCitaConfirmada) {
			actionPerformedBtnCitaConfirmada(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
        listarPorFecha();
	}
	protected void actionPerformedBtnCitaConfirmada(ActionEvent e) {
		agregarCitasConfirmadas();
	}
	protected void actionPerformedBtnCitaReagendada(ActionEvent e) {
	
		AgregarCitasReagendadas();
	}
	protected void actionPerformedBtnCitaCancelada(ActionEvent e) {
		AgregarCitasCanceladas();
	}
	protected void actionPerformedBtnPosAlisado(ActionEvent e) {
		AgregarPosAlisado();
	}
	protected void actionPerformedBtnMorosos(ActionEvent e) {
		
	}
	
	void AgregarPosAlisado() {

        try {
            int fila = jtReporteFecha.getSelectedRow();
            int codigo = Integer.parseInt(jtReporteFecha.getModel().getValueAt(fila, 0).toString());
            String nombre = jtReporteFecha.getModel().getValueAt(fila, 1).toString();
            String apellido = jtReporteFecha.getModel().getValueAt(fila, 2).toString();
            //String fecha=jtblReportePorFecha.getModel().getValueAt(fila, 4).toString();
            //String hora=jtblReportePorFecha.getModel().getValueAt(fila, 6).toString();

            DialogPosAlisado dr = new DialogPosAlisado();
            dr.setVisible(true);
            DialogPosAlisado.lblCodigoPos.setText(codigo + "");
            DialogPosAlisado.lblNombresPos.setText(nombre + " " + apellido);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, Por Favor Seleccione un Cliente", "AVISO", JOptionPane.WARNING_MESSAGE);

        }
    }
	
	
	void AgregarCitasReagendadas() {

        try {
            int fila = jtReporteFecha.getSelectedRow();
            int codigo = Integer.parseInt(jtReporteFecha.getModel().getValueAt(fila, 0).toString());
            String nombre = jtReporteFecha.getModel().getValueAt(fila, 1).toString();
            String apellido = jtReporteFecha.getModel().getValueAt(fila, 2).toString();
            //String fecha=jtblReportePorFecha.getModel().getValueAt(fila, 4).toString();
            //String hora=jtblReportePorFecha.getModel().getValueAt(fila, 6).toString();
            DialogRegendarCita dr = new DialogRegendarCita();
            dr.setVisible(true);
            DialogRegendarCita.lblCodigo.setText(codigo + "");
            DialogRegendarCita.lblNombres.setText(nombre + " " + apellido);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, Por Favor Seleccione un Cliente", "AVISO", JOptionPane.WARNING_MESSAGE);
        }
    }

    void AgregarCitasCanceladas() {

        try {
            int fila = jtReporteFecha.getSelectedRow();
            int codigo = Integer.parseInt(jtReporteFecha.getModel().getValueAt(fila, 0).toString());
            String nombre = jtReporteFecha.getModel().getValueAt(fila, 1).toString();
            String apellido = jtReporteFecha.getModel().getValueAt(fila, 2).toString();
           
            CitasCCR c = new CitasCCR();
            c.setCodCliente(codigo);
            
            GestionCitasCCR gc = new GestionCitasCCR();

            int boton = JOptionPane.showConfirmDialog(null, "Seguro que la clienta "+nombre.toUpperCase()+" "+apellido.toUpperCase()+" cancelo su cita?");
            if(c.getCodCliente()==codigo) {           
	            if (boton == 0) {
	                int ok = gc.agregarCitaCanceladas(c);
	                if (ok == 0) {
	                    JOptionPane.showMessageDialog(null, "Error cita no encotrada");
	                } else {
	                    JOptionPane.showMessageDialog(null, "Clienta "+nombre.toUpperCase()+" "+apellido.toUpperCase()+" se garego a clientas canceladas");
	                }
	            }            
            }                      
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione una clienta de la tabla", "AVISO", JOptionPane.WARNING_MESSAGE);
        }

    }

    void agregarCitasConfirmadas() {
    	 try {
             int fila = jtReporteFecha.getSelectedRow();
             int codigo = Integer.parseInt(jtReporteFecha.getModel().getValueAt(fila, 0).toString());
             String nombre = jtReporteFecha.getModel().getValueAt(fila, 1).toString();
             String apellido = jtReporteFecha.getModel().getValueAt(fila, 2).toString();

             CitasCCR c = new CitasCCR();
             c.setCodCliente(codigo);

             GestionCitasCCR gc = new GestionCitasCCR();

             int boton = JOptionPane.showConfirmDialog(null, "Esta seguro que "+nombre.toUpperCase()+" "+apellido.toUpperCase()+" sí se realizo el tratamiento?");
             if(c.getCodCliente()==codigo) {           
 	            if (boton == 0) {
 	                int ok = gc.agergarrCitaConfirmada(c);
 	                if (ok == 0) {
 	                    JOptionPane.showMessageDialog(null, "Error cita no encotrada");
 	                } else {
 	                    JOptionPane.showMessageDialog(null, "Clienta "+nombre.toUpperCase()+" "+apellido.toUpperCase()+" se garego a clientas confirmadas :)");
 	                }
 	            }            
             }                      
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Seleccione una clienta de la tabla", "AVISO", JOptionPane.WARNING_MESSAGE);
         }
    }

    /*void mostrarReporte() {
     DateFormat d=new SimpleDateFormat("yyyy-MM-dd");
     String fecha=d.format(txtFecha.getDate());

     ReporteFecha reporte = new ReporteFecha("Reporte.pdf"+fecha);
     try {
     Desktop.getDesktop().open(new File(reporte.getReporteCons()));
     } catch (Exception e) {
     JOptionPane.showMessageDialog(null, "Error al mostrar reporte ", "AVISO", JOptionPane.WARNING_MESSAGE);
     }
     }*/   /*no */
    void listarPorFecha() {

        DateFormat d = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = d.format(jcFecha.getDate());
        // String fecha=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        GestionCliente gcli = new GestionCliente();
        ArrayList<Clientes> lista = gcli.ReportePorFecha(fecha);

        modelo.setRowCount(0);
        for (Clientes c : lista) {
            Object fila[] = {c.getCodCli(), c.getNombre(), c.getApellido(), c.getDni(), c.getFecha(), c.getTelefono(), c.getHora(), c.getCorreo()};
            modelo.addRow(fila);
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
		if (e.getSource() == jtReporteFecha) {
			mouseReleasedJtReporteFecha(e);
		}
	}
	protected void mouseReleasedJtReporteFecha(MouseEvent e) {
		
	}
}
