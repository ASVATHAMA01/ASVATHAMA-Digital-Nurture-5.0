package com.cognizant.ormlearn.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "st_id")
	private int id;

	@Column(name = "st_code")
	private String code;

	@Column(name = "st_date")
	private Date date;

	@Column(name = "st_open")
	private double open;

	@Column(name = "st_close")
	private double close;

	@Column(name = "st_volume")
	private double volume;

	public int getId() { return id; }
	public String getCode() { return code; }
	public void setCode(String code) { this.code = code; }
	public Date getDate() { return date; }
	public void setDate(Date date) { this.date = date; }
	public double getOpen() { return open; }
	public void setOpen(double open) { this.open = open; }
	public double getClose() { return close; }
	public void setClose(double close) { this.close = close; }
	public double getVolume() { return volume; }
	public void setVolume(double volume) { this.volume = volume; }

	public String toString() {
		return "Stock [code=" + code + ", date=" + date + ", open=" + open + ", close=" + close + ", volume=" + volume + "]";
	}
}
