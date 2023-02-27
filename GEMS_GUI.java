package gems;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GEMS_GUI 
{
	//Main Frame 
		private JFrame gems = new JFrame("G.E.M.S - Gaskin Enterprise Management System");
			//Main Frame Menu Bar
			private JMenuBar gemsMenuBar = new JMenuBar();
				private JMenu gemsMENU = new JMenu("G.E.M.S");
					private JMenuItem tbcItem = new JMenuItem("TBC");
					private JMenuItem tbcItem2 = new JMenuItem("TBC");
					private JMenu gemsHELP = new JMenu("Help");
					private JMenuItem tbcItem3 = new JMenuItem("TBC");
					private JMenuItem tbcItem4 = new JMenuItem("TBC");
					
		//Required Buttons
		private JButton viewItems = new JButton("View: Items");
		private JButton viewClients = new JButton("View: Clients");
		private JButton viewAdministrators = new JButton("View: Administrators");
		private JButton viewAccountManagers = new JButton("View: Account Managers");
		private JButton viewSuppliers = new JButton("View: Suppliers");
		private JButton viewOrders = new JButton("View: Orders");
		
		//Required Panels 
		private JPanel westPanel = new JPanel();//add the buttons to
		private JPanel centerPanel = new JPanel();//the blank square
		private JPanel centerSouth = new JPanel();//CUD buttons 
		
		
	//Buttons Used In All View Frames
		private JButton createEntryAdministrator = new JButton("Create Entry");
		private JButton createEntryAccountManager = new JButton("Create Entry");
		private JButton createEntryClient = new JButton("Create Entry");
		private JButton createEntryItem = new JButton("Create Entry");
		private JButton createEntryOrder = new JButton("Create Entry");
		private JButton createEntrySupplier = new JButton("Create Entry");

		
		private JButton updateEntry = new JButton("Update Entry");
		private JButton deleteEntry = new JButton("Delete Entry");
		private JButton refresh = new JButton("Refresh");
		
	//Buttons Used In All CRUD 
		private JButton apply = new JButton("Apply");
		private JButton cancel = new JButton("Cancel");
		
	//Update Entry Frame 
		private JOptionPane updateEntryPopUp = new JOptionPane("UPDATE ENTRY");
		private JTextField updateTable = new JTextField("Table...");
		private JTextField updateAttribute = new JTextField("Changing Field...");
		private JTextField updateNewEntry = new JTextField("New Entry...");
		private JTextField updateTablePrimaryID = new JTextField("Table Primary ID...");
		private JTextField updateWhereValue = new JTextField("Where Value...");
		
	//Delete Entry Frame
		private JOptionPane deleteEntryPopUp = new JOptionPane("DELETE ENTRY");
		private JTextField deleteTable = new JTextField("Table...");
		private JTextField deleteAttribute = new JTextField("Attribute...");
		private JTextField deleteValue = new JTextField("Value...");
		
//	//Create Entry Administrator
//		private JOptionPane createAdminEntryPopUp = new JOptionPane("CREATE ADMIN ENTRY");
//		private JTextField createAdminForename = new JTextField("Forename...");
//		private JTextField createAdminSurname = new JTextField("Surname...");
//		private JTextField createAdminPhoneNo = new JTextField("Phone Number...");
		
//	//Create Entry AccountManager 
//		private JOptionPane createAccountEntryPopUp = new JOptionPane("CREATE ACCOUNT MANAGER ENTRY");
//		private JTextField createAccountForename = new JTextField("Forename...");
//		private JTextField createAccountSurname = new JTextField("Surname...");
//		private JTextField createAccountPhoneNo = new JTextField("Phone Number...");
		
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
		
//	//Create Entry Client 
//		private JOptionPane createClientEntryPopUp = new JOptionPane("CREATE CLIENT ENTRY");
//		private JTextField createClientCompanyName = new JTextField("Company Name...");
//		private JTextField createClientAddress = new JTextField("Address...");
//		private JTextField createClientAccountManID = new JTextField("Account Manager ID...");
//		private JTextField createClientForename = new JTextField("Forename...");
//		private JTextField createClientSurname = new JTextField("Surname...");
//		private JTextField createClientEmail = new JTextField("Contact Email...");
//		private JTextField createClientPhoneNo = new JTextField("Contact Phone Number...");
	
	//GEMS for Data Operations 
		private GEMS y = new GEMS();
		
		//--------------------
		
		//Individual Database Tables 
		//Item
		private String[] itemHeader = {"Item ID","Description","Supplier ID","Buy Price","Sell Price"};
		private Object[][] itemData = y.retrieveSelectedTableObject("item");
		private JTable itemTable = new JTable(itemData, itemHeader);
		private JScrollPane itemScroll = new JScrollPane(itemTable);
		
		//Client
		private String[] clientHeader = {"Client ID","Company Name","Address","Account Manager ID","Contact Forename"
				,"Contact Surname","Contact Email","Contact Phone No"};
		private Object[][] clientData = y.retrieveSelectedTableObject("client");
		private JTable clientTable = new JTable(clientData, clientHeader);
		private JScrollPane clientScroll = new JScrollPane(clientTable);
		
		//Account Manager
		private String[] accountManagerHeader = {"Account Manager ID","Forename","Surname","Phone Number"};
		private Object[][] accountManagerData = y.retrieveSelectedTableObject("AccountManager");
		private JTable accountManagerTable = new JTable(accountManagerData, accountManagerHeader);
		private JScrollPane accountManagerScroll = new JScrollPane(accountManagerTable);
		
		//Administrator
		private String[] administratorHeader = {"Administrator ID","Forename","Surname","Phone Number"};
		private Object[][] administratorData = y.retrieveSelectedTableObject("Administrator");
		private JTable administratorTable = new JTable(administratorData, administratorHeader);
		private JScrollPane administratorScroll = new JScrollPane(administratorTable);
		
		//Order
		private String[] orderHeader = {"Order ID","Client ID","Account Manager ID","Administrator ID",
				"Item ID","Quantity","Supplier ID","Delivery Address"};
		private Object[][] orderData = y.retrieveSelectedTableObject("order");
		private JTable orderTable = new JTable(orderData, orderHeader);
		private JScrollPane orderScroll = new JScrollPane(orderTable);
		
		//Supplier
		private String[] supplierHeader = {"Supplier ID","Company Name","Address","Contact Forename"
				,"Contact Surname","Contact Email","Contact Phone Number"};
		private Object[][] supplierData = y.retrieveSelectedTableObject("supplier");
		private JTable supplierTable = new JTable(supplierData, supplierHeader);
		private JScrollPane supplierScroll = new JScrollPane(supplierTable);
		
		
		
		
		//experimental int for refresh 
		public int intRefresh;
		
		
		
		
		
		
	//constructor 
	public static void main(String[] args)
	{
		GEMS_GUI x = new GEMS_GUI();
		GEMS y = new GEMS();
	}
	
	
	
	
	
	
	//build GUI
	public GEMS_GUI()
	{
		makeHomeFrame();
		makeMenu();
	}
	
	
	
	
	
	
	
	
	
	//Home Frame
	public void makeHomeFrame()
	{
		//Layout 
		gems.setLayout(new BorderLayout());
		
		//Panels To Be Used
		gems.add(westPanel, BorderLayout.WEST);//View Buttons Go In This Panel
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));//Outlining Panel
		gems.add(centerPanel, BorderLayout.CENTER);//Table Views Go Here
		
		//West Panel Configuration
		westPanel.setLayout(new GridLayout(6,1));
			westPanel.add(viewItems);
				viewItems.addActionListener(new viewItemsHandler());
			westPanel.add(viewClients);
				viewClients.addActionListener(new viewClientsHandler());
			westPanel.add(viewAccountManagers);
				viewAccountManagers.addActionListener(new viewAccountManagersHandler());
			westPanel.add(viewAdministrators);
				viewAdministrators.addActionListener(new viewAdministratorsHandler());
			westPanel.add(viewOrders);
				viewOrders.addActionListener(new viewOrdersHandler());
			westPanel.add(viewSuppliers);
				viewSuppliers.addActionListener(new viewSuppliersHandler());
		westPanel.setBackground(Color.BLACK);
				
		//Centre Panel Configuration 
		centerPanel.setLayout(new BorderLayout());
			centerPanel.add(centerSouth, BorderLayout.SOUTH);
				centerSouth.setLayout(new GridLayout(1,4));
					centerSouth.setBackground(Color.BLACK);
		
		//Frame Packed and Visible
		gems.pack();
		gems.setVisible(true);
	}
	
	
	//Menu Bar
	public void makeMenu()
	{
		//Menu Bar 
		gems.setJMenuBar(gemsMenuBar);
		
		//Menus and Items
		gemsMenuBar.add(gemsMENU);
			gemsMENU.add(tbcItem);
			gemsMENU.add(tbcItem2);
		gemsMenuBar.add(gemsHELP);
			gemsHELP.add(tbcItem3);
			gemsHELP.add(tbcItem4);
	}
	
	
	
	
	
	
	
	
	
	
	//*****************************ACTION LISTENERS*****************************
	//View Items Listener
	public class viewItemsHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{				
				//Removes Duplicate Tables
				centerPanel.revalidate();
				centerPanel.remove(clientScroll);
				centerPanel.remove(administratorScroll);
				centerPanel.remove(accountManagerScroll);
				centerPanel.remove(supplierScroll);
				centerPanel.remove(orderScroll);
				
				//Removes Duplicate Create Buttons
				centerSouth.remove(createEntryClient);
				centerSouth.remove(createEntrySupplier);
				centerSouth.remove(createEntryOrder);
				centerSouth.remove(createEntryAccountManager);
				centerSouth.remove(createEntryAdministrator);

				//Creating The Layout & Implementing Action Listeners
				centerPanel.add(itemScroll, BorderLayout.CENTER);
				centerSouth.add(createEntryItem);
					createEntryItem.setPreferredSize(new Dimension(145,145));
					createEntryItem.addActionListener(new CreateItemButtonActionHandler());
				centerSouth.add(updateEntry);
					updateEntry.addActionListener(new UpdateButtonActionHandler());
				centerSouth.add(deleteEntry);
					deleteEntry.addActionListener(new DeleteButtonActionHandler());
				centerSouth.add(refresh);
					refresh.addActionListener(new RefreshButtonActionHandler());
				centerPanel.revalidate();
				//int refresh experimental feature 
				intRefresh = 1;
			}
			catch(Exception e)
			{
				//create a pop up here?? idk yet 
				e.printStackTrace(); 
			}
		}
	}
	
	
	
	
	
	
	
	//View Clients Listener
	private class viewClientsHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				centerPanel.revalidate();
				centerPanel.remove(itemScroll);
				centerPanel.remove(administratorScroll);
				centerPanel.remove(accountManagerScroll);
				centerPanel.remove(supplierScroll);
				centerPanel.remove(orderScroll);
				
				//removing old version if exists -- to then be added again 
				centerSouth.remove(clientScroll);
				
				centerSouth.remove(createEntryOrder);
				centerSouth.remove(createEntrySupplier);
				centerSouth.remove(createEntryItem);
				centerSouth.remove(createEntryAccountManager);
				centerSouth.remove(createEntryAdministrator);

				centerPanel.add(clientScroll, BorderLayout.CENTER);
				centerSouth.add(createEntryClient);
					createEntryClient.setPreferredSize(new Dimension(145,145));
					createEntryClient.addActionListener(new CreateClientButtonActionHandler());
				centerSouth.add(updateEntry);
					updateEntry.addActionListener(new UpdateButtonActionHandler());
				centerSouth.add(deleteEntry);
					deleteEntry.addActionListener(new DeleteButtonActionHandler());
				centerSouth.add(refresh);
					refresh.addActionListener(new RefreshButtonActionHandler());

					//new additions below - @11:19
					String[] clientHeader = {"Client ID","Company Name","Address","Account Manager ID",
							"Contact Forename", "Contact Surname", "Email", "Phone Number"};
					Object[][] clientData = y.retrieveSelectedTableObject("Client");
					JTable clientTable = new JTable(clientData, clientHeader);
					JScrollPane clientScroll = new JScrollPane(clientTable);
					
					centerPanel.add(clientScroll, BorderLayout.CENTER);	
					
				//int refresh experimental feature 
				intRefresh = 2;
			}
			catch(Exception e)
			{
				//create a pop up here?? idk yet 
				e.printStackTrace();
			}
		}
	}
	
	//ORIGNAL !!!!!!!
	private class viewAdministratorsHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				centerPanel.revalidate();
				centerPanel.remove(clientScroll);
				centerPanel.remove(itemScroll);
				centerPanel.remove(accountManagerScroll);
				centerPanel.remove(supplierScroll);
				centerPanel.remove(orderScroll);
				
				//removing old version if exists -- to then be added again 
				centerSouth.remove(administratorScroll);
				
				centerSouth.remove(createEntryClient);
				centerSouth.remove(createEntrySupplier);
				centerSouth.remove(createEntryItem);
				centerSouth.remove(createEntryAccountManager);
				centerSouth.remove(createEntryOrder);

				centerPanel.add(administratorScroll, BorderLayout.CENTER);
				centerSouth.add(createEntryAdministrator);
					createEntryAdministrator.setPreferredSize(new Dimension(145,145));
					createEntryAdministrator.addActionListener(new CreateAdministratorButtonActionHandler());
				centerSouth.add(updateEntry);
					updateEntry.addActionListener(new UpdateButtonActionHandler());
				centerSouth.add(deleteEntry);
					deleteEntry.addActionListener(new DeleteButtonActionHandler());
				centerSouth.add(refresh);
					refresh.addActionListener(new RefreshButtonActionHandler());

					
					
					
					//new additions below - @11:19
					String[] administratorHeader = {"Administrator ID","Forename","Surname","Phone Number"};
					Object[][] administratorData = y.retrieveSelectedTableObject("Administrator");
					JTable administratorTable = new JTable(administratorData, administratorHeader);
					JScrollPane administratorScroll = new JScrollPane(administratorTable);
					
					centerPanel.add(administratorScroll, BorderLayout.CENTER);	
					//int refresh experimental feature 
					intRefresh = 3;
			}
			catch(Exception e)
			{
				//create a pop up here?? idk yet 
			}
		}
	}
	
	
	
	
	
	
	//View Account Managers Listener
	private class viewAccountManagersHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				centerPanel.revalidate();
				centerPanel.remove(clientScroll);
				centerPanel.remove(administratorScroll);
				centerPanel.remove(itemScroll);
				centerPanel.remove(supplierScroll);
				centerPanel.remove(orderScroll);
				
				centerSouth.remove(createEntryClient);
				centerSouth.remove(createEntrySupplier);
				centerSouth.remove(createEntryItem);
				centerSouth.remove(createEntryOrder);
				centerSouth.remove(createEntryAdministrator);
				
				centerPanel.add(accountManagerScroll, BorderLayout.CENTER);
				centerSouth.add(createEntryAccountManager);
					createEntryAccountManager.setPreferredSize(new Dimension(145,145));
					createEntryAccountManager.addActionListener(new CreateAccountManagerButtonActionHandler());
				centerSouth.add(updateEntry);
					updateEntry.addActionListener(new UpdateButtonActionHandler());
				centerSouth.add(deleteEntry);
					deleteEntry.addActionListener(new DeleteButtonActionHandler());
				centerSouth.add(refresh);
					refresh.addActionListener(new RefreshButtonActionHandler());
				centerPanel.revalidate();
				//int refresh experimental feature 
				intRefresh = 4;
				
			}
			catch(Exception e)
			{
				//create a pop up here?? idk yet 
			}
		}
	}
	
	
	
	
	
	
	
	//View Suppliers Listener
	private class viewSuppliersHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				centerPanel.revalidate();
				centerPanel.remove(clientScroll);
				centerPanel.remove(administratorScroll);
				centerPanel.remove(accountManagerScroll);
				centerPanel.remove(itemScroll);
				centerPanel.remove(orderScroll);
				
				centerSouth.remove(createEntryClient);
				centerSouth.remove(createEntryOrder);
				centerSouth.remove(createEntryItem);
				centerSouth.remove(createEntryAccountManager);
				centerSouth.remove(createEntryAdministrator);
				
				centerPanel.add(supplierScroll, BorderLayout.CENTER);
				centerSouth.add(createEntrySupplier);
					createEntrySupplier.setPreferredSize(new Dimension(145,145));
					createEntrySupplier.addActionListener(new CreateSupplierButtonActionHandler());
				centerSouth.add(updateEntry);
					updateEntry.addActionListener(new UpdateButtonActionHandler());
				centerSouth.add(deleteEntry);
					deleteEntry.addActionListener(new DeleteButtonActionHandler());
				centerSouth.add(refresh);
					refresh.addActionListener(new RefreshButtonActionHandler());
				centerPanel.revalidate();
				//int refresh experimental feature 
				intRefresh = 5;

			}
			catch(Exception e)
			{
				//create a pop up here?? idk yet 
			}
		}
	}
	
	
	
	
	
	
	
	
	
	//View Orders Listener
	private class viewOrdersHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				centerPanel.revalidate();
				centerPanel.remove(clientScroll);
				centerPanel.remove(administratorScroll);
				centerPanel.remove(accountManagerScroll);
				centerPanel.remove(supplierScroll);
				centerPanel.remove(itemScroll);
				
				centerSouth.remove(createEntryClient);
				centerSouth.remove(createEntrySupplier);
				centerSouth.remove(createEntryItem);
				centerSouth.remove(createEntryAccountManager);
				centerSouth.remove(createEntryAdministrator);
				
				

				centerPanel.add(orderScroll, BorderLayout.CENTER);
				centerSouth.add(createEntryOrder);
					createEntryOrder.setPreferredSize(new Dimension(145,145));
					createEntryOrder.addActionListener(new CreateOrderButtonActionHandler());
				centerSouth.add(updateEntry);
					updateEntry.addActionListener(new UpdateButtonActionHandler());
				centerSouth.add(deleteEntry);
					deleteEntry.addActionListener(new DeleteButtonActionHandler());
				centerSouth.add(refresh);
					refresh.addActionListener(new RefreshButtonActionHandler());
				centerPanel.revalidate();
				//int refresh experimental feature 
				intRefresh = 6;

			}
			catch(Exception e)
			{
				//create a pop up here?? idk yet 
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	//Create Entry Administrator
	private JOptionPane createAdminEntryPopUp = new JOptionPane("CREATE ADMIN ENTRY");
	private JTextField createAdminForename = new JTextField("Forename...");
	private JTextField createAdminSurname = new JTextField("Surname...");
	private JTextField createAdminPhoneNo = new JTextField("Phone Number...");
	
	//****************************CUD ACTION LISTENERS*****************************
	private class CreateAdministratorButtonActionHandler implements ActionListener
	{
	    public void actionPerformed(ActionEvent event)
	    {
	        try
	        {
	            gems.add(createAdminEntryPopUp);

	            createAdminEntryPopUp.setLayout(new GridLayout(3,2));

	            createAdminEntryPopUp.add(createAdminForename);
	            createAdminEntryPopUp.add(createAdminSurname);
	            createAdminEntryPopUp.add(createAdminPhoneNo);

	            int result = JOptionPane.showConfirmDialog(null, createAdminEntryPopUp, "Enter Values", JOptionPane.OK_CANCEL_OPTION);

	            if(result == JOptionPane.OK_OPTION)
	            {
	                String forename = createAdminForename.getText();
	                String surname = createAdminSurname.getText();
	                String phoneNo = createAdminPhoneNo.getText();

	                y.createAdministratorObject(forename, surname, phoneNo);

	                //Update the table model
	                DefaultTableModel model = (DefaultTableModel) administratorTable.getModel();
	                model.addRow(new Object[]{forename, surname, phoneNo});
	                model.fireTableDataChanged();
	            }
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	}

	//Create Entry AccountManager 
	private JOptionPane createAccountEntryPopUp = new JOptionPane("CREATE ACCOUNT MANAGER ENTRY");
	private JTextField createAccountForename = new JTextField("Forename...");
	private JTextField createAccountSurname = new JTextField("Surname...");
	private JTextField createAccountPhoneNo = new JTextField("Phone Number...");
	private class CreateAccountManagerButtonActionHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
	            gems.add(createAccountEntryPopUp);

	            createAccountEntryPopUp.setLayout(new GridLayout(3,2));

	            createAccountEntryPopUp.add(createAccountForename);
	            createAccountEntryPopUp.add(createAccountSurname);
	            createAccountEntryPopUp.add(createAccountPhoneNo);

	            int result = JOptionPane.showConfirmDialog(null, createAccountEntryPopUp, "Enter Values", JOptionPane.OK_CANCEL_OPTION);

	            if(result == JOptionPane.OK_OPTION)
	            {
	                String forename = createAccountForename.getText();
	                String surname = createAccountSurname.getText();
	                String phoneNo = createAccountPhoneNo.getText();

	                y.createAccountManagerObject(forename, surname, phoneNo);

	                //Update the table model
	                DefaultTableModel model = (DefaultTableModel) accountManagerTable.getModel();
	                model.addRow(new Object[]{forename, surname, phoneNo});
	                model.fireTableDataChanged();
	            }
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
	
	
	
	
	//Create Entry Client 
	private JOptionPane createClientEntryPopUp = new JOptionPane("CREATE CLIENT ENTRY");
	private JTextField createClientCompanyName = new JTextField("Company Name...");
	private JTextField createClientAddress = new JTextField("Address...");
	private JTextField createClientAccountManID = new JTextField("Account Manager ID...");
	private JTextField createClientForename = new JTextField("Forename...");
	private JTextField createClientSurname = new JTextField("Surname...");
	private JTextField createClientEmail = new JTextField("Contact Email...");
	private JTextField createClientPhoneNo = new JTextField("Contact Phone Number...");
	private class CreateClientButtonActionHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
	            gems.add(createClientEntryPopUp);

	            createClientEntryPopUp.setLayout(new GridLayout(3,2));

	            createClientEntryPopUp.add(createAccountForename);
	            createClientEntryPopUp.add(createAccountSurname);
	            createClientEntryPopUp.add(createAccountPhoneNo);

	            int result = JOptionPane.showConfirmDialog(null, createClientEntryPopUp, "Enter Values", JOptionPane.OK_CANCEL_OPTION);

	            if(result == JOptionPane.OK_OPTION)
	            {
	            	String companyName = createClientCompanyName.getText();
	            	String address = createClientAddress.getText();
	            	String accountManagerID = createClientAccountManID.getText();//not sure if will work
	                String forename = createClientForename.getText();
	                String surname = createClientSurname.getText();
	                String email = createClientEmail.getText();
	                String phoneNo = createClientPhoneNo.getText();

	                y.createClientObject(companyName,address,accountManagerID,forename,surname,email,phoneNo);

	                //Update the table model
	                DefaultTableModel model = (DefaultTableModel) clientTable.getModel();
	                model.addRow(new Object[]{forename, surname, phoneNo, this});
	                model.fireTableDataChanged();
	            }
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
	
	
	
	
	private class CreateOrderButtonActionHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				gems.add(createOrderEntryPopUp);
				createOrderEntryPopUp.showMessageDialog(gems, "test");
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
	
	
	
	private class CreateItemButtonActionHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				gems.add(createOrderEntryPopUp);
				createOrderEntryPopUp.showMessageDialog(gems, "test");
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
	
	
	
	private class CreateSupplierButtonActionHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				gems.add(createOrderEntryPopUp);
				createOrderEntryPopUp.showMessageDialog(gems, "test");
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private class UpdateButtonActionHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				gems.repaint();
				gems.revalidate();
			}
			catch(Exception e)
			{
				
			}
		}
	}
	private class DeleteButtonActionHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
