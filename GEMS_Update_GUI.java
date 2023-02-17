package gems;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class GEMS_Update_GUI 
{
	private JButton apply = new JButton("Apply");
	private JButton cancel = new JButton("Cancel");
	
	//Update Entry Frame 
	private JOptionPane updateEntryPopUp = new JOptionPane("UPDATE ENTRY");
	private JTextField updateTable = new JTextField("Table...");
	private JTextField updateAttribute = new JTextField("Changing Field...");
	private JTextField updateNewEntry = new JTextField("New Entry...");
	private JTextField updateTablePrimaryID = new JTextField("Table Primary ID...");
	private JTextField updateWhereValue = new JTextField("Where Value...");
	
	public GEMS_Update_GUI()
	{
		makeFrame();
	}
	
	public void makeFrame()
	{
		
	}

}
