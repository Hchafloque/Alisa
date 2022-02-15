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
import com.toedter.calendar.JDateChooser;

import mantenimiento.GestionCitasCCR;
import mantenimiento.GestionCliente;
import model.CitasCCR;
import model.Clientes;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class DialogRegendarCita extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	public static JLabel lblCodigo;
	private JLabel lblNewLabel_1;
	public static JLabel lblNombres;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	public static JTextField txtHora;
	public static JDateChooser jcFecha;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogRegendarCita frame = new DialogRegendarCita();
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
	public DialogRegendarCita() {
		setTitle("Reagendar Cita");
		setClosable(true);
		setIconifiable(true);
		
		//this.setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 284, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(10, 22, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblCodigo = new JLabel("");
		lblCodigo.setBounds(104, 22, 46, 14);
		contentPane.add(lblCodigo);
		
		lblNewLabel_1 = new JLabel("Cliente:");
		lblNewLabel_1.setBounds(10, 47, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNombres = new JLabel("");
		lblNombres.setBounds(104, 47, 145, 14);
		contentPane.add(lblNombres);
		
		lblNewLabel_3 = new JLabel("Nueva Fecha:");
		lblNewLabel_3.setBounds(10, 78, 83, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Nuevo Horario:");
		lblNewLabel_4.setBounds(10, 112, 83, 14);
		contentPane.add(lblNewLabel_4);
		
		txtHora = new JTextField();
		txtHora.setBounds(104, 109, 128, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);
		
		jcFecha = new JDateChooser();
		jcFecha.setBounds(104, 72, 128, 20);
		contentPane.add(jcFecha);
		
		jcFecha.setDateFormatString("dd-MM-yyyy");//fecha actual en el jcalendar
		
		btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(93, 140, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		actualizarCitas();
	}
	
	void actualizarCitaReagendada() {
        int codigo = Integer.parseInt(lblCodigo.getText());
        CitasCCR c = new CitasCCR();
        c.setCodCliente(codigo);     
        GestionCitasCCR gc = new GestionCitasCCR();
        gc.ActualizarCitaReagendada(c);
    }
	
	void actualizarCitas() {
        int codigo = Integer.parseInt(lblCodigo.getText());
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = f.format(jcFecha.getDate());
        String hora = txtHora.getText();

        Clientes c = new Clientes();
        c.setCodCli(codigo);
        c.setFecha(fecha);
        c.setHora(hora);

        GestionCliente gc = new GestionCliente();

        int boton = JOptionPane.showConfirmDialog(null, "Asegurese que los datos sean los que proporciono la clineta");
        if (boton == 0) {
            int ok = gc.ActualizarFechaYHoraCliente(c);
            if (ok == 0) {
                JOptionPane.showMessageDialog(null, "Error alactualizar la cita");
            } else {
                JOptionPane.showMessageDialog(null, "Exito!! "+lblNombres.getText()+" se reagendo correctamente pafra el dia "+jcFecha.getDate()+" a las "+txtHora.getText());
                actualizarCitaReagendada();
                dispose();
            }
        }
    }

}
