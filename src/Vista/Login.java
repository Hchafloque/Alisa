package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimiento.GestionUsuario;
import model.Usuarios;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtUsuario; 
	private JPasswordField txtPass;
	private JButton btnImgresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(71, 82, 59, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(71, 120, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2.setBounds(165, 32, 59, 20);
		contentPane.add(lblNewLabel_2);
		 
		txtUsuario = new JTextField();
		txtUsuario.setBounds(140, 79, 122, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(142, 117, 120, 20);
		contentPane.add(txtPass);
		
		btnImgresar = new JButton("INGRESAR");
		btnImgresar.addActionListener(this);
		btnImgresar.setBounds(142, 174, 120, 23);
		contentPane.add(btnImgresar);
	}

	void login(){
	    String usu,pass;
	    usu=txtUsuario.getText();
	    pass=txtPass.getText();
	    
	        
	        GestionUsuario gu=new GestionUsuario();
	        Usuarios u= gu.loginUsuario(usu, pass);
	        //System.out.println("--->"+u.getUsuario());
	        if (u.getUsuario()==null && u.getPass()==null) {
	           JOptionPane.showMessageDialog(null, "Usuario no registrado /campos vacios ","AVISO",JOptionPane.WARNING_MESSAGE);
	        }else{
	            
	            JOptionPane.showMessageDialog(null, "Bienvenido " + u.getNombreUsu().toUpperCase()+" "+u.getApellidoUsu().toUpperCase());
	            MenuPrincipal p=new MenuPrincipal();
	          
	            p.setVisible(true);
	            
	            MenuPrincipal.lblNombre.setText(u.getNombreUsu().toUpperCase()); 
	            MenuPrincipal.lblApellido.setText(u.getApellidoUsu().toUpperCase());
	            MenuPrincipal.lblCodigo.setText(u.getCodUsuario()+"");  
	            p.setExtendedState(MAXIMIZED_BOTH);
	            dispose();
	        }
	    }
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnImgresar) {
			actionPerformedBtnImgresar(e);
		}
	}
	protected void actionPerformedBtnImgresar(ActionEvent e) {
		login();
	}
}
