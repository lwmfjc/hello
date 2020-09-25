package fife.ly.dao;

import fife.ly.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class PlainPhoneDao implements PhoneDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Phone> findAll() {
        //queryList方法做不到直接将放回的列映射为类对象
        return jdbcTemplate.query("SELECT * FROM phone p", new RowMapper<Phone>() {
            @Override
            public Phone mapRow(ResultSet rs, int rowNum) throws SQLException {
                Phone phone=new Phone();
                phone.setId(rs.getInt("id"));
                phone.setName(rs.getString("name"));
                return phone;
            }
        });
    }
}
