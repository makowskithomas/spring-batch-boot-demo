package de.moscon.etl.statementsetter;

import de.moscon.etl.beans.Customer;
import de.moscon.etl.beans.Product;
import de.moscon.etl.utils.DecimalUtils;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductItemPreparedStmSetter implements ItemPreparedStatementSetter<Product> {

    DecimalUtils doubleUtil = new DecimalUtils();

    @Override
    public void setValues(Product product, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, Math.toIntExact(product.getId()));
        preparedStatement.setString(2, product.getCategory());
        preparedStatement.setString(3, product.getDisplayName());
        preparedStatement.setDouble(4, doubleUtil.newDouble(product.getNetPriceFormatted()));
        preparedStatement.setString(5, product.getPlayerBrand());
    }
}
