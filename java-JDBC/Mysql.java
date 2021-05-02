import java.sql.*;  
class Mysql{  
public static void main(String args[]){

	Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","");

			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from users");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"-"+rs.getString(2)+"-"+rs.getString(3)+"-"+rs.getString(4)+"$");
			
			}
		}

		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}

			finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
			    } 
		catch(Exception es) {
				es.printStackTrace();
				    }
			}}	}
