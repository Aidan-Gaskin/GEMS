package gems;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class GEMS_Create_GUI 
{
	
	private JButton apply = new JButton("Apply");
	private JButton cancel = new JButton("Cancel");
	
//Create Entry Administrator
	private JOptionPane createAdminEntryPopUp = new JOptionPane("CREATE ADMIN ENTRY");
	private JTextField createAdminForename = new JTextField("Forename...");
	private JTextField createAdminSurname = new JTextField("Surname...");
	private JTextField createAdminPhoneNo = new JTextField("Phone Number...");
//Create Entry AccountManager 
	private JOptionPane createAccountEntryPopUp = new JOptionPane("CREATE ACCOUNT MANAGER ENTRY");
	private JTextField createAccountForename = new JTextField("Forename...");
	private JTextField createAccountSurname = new JTextField("Surname...");
	private JTextField createAccountPhoneNo = new JTextField("Phone Number...");
//Create Entry Order
	private JOptionPane createOrderEntryPopUp = new JOptionPane("CREATE ORDER ENTRY");
	private JTextField createOrderClientID = new JTextField("Client ID...");
	private JTextField createOrderAccountManID = new JTextField("Account Manager ID...");
	private JTextField createOrderAdminID = new JTextField("Administrator ID...");
	private JTextField createOrderItemID = new JTextField("Item ID...");
	private JTextField createOrderQuantity = new JTextField("Quantity...");
	private JTextField createOrderSupplierID = new JTextField("Supplier ID...");
	private JTextField createOrderDeliveryAddress = new JTextField("Delivery Address...");
//Create Entry Supplier
	private JOptionPane createSupplieEntryPopUp = new JOptionPane("CREATE SUPPLIER ENTRY");
	private JTextField createSupplierCompanyName = new JTextField("Company Name...");
	private JTextField createSupplierAddress = new JTextField("Address...");
	private JTextField createSupplierForename = new JTextField("Contact Forename...");
	private JTextField createSupplierSurname = new JTextField("Contact Surname...");
	private JTextField createSupplierEmail = new JTextField("Contact Email...");
	private JTextField createSupplierPhoneNo = new JTextField("Contact Phone Number...");
//Create Entry Item
	private JOptionPane createItemEntryPopUp = new JOptionPane("CREATE ITEM ENTRY");
	private JTextField createItemDescription = new JTextField("Description...");
	private JTextField createItemSupplierID = new JTextField("Supplier ID...");
	private JTextField createItemBuyPrice = new JTextField("Buy Price...");
	private JTextField createItemSellPrice = new JTextField("Sell Price....");
//Create Entry Client 
	private JOptionPane createClientEntryPopUp = new JOptionPane("CREATE CLIENT ENTRY");
	private JTextField createClientCompanyName = new JTextField("Company Name...");
	private JTextField createClientAddress = new JTextField("Address...");
	private JTextField createClientAccountManID = new JTextField("Account Manager ID...");
	private JTextField createClientForename = new JTextField("Forename...");
	private JTextField createClientSurname = new JTextField("Surname...");
	private JTextField createClientEmail = new JTextField("Contact Email...");
	private JTextField createClientPhoneNo = new JTextField("Contact Phone Number...");
	
	public GEMS_Create_GUI()
	{
		makeFrame();
	}
	
	public void makeFrame()
	{
		
	}

}
