#include <iostream>
#include <clocale>
#include <stdio.h>
#include <windows.h>

using namespace std;

char word[20];

int main(){
    setlocale(LC_CTYPE, "rus");

    char sentence[35];  //������� �����������
    FILE *file;

    file=fopen("Sentense.txt", "w");    //�������� ��� ������
    if(file==NULL){ //��������, ������������ �� ��������
        cerr << "���� �� ����������!";
        return 1;
    }
    cout << "������� �����������: ";
    SetConsoleCP(1251); //��������� ������� ��� �������� ������ � ����
    cin.getline(sentence,35);  //������������ ��� ������ �����������
    fputs(sentence, file);
    fclose(file);
    SetConsoleCP(866);//������� ���������

    cout << "���������� �������� � ����\n"; //����� ��� ���������� ���������
    system("pause");

    file=fopen("Sentense.txt", "r");    //��������� �� ������
    if(file==NULL){
        cerr << "���� �� ����������!";
        return 1;
    }
    for(int i=0; word[i-1]!=' '; i++) //���������� �� �������
        word[i]=fgetc(file);
    fclose(file);

    file=fopen("Sentense.txt", "a");    //��������� �� ����������
    if(file==NULL){
        cerr << "���� �� ����������!";
        return 1;
    }
    fputs(" ", file); //�������� ������
    fputs(word, file);
    fclose(file);
    cout << "��������� ����� ����������� � ����� �����!\n---���������� ���������---" << endl;
    return 0;
}
