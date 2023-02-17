package gems;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class GEMS_Delete_GUI 
{
	private JButton apply = new JButton("Apply");
	private JButton cancel = new JButton("Cancel");
	
	private JOptionPane deleteEntryPopUp = new JOptionPane("DELETE ENTRY");
	private JTextField deleteTable = new JTextField("Table...");
	private JTextField deleteAttribute = new JTextField("Attribute...");
	private JTextField deleteValue = new JTextField("Value...");
	
	public GEMS_Delete_GUI()
	{
		makeFrame();
	}
	
	public void makeFrame()
	{
		
	}

}
