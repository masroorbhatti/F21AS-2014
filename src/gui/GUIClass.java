package gui;

import global.Shared;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import pl.Table;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTable;

public class GUIClass extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea,textArea_1;
	private JLabel lblNewLabel;
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public GUIClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterTableNumber = new JLabel("Enter Table Number");
		lblEnterTableNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblEnterTableNumber.setBounds(24, 20, 113, 14);
		contentPane.add(lblEnterTableNumber);
		
		textField = new JTextField();
		textField.setBounds(147, 17, 95, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(24, 82, 459, 172);
		textArea.setFont(new Font (Font.MONOSPACED, Font.PLAIN,11));
		textArea.setEditable(false);
		textArea.setCaretPosition(0);
		
		JScrollPane scroll = new JScrollPane(textArea_1);
		contentPane.add(scroll);
		
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Generate Bill");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int input = Integer.parseInt(textField.getText());
				Table tb = Shared.resttables.getTable(input);
				if (tb!=null) {
					textArea.setText(tb.getOrderdItemDetails());
				}
				else{
					textArea.setText("Invalid Table Number");
				}
				
			}
		});
		btnNewButton.setBounds(147, 48, 125, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("List of Occupied Tables");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblNewLabel.setBounds(368, 10, 125, 23);
		contentPane.add(lblNewLabel);
		

		
		table = new JTable();
		table.setBounds(314, 63, 131, -22);
		contentPane.add(table);
		ArrayList<Table> tblist = Shared.resttables.getOccupiedTableList();
		String tablelist = "";
		for(Table tb : tblist){
			tablelist +=  tb.getTableno()+"\n";
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(368, 30, 115, 51);
		contentPane.add(scrollPane);
		
		textArea_1 = new JTextArea();
		textArea_1.setText(tablelist);
		scrollPane.setViewportView(textArea_1);
	}
}
