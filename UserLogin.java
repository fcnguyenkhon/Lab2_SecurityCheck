import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement; 
public class UserLogin { 
// 1. Hard-coded Credential 
private static final String DB_URL = "jdbc:mysql://localhost/users"; 
private static final String USER = "admin"; 
private static final String PASS = "123456";  
public boolean login(String username, String password) { 
try { 
Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
Statement stmt = conn.createStatement(); 
// 2. SQL Injection Vulnerability 
String sql = "SELECT * FROM users WHERE username = '" + username + "' 
AND password = '" + password + "'"; 
System.out.println("Executing query: " + sql); // 3. Logging sensitive data 
ResultSet rs = stmt.executeQuery(sql); 
if (rs.next()) { 
return true; 
} 
} catch (Exception e) { 
e.printStackTrace(); // 4. Poor Error Handling 
} 
return false; 
} 
} 