package anand.learn.one;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name ="setter_table")
@Table(name = "table_setter")
public class SetterRelated {
	@Id
	@Column(name="field_id")
	private int id;
	@Column(name="field_name")
	private String name;
	@Column(name = "field_value1")
	private String value;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "join_date")
	private Date joinDate;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "join_time")
	private Date joinTime;
	@Lob
	private String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "field_value")
	public String getValue() {
		return value + " from getter";
	}
	@Column(name = "value_date")
	public void setValue(String value) {
		this.value = value;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
