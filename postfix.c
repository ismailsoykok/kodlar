#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
struct postfix{
    char veri[];
    struct postfix *next;





};
struct postfix *top=NULL;
void push(char a){
   struct postfix *yeni = (struct postfix*)malloc(sizeof(struct postfix));
   yeni->veri=a;
   yeni->next=NULL;
   if(top!=NULL){
    yeni->next=top;
    top=yeni;
   }
}
void dosyadanal(){
    FILE *dosya;
    char infix[100];
    dosya = fopen("infix.txt","r");
    fgets(infix,100,dosya);
    fclose(dosya);
    donusum(infix);


}
deðerler(char b){
          switch(char b){
      case '+':
        return 1;
      case '-':
        return 1;
      case '*':
        return 2;
      case '/':
        return 2;

      case '^':
        return 3;
          }
    return -1;




          }
donusum(char a[]){
       int i=0;
    char c;
    while(a[i]!='\0'){
        if(a[i]=='+' || a[i]=='-' || a[i]=='*' || a[i]=='/' || a[i]=='^'){
            while(top!=NULL && deðerler(top->veri)>=deðerler(a[i])){
                printf("%c",pop());
            }
            push(a[i]);
        }
        else if(a[i]=='('){
            push(a[i]);
        }
        else if(a[i]==')'){
            while((c=pop())!='('){
                printf("%c", c);
            }
        }
        else{
            printf("%c",a[i]);
        }
        i++;
    }
    while(top!=NULL){
        printf("%c",pop());
    }
}








}
int main()
{
    dosyadanal();
    return 0;
}
