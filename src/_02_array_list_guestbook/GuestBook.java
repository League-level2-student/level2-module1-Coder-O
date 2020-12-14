package _02_array_list_guestbook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	
	JFrame frame;
	JPanel panel;
	JButton addButton;
	JButton viewButton;
	ArrayList<String> guestList;
	
	
	JFrame addFrame;
	JButton addConfirmButton;
	JTextField nameInput;
	
	void run() {
		frame = new JFrame();
		panel = new JPanel();
		addButton = new JButton("Add Name");
		viewButton = new JButton("View Names");
		
		
		
		frame.add(panel);
		panel.add(addButton);
		panel.add(viewButton);
		
		addButton.addActionListener(this);
		viewButton.addActionListener(this);
		
		frame.setVisible(true);
		frame.pack();
		
		guestList = new ArrayList<String>();
		guestList.add("Bob Banders");
		guestList.add("Sandy Summers");
		guestList.add("Greg Ganders");
		guestList.add("Donny Doners");
		
	}
	
	void addName() {
		addFrame = new JFrame("Enter a name.");
		JPanel addPanel = new JPanel();
		nameInput = new JTextField(20);
		addConfirmButton = new JButton("Confirm");
		
		addFrame.add(addPanel);
		addPanel.add(nameInput);
		addPanel.add(addConfirmButton);
		
		addFrame.pack();
		addFrame.setVisible(true);
		
		addConfirmButton.addActionListener(this);
	}
	
	String showGuestList() {
		String output = "";
		
		for (int i = 0; i < guestList.size(); i++) {
			output += "Guest #" + (i+1) + ": " + guestList.get(i)+ "\n";
		}
		
		return output;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton source = (JButton) e.getSource();
		
		if (source.equals(addButton)) {
			addName();
		} else if (source.equals(addConfirmButton)) {
			guestList.add(nameInput.getText());
			addFrame.dispose();
		} else if (source.equals(viewButton)) {
			JOptionPane.showMessageDialog(null, showGuestList());
		}
	}
}
