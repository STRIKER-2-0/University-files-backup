#include <iostream>
#include <stdio.h>
#include <windows.h>


using namespace std;

int main(){
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);
    char s;
    char sentence[50];

    cout << "Введите данные: ";
    FILE* file=fopen("filekr.txt","w");
    cin.getline(sentence,50);
    for(int i=0; sentence[i]!='\0'; i++)
        fputc(sentence[i],file);
    fclose(file);
    cout << "Данные помещены в файл filekr.txt" << endl;

    file=fopen("filekr.txt","r");
    FILE* fout=fopen("file_outkr.txt","w");
    while(true){
        s=fgetc(file);
        if(feof(file)!=0)
            break;
        fputc(s,fout);
    }
    cout << "Данные из файла filekr.txt скопированы в файл file_outkr.txt. Завершение программы.";
    fclose(file);
    fclose(fout);

}


