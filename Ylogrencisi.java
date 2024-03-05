package odev1;
//İSMAİL SOYKOK 22100011007
public class Ylogrencisi extends Ogrenci{
	private int OgrID;
	private String Durum;
	public Ylogrencisi(int bolNo, String ogrAd, String ogrSoyad, int ogrID, String durum) {
		super(bolNo, ogrAd, ogrSoyad);
		this.OgrID = ogrID;
		this.Durum = "Yüksek Lisans";
	}
	public int getOgrID() {
		return OgrID;
	}
	public void setOgrID(int ogrID) {
		OgrID = ogrID;
	}
	public String getDurum() {
		return Durum;
	}
	public void setDurum(String durum) {
		Durum = durum;
	}
	


}
