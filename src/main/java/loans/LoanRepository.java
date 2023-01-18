package loans;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class LoanRepository {

    private JdbcTemplate jdbcTemplate;

    public LoanRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long insertLoan(String name, int debt, double interest) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps =
                    con.prepareStatement("insert into loans (name, debt, interest) values (?, ?, ?);",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setLong(2, debt);
            ps.setDouble(3, interest);
            return ps;
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }


    public Loan findLoanById(long id) {
        return jdbcTemplate.queryForObject(
                "select * from loans where id = ?;",
                (rs, rowNum) -> new Loan(rs.getLong("id"), rs.getString("name"), rs.getLong("debt"), rs.getDouble("interest")),
                id
        );
    }

    public void updateDebtWithInterest(){
        jdbcTemplate.update("UPDATE loans set debt = debt*(1+interest/100);");
    }

    public void updateDebtWithPayment(long id, int amount){
        jdbcTemplate.update("update loans set debt = debt - ? where id = ?;", amount, id);
    }



}
