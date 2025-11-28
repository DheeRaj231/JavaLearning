

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DemoJdbc {
    public static void main(String[] args) throws Exception {

/*
import package
load and register
create connection
create statement
execute statement
process the results
close


*/

        int sid = 102;
        String sname = "Jasmine";
        int marks = 52;

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "6031";

        String sql = "insert into student values (?,?,?)";


        Connection con = DriverManager.getConnection(url, uname, pass);
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, sid);
        st.setString(2, sname);
        st.setInt(3, marks);
        st.execute();


        con.close();


    }
}

# Java JDBC – Handy Notes (Beginner → Intermediate)

## 📘 What is JDBC?
JDBC (Java Database Connectivity) is a Java API that enables Java applications to interact with relational databases like MySQL, PostgreSQL, Oracle, etc.

It allows you to:
- Connect to a database
- Execute SQL queries
- Insert, update, delete data
- Read (retrieve) data
- Handle transactions

---

## 🔹 JDBC Architecture
1. **DriverManager** – Manages database drivers  
2. **Connection** – Opens a connection to DB  
3. **Statement / PreparedStatement / CallableStatement** – Executes SQL commands  
4. **ResultSet** – Holds query results  

---

## 🔹 Steps in JDBC Program
1. Load driver  
2. Create connection  
3. Create statement  
4. Execute SQL  
5. Process results  
6. Close connection  

### Example:
```java
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/testdb", "root", "password");

Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM students");

while (rs.next()) {
    System.out.println(rs.getInt("id") + " " + rs.getString("name"));
}

con.close();
```

---

# 🚀 JDBC Components

## 🔹 DriverManager
```java
Connection con = DriverManager.getConnection(url, user, pass);
```

---

## 🔹 Connection
Methods:
- createStatement()
- prepareStatement()
- commit(), rollback()
- setAutoCommit(false)

---

## 🔹 Statement Example
```java
Statement stmt = con.createStatement();
stmt.executeUpdate("INSERT INTO students VALUES (1,'Ravi')");
```

---

## 🔹 PreparedStatement Example
```java
PreparedStatement ps = con.prepareStatement(
    "INSERT INTO students(id,name) VALUES (?, ?)");

ps.setInt(1, 101);
ps.setString(2, "Arjun");

ps.executeUpdate();
```

---

## 🔹 ResultSet Example
```java
ResultSet rs = stmt.executeQuery("SELECT * FROM students");
while(rs.next()) {
    System.out.println(rs.getInt("id")+" "+rs.getString("name"));
}
```

---

## 🔹 CallableStatement Example
```java
CallableStatement cs = con.prepareCall("{call getStudent(?)}");
cs.setInt(1, 101);
ResultSet rs = cs.executeQuery();
```

---

# 🔥 Intermediate Concepts

## 🔹 Transactions
```java
con.setAutoCommit(false);

ps1.executeUpdate();
ps2.executeUpdate();

con.commit();
```

---

## 🔹 Batch Processing
```java
PreparedStatement ps = con.prepareStatement(
    "INSERT INTO students VALUES (?, ?)");

ps.setInt(1, 201);
ps.setString(2, "Hari");
ps.addBatch();

ps.setInt(1, 202);
ps.setString(2, "Kiran");
ps.addBatch();

ps.executeBatch();
```

---

## 🔹 Exception Handling
```java
try {
   // JDBC code
} catch(SQLException e) {
   System.out.println(e.getMessage());
}
```

---

## 🔹 Try-With-Resources
```java
try (Connection con = DriverManager.getConnection(url,user,pass);
     PreparedStatement ps = con.prepareStatement("SELECT * FROM students")) {

    ResultSet rs = ps.executeQuery();
}
```

---

# 🔹 JDBC URL Formats
### MySQL  
`jdbc:mysql://host:3306/dbname`  
### PostgreSQL  
`jdbc:postgresql://host:5432/dbname`  
### Oracle  
`jdbc:oracle:thin:@localhost:1521:orcl`  

---

# 📦 Complete Program
```java
import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb","root","password");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students")) {

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getInt(1)+" "+rs.getString(2));
            }
        }
    }
}
```

---

# ✔ JDBC Best Practices
- Prefer **PreparedStatement**
- Close resources properly
- Use **connection pooling** in production
- Avoid hardcoding DB credentials
- Use try-with-resources
