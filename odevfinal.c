#include <stdio.h>
#include <stdlib.h>


aracekle()
{
 a *al;
 al=(a *) malloc(sizeof(a));

  printf("Marka Gİriniz");
  scanf("%s", al->ad);



}

void aracsil()
{

}

void aracduzenle()
{

}

void araclist()
{

}

void fiyatsirala()
{

}

void markasirala()
{

}

 typedef struct kayit{
    int yil;
    int fiyat;
    int km;
    char marka[10];
    char renk[10];
    struct durum{
     int degisen;
     int boyali;}
    }a;



};
















int main()
{   typedef struct kayit{
    int yil;
    int fiyat;
    int km;
    char marka[10];
    char renk[10];
    struct durum{
     int degisen;
     int boyali;}
    }a;



    struct kayit a;
    int secim;
    printf("\t Hosgeldiniz\n");
    printf("Arac eklemek icin 1'e basiniz\n");
    printf("Arac silmek icin 2'ye basiniz\n");
    printf("Arac düzenlemek icin 3'e basiniz\n");
    printf("Arac listelemek icin 4'e basiniz\n");
    printf("Fiyata gore siralamak icin 5'e basiniz\n");
    printf("Markaya gore siralamak icin 6'ya basiniz\n");
    printf("<<<<<<<<<KONYA GALERI>>>>>>>>\n");
    scanf("%d",&secim)
    switch(secim)
    {
    case 1:
        aracekle()
        break;
    case 2:
        aracsil()
        break;
    case 3:
        aracduzenle()
        break;
    case 4:
        araclist()
        break;
    case 5:
        fiyatsirala()
        break;
    case 6:
        markasirala()
        break;






    }






















    return 0;
}
