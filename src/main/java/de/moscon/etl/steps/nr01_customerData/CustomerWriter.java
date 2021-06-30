package de.moscon.etl.steps.nr01_customerData;

import de.moscon.etl.beans.Customer;
import de.moscon.etl.statementsetter.CustomerItemPreparedStmSetter;
import de.moscon.etl.steps.StepUtils;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class CustomerWriter extends JdbcBatchItemWriter<Customer> {

    String sql = "Insert into kunden_tennisshop (id, birthday_formatted, city, gender, pseudonym, registration_date_formatted, zip_code) values (?,?,?,?,?,?,?)";

    public CustomerWriter(@Qualifier("dataSourceMySql") DataSource dataSourceMySql) {
        setDataSource(dataSourceMySql);
        setSql(sql);
        setItemPreparedStatementSetter(new CustomerItemPreparedStmSetter());
    }
}


//	private Resource outputResource = new FileSystemResource("data/output/kunden_tennisshop.csv");

//	public CustomerWriter() {
//		setResource(outputResource);
//		// setAppendAllowed(true);
//		setLineAggregator(StepUtils.createLineAggregator(getFields()));
//		setHeaderCallback(writer -> {
//			writer.write(String.join(";",getFields()));
//		});
//	}
//
//
//	private String[] getFields() {
//		return new String[]{"id", "pseudonym", "gender", "birthdayFormatted", "zipCode", "city", "registrationDateFormatted"};	//Felder die man ins CSV schreiben möchte
//	}

