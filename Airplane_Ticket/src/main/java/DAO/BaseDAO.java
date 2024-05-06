package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/ticketmanager";   // tên database
    private static String jdbcUsername = "root"; // tk database
    private static String jdbcPassword = "1234";  // mk database
    private static Connection connection;

    public static Connection getConnection() {   // phương thức kết nối database
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {  // cuối mỗi phương thức nhớ gọi phương thức này để đóng database
        connection.close();
        connection = null;
    }

//    public static void main(String[] args) throws SQLException {
//        List<SanBayDTO> sanBayDTOList = new ArrayList<>();
//        PreparedStatement preparedStatement = BaseDAO.getConnection()
//                .prepareStatement("SELECT * FROM `sanbay`");
//        ResultSet resultSet = preparedStatement.executeQuery();
//        SanBayDTO sanBayDTO;
//        while (resultSet.next()) {
//            sanBayDTO = new SanBayDTO();
//            sanBayDTO.setMaSanBay(resultSet.getString("maSanBay"));
//            sanBayDTO.setTen(resultSet.getString("ten"));
//            sanBayDTO.setStatus(resultSet.getBoolean("status"));
//            sanBayDTOList.add(sanBayDTO);
//        }
//
//        for (SanBayDTO sanBayDTO1 : sanBayDTOList) {
//            System.out.println(sanBayDTO1);
//        }
//    }
}
