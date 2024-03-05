import random#İsmail Soykök 22100011007

while True:
    print("Hosgeldiniz oynamak icin 1 cıkış icin 2\n")
    secim = int(input())
    if secim == 1:
        print("KURALLAR \n Bilinen her ünlü harf 3 puan , Bilinen her ünsüz harf 2 puandır...\n Yanlış tahminlerde 4 puan silinir \n Kelime uzunluğunun yarısı kadar harf tahmin hakkınız vardır hakkınız bittiğinde kelimeyi tahmin etmeniz istenir...")
        bosluk = "_"
        Kelime_listesi = ["system", "data", "algorithm", "such", "base", "node", "model", "case",
    "program", "information", "set", "code", "function", "process", "application", "software",
    "class", "point", "type", "network", "tree", "object", "element", "input", "operation", "level",
    "memory", "table", "order", "file", "variable", "language", "write", "list", "structure",
    "compute", "sequence", "computer", "bit", "probability", "machine", "array", "page", "error",
    "step", "search", "most", "path", "graph", "web", "length", "several", "security", "proof",
    "access", "obtain", "matrix", "task", "image", "form", "return", "interface", "resource",
    "address", "implementation", "loop", "first", "read", "location", "hardware", "behavior",
    "programming", "field", "key", "parameter", "distribution", "definition", "instance",
    "interaction", "internet", "representation", "edge", "stack", "return", "procedure",
    "link", "output", "block", "domain", "store", "call", "device", "server", "static", "dataset",
    "detection", "write", "execute", "least", "key"]
        kelime = random.choice(Kelime_listesi)
        uzunluk = len(kelime)
        print("Kelimeniz \n",uzunluk*bosluk,end="\n")
        unlu_harf = "aeıuiüoö"
        dogru_tah = []
        yanlis_tah = []
        yedek = []
        unlu_harf = "aeıioöuü"
        puan = 0
        for x in range(uzunluk):
            yedek.append("_")
        if uzunluk % 2 == 0:
            hak = uzunluk //2
        else:
            hak = (uzunluk // 2) + 1
        while hak>0:

            tahmin = input("Tahmininizi giriniz\n")
            tahmin.lower()
            for j in range(uzunluk):
               if tahmin==kelime[j]:
                    yedek[j]=tahmin
                    if tahmin in unlu_harf:
                        puan += 3
                    elif tahmin != unlu_harf:
                        puan += 2
               else:
                   continue
            if tahmin not in kelime:
                puan = puan - 4
            hak -= 1
            for y in yedek:

               print(y,sep=":",end=" ")


            print("kalan hak:{} \n ".format(hak,end="\n"))
            print("puanınız: \n ", puan)
        if yedek == kelime:
             print("basardınız")
        else:
            sontah = str(input("Kelime tahmini giriniz\n"))
            if kelime == sontah:
                print("basardiniz")
            else:
                print("olmadı bir dahaki oyuna...")
                break

    elif secim == 2:
        break