//	//PUTTING THE TABLE SHIT INTO REFRESH 
//	private String[] administratorHeader = {"Administrator ID","Forename","Surname","Phone Number"};
//	private Object[][] administratorData = y.retrieveSelectedTableObject("Administrator");
//	private JTable administratorTable = new JTable(administratorData, administratorHeader);
//	private JScrollPane administratorScroll = new JScrollPane(administratorTable);
	
	private class RefreshButtonActionHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				
				switch(intRefresh)
				{
				case 1: System.out.println("\nCASE 1");
				break;

				//CLIENT
				case 2:
					centerPanel.revalidate();
					
					//removing old version of the table
					centerSouth.remove(clientScroll);
					
					//Refreshing the table to match the Database back-end
					String[] clientHeader = {"Client ID","Company Name","Address","Account Manager ID",
							"Contact Forename", "Contact Surname", "Email", "Phone Number"};
					Object[][] clientData = y.retrieveSelectedTableObject("Client");
					JTable clientTable = new JTable(clientData, clientHeader);
					JScrollPane clientScroll = new JScrollPane(clientTable);					
			
					//Adding the table back to GUI 
					centerPanel.add(clientScroll, BorderLayout.CENTER);	
				break;
				
				//*****ADMINISTRATOR*****
				case 3:
				centerPanel.revalidate();
				
				//removing old version of the table
				centerSouth.remove(administratorScroll);
				
				//Refreshing the table to match the Database back-end
				String[] administratorHeader = {"Administrator ID","Forename","Surname","Phone Number"};
				Object[][] administratorData = y.retrieveSelectedTableObject("Administrator");
				JTable administratorTable = new JTable(administratorData, administratorHeader);
				JScrollPane administratorScroll = new JScrollPane(administratorTable);					
		
				//Adding the table back to GUI 
				centerPanel.add(administratorScroll, BorderLayout.CENTER);	
				break;

				//*****ACCOUNT MANAGER*****
				case 4:
				centerPanel.revalidate();
				
				//removing old version of the table
				centerSouth.remove(accountManagerScroll);
				//Refreshing the table to match the Database back-end
				String[] accountManagerHeader = {"Account Manager ID","Forename","Surname","Phone Number"};
				Object[][] accountManagerData = y.retrieveSelectedTableObject("AccountManager");
				JTable accountManagerTable = new JTable(accountManagerData, accountManagerHeader);
				JScrollPane accountManagerScroll = new JScrollPane(accountManagerTable);					
			
				//Adding the table back to GUI 
				centerPanel.add(accountManagerScroll, BorderLayout.CENTER);	
				break;
				
				case 5: System.out.println("\nCASE 5");
				break;

				case 6: System.out.println("\nCASE 6");
				break;
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	//add  a new refresh method here which removes all Scrolls and re add's them respectively
	
	
	
}
