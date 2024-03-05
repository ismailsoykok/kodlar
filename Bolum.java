package odev1;
//İSMAİL SOYKOK 22100011007
public class Bolum {
	private int bolNo;
	private String bolAd;
	public Ogrenci ogrenciler[];
	public Ders Dersler[];
	public Bolum(int bolNo, String bolAd) {
		super();
		this.bolNo = bolNo;
		this.bolAd = bolAd;
	}
	public int getBolNo() {
		return bolNo;
	}
	public void setBolNo(int bolNo) {
		this.bolNo = bolNo;
	}
	public String getBolAd() {
		return bolAd;
	}
	public void setBolAd(String bolAd) {
		this.bolAd = bolAd;
	}



	

}
