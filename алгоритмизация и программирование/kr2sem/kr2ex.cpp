#include <iostream>
#include <stdio.h>
#include <windows.h>


using namespace std;

int main(){
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);
    char s;
    char sentence[50];

    cout << "������� ������: ";
    FILE* file=fopen("filekr.txt","w");
    cin.getline(sentence,50);
    for(int i=0; sentence[i]!='\0'; i++)
        fputc(sentence[i],file);
    fclose(file);
    cout << "������ �������� � ���� filekr.txt" << endl;

    file=fopen("filekr.txt","r");
    FILE* fout=fopen("file_outkr.txt","w");
    while(true){
        s=fgetc(file);
        if(feof(file)!=0)
            break;
        fputc(s,fout);
    }
    cout << "������ �� ����� filekr.txt ����������� � ���� file_outkr.txt. ���������� ���������.";
    fclose(file);
    fclose(fout);

}


