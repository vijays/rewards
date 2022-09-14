package com.vijays.rewards.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Entity mapping tbl_transaction

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
	private int quantity_transaction ;
	@Column
	private int amount_transaction ;
	@Column
	private int reward_points_transaction ;
	
	public Transaction() {
		super();
	}

	// Constructor
	
	public Transaction(int id_transaction, Date date_transaction, int id_customer, int id_product,
			int quantity_transaction, int amount_transaction, int reward_points_transaction) {
		super();
		this.id_transaction = id_transaction;
		this.date_transaction = date_transaction;
		this.id_customer = id_customer;
		this.id_product = id_product;
		this.quantity_transaction = quantity_transaction;
		this.amount_transaction = amount_transaction;
		this.reward_points_transaction = reward_points_transaction;
	}

	// Getter Setter methods
	
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

	public int getQuantity_transaction() {
		return quantity_transaction;
	}

	public void setQuantity_transaction(int quantity_transaction) {
		this.quantity_transaction = quantity_transaction;
	}

	public int getAmount_transaction() {
		return amount_transaction;
	}

	public void setAmount_transaction(int amount_transaction) {
		this.amount_transaction = amount_transaction;
	}

	public int getReward_points_transaction() {
		return reward_points_transaction;
	}

	public void setReward_points_transaction(int reward_points_transaction) {
		this.reward_points_transaction = reward_points_transaction;
	}



}
