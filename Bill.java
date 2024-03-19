package Shop.model;

import java.util.List;

public class Bill {

	private int billNo;
	private float total;
	private float cgst;
	private float sgst;
	private float finaltotal;
	private List<Product> lstProduct;

	public Bill(int billNo, float total, float cgst, float sgst, float finaltotal) {
		super();
		this.billNo = billNo;
		this.total = total;
		this.cgst = cgst;
		this.sgst = sgst;
		this.finaltotal = finaltotal;
	}
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getCgst() {
		return cgst;
	}
	public void setCgst(float cgst) {
		this.cgst = cgst;
	}
	public float getSgst() {
		return sgst;
	}
	public void setSgst(float sgst) {
		this.sgst = sgst;
	}
	public float getFinaltotal() {
		return finaltotal;
	}
	public void setFinaltotal(float finaltotal) {
		this.finaltotal = finaltotal;
	}
	public void setLstProduct(List<Product> lstProd) {
		// TODO Auto-generated method stub
		
	}
}
