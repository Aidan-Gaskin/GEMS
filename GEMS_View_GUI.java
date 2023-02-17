package gems;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class GEMS_View_GUI 
{
	
	
	//Buttons Used In All View Frames
	private JButton createEntry = new JButton("Create Entry");
	private JButton updateEntry = new JButton("Update Entry");
	private JButton deleteEntry = new JButton("Delete Entry");
	private JButton refresh = new JButton("Refresh");
//View Items Frame
//	private JLabel itemID = new JLabel("Item ID");
//	private JLabel description = new JLabel("Description");
//	private JLabel supplierID = new JLabel("Supplier ID");
//	private JLabel buyPrice = new JLabel("Buy Price");
//	private JLabel sellPrice = new JLabel("Sell Price");
	private JTable itemTable = new JTable();//need to use methods to add collumns and data
//View Clients Frame 
	private JTable clientsTable = new JTable();
//View Administrators Frame 
	private JTable administratorsTable = new JTable();
//View Account Managers Table 
	private JTable accountManagerTable = new JTable();
//View Supplier Table 
	private JTable supplierTable = new JTable();
//View Order Table 
	private JTable orderTable = new JTable();
	
	
	//If I create a method to produce the desired view,
	//I would need to set frame to invisible and only visible
	//once clicked and then set to invisible again once changed view/frame
	
	public GEMS_View_GUI()
	{
		
	}
	

	
	public void makeAdminFrame()//1
	{
		
	}
	public void makeClientFrame()//2
	{
		
	}
	public void makeAccountManagerFrame()//3
	{
		
	}
	public void makeSupplierFrame()//4
	{
		
	}
	public void makeOrderFrame()//5
	{
		
	}
	public void makeItemFrame()//6
	{
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
