package app.services;

import java.util.HashMap;

import app.controllers.MainController;

public class Payment {

	String buyer_id;
	String provider_id;
	int numberOfHours;
	double amount;
	double total;
	String transaction_uuid;

	public Payment(String pid, double am, int numberOfHours) {
		provider_id = pid;
		amount = am;
		this.numberOfHours = numberOfHours;
		total = this.amount * this.numberOfHours;

		/**
		 * Dependency injection
		 */
		MainController.payment = this;
	}

	public double getTotal() {
		return total;
	}

	public int getNumberOfHours() {
		return numberOfHours;
	}

	public void initPayment() {

	}

	public void setTransaction_uuid(String transaction_uuid) {
		this.transaction_uuid = transaction_uuid;
	}

	public String getBuyer_id() {
		return buyer_id;
	}

	public double getAmount() {
		return amount;
	}

	public String getProvider_id() {
		return provider_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public void reset() {
		buyer_id = null;
		provider_id = null;
		amount = 0.00;
		transaction_uuid = null;
		UGMBCard.clear();

	}

	public void setUGMBCard_infos(String number, String cvv, String exp_date, String zip) {
		UGMBCard.put("number", number);
		UGMBCard.put("cvv", cvv);
		UGMBCard.put("exp_date", exp_date);
		UGMBCard.put("zip", zip);
	}

	public void resetUGMBCard_infos() {
		UGMBCard.clear();
	}

	HashMap<String, String> UGMBCard = new HashMap<String, String>();

}
