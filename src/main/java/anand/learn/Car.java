package anand.learn;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String model;
	private String manufacturer;
	private String price;
	private LocalDate makeYear;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public LocalDate getMakeYear() {
		return makeYear;
	}

	public void setMakeYear(LocalDate makeYear) {
		this.makeYear = makeYear;
	}

}