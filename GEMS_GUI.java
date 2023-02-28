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
		private JButton viewItems = new JButton("View: Item");
		private JButton viewClients = new JButton("View: Client");
		private JButton viewAdministrators = new JButton("View: Administrator");
		private JButton viewAccountManagers = new JButton("View: AccountManager");
		private JButton viewSuppliers = new JButton("View: Supplier");
		private JButton viewOrders = new JButton("View: Order");
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
		//GEMS for Data Operations 
		private GEMS y = new GEMS();
		//Individual Database Tables 
		//Item
		private String[] itemHeader = {"itemID","description","supplierID","buyPrice","sellPrice"};
		private Object[][] itemData = y.retrieveSelectedTableObject("Item");
		private JTable itemTable = new JTable(itemData, itemHeader);
		private JScrollPane itemScroll = new JScrollPane(itemTable);
		//Client
		private String[] clientHeader = {"clientID","companyName","address","accountManagerID","contactForename"
				,"contactSurname","contactEmail","contactPhoneNo"};
		private Object[][] clientData = y.retrieveSelectedTableObject("Client");
		private JTable clientTable = new JTable(clientData, clientHeader);
		private JScrollPane clientScroll = new JScrollPane(clientTable);
		//Account Manager
		private String[] accountManagerHeader = {"AccountManID","forename","surname","phoneNumber"};
		private Object[][] accountManagerData = y.retrieveSelectedTableObject("AccountManager");
		private JTable accountManagerTable = new JTable(accountManagerData, accountManagerHeader);
		private JScrollPane accountManagerScroll = new JScrollPane(accountManagerTable);
		//Administrator
		private String[] administratorHeader = {"adminID","forename","surname","phoneNo"};
		private Object[][] administratorData = y.retrieveSelectedTableObject("Administrator");
		private JTable administratorTable = new JTable(administratorData, administratorHeader);
		private JScrollPane administratorScroll = new JScrollPane(administratorTable);
		//Order
		private String[] orderHeader = {"orderID","clientID","accountManID","adminID",
				"itemID","quantity","supplierID","deliveryAddress"};
		private Object[][] orderData = y.retrieveSelectedTableObject("Order");
		private JTable orderTable = new JTable(orderData, orderHeader);
		private JScrollPane orderScroll = new JScrollPane(orderTable);
		//Supplier
		private String[] supplierHeader = {"supplierID","companyName","address","contactForename"
				,"contactSurname","contactEmail","contactPhoneNo"};
		private Object[][] supplierData = y.retrieveSelectedTableObject("Supplier");
		private JTable supplierTable = new JTable(supplierData, supplierHeader);
		private JScrollPane supplierScroll = new JScrollPane(supplierTable);
		//intRefres - attached to the view handlers to allow manipulation on specific view page 
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
				centerPanel.revalidate();
				centerPanel.remove(clientScroll);
				centerPanel.remove(administratorScroll);
				centerPanel.remove(accountManagerScroll);
				centerPanel.remove(supplierScroll);
				centerPanel.remove(orderScroll);
				centerPanel.remove(itemScroll);
				centerSouth.remove(createEntryItem);
				centerSouth.remove(createEntryClient);
				centerSouth.remove(createEntrySupplier);
				centerSouth.remove(createEntryOrder);
				centerSouth.remove(createEntryAccountManager);
				centerSouth.remove(createEntryAdministrator);
				centerSouth.remove(refresh);
				centerSouth.remove(updateEntry);
				centerSouth.remove(deleteEntry);
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
				String[] itemHeader = {"itemID","description","supplierID","buyPrice",
						"sellPrice"};
				Object[][] itemData = y.retrieveSelectedTableObject("Item");
				JTable itemTable = new JTable(itemData, itemHeader);
				JScrollPane itemScroll = new JScrollPane(itemTable);
				centerPanel.add(itemScroll, BorderLayout.CENTER);	
				intRefresh = 1;
			}
			catch(Exception e)
			{
				e.printStackTrace(); 
			}
		}
	}
	//View CLIENTS Listener
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
				centerSouth.remove(clientScroll);
				centerSouth.remove(createEntryOrder);
				centerSouth.remove(createEntrySupplier);
				centerSouth.remove(createEntryItem);
				centerSouth.remove(createEntryAccountManager);
				centerSouth.remove(createEntryAdministrator);
				centerSouth.remove(refresh);
				centerSouth.remove(updateEntry);
				centerSouth.remove(deleteEntry);
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
					String[] clientHeader = {"clientID","companyName","address","accountManagerID",
							"contactForename", "contactSurname", "contactEmail", "contactPhoneNo"};
					Object[][] clientData = y.retrieveSelectedTableObject("Client");
					JTable clientTable = new JTable(clientData, clientHeader);
					JScrollPane clientScroll = new JScrollPane(clientTable);
					centerPanel.add(clientScroll, BorderLayout.CENTER);	
				intRefresh = 2;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	//View ADMINISTRATOR Listener
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
				centerSouth.remove(administratorScroll);
				centerSouth.remove(createEntryClient);
				centerSouth.remove(createEntrySupplier);
				centerSouth.remove(createEntryItem);
				centerSouth.remove(createEntryAccountManager);
				centerSouth.remove(createEntryOrder);
				centerSouth.remove(refresh);
				centerSouth.remove(updateEntry);
				centerSouth.remove(deleteEntry);
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
					String[] administratorHeader = {"adminID","forename","surname","phoneNo"};
					Object[][] administratorData = y.retrieveSelectedTableObject("Administrator");
					JTable administratorTable = new JTable(administratorData, administratorHeader);
					JScrollPane administratorScroll = new JScrollPane(administratorTable);
					centerPanel.add(administratorScroll, BorderLayout.CENTER);	
					intRefresh = 3;
			}
			catch(Exception e)
			{
				//create a pop up here?? idk yet 
			}
		}
	}
	//View ACCOUNT MANAGERS Listener
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
				centerSouth.remove(accountManagerScroll);
				centerSouth.remove(createEntryClient);
				centerSouth.remove(createEntrySupplier);
				centerSouth.remove(createEntryItem);
				centerSouth.remove(createEntryOrder);
				centerSouth.remove(createEntryAdministrator);
				centerSouth.remove(refresh);
				centerSouth.remove(updateEntry);
				centerSouth.remove(deleteEntry);
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
					String[] accountHeader = {"accountManID","forename","surname","phoneNo"};
					Object[][] accountData = y.retrieveSelectedTableObject("AccountManager");
					JTable accountTable = new JTable(accountData, accountHeader);
					JScrollPane accountScroll = new JScrollPane(accountTable);
					centerPanel.add(accountScroll, BorderLayout.CENTER);		
				intRefresh = 4;
				
			}
			catch(Exception e)
			{
				//create a pop up here?? idk yet 
			}
		}
	}
	//View SUPPLIERS Listener
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
				centerPanel.remove(supplierScroll);
				centerSouth.remove(createEntryClient);
				centerSouth.remove(createEntryOrder);
				centerSouth.remove(createEntryItem);
				centerSouth.remove(createEntryAccountManager);
				centerSouth.remove(createEntryAdministrator);
				centerSouth.remove(refresh);
				centerSouth.remove(updateEntry);
				centerSouth.remove(deleteEntry);
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
					String[] supplierHeader = {"supplierID","companyName","address","contactForename",
							"contactSurname", "contactEmail", "contactPhoneNo"};
					Object[][] supplierData = y.retrieveSelectedTableObject("Supplier");
					JTable supplierTable = new JTable(supplierData, supplierHeader);
					JScrollPane supplierScroll = new JScrollPane(supplierTable);
					centerPanel.add(supplierScroll, BorderLayout.CENTER);		
				intRefresh = 5;

			}
			catch(Exception e)
			{
				//create a pop up here?? idk yet 
			}
		}
	}
	//View ORDERS Listener
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
				centerPanel.remove(orderScroll);
				centerSouth.remove(createEntryClient);
				centerSouth.remove(createEntrySupplier);
				centerSouth.remove(createEntryItem);
				centerSouth.remove(createEntryAccountManager);
				centerSouth.remove(createEntryAdministrator);
				centerSouth.remove(refresh);
				centerSouth.remove(updateEntry);
				centerSouth.remove(deleteEntry);
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
					String[] orderHeader = {"orderID","clientID","accountManID","adminID",
							"itemID", "quantity", "supplierID", "deliveryAddress"};
					Object[][] orderData = y.retrieveSelectedTableObject("Order");
					JTable orderTable = new JTable(orderData, orderHeader);
					JScrollPane orderScroll = new JScrollPane(orderTable);
					centerPanel.add(orderScroll, BorderLayout.CENTER);	
				intRefresh = 6;

			}
			catch(Exception e)
			{
				//create a pop up here?? idk yet 
			}
		}
	}
	//****************************CUD ACTION LISTENERS*****************************
	//Create Entry ADMINISTRATOR
	private JOptionPane createAdminEntryPopUp = new JOptionPane("CREATE ADMIN ENTRY");
	private JLabel createAdminForenameLabel = new JLabel("Forename:");
	private JTextField createAdminForename = new JTextField();
	private JLabel createAdminSurnameLabel = new JLabel("Surname:");
	private JTextField createAdminSurname = new JTextField();
	private JLabel createAdminPhoneNoLabel = new JLabel("Phone Number:");
	private JTextField createAdminPhoneNo = new JTextField();
	private class CreateAdministratorButtonActionHandler implements ActionListener
	{
	    public void actionPerformed(ActionEvent event)
	    {
	        try
	        {	   
	            JPanel messagePanel = new JPanel();
	            messagePanel.setLayout(new GridLayout(4, 2));
	            messagePanel.add(createAdminForenameLabel);
	            messagePanel.add(createAdminForename);
	            messagePanel.add(createAdminSurnameLabel);
	            messagePanel.add(createAdminSurname);
	            messagePanel.add(createAdminPhoneNoLabel);
	            messagePanel.add(createAdminPhoneNo);
	            int result = JOptionPane.showConfirmDialog(null, messagePanel, "Administrator", JOptionPane.OK_CANCEL_OPTION);
	            if(result == JOptionPane.OK_OPTION)
	            {
	                String forename = createAdminForename.getText();
	                String surname = createAdminSurname.getText();
	                String phoneNo = createAdminPhoneNo.getText();
	                y.createAdministratorObject(forename, surname, phoneNo);
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
	//Create Entry ACCOUNT MANAGER 
	private JOptionPane createAccountEntryPopUp = new JOptionPane("CREATE ACCOUNT MANAGER ENTRY");
	private JLabel createAccountForenameLabel = new JLabel("Forename:");
	private JTextField createAccountForename = new JTextField();
	private JLabel createAccountSurnameLabel = new JLabel("Surname:");
	private JTextField createAccountSurname = new JTextField();
	private JLabel createAccountPhoneNoLabel = new JLabel("Phone Number:");
	private JTextField createAccountPhoneNo = new JTextField();
	private class CreateAccountManagerButtonActionHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
	            JPanel messagePanel = new JPanel();
	            messagePanel.setLayout(new GridLayout(4, 2));
	            messagePanel.add(createAccountForenameLabel);
	            messagePanel.add(createAccountForename);
	            messagePanel.add(createAccountSurnameLabel);
	            messagePanel.add(createAccountSurname);
	            messagePanel.add(createAccountPhoneNoLabel);
	            messagePanel.add(createAccountPhoneNo);
	            int result = JOptionPane.showConfirmDialog(null, messagePanel, "AccountManager", JOptionPane.OK_CANCEL_OPTION);
	            if(result == JOptionPane.OK_OPTION)
	            {
	                String forename = createAccountForename.getText();
	                String surname = createAccountSurname.getText();
	                String phoneNo = createAccountPhoneNo.getText();
	                y.createAccountManagerObject(forename, surname, phoneNo);
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
	//Create Entry CLIENT 
	private JOptionPane createClientEntryPopUp = new JOptionPane("CREATE CLIENT ENTRY");
	private JLabel createClientCompanyNameLabel = new JLabel("Company Name:");
	private JTextField createClientCompanyName = new JTextField();
	private JLabel createClientAddressLabel = new JLabel("Address:");
	private JTextField createClientAddress = new JTextField();
	private JLabel createClientAccountManIDLabel = new JLabel("Account Manager ID:");
	private JTextField createClientAccountManID = new JTextField();
	private JLabel createClientContactForenameLabel = new JLabel("Contact Forename:");
	private JTextField createClientForename = new JTextField();
	private JLabel createClientContactSurnameLabel = new JLabel("Contact Surname:");
	private JTextField createClientSurname = new JTextField();
	private JLabel createClientContactEmailLabel = new JLabel("Contact Email:");
	private JTextField createClientEmail = new JTextField();
	private JLabel createClientContactPhoneNoLabel = new JLabel("Contact Phone Number:");
	private JTextField createClientPhoneNo = new JTextField();
	private class CreateClientButtonActionHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
	            JPanel messagePanel = new JPanel();
	            messagePanel.setLayout(new GridLayout(4, 2));
	            messagePanel.add(createClientCompanyNameLabel);
	            messagePanel.add(createClientCompanyName);
	            messagePanel.add(createClientAddressLabel);
	            messagePanel.add(createClientAddress);
	            messagePanel.add(createClientAccountManIDLabel);
	            messagePanel.add(createClientAccountManID);
	            messagePanel.add(createClientContactForenameLabel);
	            messagePanel.add(createClientForename);
	            messagePanel.add(createClientContactSurnameLabel);
	            messagePanel.add(createClientSurname);
	            messagePanel.add(createClientContactEmailLabel);
	            messagePanel.add(createClientEmail);
	            messagePanel.add(createClientContactPhoneNoLabel);
	            messagePanel.add(createClientPhoneNo);
	            int result = JOptionPane.showConfirmDialog(null, messagePanel, "Client", JOptionPane.OK_CANCEL_OPTION);
	            if(result == JOptionPane.OK_OPTION)
	            {
	            	String companyName = createClientCompanyName.getText();
	            	String address = createClientAddress.getText();
	            	String accountManagerID = createClientAccountManID.getText();//not sure if will work
	                String forename = createClientForename.getText();
	                String surname = createClientSurname.getText();
	                String email = createClientEmail.getText();
	                String phoneNo = createClientPhoneNo.getText();
	                int accountManagerIDInt = Integer.parseInt(accountManagerID);
	                y.createClientObject(companyName,address,accountManagerIDInt,forename,surname,email,phoneNo);
	                DefaultTableModel model = (DefaultTableModel) clientTable.getModel();
	                model.addRow(new Object[]{companyName, address, accountManagerIDInt, forename, surname, email, phoneNo});
	                model.fireTableDataChanged();
	            }
			}
			catch(Exception e)
			{
				
			}
		}
	}
	//Create Entry ORDER
	private JOptionPane createOrderEntryPopUp = new JOptionPane("CREATE ORDER ENTRY");
	private JLabel createOrderClientIDLabel = new JLabel("Client ID:");
	private JTextField createOrderClientID = new JTextField();
	private JLabel createOrderAccountManIDLabel = new JLabel("Account Manager ID:");
	private JTextField createOrderAccountManID = new JTextField();
	private JLabel createOrderAdminIDLabel = new JLabel("Administrator ID:");
	private JTextField createOrderAdminID = new JTextField();
	private JLabel createOrderItemIDLabel = new JLabel("Item ID:");
	private JTextField createOrderItemID = new JTextField();
	private JLabel createOrderQuantityLabel = new JLabel("Quantity:");
	private JTextField createOrderQuantity = new JTextField();
	private JLabel createOrderSupplierIDLabel = new JLabel("Supplier ID:");
	private JTextField createOrderSupplierID = new JTextField();
	private JLabel createOrderDeliveryAddressLabel = new JLabel("Delivery Address:");
	private JTextField createOrderDeliveryAddress = new JTextField();
	private class CreateOrderButtonActionHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
	            JPanel messagePanel = new JPanel();
	            messagePanel.setLayout(new GridLayout(4, 2));
	            messagePanel.add(createOrderClientIDLabel);
	            messagePanel.add(createOrderClientID);
	            messagePanel.add(createOrderAccountManIDLabel);
	            messagePanel.add(createOrderAccountManID);
	            messagePanel.add(createOrderAdminIDLabel);
	            messagePanel.add(createOrderAdminID);
	            messagePanel.add(createOrderItemIDLabel);
	            messagePanel.add(createOrderItemID);
	            messagePanel.add(createOrderQuantityLabel);
	            messagePanel.add(createOrderQuantity);
	            messagePanel.add(createOrderSupplierIDLabel);
	            messagePanel.add(createOrderSupplierID);
	            messagePanel.add(createOrderDeliveryAddressLabel);
	            messagePanel.add(createOrderDeliveryAddress);
	            int result = JOptionPane.showConfirmDialog(null, messagePanel, "Order", JOptionPane.OK_CANCEL_OPTION);
	            if(result == JOptionPane.OK_OPTION)
	            {
	                String clientID = createOrderClientID.getText();
	                String accountManID = createOrderAccountManID.getText();
	                String adminID = createOrderAdminID.getText();
	                String itemID = createOrderItemID.getText();
	                String quantity = createOrderQuantity.getText();
	                String supplierID = createOrderSupplierID.getText();
	                String deliveryAddress = createOrderDeliveryAddress.getText();
	                int clientIDInt = Integer.parseInt(clientID);
	                int accountManIDInt = Integer.parseInt(accountManID);
	                int adminIDInt = Integer.parseInt(adminID);
	                int itemIDInt = Integer.parseInt(itemID);
	                int quantityInt = Integer.parseInt(quantity);
	                int supplierIDInt = Integer.parseInt(supplierID);
	                y.createOrderObject(clientIDInt, accountManIDInt, adminIDInt, itemIDInt, 
	                		quantityInt, supplierIDInt, deliveryAddress);
	                DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
	                model.addRow(new Object[]{clientIDInt, accountManIDInt, adminIDInt, itemIDInt, 
	                		quantityInt, supplierIDInt, deliveryAddress});
	                model.fireTableDataChanged();
	            }
			}
			catch(Exception e)
			{
				
			}
		}
	}
	//Create Entry ITEM
	private JOptionPane createItemEntryPopUp = new JOptionPane("CREATE ITEM ENTRY");
	private JLabel createItemDescriptionLabel = new JLabel("Description:");
	private JTextField createItemDescription = new JTextField();
	private JLabel createItemSupplierIDLabel = new JLabel("Supplier ID:");
	private JTextField createItemSupplierID = new JTextField();
	private JLabel createItemBuyPriceLabel = new JLabel("Buy Price:");
	private JTextField createItemBuyPrice = new JTextField();
	private JLabel createItemSellPriceLabel = new JLabel("Sell Price:");
	private JTextField createItemSellPrice = new JTextField();
	private class CreateItemButtonActionHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
	            JPanel messagePanel = new JPanel();
	            messagePanel.setLayout(new GridLayout(4, 2));
	            messagePanel.add(createItemDescriptionLabel);
	            messagePanel.add(createItemDescription);
	            messagePanel.add(createItemSupplierIDLabel);
	            messagePanel.add(createItemSupplierID);
	            messagePanel.add(createItemBuyPriceLabel);
	            messagePanel.add(createItemBuyPrice);
	            messagePanel.add(createItemSellPriceLabel);
	            messagePanel.add(createItemSellPrice);
	            int result = JOptionPane.showConfirmDialog(null, messagePanel, "Item", JOptionPane.OK_CANCEL_OPTION);
	            if(result == JOptionPane.OK_OPTION)
	            {
	                String description = createItemDescription.getText();
	                String supplierID = createItemSupplierID.getText();
	                String buyPrice = createItemBuyPrice.getText();
	                String sellPrice = createItemSellPrice.getText();
	                int itemSupplierIDInt = Integer.parseInt(supplierID);
	                double buyPriceDouble = Double.parseDouble(buyPrice);
	                double sellPriceDouble = Double.parseDouble(sellPrice);
	                y.createItemObject(description, itemSupplierIDInt, buyPriceDouble, sellPriceDouble);
	                DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
	                model.addRow(new Object[]{description, itemSupplierIDInt, buyPriceDouble, sellPriceDouble});
	                model.fireTableDataChanged();
	            }
			}
			catch(Exception e)
			{
				
			}
		}
	}
	//Create Entry SUPPLIER
	private JOptionPane createSupplierEntryPopUp = new JOptionPane("CREATE SUPPLIER ENTRY");
	private JTextField createSupplierCompanyName = new JTextField();
	private JLabel createSupplierCompanyNameLabel = new JLabel("Company Name:");
	private JTextField createSupplierAddress = new JTextField();
	private JLabel createSupplierAddressLabel = new JLabel("Address: ");
	private JTextField createSupplierForename = new JTextField();
	private JLabel createSupplierForenameLabel = new JLabel("Contact Forename:");
	private JTextField createSupplierSurname = new JTextField();
	private JLabel createSupplierSurnameLabel = new JLabel("Contact Surname: ");
	private JTextField createSupplierEmail = new JTextField();
	private JLabel createSupplierEmailLabel = new JLabel("Email: ");
	private JTextField createSupplierPhoneNo = new JTextField();
	private JLabel createSupplierPhoneNoLabel = new JLabel("Phone Number: ");
	private class CreateSupplierButtonActionHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				JPanel messagePanel = new JPanel();
				messagePanel.setLayout(new GridLayout(6, 2));
				messagePanel.add(createSupplierCompanyNameLabel);
				messagePanel.add(createSupplierCompanyName);
				messagePanel.add(createSupplierAddressLabel);
				messagePanel.add(createSupplierAddress);
				messagePanel.add(createSupplierForenameLabel);
				messagePanel.add(createSupplierForename);
				messagePanel.add(createSupplierSurnameLabel);
				messagePanel.add(createSupplierSurname);
				messagePanel.add(createSupplierEmailLabel);
				messagePanel.add(createSupplierEmail);
				messagePanel.add(createSupplierPhoneNoLabel);
				messagePanel.add(createSupplierPhoneNo);
				int result = JOptionPane.showConfirmDialog(null, messagePanel, "Supplier", JOptionPane.OK_CANCEL_OPTION);
	            if(result == JOptionPane.OK_OPTION)
	            {
	                String companyName = createSupplierCompanyName.getText();
	                String address = createSupplierAddress.getText();
	                String forename = createSupplierForename.getText();
	                String surname = createSupplierSurname.getText();
	                String email = createSupplierEmail.getText();
	                String phoneNo = createSupplierPhoneNo.getText();
	                y.createSupplierObject(companyName, address, forename, surname, email, phoneNo);
	                DefaultTableModel model = (DefaultTableModel) supplierTable.getModel();
	                model.addRow(new Object[]{companyName, address, forename, surname, email, phoneNo});
	                model.fireTableDataChanged();
	            }
			}
			catch(Exception e)
			{
				
			}
		}
	}
