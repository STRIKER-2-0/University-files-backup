#include <iostream>
#include <clocale>
#include <stdio.h>
#include <windows.h>
#define N 200   //���������

using namespace std;

char sentence[N];
char maxword[25];
char word[25];


int main(){
    setlocale(LC_CTYPE, "Russian");

    FILE *file; //��������� �� ����
    fpos_t pos; //������ �� ������� ������� � �����
    int numchar=0;  //������� ��������

    file=fopen("dop_ex3.txt", "r");
    if(file==NULL){
        cerr << "���� �� ����������!";
        return 1;
    }

    cout << "�����, ��������� �� �����:\n\n";
    fgetpos (file,&pos); //���� ��� ������ ��������

    while(feof(file)==0){
        fsetpos (file,&pos);    //�������� ������� ������ �� � ������ �����
        numchar=0;
        for(int j=0; (sentence[j-1]!='.')&&(sentence[j-1]!='?')&&(sentence[j-1]!='!')&&(feof(file)==0); j++){   //����, ������ �� ������������
            sentence[j]=fgetc(file);        //����������
            fgetpos (file,&pos);        //��������� �������
            if((sentence[j]!=' ')&&(sentence[j]!='.')&&(sentence[j]!='\n')&&(sentence[j-1]!='?')&&(sentence[j-1]!='!'))
                numchar++;
        }
        if(feof(file)==0)   //����������� ���� � ����������
            cout << sentence <<" (���������� ��������: " << numchar << ")\n";
        else
            break;

        for(int k=0; k<N; k++)    //��������� ������
            sentence[k]='\0';

    }

    fclose(file);
    return 0;
}
