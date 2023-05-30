package com.cherrypicker.cherrypick3r.component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class putDatabasesServce {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public putDatabasesServce(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertDataFromCSV(String filePath) throw IOException{
        String sql = "INSERT INTO cherrypicker_database.shop_table ()"

    }



    public

}
