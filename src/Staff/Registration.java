package Staff;


import java.awt.EventQueue;
import net.proteanit.sql.DbUtils;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
//import javax.swing.UIManager;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Registration {

	JFrame secondframe;
	private JTextField txtid;
	private JTextField txtName;
	private JTextField txtdesignation;
	private JTextField txtaddress;
	private JTextField txtcontactno;
	private JTextField txtemail;
	private JTable table;
	DefaultTableModel model;

	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.secondframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Registration() {

		
	
		secondframe = new JFrame();
		secondframe.setTitle("Medical Staff");
		secondframe.setIconImage(Toolkit.getDefaultToolkit().getImage(Registration.class.getResource("/SquadDetails/Squad/FCB.png")));
		secondframe.setBounds(200, 60, 1125, 684);
		secondframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		secondframe.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 0));
		panel.setForeground(Color.BLACK);
		panel.setBounds(0, 0, 1101, 637);
		secondframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(new Dimension(0, 5));
		scrollPane.setBounds(11, 49, 1084, 316);
		panel.add(scrollPane);
		
		//.................table.............................
		table = new JTable();
		table.setRowHeight(30);
		
		
		model =new DefaultTableModel();
		table.addMouseListener(new MouseAdapter() {
			
		});;
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Designation", "Address", "Contact No", "Email"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		table.getColumnModel().getColumn(3).setPreferredWidth(86);
		table.getColumnModel().getColumn(4).setPreferredWidth(107);
		scrollPane.setViewportView(table);
		
		load_table();
		
		//......................... address.......................
		
		JLabel lblAdress = new JLabel("Address");
		lblAdress.setBounds(11, 484, 73, 34);
		lblAdress.setForeground(SystemColor.window);
		lblAdress.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblAdress);
		
		txtaddress = new JTextField();
		txtaddress.setBounds(11, 516, 163, 40);
		txtaddress.setColumns(10);
		panel.add(txtaddress);
		
		// ..........................panel 1..............................
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 375, 1101, 276);
		panel_1.setForeground(new Color(204, 0, 0));
		panel_1.setBackground(new Color(0, 0, 51));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtid = new JTextField();
		txtid.setBackground(Color.WHITE);
		txtid.setBounds(10, 68, 167, 44);
		panel_1.add(txtid);
		txtid.setColumns(10);
		
		
		
		
		
		
						txtid.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
							try {
							          
							            String id = txtid.getText();
							               Connection con;
							               PreparedStatement pst;
							               con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
										
							                pst = con.prepareStatement("select Name,Designation,Address,ContactNo,Email from medical where ID = ?");
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
		

		
		
		//...............................designation......................
		
		JLabel lblDesignation = new JLabel("Designation ");
		lblDesignation.setBounds(468, 34, 121, 44);
		panel_1.add(lblDesignation);
		lblDesignation.setForeground(SystemColor.window);
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtdesignation = new JTextField();
		txtdesignation.setBounds(468, 68, 152, 36);
		panel_1.add(txtdesignation);
		txtdesignation.setColumns(10);
		
		//........................Name.....................................
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(243, 34, 73, 44);
		panel_1.add(lblName);
		lblName.setForeground(SystemColor.window);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		

		txtName = new JTextField();
		txtName.setBackground(new Color(255, 255, 255));
		txtName.setBounds(243, 68, 152, 44);
		panel_1.add(txtName);
		txtName.setColumns(10);	
					
	
			//.........................Email.....................
			
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setBounds(468, 110, 73, 34);
			panel_1.add(lblEmail);
			lblEmail.setForeground(SystemColor.window);
			lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			txtemail = new JTextField();
			txtemail.setBounds(468, 141, 152, 44);
			panel_1.add(txtemail);
			txtemail.setColumns(10);
			
			//........................contact No.............
			
			txtcontactno = new JTextField();
			txtcontactno.setBounds(243, 141, 152, 44);
			panel_1.add(txtcontactno);
			txtcontactno.setColumns(10);
			
			JLabel lblContactNo = new JLabel("Contact No ");
			lblContactNo.setBounds(243, 110, 121, 34);
			panel_1.add(lblContactNo);
			lblContactNo.setForeground(SystemColor.window);
			lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			//.......................Exit button.....................
			
			JButton btnNewButton_1 = new JButton("Exit");
			btnNewButton_1.setBorderPainted(false);
			btnNewButton_1.setBackground(SystemColor.info);
			btnNewButton_1.setBounds(944, 194, 113, 44);
			panel_1.add(btnNewButton_1);
			btnNewButton_1.setForeground(new Color(0, 0, 102));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					secondframe= new JFrame();
					
					if (JOptionPane.showConfirmDialog(secondframe,"confirm if you want to exit","Membership registration System",
							JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
						System.exit(0);
					};
				}
			});
			btnNewButton_1.setFont(new Font("Cambria", Font.BOLD, 18));
			
			//............................Add button....................
			
			JButton btnNewButton = new JButton("Add");
			btnNewButton.setBorderPainted(false);
			btnNewButton.setBackground(SystemColor.info);
			btnNewButton.setBounds(813, 64, 101, 44);
			panel_1.add(btnNewButton);
			btnNewButton.setForeground(new Color(0, 0, 102));
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
							Add();
					}
					
					
			
			});
			btnNewButton.setFont(new Font("Cambria", Font.BOLD, 18));
			
			//........................Update Button......................
			
			JButton btnUpdate = new JButton("Update");
			btnUpdate.setBorderPainted(false);
			btnUpdate.setBackground(SystemColor.info);
			btnUpdate.setBounds(944, 64, 113, 44);
			panel_1.add(btnUpdate);
			btnUpdate.setForeground(new Color(0, 0, 102));
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					update();
					
						
				}
			});
			btnUpdate.setFont(new Font("Cambria", Font.BOLD, 18));
			
			//............................Delete Button..................
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.setBorderPainted(false);
			btnDelete.setBackground(SystemColor.info);
			btnDelete.setBounds(813, 127, 101, 40);
			panel_1.add(btnDelete);
			btnDelete.setForeground(new Color(0, 0, 102));
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Delete();
					
				
				}
			});
			btnDelete.setFont(new Font("Cambria", Font.BOLD, 18));
			
			//..........................Reset Button.......................
			
			JButton btnClear = new JButton("Reset");
			btnClear.setBorderPainted(false);
			btnClear.setBackground(SystemColor.info);
			btnClear.setBounds(944, 125, 113, 44);
			panel_1.add(btnClear);
			btnClear.setForeground(new Color(0, 0, 102));
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtid.setText("");
					txtName.setText("");
					txtdesignation.setText("");
					txtaddress.setText("");
					txtcontactno.setText("");
					txtemail.setText("");
					
				}
			});
			btnClear.setFont(new Font("Cambria", Font.BOLD, 18));
			
			//.........................label medical staff................
			
			JLabel lblNewLabel = new JLabel("MEDICAL STAFF");
			lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
			lblNewLabel.setFont(new Font("Bodoni MT Black", Font.BOLD, 29));
			lblNewLabel.setBounds(11, 10, 285, 40);
			panel.add(lblNewLabel);
			
			//..........................ID.................................	
			JLabel Id = new JLabel("ID");
			Id.setBounds(10, 34, 73, 44);
			panel_1.add(Id);
			Id.setForeground(SystemColor.window);
			Id.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			//............................back button......................
			
			JButton btnNewButton_1_1 = new JButton("BACK");
			btnNewButton_1_1.setBorderPainted(false);
			btnNewButton_1_1.setBackground(SystemColor.info);
			btnNewButton_1_1.setBounds(10, 209, 77, 40);
			panel_1.add(btnNewButton_1_1);
			btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondframe.dispose();
				MainInt window = new MainInt();
				window.frame.setVisible(true);
				
				
				}

		
			});
			btnNewButton_1_1.setForeground(new Color(0, 0, 51));
			btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
	
		
	}
		public void load_table() {
			Connection con;
			
			
		Object[] col = new Object[6];
		 try {  
				Class.forName("com.mysql.cj.jdbc.Driver");
				 con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
				Statement stmt = con.createStatement();
				String sql="SELECT * FROM `medical` WHERE 1";
				ResultSet rs=stmt.executeQuery(sql);
				table.setModel(DbUtils.resultSetToTableModel(rs));

				while (rs.next()) {
					
					col [0] = rs.getString("Id");
					col [1] = rs.getString("Name");
					col [2] = rs.getString("Designation");
					col [3] = rs.getString("Address");
					col [4] = rs.getString("Contact No");
					col [5] = rs.getString("Email");
					
					
					
					model.addRow(col);
				}
				con.close();
				
				
		 }
			catch(Exception e1) {
				;
				System.out.print(e1);
			}
			
		
		
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
			     
				pst = con.prepareStatement("INSERT INTO medical(ID , Name, Designation, Address, ContactNo, Email)"+"VALUES(?,?,?,?,?,?)");
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
			     
				pst = con.prepareStatement("UPDATE  medical SET Name=?, Designation=?, Address=?, ContactNo=?, Email=? WHERE ID=?");
			
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
	           JOptionPane.showMessageDialog(null,  "Enter the ID number ");
	       }}
		
		
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
				     
					pst = con.prepareStatement("DELETE FROM medical  WHERE ID='"+selected+"'");
				
				
				model.removeRow(table.getSelectedRow());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Record Deleted");
				load_table();}
				catch(Exception e1) {
					
					System.out.print(e1);
				}
				
				
				
			
				}
		
		}		
	}

