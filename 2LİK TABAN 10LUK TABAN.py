while 2>1:
     print("HOSGELDİNİZ İSLEM MENUSU \n 1- 2'lik tabanı 10'luk tabana cevirme \n 2- 10'luk tabanı 2'lik tabana çevirme \n 3- Çıkış")
     tercih = int(input("TERCİH İCİN RAKAM GİRİNİZ"))


     if tercih ==1:
          sayac = 0
          total = 0

          sayi = input("Sayiyi giriniz")
          for x in sayi:
               if x !="0" and x !="1":
                sayi = input("1 ve 0 harici sayi bulunamaz tekrar giriniz")
               else:
                  sayi = int(sayi)
                  while sayi > 0:
                    yedek = sayi % 10
                    total = total + yedek * (2 ** sayac)
                    sayac = sayac + 1
                    sayi = sayi / 10

                  print("10luk bicim ", int(total))
                  break






     elif tercih==2:
          ikihal=" "
          sayi2 = int(input("Sayiyi giriniz"))
          while sayi2>0:
               ikihal= str(sayi2 % 2)+ikihal
               sayi2= sayi2 // 2
          print(ikihal)





     elif tercih==3:
          break











