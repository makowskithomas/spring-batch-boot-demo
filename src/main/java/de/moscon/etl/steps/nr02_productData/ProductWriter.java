package de.moscon.etl.steps.nr02_productData;

import de.moscon.etl.beans.Product;
import de.moscon.etl.statementsetter.ProductItemPreparedStmSetter;
import de.moscon.etl.steps.StepUtils;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class ProductWriter extends JdbcBatchItemWriter<Product> {

	String sql = "Insert into produkte_tennisshop (id, category, display_name, net_price_formatted, player_brand) values (?,?,?,?,?)";

	public ProductWriter(@Qualifier("dataSourceMySql")DataSource dataSourceMySql) {
		setDataSource(dataSourceMySql);
		setSql(sql);
		setItemPreparedStatementSetter(new ProductItemPreparedStmSetter());

	}






//	private Resource outputResource = new FileSystemResource("data/output/produkte_tennisshop.csv");
//
//	public ProductWriter() {
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
//		return new String[]{"id", "displayName", "netPriceFormatted", "category", "playerBrand"};
//	}

}
