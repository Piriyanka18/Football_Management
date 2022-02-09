package Staff;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
//import java.awt.SystemColor;

public class Coaches extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtdesignation;
	private JTextField txtName;
	private JTextField txtid;
	private JTextField txtaddress;
	private JTextField txtcontactno;
	private JTextField txtemail;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coaches frame = new Coaches();
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
	public Coaches() {
		setTitle("Coaches");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Coaches.class.getResource("/SquadDetails/Squad/FCB.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 70, 1031, 714);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 433, 1017, 244);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(25, 26, 119, 27);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(266, 26, 119, 27);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("designation");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(462, 26, 119, 27);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(25, 98, 119, 27);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Contact No");
		lblNewLabel_1_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(266, 98, 119, 27);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Email");
		lblNewLabel_1_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(466, 98, 119, 27);
		panel_1.add(lblNewLabel_1_5);
		
		txtdesignation = new JTextField();
		txtdesignation.setBounds(461, 50, 141, 38);
		panel_1.add(txtdesignation);
		txtdesignation.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(266, 50, 150, 38);
		panel_1.add(txtName);
		
		txtid = new JTextField();
		txtid.setBackground(new Color(255, 255, 255));
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchId();
			}
		});
		txtid.addMouseListener(new MouseAdapter() {
		
			
		});
		
		
		txtid.setColumns(10);
		txtid.setBounds(21, 50, 209, 38);
		panel_1.add(txtid);
		
		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(25, 122, 205, 40);
		panel_1.add(txtaddress);
		
		txtcontactno = new JTextField();
		txtcontactno.setColumns(10);
		txtcontactno.setBounds(266, 122, 150, 38);
		panel_1.add(txtcontactno);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(461, 122, 141, 38);
		panel_1.add(txtemail);
		
		JButton Add = new JButton("Add");
		Add.setBorderPainted(false);
		Add.setBackground(new Color(255, 255, 225));
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add();
				
			}
		});
		Add.setForeground(new Color(0, 0, 51));
		Add.setFont(new Font("Cambria", Font.BOLD, 18));
		Add.setBounds(683, 58, 119, 30);
		panel_1.add(Add);
		
		JButton Delete = new JButton("Delete");
		Delete.setBorderPainted(false);
		Delete.setBackground(new Color(255, 255, 225));
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete();
			}
		});
		Delete.setForeground(new Color(0, 0, 51));
		Delete.setFont(new Font("Cambria", Font.BOLD, 18));
		Delete.setBounds(683, 122, 119, 30);
		panel_1.add(Delete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBorderPainted(false);
		btnExit.setBackground(new Color(255, 255, 225));
		btnExit.setForeground(new Color(0, 0, 51));
		btnExit.setFont(new Font("Cambria", Font.BOLD, 18));
		btnExit.setBounds(842, 178, 119, 30);
		panel_1.add(btnExit);
		
		JButton Update = new JButton("Update");
		Update.setBorderPainted(false);
		Update.setBackground(new Color(255, 255, 225));
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		Update.setForeground(new Color(0, 0, 51));
		Update.setFont(new Font("Cambria", Font.BOLD, 18));
		Update.setBounds(842, 58, 119, 30);
		panel_1.add(Update);
		
		JButton Reset = new JButton("Reset");
		Reset.setBorderPainted(false);
		Reset.setBackground(new Color(255, 255, 225));
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtid.setText("");
				txtName.setText("");
				txtdesignation.setText("");
				txtaddress.setText("");
				txtcontactno.setText("");
				txtemail.setText("");
				
			}
		});
		Reset.setForeground(new Color(0, 0, 51));
		Reset.setFont(new Font("Cambria", Font.BOLD, 18));
		Reset.setBounds(842, 122, 119, 30);
		panel_1.add(Reset);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(new Color(255, 255, 225));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainInt window = new MainInt();
				window.frame.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 51));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_1.setBounds(23, 197, 77, 40);
		panel_1.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 0));
		panel.setBounds(0, 10, 1017, 667);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 997, 359);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(30);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Designation", "Address", "ContactNo", "Email"
			}
			
		
		));
		
		load_table();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("COACH DETAILS");
		lblNewLabel.setBounds(10, -13, 411, 80);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(204, 204, 204));
		lblNewLabel.setFont(new Font("Bodoni MT Black", Font.BOLD, 29));
	}
	public void Add() {
		int sid, scontactno ;
		String sname,sdesignation,saddress, semail;
		
		
		try {
			sid= Integer.parseInt(txtid.getText());
			sname=txtName.getText();
			sdesignation= txtdesignation.getText();
			saddress= txtaddress.getText();
			scontactno = Integer.parseInt(txtcontactno.getText());
			semail = txtemail.getText();
			
			PreparedStatement pst;
	
		  Connection con= DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
		     
			pst = con.prepareStatement("INSERT INTO coaches(ID , Name, Designation, Address, ContactNo, Email)"+"VALUES(?,?,?,?,?,?)");
			pst.setLong(1,sid);
			pst.setString(2,sname);
			pst.setString(3,sdesignation);
			pst.setString(4,saddress);
			pst.setLong(5,scontactno);
			pst.setString(6,semail);
			
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null,"Record Added");
			
			load_table();
			txtid.setText("");
			txtName.setText("");
			txtdesignation.setText("");
			txtaddress.setText("");
			txtcontactno.setText("");
			txtemail.setText("");
			txtid.requestFocus();
			
			
         
     } catch (Exception ex) {
         JOptionPane.showMessageDialog(null,  ex.getMessage());
     }
	}

	public void load_table() {
		Connection con;
		
		
	Object[] col = new Object[6];
	 try {  
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
			Statement stmt = con.createStatement();
			String sql="SELECT * FROM `coaches` WHERE 1";
			ResultSet rs=stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));

			while (rs.next()) {
				
				col [0] = rs.getString("Id");
				col [1] = rs.getString("Name");
				col [2] = rs.getString("Designation");
				col [3] = rs.getString("Address");
				col [4] = rs.getString("Contact No");
				col [5] = rs.getString("Email");
			
				
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(col);
			}
			con.close();
			}
			

		catch(Exception e1) {
			;
			System.out.print(e1);
		}
		
	
	
}
	public void Delete() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if (table.getSelectedRow()== -1) {
			if (table.getRowCount() == 0) {
				
			JOptionPane.showMessageDialog(null,"No data to Delete ",
					"Membership Management System", JOptionPane.OK_OPTION);
			
			}else {
				JOptionPane.showMessageDialog(null,"Select a row to Delete ",
						"Membership Management System", JOptionPane.OK_OPTION);
				
				
			}
		}else {
			try {
				
				PreparedStatement pst;
				int row = table.getSelectedRow();
				String selected = model.getValueAt(row,0).toString();
		
			  Connection con= DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
			     
				pst = con.prepareStatement("DELETE FROM coaches WHERE ID='"+selected+"'");
			
			
			model.removeRow(table.getSelectedRow());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null,"Record Deleted");
			load_table();}
			catch(Exception e1) {
				
				System.out.print(e1);
			}
			
			
			
		
			}
	
}
	public void update() {
		
		int sid, scontactno ;
		String sname,sdesignation,saddress, semail;
		
		
		try {
			sid= Integer.parseInt(txtid.getText());
			sname=txtName.getText();
			sdesignation= txtdesignation.getText();
			saddress= txtaddress.getText();
			scontactno = Integer.parseInt(txtcontactno.getText());
			semail = txtemail.getText();
			
			PreparedStatement pst;
	
		  Connection con= DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
		     
			pst = con.prepareStatement("UPDATE  coaches SET Name=?, Designation=?, Address=?, ContactNo=?, Email=? WHERE ID=?");
		
			pst.setLong(6, sid);
			pst.setString(1,sname);
			pst.setString(2,sdesignation);
			pst.setString(3,saddress);
			pst.setLong(4,scontactno);
			pst.setString(5,semail);
			
			pst.executeUpdate();
			
		
			JOptionPane.showMessageDialog(null,"Updated");
			
			load_table();
			
			txtName.setText("");
			txtdesignation.setText("");
			txtaddress.setText("");
			txtcontactno.setText("");
			txtemail.setText("");
			txtid.requestFocus();
			
         
     } catch (Exception ex) {
         JOptionPane.showMessageDialog(null, "Enter the ID to Update ");
     }}
	
		
		public void searchId() {
		try {
	          
          String id = txtid.getText();
             Connection con;
             PreparedStatement pst;
             con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
			
              pst = con.prepareStatement("select Name,Designation,Address,ContactNo,Email from coaches where ID = ?");
              pst.setNString(1, id);
              ResultSet rs = pst.executeQuery();

          if(rs.next()==true)
          {
          	
              String Name = rs.getString(1);
              String Designation = rs.getString(2);
              String Address = rs.getString(3);
              String ContactNo = rs.getString(4);
              String Email = rs.getString(5);
            
              txtName.setText(Name);
              txtdesignation.setText(Designation);
              txtaddress.setText(Address);
              txtcontactno.setText(ContactNo);
              txtemail.setText(Email);
              
              
              
          }  
          else
          {
              txtName.setText("");
              txtdesignation.setText("");
              txtaddress.setText("");
              txtcontactno.setText("");
              txtemail.setText("");
              
          }
          


      }
catch (SQLException ex) {
        
      }
}
}