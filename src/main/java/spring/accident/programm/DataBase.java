/**
 * Package spring.accident.programm for
 *
 * @author Maksim Tiunchik
 */
package spring.accident.programm;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import spring.accident.models.Accident;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class DataBase - JDBC multithreading DB connection class
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 20.04.2020
 */
@Repository
@Scope("singleton")
@Qualifier("base")
public class DataBase {

    /**
     * inner logger
     */
    private static final Logger LOG = LogManager.getLogger(DataBase.class.getName());

    /**
     * special version of JDBC for multithreading sessions
     */
    private static final BasicDataSource SOURCE = dbStore();

    /**
     * make connections to psql
     *
     * @return connections factory
     */
    private static BasicDataSource dbStore() {
        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName("org.postgresql.Driver");
        source.setUrl("jdbc:postgresql://127.0.0.1:5432/car");
        source.setUsername("postgres");
        source.setPassword("password");
        source.setMinIdle(5);
        source.setMaxIdle(10);
        source.setMaxOpenPreparedStatements(100);
        source.setDefaultTransactionIsolation(4);
        return source;
    }

    /**
     * provide full list of saved accidents
     *
     * @return list of saved accidents
     */
    public List<Accident> getAll() {
        List<Accident> answer = new ArrayList<>();
        try (Connection connection = SOURCE.getConnection()) {
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM ACCIDENTS");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Accident temp = new Accident();
                temp.setId(rs.getInt("acc_nubmer"));
                temp.setName(rs.getString("acc_name"));
                temp.setText(rs.getString("acc_text"));
                temp.setAddress(rs.getString("acc_address"));
                answer.add(temp);
            }
        } catch (SQLException sql) {
            LOG.error("SQL execption", sql);
        }
        return answer;
    }
}
