#Arabalar dosyasının içinde bilgi varken kod çalıştığında fonksiyonlarda bazen çalışmama durumu oluyor ama arabalar dosyasının içi boşken yeni ekleme yapıp sonra fonksiyonları kullandığımızda bir hata olmuyor düzeltmeye çok çalıştım ama sebebini bulamadım umarum buna dikkat edersiniz hocam
import json
arabalar = dict()
sayac=0
def oku_arabalar():
    global arabalar
    try:
        with open("arabalar.txt", "r") as dosya:
            icerik = dosya.readlines()

        for satir in icerik:
            araba = json.loads(satir)
            numara = araba['NUMARA']
            arabalar[numara] = araba

    except FileNotFoundError:
        print("Dosya bulunamadı")
def menu():
    """Galeri otomasyonu ana menüsü."""

    while True:
      try:
        print("------ GALERİ OTOMASYONU ------")   #MENU GÖSTERİLİYOR
        print("1. Araba Listesi")
        print("2. Araba Ekle")
        print("3. Araba Ara")
        print("4. Araba Güncelle")
        print("5. Araba Sil")
        print("6. Fiyat Guncelle")
        print("7. Marka Adet Bilgisi")
        print("0. Çıkış")

        secim = input("Bir işlem seçin: ")
        print()

        if secim == "1":
            araba_listesi()                          #İF ELİF KULLANARAK KULLANICININ İSTEDİĞİ FONKSİYONA YÖNLENDİRMESİ YAPILIYOR
        elif secim == "2":
            araba_ekle()
        elif secim == "3":
            araba_ara()
        elif secim == "4":
            araba_guncelle()
        elif secim == "5":
            araba_sil()
        elif secim == "6":
            fiyat_guncelle()
        elif secim == "7":
            marka_adet()
        elif secim == "0":
            print("Galeri otomasyonu kapatılıyor...")
            break
        else:
            print("Geçersiz bir seçim yaptınız. Lütfen tekrar deneyin.")
        print()
      except ValueError:
          print("Geçersiz bir değer girdiniz. Tam sayı bekleniyor.")
def araba_listesi():
    global sayac
    try:
        with open("arabalar.txt", "r") as dosya:                #ARABALAR DOSYASININ İÇİNDEKİ BİLGİLERİ DEĞİŞKENE AKTARIYORUZ VE DEĞİŞKENİN İÇİNDEN OKUYARAK YAZDIRIYORUZ
            icerik = dosya.readlines()
            for satir in icerik:
                araba = json.loads(satir)
                if araba:
                    print(araba)
                    print()



    except FileNotFoundError:
        print("Dosya bulunamadı")

    except FileNotFoundError:
        print("Dosya bulunamadı")
def araba_ekle():
    global sayac,arabalar
    try:
       marka=input("Markasını giriniz")                                   #ARABA HAKKINDAKİ BİLGİLER ALINIYOR VE YENİARAC KÜMESİNDE TUTULUYOR
       arabayıl=int(input("Yılını giriniz"))                              #ARDINDAN BU KÜME DE BAŞKA BİR KÜMEYE ATILARAK DOSYAYA EKLENİYOR BURDA SÖZLÜK YAPISI KORUNSUN DİYE JSON KULLANDIM
       araba_renk=input("Rengini giriniz")
       araba_fiyat=int(input("Fiyat giriniz"))
    except ValueError:
      print("Geçersiz bir değer girdiniz. Tam sayı bekleniyor.")

    except TypeError:
      print("Geçersiz bir değer girdiniz. Tam sayı bekleniyor.")
    except NameError:
       print("Geçerli bir değer girilmedi. Marka veya renk bekleniyor.")
    yeni_arac={'NUMARA': sayac,
               'MARKA':marka,
                        'YIL':arabayıl,
                        'RENK':araba_renk,
                        'FIYAT':araba_fiyat}
    arabalar[sayac]=yeni_arac
    sayac += 1
    print("Araç başarıyla eklendi")
    try:
       with open("arabalar.txt","a") as dosya:
           dosya.write(json.dumps(yeni_arac) + "\n")
    except FileNotFoundError:
       print("Dosya bulunamadı")


