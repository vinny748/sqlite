import java.sql.Connection;
import java.sql.DriverManager;  
import java.sql.SQLException;
import java.sql.Statement;  
import java.sql.ResultSet; 



	public static void selectRecord() {
		//database
		String url = "jdbc:sqlite:Movies.db";
		//sql
		String sql = "SELECT * FROM movies";
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Name \t\t Actor \t\t Actress \t\t Director \t ReleasedYear");
			while(rs.next()) {
				System.out.println(rs.getString("Name")+"\t"+rs.getString("Actor")+"\t"+rs.getString("Actress")+"\t"+rs.getString("Director")+"\t"+rs.getInt("Year"));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void selectRecord(String actor) {
		//database
				String url = "jdbc:sqlite:Movies.db";
				//sql
				String sql = "SELECT * FROM movies WHERE Actor='"+actor+"';";
				try {
					Connection conn = DriverManager.getConnection(url);
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					System.out.println("Name \t\t Actor \t\t Actress \t\t Director \t ReleasedYear");
					while(rs.next()) {
						System.out.println(rs.getString("Name")+"\t"+rs.getString("Actor")+"\t"+rs.getString("Actress")+"\t"+"\t"+rs.getString("Director")+"\t"+rs.getInt("ReleasedYaer"));
					}
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
	}
	
	public static void main(String[] args) {  
		selectRecord();
		selectRecord("Salman Khan");
	}  
}  