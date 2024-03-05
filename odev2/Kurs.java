//İSMAİL SOYKÖK 22100011007
package odev2;

public class Kurs {
	
	private int KursID;
	private String KursAd;
	public Kurs(int kursID, String kursAd) {
		super();
		KursID = kursID;
		KursAd = kursAd;
	}
	public int getKursID() {
		return KursID;
	}
	public void setKursID(int kursID) {
		KursID = kursID;
	}
	public String getKursAd() {
		return KursAd;
	}
	public void setKursAd(String kursAd) {
		KursAd = kursAd;
	}
	

}
