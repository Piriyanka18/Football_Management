package Staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Other extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField txtid;
	private JTextField txtName;
	private JTextField txtdesignation;
	private JTextField txtaddress;
	private JTextField txtcontactno;
	private JTextField txtemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Other frame = new Other();
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
	public Other() {
		setTitle("Other Staff");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Other.class.getResource("/SquadDetails/Squad/FCB.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(220, 60, 1094, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 51));
		panel_2.setBounds(0, 418, 1080, 281);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(SystemColor.info);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete();
			}
		});
		btnDelete.setForeground(new Color(0, 0, 51));
		btnDelete.setFont(new Font("Cambria", Font.BOLD, 18));
		btnDelete.setBounds(753, 142, 104, 40);
		panel_2.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(SystemColor.window);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(10, 31, 118, 33);
		panel_2.add(lblNewLabel_1);
		
		txtid = new JTextField();
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
			          
		            String id = txtid.getText();
		               Connection con;
		               PreparedStatement pst;
		               con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
					
		                pst = con.prepareStatement("select Name,Designation,Address,ContactNo,Email from otherstaff where ID = ?");
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
		});
		txtid.setBounds(10, 62, 211, 27);
		panel_2.add(txtid);
		txtid.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(252, 62, 140, 27);
		panel_2.add(txtName);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setForeground(SystemColor.window);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(252, 31, 118, 33);
		panel_2.add(lblNewLabel_1_1);
		
		txtdesignation = new JTextField();
		txtdesignation.setColumns(10);
		txtdesignation.setBounds(435, 62, 140, 27);
		panel_2.add(txtdesignation);
		
		JLabel lblNewLabel_1_2 = new JLabel("Designation");
		lblNewLabel_1_2.setForeground(SystemColor.window);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(435, 31, 118, 33);
		panel_2.add(lblNewLabel_1_2);
		
		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(10, 152, 211, 27);
		panel_2.add(txtaddress);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Address");
		lblNewLabel_1_2_1.setForeground(SystemColor.window);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_2_1.setBounds(10, 121, 118, 33);
		panel_2.add(lblNewLabel_1_2_1);
		
		txtcontactno = new JTextField();
		txtcontactno.setColumns(10);
		txtcontactno.setBounds(252, 152, 140, 27);
		panel_2.add(txtcontactno);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Contact No");
		lblNewLabel_1_2_2.setForeground(SystemColor.window);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_2_2.setBounds(252, 121, 118, 33);
		panel_2.add(lblNewLabel_1_2_2);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(435, 152, 140, 27);
		panel_2.add(txtemail);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Email");
		lblNewLabel_1_2_3.setForeground(SystemColor.window);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_2_3.setBounds(435, 121, 118, 33);
		panel_2.add(lblNewLabel_1_2_3);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add();
			}
			
		});
		btnNewButton.setForeground(new Color(0, 0, 51));
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 18));
		btnNewButton.setBounds(753, 62, 104, 40);
		panel_2.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBackground(SystemColor.info);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		
		btnUpdate.setForeground(new Color(0, 0, 51));
		btnUpdate.setFont(new Font("Cambria", Font.BOLD, 18));
		btnUpdate.setBounds(915, 62, 104, 40);
		panel_2.add(btnUpdate);
		
		
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBorderPainted(false);
		btnReset.setBackground(SystemColor.info);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtid.setText("");
				txtName.setText("");
				txtdesignation.setText("");
				txtaddress.setText("");
				txtcontactno.setText("");
				txtemail.setText("");
			}
		});
		btnReset.setForeground(new Color(0, 0, 51));
		btnReset.setFont(new Font("Cambria", Font.BOLD, 18));
		btnReset.setBounds(915, 142, 104, 40);
		panel_2.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBorderPainted(false);
		btnExit.setBackground(SystemColor.info);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (JOptionPane.showConfirmDialog(null,"confirm if you want to exit","Membership registration System",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				
				
			}}
		});
		btnExit.setForeground(new Color(0, 0, 51));
		btnExit.setFont(new Font("Cambria", Font.BOLD, 18));
		btnExit.setBounds(915, 209, 104, 40);
		panel_2.add(btnExit);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(SystemColor.info);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainInt window = new MainInt();
				window.frame.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setForeground(new Color(0, 0, 51));
		btnNewButton_1.setBounds(10, 227, 77, 40);
		panel_2.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 0));
		panel.setBounds(0, 0, 1080, 699);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setRowHeight(30);
		table.setBounds(540, 5, 0, 0);
		panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(102, 0, 0));
		scrollPane.setBounds(10, 47, 1060, 529);
		panel.add(scrollPane);
		
		table_1 = new JTable();
	
		table_1.setRowHeight(30);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Designation", "Address", "ContactNo", "Email"
			}
		));
		load_table();
		scrollPane.setViewportView(table_1);
		
		
		JLabel lblNewLabel = new JLabel("OTHER STAFF");
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Bodoni MT Black", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 5, 424, 48);
		panel.add(lblNewLabel);
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
		     
			pst = con.prepareStatement("INSERT INTO otherstaff(ID , Name, Designation, Address, ContactNo, Email)"+"VALUES(?,?,?,?,?,?)");
			pst.setLong(1,sid);
			pst.setString(2,sname);
			pst.setString(3,sdesignation);
			pst.setString(4,saddress);
			pst.setLong(5,scontactno);
			pst.setString(6,semail);
			
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null,"Record Added ");
			
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
			String sql="SELECT * FROM `otherstaff` WHERE 1";
			ResultSet rs=stmt.executeQuery(sql);
			table_1.setModel(DbUtils.resultSetToTableModel(rs));

			while (rs.next()) {
				
				col [0] = rs.getString("Id");
				col [1] = rs.getString("Name");
				col [2] = rs.getString("Designation");
				col [3] = rs.getString("Address");
				col [4] = rs.getString("Contact No");
				col [5] = rs.getString("Email");
			
				
				
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
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
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		if (table_1.getSelectedRow()== -1) {
			if (table_1.getRowCount() == 0) {
				
			JOptionPane.showMessageDialog(null,"No data to Delete ",
					"Membership Management System", JOptionPane.OK_OPTION);
			
			}else {
				JOptionPane.showMessageDialog(null,"Select a row to Delete ",
						"Membership Management System", JOptionPane.OK_OPTION);
				
				
			}
		}else {
			try {
				
				PreparedStatement pst;
				int row = table_1.getSelectedRow();
				String selected = model.getValueAt(row,0).toString();
		
			  Connection con= DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
			     
				pst = con.prepareStatement("DELETE FROM otherstaff WHERE ID='"+selected+"'");
			
			
			model.removeRow(table_1.getSelectedRow());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null,"Record deleted");
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
		     
			pst = con.prepareStatement("UPDATE  otherstaff SET Name=?, Designation=?, Address=?, ContactNo=?, Email=? WHERE ID=?");
		
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
           JOptionPane.showMessageDialog(null,  "Enter the ID to Update ");
       }}
	
		
		public void searchId1() {
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


