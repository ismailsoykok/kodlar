import java.util.Scanner;
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
public class Ogrenci {
	private int bolNo;
	private String ogrAd;
	private String ogrSoyad;
	public int getBolNo() {
		return bolNo;
	}
	
	public void setBolNo(int bolNo) {
		this.bolNo = bolNo;
	}
	public String getOgrAd() {
		return ogrAd;
	}
	public void setOgrAd(String ogrAd) {
		this.ogrAd = ogrAd;
	}
	public String getOgrSoyad() {
		return ogrSoyad;
	}
	public void setOgrSoyad(String ogrSoyad) {
		this.ogrSoyad = ogrSoyad;
	}

	public Ogrenci(int bolNo, String ogrAd, String ogrSoyad) {
		super();
		this.bolNo = bolNo;
		this.ogrAd = ogrAd;
		this.ogrSoyad = ogrSoyad;
	}


}
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
public class AnaSayfa {
	private static int ogrenciIDCounter = 1;
	private static int dersID = 1;
    public static int bolsay;
    public static int lissay;
    public static int yklissay;
    public static int derssay;
    public static Bolum bolumler[];
 
    
    public static void BolumListele() {
    	for(int i=0;i<bolsay;i++) {
    		System.out.println("Bolum NO: "+bolumler[i].getBolNo()+"  Bolum AD: "+ bolumler[i].getBolAd());
    		System.out.println("Lisans Ogrencileri: \n");
    		for(int j=0;j<lissay;j++) {
    			if (bolumler[i].ogrenciler[j] instanceof LisansOgrencisi) {
                    LisansOgrencisi lisansOgrencisi2 = (LisansOgrencisi) bolumler[i].ogrenciler[j]; 
                   System.out.println("ID: " +lisansOgrencisi2.getOgrID()+"  Ad: "+ lisansOgrencisi2.getOgrAd()+"  Soyad: "+lisansOgrencisi2.getOgrSoyad()+"\n");
                    
                    
    			}
    			
    		}
    		System.out.println("Yuksek Lisans Ogrencileri : \n");
    		for(int a=0;a<yklissay+lissay;a++) {
    			if (a < bolumler[i].ogrenciler.length && bolumler[i].ogrenciler[a] instanceof Ylogrencisi) {
                    Ylogrencisi yukseklisansogr2 = (Ylogrencisi) bolumler[i].ogrenciler[a];
                   
                    	System.out.println("  ID: "+yukseklisansogr2.getOgrID()+"  Ad: "+yukseklisansogr2.getOgrAd()+ "  Soyad: "+yukseklisansogr2.getOgrSoyad()+"\n");
                    
                    
    			}
    			
    		}
    		System.out.println("Dersler: \n");
    		for(int x=0;x<derssay;x++) {
    			if (x < bolumler[i].Dersler.length) {
    				System.out.println(bolumler[i].Dersler[x].getDersId() + " Ders Ad: " + bolumler[i].Dersler[x].getDersAD()+"Kredi: " +bolumler[i].Dersler[x].getDersKredi()+"\n");
    			}
    			
    			
    		}

    		
    		
    	}
    	
    	
    } 
    

    public static void LisansOgrLis() {
        for (int sinif = 1; sinif <= 4; sinif++) {
            System.out.println(sinif + " Sınıf Öğrenciler:");
            for (int j = 0; j < bolsay; j++) {
                for (int i = 0; i < lissay; i++) {
                    if (bolumler[j].ogrenciler[i] instanceof LisansOgrencisi) {
                        LisansOgrencisi lisansOgrencisi1 = (LisansOgrencisi) bolumler[j].ogrenciler[i];
                        int sinifNo = lisansOgrencisi1.getOgrSnf();
                        if (sinifNo == sinif) {
                            System.out.println("ID: " + lisansOgrencisi1.getOgrID() + "  Ad: " + lisansOgrencisi1.getOgrAd() + "  Soyad: " + lisansOgrencisi1.getOgrSoyad());
                        }
                    }
                }
            }
        }
    }
    public static void YlOgrLis() {
        System.out.println("Yuksek Lisans Ogrencileri: \n");
        for (int i = 0; i < bolsay; i++) {
            System.out.println("Bolum Ad: " + bolumler[i].getBolAd());
            for (int j = 0; j < lissay + yklissay; j++) {
                if (j < bolumler[i].ogrenciler.length && bolumler[i].ogrenciler[j] instanceof Ylogrencisi) {
                    Ylogrencisi yukseklisansogr2 = (Ylogrencisi) bolumler[i].ogrenciler[j];
                    System.out.println("  ID: " + yukseklisansogr2.getOgrID() + "  Ad: " + yukseklisansogr2.getOgrAd() + "  Soyad: " + yukseklisansogr2.getOgrSoyad());
                }
            }
            System.out.println(); 
        }
    }

    	


