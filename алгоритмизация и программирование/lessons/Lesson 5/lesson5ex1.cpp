#include <iostream>
#include <clocale>
#include <My_library.h>
#include <stdio.h>

using namespace std;


int main(){
    setlocale(LC_CTYPE, "rus");

    char word[10];
    FILE *file;
    file=fopen("WORD.txt", "r");
    if(file==NULL){
        cerr << "���� �� ����������!";
        return 1;
    }
    fgets(word,5,file);
    fclose(file);

    file=fopen("WORD.txt", "a");
    fputs(word,file);
    fclose(file);
    cout << "���������� � ���� ��������� �������!!" << endl;

    return 0;
}
