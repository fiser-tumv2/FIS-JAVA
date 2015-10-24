package tu.data.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnect {
  private final String className = "com.mysql.jdbc.Driver";
  private final String url = "jdbc:mysql://localhost:3306/demo";
  private Connection connect;
  private String user = "root";
  private String password = "";

  public void connect() {
    try {
      Class.forName(className);
      connect = DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException e) {
      System.out.println("Class not found!");
    } catch (SQLException e) {
      System.out.println("Error connection!");
    }
  }

  public ResultSet getData() {
    ResultSet rs = null;
    String query = "SELECT * FROM user";
    Statement st;
    try {
      st = connect.createStatement();
      rs = st.executeQuery(query);
    } catch (SQLException e) {
      System.out.print("Select error. " + e.toString());
    }

    return rs;
  }

  public void insertData(int id, String name, String address) {
    String query = "INSERT INTO user VALUES(?,?,?)";
    try {
      PreparedStatement ps = connect.prepareStatement(query);
      ps.setInt(1, id);
      ps.setString(2, name);
      ps.setString(3, address);
      if (ps.executeUpdate() > 0) {
        System.out.println("Insert success");
      }

    } catch (SQLException e) {
      System.out.println("Not insert");
    }
  }

  public void deleteData(int id) {
    String query = "DELETE FROM user WHERE iduser = ?";
    try {
      PreparedStatement ps = connect.prepareStatement(query);
      ps.setInt(1, id);
      if (ps.executeUpdate() > 0) {
        System.out.println("Delete success");
      }
    } catch (SQLException e) {
      System.out.println("Not delete");
    }
  }

  public void showData(ResultSet rs) {
    try {
      while (rs.next()) {
        System.out.printf("%10s %10s %20s \n", rs.getString(1), rs.getString(2), rs.getString(3));
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    MyConnect myconnect = new MyConnect();
    myconnect.connect();
    myconnect.deleteData(4);
    //myconnect.insertData(4, "Tuan", "Ha Noi");
    myconnect.showData(myconnect.getData());
  }
}
