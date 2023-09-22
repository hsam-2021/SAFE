package com.safe.hsap.safe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "amhs_mp", schema = "public")
@NamedQuery(name = "MealPlan.findAll", query = "SELECT g FROM MealPlan g")
public class MealPlan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "meal_id")
	private int mealId;

	@Column(name = "meal_name")
	private String mealName;

	@Column(name = "meal_price")
	private String mealPrice;

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public String getMealPrice() {
		return mealPrice;
	}

	public void setMealPrice(String mealPrice) {
		this.mealPrice = mealPrice;
	}
}
