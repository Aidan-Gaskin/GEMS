package gems;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GEMS 
{
    //Connection Variable.
	//Static: Only one connection. Doesn't matter how many GEMS created 
	private static Connection connection;
    //path for database
	private String url = "jdbc:mysql://localhost:3306/";
	//user name for database
	private String username = "root";
	//password for database 
	private String password = "Candy09!";
    public GEMS()
    {
    	try 
    	{
			connectGEMS();
			System.out.println("\nConnected");//for testing, delete out prints after / put in GUI handlers 
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();//for testing, delete all prints after / put in GUI handlers 
		}
    }
    //ESTABLISHES CONNECTION 
    public void connectGEMS() throws SQLException 
    {
    	try
    	{
        	GEMS.connection = DriverManager.getConnection(url, username, password);
        	System.out.println("\nSUCCESS");//testing purposes 
    	}
    	catch(Exception e)
    	{
    		System.out.println("\nFAILED");//testing purposes 
    	}
	}
    //****************************C.R.U.D. OPERATIONS*********************************
    //****************************CREATE METHODS HERE*********************************
    public void createAdministratorObject(String forename, String surname, String phoneNo) throws SQLException 
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO gemsDB.Administrator (forename, surname, phoneNo) VALUES (?, ?, ?)");
            ps.setString(1, forename);
            ps.setString(2, surname);
            ps.setString(3, phoneNo);
            int status = ps.executeUpdate();
            if(status != 0)
            {
                System.out.println("\nRecord was inserted.");
            }
            else
            {
                System.out.println("\nRecord not inserted.");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void createAccountManagerObject(String forename, String surname, String phoneNo)
    {
    	try
    	{
    		PreparedStatement ps = connection.prepareStatement("INSERT INTO gemsDB.AccountManager (forename, surname, phoneNo) VALUES "
			+ "('"+forename+"','"+surname+"', '"+phoneNo+"');");
    		int status = ps.executeUpdate();
    		if(status != 0)
    		{
    			System.out.println("\nRecord was inserted.");
    		}
    		else
    		{
    			System.out.println("\nRecord was not inserted.");
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    public void createClientObject(String companyName, String address, int accountManagerID, String contactForename, String contactSurname,
    		String contactEmail, String contactPhoneNo)
    {
    	try
    	{
    		PreparedStatement ps = connection.prepareStatement("INSERT INTO gemsDB.Client "
			+ "(companyName, address, accountManagerID, contactForename, contactSurname, contactEmail, contactPhoneNo) VALUES "
			+ "('"+companyName+"','"+address+"', '"+accountManagerID+"','"+contactForename+"','"+contactSurname+"','"+
			contactEmail+"','"+contactPhoneNo+"');");
			int status = ps.executeUpdate();
			if(status != 0)
			{
				System.out.println("\nRecord was inserted.");
			}
			else
			{
				System.out.println("\nRecord not inserted.");
			}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    public void createItemObject(String description, int supplierID, double buyPrice, double sellPrice)
    {
    	try
    	{
    		PreparedStatement ps = connection.prepareStatement("INSERT INTO gemsDB.Item "
   			+ "(description, supplierID, buyPrice, sellPrice) VALUES "
    		+ "('"+description+"','"+supplierID+"', '"+buyPrice+"','"+sellPrice+"');");
    		int status = ps.executeUpdate();
    		if(status != 0)
    		{
    			System.out.println("\nRecord was inserted.");
    		}
    		else
    		{
    			System.out.println("\nRecord not inserted.");
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    public void createOrderObject(int clientID, int accountManID, int adminID, int itemID, int quantity, int supplierID, String deliveryAddress)
    {
    	try
    	{
    		PreparedStatement ps = connection.prepareStatement("INSERT INTO gemsDB.Order "
    		+ "(clientID, accountManID, adminID, itemID, quantity, supplierID, deliveryAddress) VALUES "
  			+ "('"+clientID+"','"+accountManID+"', '"+adminID+"','"+itemID+"','"+quantity+"','"+
    		supplierID+"','"+deliveryAddress+"');");
    		int status = ps.executeUpdate();
    		if(status != 0)
    		{
    			System.out.println("\nRecord was inserted");
    		}
    		else
    		{
    			System.out.println("\nRecord not inserted.");
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    public void createSupplierObject(String companyName, String address, String forename, String surname, String email, String phoneNo)
    {
    	try
    	{
        	PreparedStatement ps = connection.prepareStatement("INSERT INTO gemsDB.Supplier "
    		+ "(companyName, address, contactForename, contactSurname, contactEmail, contactPhoneNo) VALUES "
    		+ "('"+companyName+"','"+address+"', '"+forename+"','"+surname+"','"+email+"','"+
    		phoneNo+"');");
    		int status = ps.executeUpdate();
    		if(status != 0)
    		{
    			System.out.println("\nRecord was inserted.");
    		}
    		else
    		{
    			System.out.println("\nRecord not inserted.");
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    //****************************RETRIEVE METHOD HERE********************************
    public void retrieveSelectedTable(String s) 
    {
    	try
    	{
        	String sql = "SELECT * FROM gemsDB."+s;

    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    		
    		System.out.println("\n********"+s+" TABLE********\n");
    		
            if (!rs.isBeforeFirst()) 
            {
                System.out.println(s+" Table Empty\n");
            }
            while (rs.next()) 
            {
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                for (int i = 1; i <= columnsNumber; i++) 
                {
                    String columnName = rsmd.getColumnName(i);
                    System.out.print(columnName + ": " + rs.getString(columnName) + "  \n");
                }
            }

    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    		//e.printStackTrace();
    	}
    } 
    public Object[][] retrieveSelectedTableObject(String s) 
    {
        try 
        {
            String sql = "SELECT * FROM gemsDB." + s;

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (!rs.isBeforeFirst()) 
            {
                return null;
            }
            //ResultSetMetaData Gets the Rows and Names etc (e.g. the meta data of the ResultSet)
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            List<Object[]> dataList = new ArrayList<Object[]>();
            while (rs.next()) 
            {
                Object[] row = new Object[columnsNumber];
                for (int i = 1; i <= columnsNumber; i++) 
                {
                    row[i - 1] = rs.getObject(i);
                }
                dataList.add(row);
            }

            Object[][] data = new Object[dataList.size()][columnsNumber];
            for (int i = 0; i < dataList.size(); i++) 
            {
                data[i] = dataList.get(i);
            }
            
            return data;
            
        } 
        	catch (Exception e) 
        	{
        		System.out.println(e);
        		//e.printStackTrace();
        		return null;
        	}
    }
    //****************************UPDATE METHOD HERE**********************************
    public void updateEntry(String databaseTable, String row, String newEntry, String primaryKey, String value) 
    {
    	try
    	{
    		String query = "UPDATE `gemsDB`.`"+databaseTable+"` SET `"+row+"` = '"+newEntry+"' WHERE (`"+primaryKey+"` = '"+value+"');";
    		Statement statement = connection.createStatement();
    		statement.executeUpdate(query);
    		int status = statement.executeUpdate(query);
    		if(status != 0)
    		{
    			System.out.println("\nRecord was updated.");
    		}
    		else
    		{
    			System.out.println("\nRecord not updated.");
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    }
    //****************************DELETE METHOD HERE**********************************
    public void deleteRow(String databaseTable, String row, String condition)
    {
    	try
    	{
    		PreparedStatement ps = connection.prepareStatement("DELETE FROM `gemsDB`.`"+databaseTable+"` WHERE (`"+row+"` = '"+condition+"');");
    		int status = ps.executeUpdate();
    		if(status != 0)
  			{
  				System.out.println("\nRecord was deleted.");
  			}
    		else
    		{
    			System.out.println("\nNo such record.");
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }   
}