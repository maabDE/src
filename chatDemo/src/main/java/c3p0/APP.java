package c3p0;

import java.sql.*;

public class APP {
    public static void main(String[] args) {
        Connection conn = null;
        String sql = "";
        PreparedStatement pst = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            try {
                conn = DBUtil.getConnection();
                sql = "select * from sc";
                pst = conn.prepareStatement(sql);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    System.out.println("SID: " + resultSet.getString(1) + "\n"
                            + "CID: " + resultSet.getString(2) + "\n"
                            + "score" + resultSet.getString(3)
                    );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    pst.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println(String.format("第%d次 使用的时间为： %d", i, (end - start)));
        }

    }
}
