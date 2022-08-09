    import java.sql.Connection;  
    import java.sql.DriverManager;  
    import java.sql.Statement;  
    import java.sql.SQLException;  
       
    public class InsertData {  
       
        private Connection connect() {  
            // SQLite connection string  
            String url = "jdbc:sqlite:Movies.db";  
            Connection conn = null;  
            try {  
                conn = DriverManager.getConnection(url);  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
            return conn;  
        }  
       
      
        public void insert(String Name,String Actor,String Actress,String Director,int ReleasedYear) {  
            String sql = "INSERT INTO MovieDetails(Name, Actor, Actress, Director, ReleasedYear ) VALUES(?,?,?,?,?)";  
       
            try{  
                Connection conn = this.connect();  
                Statement stmt = conn.createStatement();  
                stmt.execute(sql);   
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
        }  
       
        public static void main(String[] args) {  
       
            InsertData dt = new InsertData();
           dt.insert("Red Notice", "Dwayne Johnsan", "Gal Gadot", "Rawson Marshall Thurber",2021);
	     dt.insert("Catch Me If You Can", "Leonardo DiCaprio", "Amy Adams","Steven Spielberg",2002);
	     dt.insert("Andhadhun", "Ayushman Khurrana", "Tabu","Sriram Raghavan",2018);
	     dt.insert("Partner", "Salman Khan", "Lara Dutta","David Dhawan",2007);
	     dt.insert("PK", "Amir Khan", "Anushka Sharma", "Rajkumar Hirani",2014);  
        }  
       
    }  