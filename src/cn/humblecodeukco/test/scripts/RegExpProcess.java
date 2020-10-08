package cn.humblecodeukco.test.scripts;

import org.jsoup.safety.Whitelist;

import java.sql.*;
import java.sql.Connection;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @Author lyr
 * @Date 2020/9/29 9:58
 * @Version 1.0
 * @Description
 */
public class RegExpProcess {

    private static Logger logger = Logger.getLogger(String.valueOf(RegExpProcess.class));

    public static void main(String[] args) {
        String text;
        String sentence;
        int total = 0;
        int offset = 0;
        int batch = 100;
        String url = "jdbc:mysql://111.231.198.239:3306/cm_xkb?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String user = "root";
        String password = "Test123456";

        //sentence = "设关于x的方程（m+1）x2-mx+m-1=0有实根时实数m的取值范围是集合A，函数的f（x）=lg[x2-（a+2）x+2a]定义域是集合B． （1）求集合A；&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（2）若A∪B=B，求实数a的取值范围．";
        String regEx_special = "\\&[a-zA-Z]{1,10};";
        Pattern p_special = Pattern.compile(regEx_special, Pattern.CASE_INSENSITIVE);

        Connection conn = null;
        PreparedStatement pstm = null;
        PreparedStatement pstmtmp = null;
        ResultSet res = null;
        String query;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            logger.info("数据库驱动加载失败");
        }

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            logger.info("创建数据库连接失败");
        }

        try {
            query = "SELECT COUNT(*) from xkb_gaokao_questions WHERE title LIKE '%&nbsp%';";
            pstm = conn.prepareStatement(query);
            res = pstm.executeQuery();
            // 高考题总数
            while (res.next()) total = res.getInt(1);

            String querySentence = "update xkb_gaokao_questions set title=? where id=?;";

            int count = 0;
            query = "SELECT * FROM xkb_gaokao_questions WHERE title like '%&nbsp%';";
            pstm = conn.prepareStatement(query);
            res = pstm.executeQuery();
            int num = 0;

            pstmtmp = conn.prepareStatement(querySentence);

            while (res.next()) {
                ++num;
                ++count;
                // 正则匹配
                text = res.getString("title");
                Matcher m_special = p_special.matcher(text);
                sentence = m_special.replaceAll("");

                pstmtmp.setString(1, sentence);
                pstmtmp.setInt(2, res.getInt("id"));
                pstmtmp.addBatch();
                logger.info(num + " of " + batch + " is updated");
            }
            //offset += batch;
            pstmtmp.executeBatch();
            //logger.info(count + " of " + total + " is executed");
            logger.info("commit ok");
            pstmtmp.clearBatch();
        } catch (SQLException e) {
            logger.info("执行数据库语句失败");
        } finally {
            try {
                res.close();
                pstmtmp.close();
                pstm.close();
                conn.close();
            } catch (Exception e) {
                logger.info("关闭数据库连接失败");
            }
        }
    }
}
