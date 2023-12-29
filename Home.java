package AddressBookSystemGUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicButtonUI;



public class Home {
	
	static JFrame frame = new JFrame("Address Book");
	
	Home() {
		Database db = new Database();
		
		AddEntry add = new AddEntry();
		ImageIcon icon = new ImageIcon("E:\\java projects\\AddressBook\\src\\AddressBookSystemGUI\\icon.png");
		frame.setIconImage(icon.getImage());
		add.addEntry();
		//font for the buttons 
		Font btnFont  = new Font("Verdana",Font.PLAIN,21);
		//title code
		JLabel title = new JLabel("<html><font color='red'>Address</font> Book <font color='red'>System</font></html>");
		title.setBounds(430,10,550,50);
		title.setForeground(new Color(112,112,112));
		title.setFont(new Font("Verdana",Font.PLAIN,25));
		frame.add(title);
		
		//add entry button code
		
		
		JButton addEntryBtn = new JButton("Add Entry");
		addEntryBtn.setBounds(100,80,170,50);
		addEntryBtn.setFocusable(false);
		addEntryBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addEntryBtn.setForeground(Color.white);
		addEntryBtn.setBorder(BorderFactory.createEmptyBorder());
		addEntryBtn.setUI(new CustomButton());
	
		addEntryBtn.setFont(btnFont);
		addEntryBtn.setBackground(new Color(170, 255, 0));
		frame.add(addEntryBtn);
		
		
		
		//delete entry btn code 
		JButton deleteEntryBtn = new JButton("Delete Entry");
		deleteEntryBtn.setBounds(270,80,170,50);
		deleteEntryBtn.setFocusable(false);
		deleteEntryBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		deleteEntryBtn.setForeground(new Color(112,112,112));
		deleteEntryBtn.setBorder(BorderFactory.createEmptyBorder());
		deleteEntryBtn.setUI(new CustomButton());
		deleteEntryBtn.setFont(btnFont);
		deleteEntryBtn.setBackground(null);
		frame.add(deleteEntryBtn);
		
		
		
		//view entry btn code 
		JButton viewEntryBtn = new JButton("View Entry");
		viewEntryBtn.setBounds(440,80,170,50);
		viewEntryBtn.setFocusable(false);
		viewEntryBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		viewEntryBtn.setForeground(new Color(112,112,112));
		viewEntryBtn.setBorder(BorderFactory.createEmptyBorder());
		viewEntryBtn.setUI(new CustomButton());
		viewEntryBtn.setFont(btnFont);
		viewEntryBtn.setBackground(null);
		frame.add(viewEntryBtn);
		
		//update entry btn code 
		JButton updateEntryBtn = new JButton("Update Entry");
		updateEntryBtn.setBounds(610,80,170,50);
		updateEntryBtn.setFocusable(false);
		updateEntryBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		updateEntryBtn.setForeground(new Color(112,112,112));
		updateEntryBtn.setBorder(BorderFactory.createEmptyBorder());
		updateEntryBtn.setUI(new CustomButton());
		updateEntryBtn.setFont(btnFont);
		updateEntryBtn.setBackground(null);
		frame.add(updateEntryBtn);
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		//click events
		
		//add entry clicked
		addEntryBtn.addActionListener((e) -> {
			//hide all the panel 
			DeleteEntry.panel.setVisible(false);
			UpdateEntry.panel.setVisible(false);
			ViewEntry.panel.setVisible(false);
			//show delete panel
			AddEntry.scroll.setVisible(true);
			AddEntry.addEntry();
			
			new Filter("");
			//DEFAULT DELETE
			deleteEntryBtn.setBackground(null);
			deleteEntryBtn.setForeground(new Color(112,112,112));
			
			//DEFAULT VIEW 
			viewEntryBtn.setBackground(null);
			viewEntryBtn.setForeground(new Color(112,112,112));
			//DEFAULT UPDATE
			updateEntryBtn.setBackground(null);
			updateEntryBtn.setForeground(new Color(112,112,112));
			
			//change add
			
			addEntryBtn.setBackground(new Color(170, 255, 0));
			addEntryBtn.setForeground(new Color(255,255,255));
			
		});
		
		//view entry clicked
		
			viewEntryBtn.addActionListener((e) -> {
				//hide all the panel 
				AddEntry.scroll.setVisible(false);
				AddEntry.panel.setVisible(false);
				UpdateEntry.panel.setVisible(false);
				DeleteEntry.panel.setVisible(false);
				//show delete panel
				ViewEntry.panel.setVisible(true);
				ViewEntry.viewEntry();
				ViewEntry.updateTable();
				db.loadFromFile();
				new Filter("");
				
			//DEFAULT DELETE
			deleteEntryBtn.setBackground(null);
			deleteEntryBtn.setForeground(new Color(112,112,112));
			
			//DEFAULT add
			addEntryBtn.setBackground(null);
			addEntryBtn.setForeground(new Color(112,112,112));
			//DEFAULT UPDATE
			updateEntryBtn.setBackground(null);
			updateEntryBtn.setForeground(new Color(112,112,112));
			
			//change view
			
			viewEntryBtn.setBackground(new Color(255,207,51));
			viewEntryBtn.setForeground(new Color(255,255,255));
			
		});
			
			//delete entry clicked
			
			deleteEntryBtn.addActionListener((e) -> {
				db.loadFromFile();
				//hide all the panel 
				AddEntry.scroll.setVisible(false);
				UpdateEntry.panel.setVisible(false);
				ViewEntry.panel.setVisible(false);
				//show delete panel
				DeleteEntry.panel.setVisible(true);
				new DeleteEntry().deleteEntry();
				DeleteEntry.updateTable();
				
				new Filter("");
			//DEFAULT view
			viewEntryBtn.setBackground(null);
			viewEntryBtn.setForeground(new Color(112,112,112));
			
			//DEFAULT add
			addEntryBtn.setBackground(null);
			addEntryBtn.setForeground(new Color(112,112,112));
			//DEFAULT UPDATE
			updateEntryBtn.setBackground(null);
			updateEntryBtn.setForeground(new Color(112,112,112));
			
			//change delete
			
			deleteEntryBtn.setBackground(Color.red);
			deleteEntryBtn.setForeground(new Color(255,255,255));
			
		});
				
				
			//update entry clicked
			
			updateEntryBtn.addActionListener((e) -> {
				UpdateEntry update = new UpdateEntry();
				update.updateEntry();
				UpdateEntry.panel.setVisible(true);
				//hide all
				AddEntry.scroll.setVisible(false);
				ViewEntry.panel.setVisible(false);
				DeleteEntry.panel.setVisible(false);
				update.updateTable();
				db.loadFromFile();
				new Filter("");
				
				
			//DEFAULT view
			viewEntryBtn.setBackground(null);
			viewEntryBtn.setForeground(new Color(112,112,112));
			
			//DEFAULT add
			addEntryBtn.setBackground(null);
			addEntryBtn.setForeground(new Color(112,112,112));
			//DEFAULT delete
			deleteEntryBtn.setBackground(null);
			deleteEntryBtn.setForeground(new Color(112,112,112));
			
			//change update
			
			updateEntryBtn.setBackground(new Color(30,144,255));
			updateEntryBtn.setForeground(new Color(255,255,255));
			
		});
				
				
		frame.setLayout(null);
		frame.setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	    frame.setSize(1200,750);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    
	}
	
	// Custom button ui
    static class CustomButton extends BasicButtonUI {
        @Override
        protected void paintButtonPressed(Graphics g, AbstractButton b) {
            
            g.setColor(new Color(255,255,255,128)); 
            g.fillRect(0, 0, b.getWidth(), b.getHeight());

            
            super.paintButtonPressed(g, b);
        }
}
}