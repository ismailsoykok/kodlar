#include <stdio.h>
#include <stdlib.h>
#define DEVAM printf("Bir Tusa bas ve devam et"); getch()
// İSMAİL SOYKOK NO: 22100011007
struct puan{
    int ders1not;
    int ders2not;
    int ders3not;





}puanlar;
struct ders{
    char ders1[11];
    char ders2[11];
    char ders3[11];
    struct puan puanlar;





}dersnot;
typedef struct kayit //kayit icin struct olusturuyoruz
{
    char ad[11];
    char soyad[21];
    double ortalama;
    unsigned long int ogrencino;
    struct ders dersnot;
    struct kayit *on, *arka;


} KAYIT;


KAYIT *ilk=NULL, *son=NULL;
void ekle(KAYIT *);
int main()
{
    int secim;
    while(1)
    {
        secim=menuden_sec(); //switch fonksiyonu ile islem tercihimizi yapiyoruz
        switch(secim)
        {
        case 1 :
            kayit();
            break;
        case 2 :
            ogrenci_listele();
            break;
        case 3 :
            ogrenci_silme();
            break;
        case 4 :
            ogrenci_arama();
            break;
        case 5 :
            ders_arama();
            break;
        case 6 :
            ortalama_arama();
            break;
        case 7 :
            bilgi_guncelle();
            break;






        }
    }
    return 0;
}


menuden_sec()
{

    int i;
    char *menu[7]= {"[1] OGRENCI EKLEME","[2] OGRENCI LISTELEME","[3] -OGRENCI SILME","[4] OGRENCI ARAMA","[5] DERS ARAMA","[6]ORTALAMA ARAMA","[7] BILGI GUNCELLE"};
    for(i=0; i<7; i++)
    {
        printf("\t%s\n", menu[i]); //menu gosterimi
    }
    printf("SECIMINIZ :");
    scanf("%d",&i);

    return i;




}

kayit()
{
    KAYIT *al;
    char kr;
    do
    {
        al=(KAYIT *) malloc(sizeof(KAYIT)); //kullanicidan alinan bilgileri bellege kaydediyoruz
        if(!al)
        {
            printf("Yer yok ");
            return;
        }
        printf("Sahibinin Adi :");
        scanf("%10s", al->ad);
        printf("Soyadi :");
        scanf("%20s", al->soyad);
        printf("Ogrenci No:");
        scanf("%lu", &al->ogrencino);
        printf("1. Ders Adı:");
        scanf("%10s", al->dersnot.ders1);
        printf("2. Ders Adı");
        scanf("%10s", al->dersnot.ders2);
        printf("3. Ders Adı");
        scanf("%10s", al->dersnot.ders3);
        printf("1. Ders Notu:");
        scanf("%4d", &al->dersnot.puanlar.ders1not);
        printf("2. Ders Notu:");
        scanf("%lu", &al->dersnot.puanlar.ders2not);
        printf("3. Ders Notu:");
        scanf("%d", &al->dersnot.puanlar.ders3not);
        int a = &al->dersnot.puanlar.ders1not;
        int b = &al->dersnot.puanlar.ders2not;
        int c = &al->dersnot.puanlar.ders3not;
        %al->ortalama=(a+b+c)/3;
     ekle(al);
        printf("Baska kayit yapacak misiniz E/H \n");
        kr=getch();
    }
    while(kr=='e');
}

void ekle(KAYIT *p)
{
    if(ilk!=0) //uc uca ekleme islemi ile aldıgımız bilgileri bellege kaydediyoruz
    {
        son->arka=p;
        p->on=son;
        son=p;
        son->arka='\0';


    }

    else
    {

        ilk=p;
        son=p;
        ilk->arka='\0';
        ilk->on='\0';
    }


}


