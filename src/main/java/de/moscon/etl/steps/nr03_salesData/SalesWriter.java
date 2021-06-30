package de.moscon.etl.steps.nr03_salesData;

import de.moscon.etl.beans.Sale;
import de.moscon.etl.statementsetter.SaleItemPreparedStmSetter;
import de.moscon.etl.steps.StepUtils;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class SalesWriter extends JdbcBatchItemWriter<Sale> {

	String sql = "Insert into sales_tennisshop (id, count, net_price_sum_formatted, time_formatted, customer_id, product_id) values (?,?,?,?,?,?)";

	public SalesWriter(@Qualifier("dataSourceMySql")DataSource dataSourceMySql) {
		setDataSource(dataSourceMySql);
		setSql(sql);
		setItemPreparedStatementSetter(new SaleItemPreparedStmSetter());
	}







//	private Resource outputResource = new FileSystemResource("data/output/sales_tennisshop.csv");
//
//	public SalesWriter() {
//		setResource(outputResource);
//		setLineAggregator(StepUtils.createLineAggregator(getFields()));
//		setHeaderCallback(writer -> {
//			writer.write(String.join(";", getFields()));
//		});
//	}
//
//
//
//	private String[] getFields() {
//		return new String[]{"id", "productId", "customerId", "count", "netPriceSumFormatted", "timeFormatted"};
//	}

}
