package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import mantenimiento.GestionCitasCCR;
import mantenimiento.GestionCliente;
import model.CitasCCR;
import model.Clientes;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class DialogPosAlisado extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	public static JLabel lblCodigoPos;
	public static JLabel lblNombresPos;
	private JDateChooser jcFechaPos;
	private JTextField txtHora;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogPosAlisado frame = new DialogPosAlisado();
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
	public DialogPosAlisado() {
		setClosable(true);
		setIconifiable(true);
		setTitle("POS ALISADO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 274, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Cliente:");
		lblNewLabel.setBounds(25, 45, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Codigo:");
		lblNewLabel_1.setBounds(25, 20, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Fecha pos:");
		lblNewLabel_2.setBounds(25, 70, 70, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Hora:");
		lblNewLabel_3.setBounds(25, 95, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		lblCodigoPos = new JLabel("");
		lblCodigoPos.setBounds(81, 20, 46, 14);
		contentPane.add(lblCodigoPos);
		
		lblNombresPos = new JLabel("");
		lblNombresPos.setBounds(81, 45, 166, 14);
		contentPane.add(lblNombresPos);
		
		jcFechaPos = new JDateChooser();
		jcFechaPos.setBounds(91, 64, 111, 20);
		contentPane.add(jcFechaPos);
		
		txtHora = new JTextField();
		txtHora.setBounds(90, 92, 86, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);
		
		btnNewButton = new JButton("Agregar pos");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(81, 133, 111, 23);
		contentPane.add(btnNewButton);
		
		jcFechaPos.setDateFormatString("dd-MM-yyyy");
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		actualizarCitas();
	}
	
	void actualizarCitas() {
        int codigo = Integer.parseInt(lblCodigoPos.getText());
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = f.format(jcFechaPos.getDate());
        String hora = txtHora.getText();

        CitasCCR c = new CitasCCR();
        c.setCodCliente(codigo);
        c.setFechaPosAlisado(fecha);
        c.setHora(hora);

        GestionCitasCCR gc = new GestionCitasCCR();

        int boton = JOptionPane.showConfirmDialog(null, "Asegurese que los datos sean los que proporciono la clineta");
        if (boton == 0) {
            int ok = gc.AgregarPosAlisado(c);
            if (ok == 0) {
                JOptionPane.showMessageDialog(null, "Error alactualizar la cita");
            } else {
                JOptionPane.showMessageDialog(null, "Exito!! "+lblNombresPos.getText().toUpperCase()+" tiene reservada su cita para POS ALISADO el dia "+fecha+" a las "+hora);           
                dispose();
            }
        }
    }
	
	
	
	
}
