package playerManagement;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

//import injuries.SecondFrame;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class MainInj {

	JFrame mainframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new MainInj();

	
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public MainInj() {
	
		mainframe = new JFrame();
		mainframe.setTitle("Injuries and Suspensions");
		mainframe.setIconImage(Toolkit.getDefaultToolkit().getImage(MainInj.class.getResource("/SquadDetails/Squad/FCB.png")));
		mainframe.getContentPane().setBackground(new Color(0, 0, 102));
		mainframe.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Injuries");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new Injuries_main();
				mainframe.dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainInj.class.getResource("/SquadDetails/Squad/fcb-meta-logo.png")));
		lblNewLabel.setBounds(266, 84, 142, 147);
		mainframe.getContentPane().add(lblNewLabel);
		
		
		
		
		btnNewButton.setBounds(50, 84, 150, 45);
		mainframe.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Suspension");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Suspended_main();
				mainframe.dispose();
			}
		});
		btnNewButton_1.setBackground(SystemColor.info);
		btnNewButton_1.setBounds(50, 186, 150, 45);
		mainframe.getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 0));
		panel.setForeground(Color.WHITE);
		panel.setBounds(333, 0, 142, 326);
		mainframe.getContentPane().add(panel);
		mainframe.setBounds(500, 200, 489, 363);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe.dispose();
				new MainFrame();
			}
	});
		panel.setLayout(null);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBorderPainted(false);			btnNewButton_3.setBackground(SystemColor.info);
		btnNewButton_3.setBounds(33,278, 75, 27);
		panel.add(btnNewButton_3);
		
		mainframe.setVisible(true);
	}

	protected static void dispose() {
		// TODO Auto-generated method stub
		
	}
}
