package cn.humblecodeukco.test.scripts;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.*;
import org.jsoup.safety.Whitelist;

import java.sql.*;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Author lyr
 * @Date 2020/9/27 9:53
 * @Version 1.0
 * @Description 使用jsoup处理HTML数据
 */
public class JsoupDataProcess {

    private static Logger logger = Logger.getLogger(String.valueOf(JsoupDataProcess.class));

    public static void main(String[] args) {
        String text;
        String sentence;
        Whitelist addTogs = new Whitelist();
        int total = 0;
        int offset = 0;
        int batch = 100;
        String url = "jdbc:mysql://111.231.198.239:3306/cm_xkb?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String user = "root";
        String password = "Test123456";

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
            query = "SELECT COUNT(*) FROM questions WHERE Similarity=202097;";
            pstm = conn.prepareStatement(query);
            res = pstm.executeQuery();
            // 高考题总数
            while (res.next()) total = res.getInt(1);

            String querySentence = "insert into xkb_gaokao_questions (id, title," +
                    "option_a, option_b, option_c, option_d, option_e, answer1, " +
                    "answer2, parse, qtpye, diff, md5, subjectId, gradeId, knowledges," +
                    "area, year, paperTpye, source, fromSite, isSub, isNormal, isKonw, " +
                    "tiid, Similarity, isunique, md52) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            int count = 0;
            while (offset < total) {
                query = "SELECT * FROM questions WHERE Similarity=202097 limit " + offset + ", " + batch + ";";
                pstm = conn.prepareStatement(query);
                res = pstm.executeQuery();
                int num = 0;

                pstmtmp = conn.prepareStatement(querySentence);

                while (res.next()) {
                    ++num;
                    ++count;
                    // jsoup处理html标签
                    text = res.getString("title");
                    sentence = Jsoup.clean(text, addTogs);

                    pstmtmp.setInt(1, res.getInt("id"));
                    pstmtmp.setString(2, sentence);
                    pstmtmp.setString(3, res.getString("option_a"));
                    pstmtmp.setString(4, res.getString("option_b"));
                    pstmtmp.setString(5, res.getString("option_c"));
                    pstmtmp.setString(6, res.getString("option_d"));
                    pstmtmp.setString(7, res.getString("option_e"));
                    pstmtmp.setString(8, res.getString("answer1"));
                    pstmtmp.setString(9, res.getString("answer2"));
                    pstmtmp.setString(10, res.getString("parse"));
                    pstmtmp.setString(11, res.getString("qtpye"));
                    pstmtmp.setFloat(12, res.getFloat("diff"));
                    pstmtmp.setString(13, res.getString("md5"));
                    pstmtmp.setShort(14, res.getShort("subjectId"));
                    pstmtmp.setInt(15, res.getInt("gradeId"));
                    pstmtmp.setString(16, res.getString("knowledges"));
                    pstmtmp.setString(17, res.getString("area"));
                    pstmtmp.setInt(18, res.getInt("year"));
                    pstmtmp.setString(19, res.getString("paperTpye"));
                    pstmtmp.setString(20, res.getString("source"));
                    pstmtmp.setString(21, res.getString("fromSite"));
                    pstmtmp.setShort(22, res.getShort("isSub"));
                    pstmtmp.setShort(23, res.getShort("isNormal"));
                    pstmtmp.setShort(24, res.getShort("isKonw"));
                    pstmtmp.setString(25, res.getString("tiid"));
                    pstmtmp.setInt(26, res.getInt("Similarity"));
                    pstmtmp.setShort(27, res.getShort("isunique"));
                    pstmtmp.setString(28, res.getString("md52"));
                    pstmtmp.addBatch();
                    logger.info(num + " of " + batch + " is added");
                }
                offset += batch;
                pstmtmp.executeBatch();
                logger.info(count + " of " + total + " is executed");
                logger.info("commit ok");
                pstmtmp.clearBatch();
            }
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
