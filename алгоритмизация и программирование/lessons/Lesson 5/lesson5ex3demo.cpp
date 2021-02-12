#include <iostream>
#include <clocale>
#include <string>
#include <stdio.h>
#include <windows.h>
#define N 200           //���������

using namespace std;

char sentence[N];//�����������
string maxword;//����� ������� �����
char word[30];//�����

int counter(FILE* file, string maxword){
    string Word;
    int x=0;//������� ����
    fpos_t pos;

    file=fopen("dop_ex3.txt", "r");
    if(file==NULL){
        cerr << "���� �� ����������!";
        return 1;
    }
    fgetpos (file,&pos);
    while(feof(file)==0){
        fsetpos (file,&pos);
        for(int i=0; (word[i-1]!=' ')&&(word[i-1]!=',')&&(word[i-1]!='.')&&(word[i-1]!='?')&&(word[i-1]!='!')&&(word[i-1]!='\n')&&(feof(file)==0); i++){ //���������� �� �������
            word[i]=fgetc(file);
            fgetpos(file,&pos);
        }
        word[strlen(word)-1]='\0';//������� ������ ������
        Word=word;
        if(Word==maxword)//��� ��� ��������� ���������� �����
            x++;

        for(int k=0; k<30; k++)    //��������� ������
            word[k]='\0';
    }
    fclose(file);
    return x;
}

void Search(FILE *file){
    fpos_t pos;

    file=fopen("dop_ex3.txt", "r");
    if(file==NULL){
        cerr << "���� �� ����������!";
        return;
    }
    fgetpos (file,&pos);
    while(feof(file)==0){
        fsetpos (file,&pos);
        for(int i=0; (word[i-1]!=' ')&&(word[i-1]!=',')&&(word[i-1]!='.')&&(word[i-1]!='?')&&(word[i-1]!='!')&&(word[i-1]!='\n')&&(feof(file)==0); i++){ //���������� �� �������
            word[i]=fgetc(file);
            fgetpos (file,&pos);
        }
        word[strlen(word)-1]='\0';  //������� ������ ������
        if(strlen(word)>maxword.size())
            maxword=word;

        for(int k=0; k<30; k++)    //��������� ������
            word[k]='\0';
    }
    fclose(file);
    cout << endl << "����� ������� ����� � ������: " << maxword << "\n���-�� ����� �� ���� � ������: " << counter(file,maxword);
}



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
        for(int j=0; (sentence[j-1]!='.')&&(sentence[j-1]!='?')&&(sentence[j-1]!='!')&&(feof(file)==0); j++){//����, ������ �� ������������
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
    Search(file);
    return 0;
}
