#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct tree {
    char ad[20];
    char soyad[20];
    long int no;
    struct tree *sol;
    struct tree *sag;
} Tree;

Tree* newNode(long int no, char ad[], char soyad[]) {
    Tree* yeni = (Tree*)malloc(sizeof(Tree));
    yeni->no = no;
    strcpy(yeni->ad, ad);
    strcpy(yeni->soyad, soyad);
    yeni->sag = NULL;
    yeni->sol = NULL;
    return yeni;
}
Tree* minValueNode(Tree* node) {
    Tree* guncel = node;
    while (guncel != NULL && guncel->sol != NULL) {
        guncel = guncel->sol;
    }

    return guncel;
}
Tree* delNode(Tree* root, long int sil) {
    if (root == NULL) {
        return root;
    }

    if (sil < root->no) {
        root->sol = delNode(root->sol, sil);
    } else if (sil > root->no) {
        root->sag = delNode(root->sag, sil);
    } else {
        if (root->sol == NULL) {
            Tree* temp = root->sag;
            free(root);
            return temp;
        } else if (root->sag == NULL) {
            Tree* temp = root->sol;
            free(root);
            return temp;
        }

        Tree* temp = minValueNode(root->sag);
        root->no = temp->no;
        strcpy(root->ad, temp->ad);
        strcpy(root->soyad, temp->soyad);

        root->sag = delNode(root->sag, temp->no);
    }
    return root;
}

Tree* addNode(Tree* node, long int no, char ad[], char soyad[]) {
    if (node == NULL) {
        return newNode(no, ad, soyad);
    } else if (no <= node->no) {
        node->sol = addNode(node->sol, no, ad, soyad);
    } else {
        node->sag = addNode(node->sag, no, ad, soyad);
    }
    return node;
}

void readFromFile(Tree** root) {
    FILE* dosya = fopen("ogrenciler.txt", "r");
    if (dosya == NULL) {
        perror("Dosya acilamadi");
        return;
    }

    long int no;
    char ad[20];
    char soyad[20];

    while (fscanf(dosya, "%ld %s %s", &no, ad, soyad) != EOF) {
        *root = addNode(*root, no, ad, soyad);
    }

    fclose(dosya);
}

void listele(Tree *node) {
    if(node == NULL) {
        return;
    }

    listele(node->sol);
    printf("Ogrenci Adi: %s\n", node->ad);
    printf("Ogrenci Soyadi: %s\n", node->soyad);
    printf("Ogrenci NO: %ld\n", node->no);
    listele(node->sag);
}

void ortbul(Tree *node, int *sayac, long int *toplam) {
    if (node == NULL) {
        return;
    }

    ortbul(node->sol, sayac, toplam);
    *toplam += node->no;
    (*sayac)++;
    ortbul(node->sag, sayac, toplam);
}

int yukseklik(Tree *node) {
    if (node == NULL) {
        return -1;
    } else {
        int soluzun = yukseklik(node->sol);
        int saguzun = yukseklik(node->sag);
        if(soluzun > saguzun) {
            return 1 + soluzun;
        } else {
            return 1 + saguzun;
        }
    }
}

void menu() {
    Tree* root = NULL;
    while (1) {
        int secim;
        printf("Agaca eklemek icin 1\nAgactan silmek icin 2\nListelemek icin 3\nNo ortalamasini bulmak icin 4\nYukseklik bulmak icin 5\nCikis icin 6\n");
        scanf("%d", &secim);

        switch (secim) {
            case 1:
                readFromFile(&root);
                printf("Ogrenciler dosyadan agaca eklendi.\n");
                break;
            case 2:
                {long int silno;
                printf("Silinecek ogrencinin numarasini giriniz: ");
                scanf("%ld", &silno);
                root = delNode(root, silno);
                }
                break;

            case 3:
                listele(root);
                break;
            case 4:
                {
                    int sayac = 0;
                    long int toplam = 0;
                    ortbul(root, &sayac, &toplam);
                    float ort = (float)toplam / sayac;
                    printf("Ogrenci Numaralarinin Ortalamasi: %.2f\n", ort);
                }
                break;
            case 5:
                printf("Agacin Yuksekligi: %d\n", yukseklik(root));
                break;
            case 6:
                exit(0);
                break;
            default:
                printf("Gecersiz secim. Lutfen tekrar deneyin.\n");
        }
    }
}

int main() {
    menu();
    return 0;
}
