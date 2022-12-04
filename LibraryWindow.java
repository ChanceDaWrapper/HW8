package hw8;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class LibraryWindow {
	//Using a hashmap for the inventory
	
	
	private JFrame frame;
	private JTextField SKUText;
	private JTextField TitleText;
	private JTextField QuantityText;
	private JTextField PriceText;
	public JTextArea outputText;
	public inventory library;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryWindow window = new LibraryWindow();
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
	public LibraryWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		SKUText = new JTextField();
		SKUText.setBounds(23, 39, 130, 26);
		frame.getContentPane().add(SKUText);
		SKUText.setColumns(10);
		
		TitleText = new JTextField();
		TitleText.setBounds(165, 39, 130, 26);
		frame.getContentPane().add(TitleText);
		TitleText.setColumns(10);
		
		QuantityText = new JTextField();
		QuantityText.setBounds(307, 39, 130, 26);
		frame.getContentPane().add(QuantityText);
		QuantityText.setColumns(10);
		
		PriceText = new JTextField();
		PriceText.setBounds(451, 39, 130, 26);
		frame.getContentPane().add(PriceText);
		PriceText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Textbook Library");
		lblNewLabel.setBounds(241, 6, 107, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SKU Number");
		lblNewLabel_1.setBounds(50, 26, 78, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Title");
		lblNewLabel_2.setBounds(215, 26, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setBounds(348, 26, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setBounds(495, 26, 61, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton addTextbook = new JButton("Add Textbook");
		addTextbook.setBounds(36, 92, 117, 29);
		frame.getContentPane().add(addTextbook);
		addTextbook.addActionListener(e->addTextbook());

		JButton RemoveTextbook = new JButton("Remove Textbook");
		RemoveTextbook.setBounds(154, 92, 157, 29);
		frame.getContentPane().add(RemoveTextbook);
		RemoveTextbook.addActionListener(e->removeTextbook());

		JButton TextbookInfo = new JButton("Textbook Info");
		TextbookInfo.setBounds(320, 92, 117, 29);
		frame.getContentPane().add(TextbookInfo);
		TextbookInfo.addActionListener(e->findTextbook());

		JButton Inventory = new JButton("Inventory");
		Inventory.setBounds(464, 92, 117, 29);
		frame.getContentPane().add(Inventory);
		Inventory.addActionListener(e->inventoryPrint());

		outputText = new JTextArea();
		outputText.setBounds(104, 133, 399, 129);
		frame.getContentPane().add(outputText);
		
		JButton btnNewButton_4 = new JButton("New Tree");
		btnNewButton_4.setBounds(7, 191, 85, 29);
		frame.getContentPane().add(btnNewButton_4);
		addTextbook.addActionListener(e->resetInventory());
	}
	
	public void addTextbook() {
		textbook t1 = new textbook((Integer.parseInt(SKUText.getText())), TitleText.getText(), Integer.parseInt(QuantityText.getText()), Integer.parseInt(PriceText.getText())); 
		library.addTextbook(t1);
		outputText.setText("Success! Textbook Added");
	
	}
	public void removeTextbook() {
		library.removeBook(Integer.parseInt(SKUText.getText()));
		outputText.setText("Textbook removed");
	}
	public void findTextbook() {
		library.findBook(Integer.parseInt(SKUText.getText()));
		//outputText.setText();
	}
	public void resetInventory() {
		library.resetTree();
		outputText.setText("Libary Inventory Reset");
	}
	public void inventoryPrint() {
		library.inOrder();
	}
}