    public static void DersListele() {
          
            int maxkrd = 0; 
            for (int i = 0; i < bolsay; i++) {
            int derssayydk2 = bolumler[i].Dersler.length;
            for (int j = 0; j < derssayydk2; j++) {
                int krd = bolumler[i].Dersler[j].getDersKredi();
                if (krd > maxkrd) {
                    maxkrd = krd;
                }
            }
        }

           for (int kr = 1; kr <= maxkrd; kr++) {
            	
            	   boolean krGirildi = false;  
            	   for(int i=0;i<bolsay;i++){
            	    int derssayydk = bolumler[i].Dersler.length;
                

                for (int k = 0; k < derssayydk; k++) {
                    if (kr == bolumler[i].Dersler[k].getDersKredi()) {
                        if (!krGirildi) {
                            System.out.println(kr + " Kredisi Olan Dersler");
                            krGirildi = true;
                        }
                        System.out.println("Ders ID: " + bolumler[i].Dersler[k].getDersId() + " Ders Ad: " + bolumler[i].Dersler[k].getDersAD());
                    }
                }
            }
            	
            }
        
        }
    


    public static void AramaYap() {
        System.out.println("Aranacak Kelimeyi Giriniz");
        Scanner scn = new Scanner(System.in);
        String kelime = scn.next();
        boolean ogrencibulundu = false;
        boolean dersbulundu = false;

        for (int i = 0; i < bolsay; i++) {
            for (int j = 0; j < lissay + yklissay; j++) {
                if (j<bolumler[i].ogrenciler.length && bolumler[i].ogrenciler[j] instanceof LisansOgrencisi) {
                    LisansOgrencisi ogrenci1 = (LisansOgrencisi) bolumler[i].ogrenciler[j]; 
                    if (ogrenci1.getOgrAd().equalsIgnoreCase(kelime) || ogrenci1.getOgrSoyad().equalsIgnoreCase(kelime) || ogrenci1.getDurum().equalsIgnoreCase(kelime)) {
                        System.out.println("Bulunan Öğrenci :"+bolumler[i].getBolAd() + " " + ogrenci1.getDurum() + " " + "Sınıf : "+ogrenci1.getOgrSnf() + " " + ogrenci1.getOgrAd() + " " + ogrenci1.getOgrSoyad());
                        ogrencibulundu = true;
                        break;
                    }
                } else if (j<bolumler[i].ogrenciler.length && bolumler[i].ogrenciler[j] instanceof Ylogrencisi) {
                    Ylogrencisi ogrenci2 = (Ylogrencisi) bolumler[i].ogrenciler[j];
                    if (ogrenci2.getOgrAd().equalsIgnoreCase(kelime) || ogrenci2.getOgrSoyad().equalsIgnoreCase(kelime) || ogrenci2.getDurum().equalsIgnoreCase(kelime)) {
                        System.out.println("Bulunan Öğrenci :"+bolumler[i].getBolAd() + "   " + ogrenci2.getDurum() +"   " + ogrenci2.getOgrAd() + "   " + ogrenci2.getOgrSoyad());
                        ogrencibulundu = true;
                        break; 
                    }
                }
            }
        }

            if (ogrencibulundu) {
                return;
            } 
            else {
                System.out.println("Ogrenci Bulunamadı");
                for (int i = 0; i < bolsay; i++) {
                	  for (int x = 0; x < derssay; x++) {
                    if (x<bolumler[i].Dersler.length && bolumler[i].Dersler[x].getDersAD().equalsIgnoreCase(kelime)) {
                        System.out.println("Bulunan Ders:"+bolumler[i].Dersler[x].getDersId() + " " + bolumler[i].Dersler[x].getDersAD() + " Kredi:" + bolumler[i].Dersler[x].getDersKredi());
                    dersbulundu = true;
                    }
                }

                }
              
            }
            if(!dersbulundu) {
                	System.out.println("Ders Bulunamadı");
                }
              
        }               
        
                	

  
	public static void main(String[] args) {
		
		System.out.println("Girilecek Bölüm Sayısı: ");
		Scanner a = new Scanner(System.in);
		bolsay=a.nextInt();
		bolumler = new Bolum[bolsay];
		
		
		
		
		for(int i=0;i<bolsay;i++) {
			System.out.println("Bölüm Adı Giriniz");
			String ad = a.next();
			System.out.println("Bölüm No Giriniz");
			int bolno = a.nextInt();
			bolumler[i]= new Bolum(bolno,ad);
			
			
			
			System.out.println("Girilecek Lisans Öğrencisi Sayısı :");
			int lissay2 = a.nextInt();
			lissay += lissay2;
			
			
			
			System.out.println("Girilecek Yüksek Lisans Öğrencisi Sayısı :");
			int yklissay2 = a.nextInt();
			yklissay += yklissay2;
			int toplamOgrenciSayisi = lissay2 + yklissay2; 

			bolumler[i].ogrenciler = new Ogrenci[toplamOgrenciSayisi]; 

			
			for (int i1 = 0; i1 < lissay2; i1++) {
			    System.out.println("Lisans Ogrencisi Adı Giriniz :");
			    String ad1 = a.next();
			    System.out.println("Lisans Ogrencisi Soyadı Giriniz :");
			    String soyad1 = a.next();
			    System.out.println("Lisans Ogrencisi Sınıfı Giriniz :");
			    int sınıf1 = a.nextInt();
			    bolumler[i].ogrenciler[i1] = new LisansOgrencisi(bolno, ad1, soyad1, ogrenciIDCounter++, sınıf1, null);
			}


			for (int i2 = lissay2; i2 < toplamOgrenciSayisi; i2++) {
			    System.out.println("Yuksek Lisans Ogrencisi Adı Giriniz :");
			    String ad2 = a.next();
			    System.out.println("Yuksek Lisans Ogrencisi Soyadı Giriniz :");
			    String soyad2 = a.next();
			    bolumler[i].ogrenciler[i2] = new Ylogrencisi(bolno, ad2, soyad2, ogrenciIDCounter++, null);
			}

			
			
			
			System.out.println("Açılan Ders Sayısı :");
			int derssay2 = a.nextInt();
			derssay += derssay2;
			bolumler[i].Dersler = new Ders[derssay2];
			
			
			for(int i3 = 0; i3<derssay2; i3++) {
				System.out.println("Ders Adı Giriniz :");
				String dersad = a.next();
				System.out.println("Ders Kredisi Giriniz :");
				int derskr = a.nextInt();
				bolumler[i].Dersler[i3] = new Ders(bolno,dersID++,dersad,derskr);
			}
			
			
				
			

			
				
				
				
			}	
			
			while(true) {
			System.out.println("\n Tüm Bölümlerin Bilgilerini Listelemek için 1'e basınız \n Lisans Öğrencilerini Listelemek için 2 \n Yüksek Lisans Öğrencilerini Listelemek için 3 \n Dersleri Listelemek için 4 \n Arama Yapmak için 5 \n Çıkış için 6");
			Scanner b = new Scanner(System.in);
			int tercih = b.nextInt();
			switch(tercih) {
			case 1:
				BolumListele();
				break;
			case 2:
				LisansOgrLis();
				break;
			case 3:
				YlOgrLis();
				break;
			case 4:
				DersListele();
				break;
			case 5:
				AramaYap();
				break;
			case 6:
				return;
			}
				

	}
		
					
			
			
			
			
			
			
			
			
			
		}

}



