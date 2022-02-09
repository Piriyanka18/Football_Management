import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import playerManagement.MainFrame;
import playerManagement.ViewersFrame;

import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
public class logIn {

	public JFrame frmLogIn;
	public JTextField textUser;
	public JLabel lblPwd;
	public JPasswordField textPwd;
	public JButton btnReset;
	public String userName;
	public String userPwd;
	public JCheckBox showPwd;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logIn window = new logIn();
					window.frmLogIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public logIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		
		// Frame //
		
		frmLogIn = new JFrame();
		frmLogIn.getContentPane().setBackground(new Color(102, 0, 0));
		frmLogIn.setTitle("Log In");
		frmLogIn.setIconImage(Toolkit.getDefaultToolkit().getImage(logIn.class.getResource("/SquadDetails/Squad/FCB.png")));
		frmLogIn.setAutoRequestFocus(false);
		frmLogIn.setBounds(550, 200, 562, 363);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(374, 109, 129, 117);
		frmLogIn.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(logIn.class.getResource("/SquadDetails/Squad/fcb-meta-logo.png")));
		
		// Username label //
		
		JLabel lblUserName = new JLabel("UserName");
		lblUserName.setForeground(SystemColor.scrollbar);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserName.setBounds(20, 80, 93, 20);
		frmLogIn.getContentPane().add(lblUserName);
		
		// Username textfield //
		
		textUser = new JTextField();
		textUser.setBackground(SystemColor.inactiveCaptionBorder);
		textUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textUser.setBounds(20, 105, 174, 30);
		frmLogIn.getContentPane().add(textUser);
		textUser.setColumns(10);
		
		// Password label //
		
		lblPwd = new JLabel("Password");
		lblPwd.setForeground(SystemColor.scrollbar);
		lblPwd.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPwd.setBounds(20, 156, 93, 20);
		frmLogIn.getContentPane().add(lblPwd);
		
		// Password textfield //
		
		textPwd = new JPasswordField();
		textPwd.setBackground(SystemColor.inactiveCaptionBorder);
		userPwd = textPwd.getText();
		textPwd.setBounds(20, 181, 174, 30);
		frmLogIn.getContentPane().add(textPwd);
		textPwd.setColumns(10);
		
		// Show Password checkbox //
		
		showPwd = new JCheckBox("Show Password");
		showPwd.setBackground(SystemColor.info);
		showPwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (showPwd.isSelected()) {
	                textPwd.setEchoChar((char) 0);
	            }
				else {
	                textPwd.setEchoChar('*');
	            }
			}
		});
		showPwd.setFont(new Font("Tahoma", Font.BOLD, 11));
		showPwd.setBounds(210, 182, 115, 26);
		frmLogIn.getContentPane().add(showPwd);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 102));
		panel.setBounds(0, 0, 441, 326);
		frmLogIn.getContentPane().add(panel);
		panel.setLayout(null);
		
		// Login Button //
		
		JButton btnLogin = new JButton("Log In");
		btnLogin.setBackground(SystemColor.info);
		btnLogin.setBounds(23, 255, 120, 39);
		panel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		         userName = textUser.getText();
		         userPwd = textPwd.getText();
		            if (userName.equalsIgnoreCase("admin") && userPwd.equalsIgnoreCase("admin")) {
		                JOptionPane.showMessageDialog(btnLogin, "Login Successful");
		                new MainFrame();
		                frmLogIn.dispose();
		          } 
		            else if (userName.equalsIgnoreCase("user") && userPwd.equalsIgnoreCase("user")) {
		                JOptionPane.showMessageDialog(btnLogin, "Login Successful");
		                new ViewersFrame();
		                frmLogIn.dispose();
		          } 
		            
		            else {
		                JOptionPane.showMessageDialog(btnLogin, "Invalid Username or Password");}
			}	}
		);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		// Reset button //
		
		btnReset = new JButton("Reset");
		btnReset.setBackground(SystemColor.info);
		btnReset.setBounds(173, 255, 120, 39);
		panel.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUser.setText("");
	            textPwd.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		lblNewLabel = new JLabel("Log in to the System");
		lblNewLabel.setBackground(SystemColor.inactiveCaption);
		lblNewLabel.setBounds(23, 5, 406, 53);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel.setFont(new Font("Imprint MT Shadow", Font.BOLD, 35));
		
	}
}
