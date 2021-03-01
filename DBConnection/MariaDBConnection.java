import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MariaDBConnection {

    static {
        // 1.JDBC로딩
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //DB에 접속
            String oracle = "jdbc:oralce:thin:@localhost:1521:xe";
            String mariaDB = "jdbc:mariadb://localhost:3306/?user=root&password=1234";
            connection = DriverManager.getConnection(mariaDB);

            //statement 객체 생성
            preparedStatement = connection.prepareStatement("SELECT * FROM TEST.user");

            //Query 실행
            resultSet = preparedStatement.executeQuery();

            //결과값 반환 및 작업
            while(resultSet.next()) {
                System.out.println(resultSet.getString("USER_NAME"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //리소스 반환
                if (resultSet != null) {
                    resultSet.close();
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
