package de.moscon.etl.statementsetter;

import de.moscon.etl.beans.Customer;
import de.moscon.etl.utils.DateStringUtils;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class CustomerItemPreparedStmSetter implements ItemPreparedStatementSetter<Customer> {

    //(id, birthday_formatted, city, gender, pseudonym, registration_date_formatted, zip_code)

    DateStringUtils dateUtil = new DateStringUtils();

    @Override
    public void setValues(Customer customer, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, Math.toIntExact(customer.getId()));
        preparedStatement.setDate(2, dateUtil.newString(customer.getBirthdayFormatted()));
        preparedStatement.setString(3,customer.getCity());
        preparedStatement.setString(4, String.valueOf(customer.getGender()));
        preparedStatement.setString(5,customer.getPseudonym());
        preparedStatement.setDate(6, dateUtil.newString(customer.getRegistrationDateFormatted()));
        preparedStatement.setInt(7, Integer.parseInt(customer.getZipCode()));
    }
}
