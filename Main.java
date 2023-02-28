package gems;
import java.sql.SQLException;
public class Main
{
	private static GEMS gems;
	private static GEMS_GUI gui;
	public static void main(String[] args) throws SQLException 
	{
		gems = new GEMS();
		gui = new GEMS_GUI();
	}
}