goster(KAYIT *ogrenci)
{

    printf("Sahibinin Adi: %s\n", ogrenci->ad); //goster fonksiyonu ile gerekli yerlerde bilgileri ekrana yansitiyoruz
    printf("Soyadi: %s\n", ogrenci->soyad);
    printf("Ogrenci No %s\n", ogrenci->ogrencino);
    printf("1. Ders Adı: %s\n", ogrenci->dersnot.ders1);
    printf("2. Ders Adı: %s\n", ogrenci->dersnot.ders2);
    printf("3. Ders Adı: %s\n", ogrenci->dersnot.ders3);
    printf("1. Ders Not : %d\n", ogrenci->dersnot.puanlar.ders1not);
    printf("2. Ders Not : %d\n", ogrenci->dersnot.puanlar.ders2not);
    printf("3. Ders not : %d\n", ogrenci->dersnot.puanlar.ders3not);
    printf("Ortalama : %d\n", ogrenci->dersnot.ortalama);


}
ogrenci_listele()
{
    int k;
    KAYIT *p;
    p=ilk;
    while(p)
    {
        goster(p);
        p=p->arka;
        DEVAM;
    }

}
ogrenci_silme()
{
    KAYIT *ogrenci, *varmi();
    char ad[11], soyad[21];
    printf("Silmek istedginiz ogrencinin adi: ");
    scanf("%10s", ad);
    printf("Silmek istedginiz ogrencinin soyadi: ");
    scanf("%20s", soyad);
    ogrenci=varmi(ad, soyad);
    if(!ogrenci)
    {
        printf("Boyle birisi yok\n");
        return;
    }
    else
    {
        if(ilk==ogrenci)
        {
            ilk=ogrenci->arka;
            ilk->on='\0';
        }
        else
        {
            ogrenci->on->arka=ogrenci->arka;
        }
        if(ogrenci!=son)
        {

            ogrenci->arka->on=ogrenci->arka;
        }

        else
        {
            son=ogrenci->on;
        }
    }
    free(ogrenci);

    printf("Silindi");
}

KAYIT *varmi(char isim[],char soyisim[])
{

    KAYIT *p;
    p=ilk;
    while(p)
    {
        if(!strcmp(p->ad, isim)&& !strcmp(p->soyad, soyisim))
            return p;
        p=p->arka;
    }
    return '\0';


}
ogrenci_arama()

{

    char isim[10];
    KAYIT *p;
    p=ilk;
    printf("Hangi isimde ogrencileri gormek istersiniz? ");
    scanf("%9s", isim);
    while(p)
    {

        if(!strcmp(isim, p->ad))
        {
            goster(p);
            DEVAM;
        }
        p=p->arka;
    }


    return menuden_sec();

}
ders_arama(){
char derss[20];
KAYIT *p;
p=ilk;
printf("Hangi derse sahip ogrencileri gormek istersiniz? ");
scanf("%9s", derss );
while(p)
{

    if(!strcmp(derss, p->dersnot.ders1))
    {
        goster(p);
        DEVAM;
    }
    else if(!strcmp(derss, p->dersnot.ders2))
    {
        goster(p);
        DEVAM;
    }
    else if(!strcmp(derss, p->dersnot.ders3))
    {
        goster(p);
        DEVAM;
    }
    p=p->arka;
}
}


ortalama_arama()

{

    double ortalama[10];
    KAYIT *p;
    p=ilk;
    printf("Ortalaması kaç olan oğrencileri gormek istersiniz");
    scanf("%f", &ortalamaa);
    while(p)
    {

        if(ortalama >= p->ortalama))
        {
            goster(p);
            DEVAM;
        }
        p=p->arka;
    }


}
bilgi_guncelle()

{
    int tercih;
    char isim_[10],soy_isim[20];
    KAYIT *p;
    p=ilk;
    printf("Bilgisi degistirilecek arabanin sahibinin adini giriniz : ");
    scanf("%9s", isim_);
     printf("Bilgisi degistirilecek arabanin sahibinin soyadini giriniz : ");
    scanf("%9s", soy_isim);
    while(p)
    {

        if(!strcmp(isim_,p->ad)|| !strcmp(soy_isim,p->soyad))
        {
            printf("Degistirmek Istediginiz Bilgiyi Seciniz \n [1] Arac sahibi \n [2] Arac Rengi \n [3] Arac fiyati \n [4] Degisen Sayisi \n [5] Boyali Sayisi");
            scanf("%d", &tercih);
            switch(tercih){
        case 1 :
            printf("Yeni Sahibin Adi :");
            scanf("%10s", p->ad);
            printf("Yeni Sahibin Soyadi :");
            scanf("%20s", p->soyad);
            break;
        case 2 :
            printf("Yeni Arac Rengi :");
            scanf("%10s", p->renk);
            break;
        case 3 :
            printf("Yeni Fiyatı Giriniz : ");
            scanf("%d", &p->fiyat);
            break;
        case 4 :
            printf("Yeni Degisen Sayisi : ");
            scanf("%d", &p->arac_durum.degisen);
            break;
            case 5 :
            printf("Yeni Boyali Sayisi :");
            scanf("%d", &p->arac_durum.boyali);



            }
            DEVAM;
            return main;

        }

    }


}

