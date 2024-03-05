package odev1;
//İSMAİL SOYKOK 22100011007
public class LisansOgrencisi extends Ogrenci{
	private int OgrID;
	private int ogrSnf;
	private String Durum;
	public LisansOgrencisi(int bolNo, String ogrAd, String ogrSoyad, int ogrID, int ogrSnf, String durum) {
		super(bolNo, ogrAd, ogrSoyad);
		this.OgrID = ogrID;
		this.ogrSnf = ogrSnf;
		this.Durum = "Lisans";
	}
	
	public String getDurum() {
		return this.Durum;
	}

	public void setDurum(String durum) {
		Durum = durum;
	}

	public int getOgrID() {
		return OgrID;
	}
	public void setOgrID(int ogrID) {
		OgrID = ogrID;
	}
	public int getOgrSnf() {
		return ogrSnf;
	}
	public void setOgrSnf(int ogrSnf) {
		this.ogrSnf = ogrSnf;
	}



}
