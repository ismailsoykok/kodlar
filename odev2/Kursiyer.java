// İSMAİL SOYKÖK 22100011007
package odev2;

import java.util.ArrayList;

class Kursiyer implements hesaplama {
    private int KursiyerId;
    private String KursiyerAdSoyad;
    private int KursiyerYas;
    private ArrayList<Kurs> alınankurslar = new ArrayList<>();

    public Kursiyer(int kursiyerId, String kursiyerAdSoyad, int kursiyerYas, ArrayList<Kurs> alınankurslar) {
		super();
		KursiyerId = kursiyerId;
		KursiyerAdSoyad = kursiyerAdSoyad;
		KursiyerYas = kursiyerYas;
		this.alınankurslar = alınankurslar;
	}

    public int getKursiyerId() {
        return KursiyerId;
    }

    public void setKursiyerId(int kursiyerId) {
        KursiyerId = kursiyerId;
    }

    public String getKursiyerAdSoyad() {
        return KursiyerAdSoyad;
    }

    public void setKursiyerAdSoyad(String kursiyerAdSoyad) {
        KursiyerAdSoyad = kursiyerAdSoyad;
    }

    public int getKursiyerYas() {
        return KursiyerYas;
    }

    public void setKursiyerYas(int kursiyerYas) {
        KursiyerYas = kursiyerYas;
    }

    public ArrayList<Kurs> getAlınankurslar() {
        return alınankurslar;
    }

    public void setAlınankurslar(Kurs kurs) {
        this.alınankurslar.add(kurs);
    }

	@Override
	public void borchesapla() {
        int toplamUcret = 0;

        for (Kurs kurs : alınankurslar) {
            toplamUcret += 500; 
        }

        
        if (alınankurslar.size() == 2) {
            toplamUcret = (int) (toplamUcret - (toplamUcret * 0.20));
            System.out.println("Kampanya 1: 2 kurs alanlara %20 indirim uygulandı.");
        }

       
        else if (alınankurslar.size() == 3) {
            toplamUcret = (int) (toplamUcret - (500 * 0.25)); 
            System.out.println("Kampanya 2: 3 kurs alanlara 3. kurs %25 indirim uygulandı.");
        }

     
        else if (alınankurslar.size() > 3) {
            toplamUcret = (int) (toplamUcret - (toplamUcret * 0.10));
            System.out.println("Kampanya 3: 3 kurs üstü alanlara her kurs %10 indirim uygulandı.");
        }

        System.out.println("Kursiyerin aylık ödeyeceği toplam ücret: " + toplamUcret);
    }
		
		
	}
