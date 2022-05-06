package com.zensar.stockapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;*/
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@ApiModel("Thisis is stock model")
//changing entity name and instead of giving table name to query we have passed entity name to query and its mapped with stock using table annotation
@Entity(name="MyStock")
@Table(name="Stock")

//@NamedQueries({@NamedQuery(name = "Stock.findStockByNameAndPrice", query = "FROM MyStock s where s.stockName=?1 and s.price=?2") })
//@NamedQuery(name = "Stock.findStockByName", query = "FROM MyStock s where s.stockName=?1")
//@NamedNativeQuery(name = "Stock.findStockByName", query = "select * from stock where stock_Name=?1", resultClass=Stock.class)



public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stockId;
	//@ApiModelProperty("name is in string format")
	private String stockName;
	private String marketName;
	private int price;
}
