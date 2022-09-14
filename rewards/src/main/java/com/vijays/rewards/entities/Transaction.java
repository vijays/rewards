package com.vijays.rewards.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_transaction")
public class Transaction {
	
	@Id
	@Column 
	private int id_transaction ;
	@Column
	private Date date_transaction ;
	@Column
	private int id_customer ;
	@Column
	private int id_product ;
	@Column
	private int nos_product ;
	@Column
	private int amount_transaction ;
	@Column
	private int reward_points ;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int id_transaction, Date date_transaction, int id_customer, int id_product, int nos_product,
			int amount_transaction, int reward_points) {
		super();
		this.id_transaction = id_transaction;
		this.date_transaction = date_transaction;
		this.id_customer = id_customer;
		this.id_product = id_product;
		this.nos_product = nos_product;
		this.amount_transaction = amount_transaction;
		this.reward_points = reward_points;
	}

	public int getId_transaction() {
		return id_transaction;
	}

	public void setId_transaction(int id_transaction) {
		this.id_transaction = id_transaction;
	}

	public Date getDate_transaction() {
		return date_transaction;
	}

	public void setDate_transaction(Date date_transaction) {
		this.date_transaction = date_transaction;
	}

	public int getId_customer() {
		return id_customer;
	}

	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}

	public int getId_product() {
		return id_product;
	}

	public void setId_product(int id_product) {
		this.id_product = id_product;
	}

	public int getNos_product() {
		return nos_product;
	}

	public void setNos_product(int nos_product) {
		this.nos_product = nos_product;
	}

	public int getAmount_transaction() {
		return amount_transaction;
	}

	public void setAmount_transaction(int amount_transaction) {
		this.amount_transaction = amount_transaction;
	}

	public int getReward_points() {
		return reward_points;
	}

	public void setReward_points(int reward_points) {
		this.reward_points = reward_points;
	}

	
}