//Update Entry Frame 
	private JTextField updateTable = new JTextField();
	private JLabel updateTableLabel = new JLabel("Table to update: ");
	private JTextField updateAttribute = new JTextField();
	private JLabel updateAttributeLabel = new JLabel("The field to update: ");
	private JTextField updateNewEntry = new JTextField();
	private JLabel updateNewEntryLabel = new JLabel("The New Value: ");
	private JTextField updateTablePrimaryID = new JTextField();
	private JLabel updateTablePrimaryIDLabel = new JLabel("First field (<table>ID): ");
	private JTextField updateWhereValue = new JTextField();
	private JLabel updateWhereValueLabel = new JLabel("First field value (<table>ID = ?): ");
	//UPDATE Action Listener 
	private class UpdateButtonActionHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{	
				JPanel messagePanel = new JPanel();
				messagePanel.setLayout(new GridLayout(6, 2));
				messagePanel.add(updateTableLabel);
				messagePanel.add(updateTable);
				messagePanel.add(updateAttributeLabel);
				messagePanel.add(updateAttribute);
				messagePanel.add(updateNewEntryLabel);
				messagePanel.add(updateNewEntry);
				messagePanel.add(updateTablePrimaryIDLabel);
				messagePanel.add(updateTablePrimaryID);
				messagePanel.add(updateWhereValueLabel);
				messagePanel.add(updateWhereValue);
				int result = JOptionPane.showConfirmDialog(null, messagePanel, "UPDATE", JOptionPane.OK_CANCEL_OPTION);
	            if(result == JOptionPane.OK_OPTION)
	            {
	                String table = updateTable.getText();
	                String attribute = updateAttribute.getText();
	                String newEntry = updateNewEntry.getText();
	                String tablePrimaryID = updateTablePrimaryID.getText();
	                String whereValue = updateWhereValue.getText();
	                y.updateEntry(table, attribute, newEntry, tablePrimaryID, whereValue);
	            }
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	private JTextField deleteTable = new JTextField();
	private JLabel deleteTableLabel = new JLabel("Table: ");
	private JTextField deleteAttribute = new JTextField();
	private JLabel deleteAttributeLabel = new JLabel("Attribute: ");
	private JTextField deleteValue = new JTextField();
	private JLabel deleteValueLabel = new JLabel("Value: ");
	//DELETE Action Listener 
	private class DeleteButtonActionHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				JPanel messagePanel = new JPanel();
				messagePanel.setLayout(new GridLayout(6, 2));
				messagePanel.add(deleteTableLabel);
				messagePanel.add(deleteTable);
				messagePanel.add(deleteAttributeLabel);
				messagePanel.add(deleteAttribute);
				messagePanel.add(deleteValueLabel);
				messagePanel.add(deleteValue);
				int result = JOptionPane.showConfirmDialog(null, messagePanel, "DELETE", JOptionPane.OK_CANCEL_OPTION);
	            if(result == JOptionPane.OK_OPTION)
	            {
	                String table = deleteTable.getText();
	                String attribute = deleteAttribute.getText();
	                String value = deleteValue.getText();
	                y.deleteRow(table, attribute, value);
	            }
			}
			catch(Exception e)
			{
				e.printStackTrace();//change this after 
			}
		}
	}
	//REFRESH Action Listener 
	private class RefreshButtonActionHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				switch(intRefresh)
				{
				//*****ITEM*****
				case 1:
					centerPanel.revalidate();
					//removing old version of the table
					centerSouth.remove(itemScroll);
					//Refreshing the table to match the Database back-end
					String[] itemHeader = {"Item ID","Description","Supplier ID","Buy Price",
							"Sell Price"};
					Object[][] itemData = y.retrieveSelectedTableObject("Item");
					JTable itemTable = new JTable(itemData, itemHeader);
					JScrollPane itemScroll = new JScrollPane(itemTable);					
					//Adding the table back to GUI 
					centerPanel.add(itemScroll, BorderLayout.CENTER);	
				break;
				//*****CLIENT*****
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
				//*****SUPPLIER*****
				case 5:
					centerPanel.revalidate();
					//removing old version of the table
					centerSouth.remove(supplierScroll);
					//Refreshing the table to match the Database back-end
					String[] supplierHeader = {"Supplier ID", "Company Name", "Address", "Contact Forename",
						"Contact Surname", "Email", "Phone Number"};
					Object[][] supplierData = y.retrieveSelectedTableObject("Supplier");
					JTable supplierTable = new JTable(supplierData, supplierHeader);
					JScrollPane supplierScroll = new JScrollPane(supplierTable);					
					//Adding the table back to GUI 
					centerPanel.add(supplierScroll, BorderLayout.CENTER);
				break;
				//*****ORDER*****
				case 6:
					centerPanel.revalidate();
					//removing old version of the table
					centerSouth.remove(orderScroll);
					//Refreshing the table to match the Database back-end
					String[] orderHeader = {"Order ID", "Client ID", "Account Manager ID", "Admin ID",
						"Item ID", "Quantity", "Supplier ID", "Delivery Address"};
					Object[][] orderData = y.retrieveSelectedTableObject("Order");
					JTable orderTable = new JTable(orderData, orderHeader);
					JScrollPane orderScroll = new JScrollPane(orderTable);					
					//Adding the table back to GUI 
					centerPanel.add(orderScroll, BorderLayout.CENTER);
				break;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}	
	
	
}
