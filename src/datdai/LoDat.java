package datdai;

import java.io.Serializable;

public class LoDat implements Serializable {
	private int malo;
	private int machulo;
	private String diadiem;
	private double Scay;
	private double Sdat;
	private int status;
	public int getMalo() {
		return malo;
	}
	public void setMalo(int malo) {
		this.malo = malo;
	}
	
	public int getMachulo() {
		return machulo;
	}
	public void setMachulo(int machulo) {
		this.machulo = machulo;
	}
	public String getDiadiem() {
		return diadiem;
	}
	public void setDiadiem(String diadiem) {
		this.diadiem = diadiem;
	}
	public double getScay() {
		return Scay;
	}
	public void setScay(double scay) {
		Scay = scay;
	}
	public double getSdat() {
		return Sdat;
	}
	public void setSdat(double sdat) {
		Sdat = sdat;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public LoDat(int malo, int chulo, String diadiem, double scay, double sdat, int status) {
		super();
		this.malo = malo;
		this.machulo = chulo;
		this.diadiem = diadiem;
		Scay = scay;
		Sdat = sdat;
		this.status = status;
	}
	public LoDat() {}
	@Override
	public String toString() {
		return "LoDat [malo=" + malo + ", machulo=" + machulo + ", diadiem=" + diadiem + ", Scay=" + Scay + ", Sdat="
				+ Sdat + ", status=" + status + "]";
	};
	
}
