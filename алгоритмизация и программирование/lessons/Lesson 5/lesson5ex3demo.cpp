#include <iostream>
#include <clocale>
#include <string>
#include <stdio.h>
#include <windows.h>
#define N 200           //константа

using namespace std;

char sentence[N];//предложение
string maxword;//самое длинное слово
char word[30];//слово

int counter(FILE* file, string maxword){
    string Word;
    int x=0;//счетчик слов
    fpos_t pos;

    file=fopen("dop_ex3.txt", "r");
    if(file==NULL){
        cerr << "Файл не существует!";
        return 1;
    }
    fgetpos (file,&pos);
    while(feof(file)==0){
        fsetpos (file,&pos);
        for(int i=0; (word[i-1]!=' ')&&(word[i-1]!=',')&&(word[i-1]!='.')&&(word[i-1]!='?')&&(word[i-1]!='!')&&(word[i-1]!='\n')&&(feof(file)==0); i++){ //считывание до пробела
            word[i]=fgetc(file);
            fgetpos(file,&pos);
        }
        word[strlen(word)-1]='\0';//убираем лишний символ
        Word=word;
        if(Word==maxword)//вот тут находятся одинаковые слова
            x++;

        for(int k=0; k<30; k++)    //затирание данных
            word[k]='\0';
    }
    fclose(file);
    return x;
}

void Search(FILE *file){
    fpos_t pos;

    file=fopen("dop_ex3.txt", "r");
    if(file==NULL){
        cerr << "Файл не существует!";
        return;
    }
    fgetpos (file,&pos);
    while(feof(file)==0){
        fsetpos (file,&pos);
        for(int i=0; (word[i-1]!=' ')&&(word[i-1]!=',')&&(word[i-1]!='.')&&(word[i-1]!='?')&&(word[i-1]!='!')&&(word[i-1]!='\n')&&(feof(file)==0); i++){ //считывание до пробела
            word[i]=fgetc(file);
            fgetpos (file,&pos);
        }
        word[strlen(word)-1]='\0';  //убираем лишний символ
        if(strlen(word)>maxword.size())
            maxword=word;

        for(int k=0; k<30; k++)    //затирание данных
            word[k]='\0';
    }
    fclose(file);
    cout << endl << "Самое длинное слово в тексте: " << maxword << "\nКол-во таких же слов в тексте: " << counter(file,maxword);
}



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
        for(int j=0; (sentence[j-1]!='.')&&(sentence[j-1]!='?')&&(sentence[j-1]!='!')&&(feof(file)==0); j++){//цикл, идущий по предложениям
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
    Search(file);
    return 0;
}
