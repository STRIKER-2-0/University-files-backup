#include <iostream>
#include <clocale>
#include <stdio.h>
#include <windows.h>
#define N 200   //константа

using namespace std;

char sentence[N];
char maxword[25];
char word[25];


int main(){
    setlocale(LC_CTYPE, "Russian");

    FILE *file; //указатель на файл
    fpos_t pos; //ссылка но текущую позицию в файле
    int numchar=0;  //счетчик символов

    file=fopen("dop_ex3.txt", "r");
    if(file==NULL){
        cerr << "Файл не существует!";
        return 1;
    }

    cout << "Текст, считанный из файла:\n\n";
    fgetpos (file,&pos); //НАДА для первой итерации

    while(feof(file)==0){
        fsetpos (file,&pos);    //проверка позиции только не с начала файла
        numchar=0;
        for(int j=0; (sentence[j-1]!='.')&&(sentence[j-1]!='?')&&(sentence[j-1]!='!')&&(feof(file)==0); j++){   //цикл, идущий по предложениям
            sentence[j]=fgetc(file);        //считывание
            fgetpos (file,&pos);        //установка позиции
            if((sentence[j]!=' ')&&(sentence[j]!='.')&&(sentence[j]!='\n')&&(sentence[j-1]!='?')&&(sentence[j-1]!='!'))
                numchar++;
        }
        if(feof(file)==0)   //исправление бага с кодировкой
            cout << sentence <<" (Количество символов: " << numchar << ")\n";
        else
            break;

        for(int k=0; k<N; k++)    //затирание данных
            sentence[k]='\0';

    }

    fclose(file);
    return 0;
}
