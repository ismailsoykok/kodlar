// İSMAİL SOYKÖK 22100011007
package odev2;

package odev2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AnaSayfa {
static ArrayList<Kursiyer> kursiyerler = new ArrayList<>();
static ArrayList<Kurs> kurslar = new ArrayList<>();
    public static void main(String[] args) {
    	
        
        try (BufferedReader br = new BufferedReader(new FileReader("kursiyerler.txt"))) {
            String line;
            Kursiyer kursiyer = null;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("*")) {
                    String[] kursiyerBilgileri = line.substring(1).split("\\+");
                    int id = Integer.parseInt(kursiyerBilgileri[0]);
                    String adSoyad = kursiyerBilgileri[1];
                    int yas = Integer.parseInt(kursiyerBilgileri[2]);
                    kursiyer = new Kursiyer(id, adSoyad, yas, null);
                    kursiyerler.add(kursiyer);
                } else if (line.startsWith("%")) {
                    if (kursiyer != null) {
                        String[] kursBilgileri = line.substring(1).split("\\+");
                        Kurs kurs = new Kurs(Integer.parseInt(kursBilgileri[0]), kursBilgileri[1]);
                        kursiyer.getAlınankurslar().add(kurs);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader("kurslar.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] kursBilgileri = line.split("\\+");
                Kurs kurs = new Kurs(Integer.parseInt(kursBilgileri[0]), kursBilgileri[1]);
                kurslar.add(kurs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        menu();
    }
    public static void menu() {
    Scanner scanner = new Scanner(System.in);	
     System.out.println("1 – Kurs Ekle\n");
     System.out.println("2 – Kurs Listele\n");
     System.out.println("3 – Kurs Ara\n");
     System.out.println("4 – Kurs Sil\n");
     System.out.println("5 – Kursiyer Ekle\n");
     System.out.println("6 – Kursiyer Ara\n");
     System.out.println("7 – Kursiyer Sil\n");
     System.out.println("8 – Kursiyerleri Listele\n");
     System.out.println("9 – Kursiyerleri Ayrıntılı Listele\n");
     System.out.println("10 – Kursiyerin Ödeyeceği Tutarı Hesapla\n");
     System.out.println("11 – Çıkış\n");
     int secim;
     do {
         
         secim = scanner.nextInt();
         

         switch (secim) {
             case 1:
                 kursEkle();
                 break;
             case 2:
                 // Kurs Listele
                 kursListele();
                 break;
             case 3:
            	 kursAra();
             case 4:
            	 kursSil();
             case 5:
            	 kursiyerEkle();
             case 6:
            	 kursiyerAra();
             case 7:
            	 kursiyerSil();
             case 8:
            	 kursiyerListele();
             case 9:
            	 kursiyerAyrıntılıList();
             case  10:
            	 System.out.println("Kursiyer ID'si giriniz:");
            	    int kursiyerId = scanner.nextInt();
            	    KursiyerinOdeyecegiTutarHesapla(kursiyerId);
            	    break;
            	 
             case 11:
                 // Çıkış
                 System.out.println("Programdan çıkılıyor...");
                 break;
             default:
                 System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                 break;
         }
     } while (secim != 11);
     
    	
    }
   
	public static void kursEkle() {
    	Scanner a = new Scanner(System.in);
    	System.out.println("Kurs ID Giriniz");
    	int ID = a.nextInt();
    	if(kurslar.contains(ID)) {
    		System.out.println("Bu ID'ye sahip bir kurs var..");
    		ID = (Integer) null;
        	System.out.println("Kurs ID Giriniz");
        	int ID2 = a.nextInt();
        	System.out.println("Kurs Adı Giriniz");
        	String ad2 = a.next();
        	Kurs kurs = new Kurs(ID2,ad2);
        	kurslar.add(kurs);
    		
    		
    	}
    	
    	System.out.println("Kurs Adı Giriniz");
    	String ad = a.next();
    	Kurs kurs = new Kurs(ID,ad);
    	kurslar.add(kurs);
    	
    	
    }
    public static void kursListele() {
    	 if (kurslar.isEmpty()) {
    	        System.out.println("Listelenecek kurs bulunmamaktadır.");
    	    } else {
    	        System.out.println("Kurs Listesi:");
    	        for (Kurs kurs : kurslar) {
    	            System.out.println("Kurs ID: " + kurs.getKursID() + ", Kurs Adı: " + kurs.getKursAd());
    	        }
    	    }

    	
    }
    public static void kursAra() {
   	 if (kurslar.isEmpty()) {
   	        System.out.println("Aranacak kurs bulunmamaktadır.");
   	    }
   	 else {
   	        System.out.println("Aranacak Kurs Adı Giriniz");
   	        Scanner b = new Scanner(System.in);
   	        String Ad = b.next();
   	        boolean kontrol = false;
   	        for (Kurs kurs : kurslar) {
   	            if(kurs.getKursAd().equalsIgnoreCase(Ad)) {
   	            	System.out.println("Kurs ID: " + kurs.getKursID() + ", Kurs Adı: " + kurs.getKursAd());
   	            	kontrol = true;
   	            }
   	            
   	        }
   	        if(kontrol==false) {
   	        	System.out.println("Kurs Bulunamadı..");
   	        }
   	    }

   	
   }
    public static void kursSil() {
      	 if (kurslar.isEmpty()) {
      	        System.out.println("Silinecek kurs bulunmamaktadır.");
      	    }
      	 else {
      	        System.out.println("Silinecek Kurs Adı Giriniz");
      	        Scanner b = new Scanner(System.in);
      	        String Ad = b.next();
      	        boolean kursiyervarmı = false;
      	        for (Kursiyer kursiyer : kursiyerler) {
      	        	for(Kurs alınan : kursiyer.getAlınankurslar()) {
      	        		if(alınan.getKursAd().equalsIgnoreCase(Ad)) {
      	        			kursiyervarmı = true;
      	        		}
      	        	}
      	        }
      	        if(kursiyervarmı) {
      	        	System.out.println("Kursu alan kursiyer olduğu için silinemez..");
      	        }
      	        else {
      	        	for(Kurs kurs : kurslar) {
      	        		if(kurs.getKursAd().equalsIgnoreCase(Ad)){
      	        			kurslar.remove(kurs);
      	        		}
      	        	}
      	        }
      	  
      	    }

      	
      }
    public static void kursiyerEkle() {

            Scanner scanner = new Scanner(System.in);
            int id;
            String adSoyad;
            int yas;

            try {
                System.out.println("Kursiyer ID Giriniz:");
                id = scanner.nextInt();
                boolean varmi = false;
                for (Kursiyer kursiyer : kursiyerler) {
                if (kursiyer.getKursiyerId() == id) {
                    varmi = true;
                }
            }
               if(varmi) {
                    System.out.println("Bu ID'ye sahip bir kursiyer zaten var. Lütfen farklı bir ID giriniz.");
                    return;
               }
               else {
            	        System.out.println("Ad Soyad Giriniz:");
                scanner.nextLine(); 
                adSoyad = scanner.nextLine();

                System.out.println("Yaş Giriniz:");
                yas = scanner.nextInt();
                
                System.out.println("Alınacak Kurs Sayısı Giriniz");
               ArrayList<Kurs> alınankurslar = new ArrayList<>();
                int kurssay = scanner.nextInt();
                for(int i = 0;i<kurssay;i++) {
                	
                	int kursID = 0;
                	boolean kursvarmi = false;
                	System.out.println("Kurs Adı Giriniz");
                	String kursad = scanner.next();
                	for(Kurs kurs : kurslar) {
                		if(kurs.getKursAd().equalsIgnoreCase(kursad)){
                			kursID = kurs.getKursID();
                			kursvarmi = true;
                		}
                		
                		
                	}
                	if (kursvarmi) {
                		Kurs kurs = new Kurs(kursID, kursad);
                		alınankurslar.add(kurs);
                		
                	}
                	else {
                		System.out.println("Girilen Kurs Bulunamadı Lütfen ID'sini de Giriniz..");
                		kursID = scanner.nextInt();
                  		Kurs kurs = new Kurs(kursID, kursad);
                		alınankurslar.add(kurs);
                	}
                	
                	
                }
                Kursiyer yeniKursiyer = new Kursiyer(id, adSoyad, yas, alınankurslar);
                kursiyerler.add(yeniKursiyer);
                

           
                System.out.println("Kursiyer başarıyla eklendi.");
               }

           

            } catch (InputMismatchException e) {
                System.out.println("Hatalı giriş! ID ve yaş alanları için sayısal değerler girilmelidir.");
            }
        }
public static void kursiyerSil() {
	System.out.println("Silinecek Kursiyer ID'si giriniz");
	Scanner scanner = new Scanner(System.in);
	int ID = scanner.nextInt();
	boolean kursiyersilindi = false;
	for(Kursiyer kursiyer : kursiyerler) {
		if(ID==kursiyer.getKursiyerId()) {
			kursiyerler.remove(kursiyer);
			kursiyersilindi = true;
		}
		
	}
	if(!kursiyersilindi) {
		System.out.println("Girilen ID'ye ait bir kursiyer bulunamadığı için silinemedi..");
	}
}
public static void kursiyerAra() {
	System.out.println("Aranacak Kursiyerin Ad Soyad'ını giriniz..");
	Scanner a = new Scanner(System.in);
	String ad = a.nextLine();
	boolean kontrol = false;
	for(Kursiyer kursiyer : kursiyerler) {
		if(kursiyer.getKursiyerAdSoyad().equalsIgnoreCase(ad)) {
			System.out.println(kursiyer.getKursiyerId()+kursiyer.getKursiyerAdSoyad()+kursiyer.getKursiyerYas()+"\n");
			kontrol = true;
		}
	}
	if(!kontrol) {
		System.out.println("Aranan isimde bir üye bulunamadı");
	}
	
}
public static void kursiyerListele() {
	for(Kursiyer kursiyer : kursiyerler) {
		System.out.println(kursiyer.getKursiyerId()+kursiyer.getKursiyerAdSoyad()+kursiyer.getKursiyerYas()+"\n");
		
	}
}
public static void kursiyerAyrıntılıList() {
	for(Kursiyer kursiyer : kursiyerler) {
		System.out.println(kursiyer.getKursiyerId()+kursiyer.getKursiyerAdSoyad()+kursiyer.getKursiyerYas()+"\n"+kursiyer.getAlınankurslar());
		
	}
}
 public static void KursiyerinOdeyecegiTutarHesapla(int kursiyerId) {
	 Kursiyer kursiyer = null;

     
     for (Kursiyer kursiyergecici : kursiyerler) {
         if (kursiyergecici.getKursiyerId() == kursiyerId) {
             kursiyer = kursiyergecici;
             break;
         }
     }

     
     if (kursiyer == null) {
         System.out.println("Belirtilen ID'ye sahip kursiyer bulunamadı.");
         return;
     }

  kursiyer.borchesapla();
     
 }
 public static void cikis() {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("kursiyerler.txt"))) {
	        for (Kursiyer kursiyer : kursiyerler) {
	            
	            writer.write("*" + kursiyer.getKursiyerId() + "+" + kursiyer.getKursiyerAdSoyad() + "+" + kursiyer.getKursiyerYas());
	            writer.newLine();

	           
	            for (Kurs alinanKurs : kursiyer.getAlınankurslar()) {
	                writer.write("%" + alinanKurs.getKursID() + "+" + alinanKurs.getKursAd());
	                writer.newLine();
	            }
	        }
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    try (BufferedWriter writerr = new BufferedWriter(new FileWriter("kurs.txt"))){
	    	for(Kurs kurs : kurslar) {
	    		writerr.write(kurs.getKursID()+kurs.getKursAd());
	    		writerr.newLine();
	    		
	    	}
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
 
 
 
 
 
	}       
        
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

        
package odev2;

public interface hesaplama {
    // Abstract method
    abstract void borchesapla();
}

       
        
        
        
        
        
        
        
        
        
    
