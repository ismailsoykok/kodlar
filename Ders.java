package odev1;
// İSMAİL SOYKOK 22100011007
public class Ders {
	private int bolno;
	private int DersId;
	private String DersAD;
	private int DersKredi;

	public Ders(int bolno, int dersId, String dersAD, int dersKredi) {
		super();
		this.bolno = bolno;
		this.DersId = dersId;
		this.DersAD = dersAD;
		this.DersKredi = dersKredi;
	}
	public int getBolno() {
		return bolno;
	}
	public void setBolno(int bolno) {
		this.bolno = bolno;
	}
	public int getDersId() {
		return DersId;
	}
	public void setDersId(int dersId) {
		DersId = dersId;
	}
	public String getDersAD() {
		return DersAD;
	}
	public void setDersAD(String dersAD) {
		DersAD = dersAD;
	}
	public int getDersKredi() {
		return DersKredi;
	}
	public void setDersKredi(int dersKredi) {
		DersKredi = dersKredi;
	}
	
	

}
