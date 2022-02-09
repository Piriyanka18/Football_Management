package Staff;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;

import playerManagement.MainFrame;

//import javax.swing.border.EtchedBorder;
//import javax.swing.border.SoftBevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
//import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Toolkit;
//import javax.swing.border.TitledBorder;
//import javax.swing.border.LineBorder;

public class MainInt {

public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInt window = new MainInt();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainInt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Staff Management");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainInt.class.getResource("/SquadDetails/Squad/FCB.png")));
		frame.getContentPane().setBackground(new Color(0, 0, 51));
		frame.setBounds(450, 180, 656, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		JLabel lblNewLabel = new JLabel("STAFF MANAGEMENT");
		lblNewLabel.setBounds(22, 44, 671, 80);
		lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel.setFont(new Font("Imprint MT Shadow", Font.BOLD, 46));
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(428, 203, 146, 165);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1  .setIcon(new ImageIcon(MainInt.class.getResource("/SquadDetails/Squad/fcb-meta-logo.png")));
		
		JButton btnNewButton = new JButton("Medical Staff");
		btnNewButton.setBounds(73, 154, 245, 61);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration form = new Registration();
				form.secondframe.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, new Color(0, 0, 0), null));
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.setFont(new Font("Bookman Old Style", Font.BOLD, 22));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Coaches");
		btnNewButton_1.setBounds(73, 251, 245, 61);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(SystemColor.scrollbar);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Coaches thirdframe= new Coaches();
				thirdframe.setVisible(true);
				
			}
		});
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, new Color(0, 0, 0), null));
		btnNewButton_1.setFont(new Font("Bookman Old Style", Font.BOLD, 22));
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Other Staff");
		btnNewButton_2.setBounds(73, 359, 245, 67);
		btnNewButton_2.setBackground(SystemColor.info);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Other fourthframe= new Other();
				fourthframe.setVisible(true);

			}
		});
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, new Color(0, 0, 0), null));
		btnNewButton_2.setFont(new Font("Bookman Old Style", Font.BOLD, 22));
		frame.getContentPane().add(btnNewButton_2);
		
		
		JLabel medic = new JLabel("");
		medic.setBounds(573, 395, 190, 165);
		frame.getContentPane().add(medic);
		
		JPanel panel = new JPanel();
		panel.setBounds(495, 0, 157, 587);
		panel.setBackground(new Color(102, 0, 0));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new MainFrame();
			}
	});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_3.setBorderPainted(false);			btnNewButton_3.setBackground(SystemColor.info);
		btnNewButton_3.setBounds(27, 431, 85, 31);
		panel.add(btnNewButton_3);

		

	}

}

