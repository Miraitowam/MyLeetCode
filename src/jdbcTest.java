import java.sql.*;

/**
 * @description: jdbc测试
 * @return:
 * @Author: M
 * @create: 2022/7/3 15:30
 */
public class jdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/testdb?useUnicode=true$characterEncoding=utf8&useSSL=true";
        String username = "root";
        String password = "12345678";
        //3.连接成功，数据库对象
        Connection connection = DriverManager.getConnection(url, username, password);
        //4.执行SQL的对象
        Statement statement = connection.createStatement();
        //5.这里写SQL语句返回结果
        String sql = "select * from zhangwu";
        ResultSet resultSet = statement.executeQuery(sql);  //返回的结果集
        while (resultSet.next()) {
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("sname=" + resultSet.getObject("sname"));
            System.out.println("money=" + resultSet.getObject("money"));
        }
        //6.释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
