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
    char ders1[20];
    long int ders1kod;
    char ders2[20];
    long int ders2kod;
    char ders3[20];
    long int ders3kod;
    struct puan puanlar;





}dersnot;
typedef struct kayit //kayit icin struct olusturuyoruz
{
    char ad[11];
    char soyad[21];
    double ortalama;
    long int ogrencino;
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






        }
    }
    return 0;
}
void okuDosya()
{
    FILE *dosya;
    char ad[11], soyad[21];
    long int ogrencino;
    char ders1[20], ders2[20], ders3[20];
    long int ders1kod, ders2kod, ders3kod;
    int ders1not, ders2not, ders3not;

    dosya = fopen("ogrenciler.txt", "r");
    if (dosya == NULL)
    {
        printf("Dosya açılamadı.");
        exit(1);
    }

    while (fscanf(dosya, "%s %s %ld %ld %s %ld %s %ld %d %d %d",
                  ad, soyad, &ogrencino, &ders1kod, ders1, &ders2kod, ders2, &ders3kod, ders3, &ders1not, &ders2not, &ders3not) != EOF)
    {
        KAYIT *al = (KAYIT *)malloc(sizeof(KAYIT));
        if (!al)
        {
            printf("Yer yok ");
            return;
        }
        strcpy(al->ad, ad);
        strcpy(al->soyad, soyad);
        al->ogrencino = ogrencino;
        al->dersnot.ders1kod = ders1kod;
        strcpy(al->dersnot.ders1, ders1);
        al->dersnot.ders2kod = ders2kod;
        strcpy(al->dersnot.ders2, ders2);
        al->dersnot.ders3kod = ders3kod;
        strcpy(al->dersnot.ders3, ders3);
        al->dersnot.puanlar.ders1not = ders1not;
        al->dersnot.puanlar.ders2not = ders2not;
        al->dersnot.puanlar.ders3not = ders3not;
        int a = al->dersnot.puanlar.ders1not;
        int b = al->dersnot.puanlar.ders2not;
        int c = al->dersnot.puanlar.ders3not;
        al->ortalama = (a + b + c) / 3.0;
        ekle(al);
    }

    fclose(dosya);
}

menuden_sec()
{
    okuDosya();
    int i;
    char *menu[6]= {"[1] OGRENCI EKLEME","[2] OGRENCI LISTELEME","[3] OGRENCI SILME","[4] OGRENCI ARAMA","[5] DERS ARAMA","[6]ORTALAMA ARAMA"};
    for(i=0; i<6; i++)
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
        printf("1. Ders Notu:");
        scanf("%4d", &al->dersnot.puanlar.ders1not);
        printf("1. Ders Kodu:");
        scanf("%ld", al->dersnot.ders1kod);
        printf("2. Ders Adı");
        scanf("%10s", al->dersnot.ders2);
        printf("2. Ders Notu:");
        scanf("%d", &al->dersnot.puanlar.ders2not);
        printf("2. Ders Kodu:");
        scanf("%ld", &al->dersnot.ders2kod);
        printf("3. Ders Adı");
        scanf("%10s", al->dersnot.ders3);
        printf("3. Ders Notu:");
        scanf("%d", &al->dersnot.puanlar.ders3not);
        printf("3. Ders Kodu:");
        scanf("%ld", &al->dersnot.ders3kod);
        int a = al->dersnot.puanlar.ders1not;
        int b = al->dersnot.puanlar.ders2not;
        int c = al->dersnot.puanlar.ders3not;
        al->ortalama = (a+b+c) / 3.0;
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
    printf("Ogrenci No %lu\n", ogrenci->ogrencino);
    printf("1. Ders Adı: %s\n", ogrenci->dersnot.ders1);
    printf("2. Ders Adı: %s\n", ogrenci->dersnot.ders2);
    printf("3. Ders Adı: %s\n", ogrenci->dersnot.ders3);
    printf("1. Ders Not : %d\n", ogrenci->dersnot.puanlar.ders1not);
    printf("2. Ders Not : %d\n", ogrenci->dersnot.puanlar.ders2not);
    printf("3. Ders not : %d\n", ogrenci->dersnot.puanlar.ders3not);
    printf("1. Ders Kodu: %ld\n", ogrenci->dersnot.ders1kod);
    printf("2. Ders Kodu: %ld\n", ogrenci->dersnot.ders2kod);
    printf("3. Ders Kodu: %ld\n", ogrenci->dersnot.ders3kod);
    printf("Ortalama : %lf\n", ogrenci->ortalama);


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
long int derss;
KAYIT *p;
p=ilk;
printf("Hangi derse sahip ogrencileri gormek istersiniz? \t Ders Kodu Giriniz ");
scanf("%ld", derss );
while(p)
{

    if(derss == p->dersnot.ders1kod)
    {
        goster(p);
        DEVAM;
    }
    else if(derss == p->dersnot.ders2kod)
    {
        goster(p);
        DEVAM;
    }
    else if(derss == p->dersnot.ders3kod)
    {
        goster(p);
        DEVAM;
    }
    p=p->arka;
}
}


ortalama_arama()

{

    double ortalamaa;
    KAYIT *p;
    p=ilk;
    printf("Ortalaması kaç olan oğrencileri gormek istersiniz");
    scanf("%lf", &ortalamaa);
    while(p)
    {

        if(ortalamaa >= p->ortalama)
        {
            goster(p);
            DEVAM;
        }
        p=p->arka;
    }


}