def araba_ara():
    ter_arama=input("Markaya göre aramak için 1 \n Yıla göre aramak için 2 \n Renge göre aramak için 3 \n Fiyata göre aramak için 4 tuşlayınız...")

    def tercih_bul(ter_arama):
     if ter_arama == "1":
        ist_mar = input("Aramak istediğiniz markayı giriniz")                                #KULLANICIDAN NEYE GÖRE ARAMA YAPMAK İSTEDİĞİ BİLGİSİNİ ALIP ARDINDAN
        for x in range(len(arabalar)):                                                       #BU BİLGİYE GÖRE SÖZLÜĞÜ TARATIR VE BULUNAN ARACIN BİLGİLERİNİ YAZDIRIR
            if arabalar[x]['MARKA'] == ist_mar:
                print(arabalar[x])
     elif ter_arama == "2":
        ist_yıl = int(input("Aramak istediğiniz yılı giriniz"))
        for y in range(len(arabalar)):
            if arabalar[y]['YIL'] == ist_yıl:
                print(arabalar[y])
     elif ter_arama == "3":
        ist_renk = input("Aramak istediğiniz rengi giriniz")
        for z in range(len(arabalar)):
            if arabalar[z]['RENK'] == ist_renk:
                print(arabalar[z])
     elif ter_arama == "4":
        ist_fiyat = int(input("Aramak istediğiniz maksimum fiyatı giriniz"))
        for k in range(len(arabalar)):
            if arabalar[k]['FIYAT'] <= ist_fiyat:
                print(arabalar[k])
    tercih_bul(ter_arama)
def araba_guncelle():
    try:
        gun_say = int(input("Güncellemek istediğiniz arabanın numarasını giriniz: "))
        print("Güncellenmek istenen arabanın bilgileri: {}".format(arabalar[gun_say]))
        print("Marka güncellemek için 1, Yıl güncellemek için 2, Renk güncellemek için 3, Fiyat güncellemek için 4 giriniz.")
        ter_say = input()
    except ValueError:
        print("Geçersiz bir değer girdiniz. Tam sayı bekleniyor.")

    try:
        if ter_say == "1":
            yeni_mar = input("Yeni markayı giriniz: ")
            arabalar[gun_say]['MARKA'] = yeni_mar
        elif ter_say == "2":
            yeni_yil = input("Yeni yılı giriniz: ")
            arabalar[gun_say]['YIL'] = yeni_yil
        elif ter_say == "3":
            yeni_renk = input("Yeni rengi giriniz: ")
            arabalar[gun_say]['RENK'] = yeni_renk
        elif ter_say == "4":
            yeni_fiyat = input("Yeni fiyatı giriniz: ")
            arabalar[gun_say]['FIYAT'] = yeni_fiyat
        else:
            print("Geçersiz bir seçim yaptınız.")
    except KeyError:
        print("Geçersiz bir araba numarası girdiniz.")

    try:
        with open("arabalar.txt", "w") as dosya:
            for numara, araba in arabalar.items():
                dosya.write("Numara: {}\n".format(numara))
                dosya.write("Marka: {}\n".format(araba['MARKA']))
                dosya.write("Yıl: {}\n".format(araba['YIL']))
                dosya.write("Renk: {}\n".format(araba['RENK']))
                dosya.write("Fiyat: {}\n".format(araba['FIYAT']))
                dosya.write("\n")
        print("Araba bilgileri güncellendi ve arabalar.txt dosyasına yazıldı.")
    except FileNotFoundError:
        print("Dosya bulunamadı.")


def araba_sil():
    araba_numarasi = int(input("Silmek istenen arabanın numarasını giriniz "))
    if araba_numarasi in arabalar.keys():#KULLANICIDAN BİLGİYİ ALIP ARACI BULUR VE DEL KOMUTU İLE SİLER
        del arabalar[araba_numarasi]
        print("Araba silindi.")
        with open("arabalar.txt", "w") as dosya:
            for araba in arabalar.values():
                dosya.write(json.dumps(araba) + "\n")

    else:
        print("Girilen numarada bir araba yok")
def fiyat_guncelle():
    global sayac
    zam_oran = int(input("Zam oranı giriniz"))


    guncellenmis_arabalar = []
    for x in range(len(arabalar)):
        gecicifiy = arabalar[x]['FIYAT']
        yenifiyat = gecicifiy + (gecicifiy * zam_oran / 100)
        arabalar[x]['FIYAT'] = yenifiyat
        guncellenmis_arabalar.append(arabalar[x])

    print("Zam oranı tüm araçlara uygulandı")

    with open("arabalar.txt", "w") as dosya:
        for araba in guncellenmis_arabalar:
            dosya.write(json.dumps(araba) + '\n')

def marka_adet():
    global sayac
    marka_listesi=[]#ARABA MARKALARININ ARASINDA DOLAŞIR VE HANGİ MARKADAN NE KADAR OLDUĞUNU LİSTEYE EKLEYEREK KONTROL EDER EĞER VARSA SONUC 1 OLUR YOKSA HER SEFERİNDE 1 ARTARAK GİDER
    marka_adetleri={}

    for x in range(sayac):
        marka = arabalar[x]['MARKA']
        if marka not in marka_listesi:
            marka_listesi.append(marka)
            marka_adetleri[marka] = 1
        else :
            marka_adetleri[marka] += 1
    for k,n in marka_adetleri.items():

        print("{} Marka araçtan {} adet vardır".format(k,n))
menu()
