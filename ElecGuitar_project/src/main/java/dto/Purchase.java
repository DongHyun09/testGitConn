package dto;

public class Purchase {
	private String ele_num;
	private String model;
	private String pickup;
	private String neck;
	private Integer price;
	private String mad_name;
	private String sell_numb;
	
	public String getEle_num() {
		return ele_num;
	}
	public void setEle_num(String ele_num) {
		this.ele_num = ele_num;
	}
	public String getMad_name() {
		return mad_name;
	}
	public void setMad_name(String mad_name) {
		this.mad_name = mad_name;
	}
	public String getSell_numb() {
		return sell_numb;
	}
	public void setSell_numb(String sell_numb) {
		this.sell_numb = sell_numb;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPickup() {
		return pickup;
	}
	public void setPickup(String pickup) {
		this.pickup = pickup;
	}
	public String getNeck() {
		return neck;
	}
	public void setNeck(String neck) {
		this.neck = neck;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
