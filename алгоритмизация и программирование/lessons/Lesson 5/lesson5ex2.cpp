#include <iostream>
#include <clocale>
#include <stdio.h>
#include <windows.h>

using namespace std;

char word[20];

int main(){
    setlocale(LC_CTYPE, "rus");

    char sentence[35];  //входное предложение
    FILE *file;

    file=fopen("Sentense.txt", "w");    //открытие для записи
    if(file==NULL){ //проверка, овыполнилось ли открытие
        cerr << "Файл не существует!";
        return 1;
    }
    cout << "Введите предложение: ";
    SetConsoleCP(1251); //кодировка консоли для русского текста в файл
    cin.getline(sentence,35);  //пользователь сам введет предложение
    fputs(sentence, file);
    fclose(file);
    SetConsoleCP(866);//возврат кодировки

    cout << "Информация помещена в файл\n"; //пауза для возмоности проверить
    system("pause");

    file=fopen("Sentense.txt", "r");    //открываем на чтение
    if(file==NULL){
        cerr << "Файл не существует!";
        return 1;
    }
    for(int i=0; word[i-1]!=' '; i++) //считывание до пробела
        word[i]=fgetc(file);
    fclose(file);

    file=fopen("Sentense.txt", "a");    //открываем на добавление
    if(file==NULL){
        cerr << "Файл не существует!";
        return 1;
    }
    fputs(" ", file); //помезаем пробел
    fputs(word, file);
    fclose(file);
    cout << "Последнее слово скопировано в конец файла!\n---Завершение программы---" << endl;
    return 0;
}
