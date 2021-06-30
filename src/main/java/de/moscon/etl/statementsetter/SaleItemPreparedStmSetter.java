package de.moscon.etl.statementsetter;

import de.moscon.etl.beans.Sale;
import de.moscon.etl.utils.DateStringUtils;
import de.moscon.etl.utils.DecimalUtils;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaleItemPreparedStmSetter implements ItemPreparedStatementSetter<Sale> {

//    String sql = "Insert into sales_tennisshop (id, count, net_price_sum_formatted, time_formatted, customer_id, product_id) values (?,?,?,?,?,?)";

    DecimalUtils doubleUtil = new DecimalUtils();
    DateStringUtils dateUtil = new DateStringUtils();

    @Override
    public void setValues(Sale sale, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, Math.toIntExact(sale.getId()));
        preparedStatement.setInt(2,sale.getCount());
        preparedStatement.setDouble(3, doubleUtil.newDouble(sale.getNetPriceSumFormatted()));
        preparedStatement.setDate(4, dateUtil.newString(sale.getTimeFormatted()));
        preparedStatement.setInt(5, Math.toIntExact(sale.getCustomerId()));
        preparedStatement.setInt(6, Math.toIntExact(sale.getProductId()));
    }
}
