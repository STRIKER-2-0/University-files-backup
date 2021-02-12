#include <iostream>
#include <clocale>
#include <cstdlib>
#include <ctime>
#include <windows.h>

using namespace std;

void menu(){ //функция для печати списка выбора
    cout << "\n\tВыберите:\n\t1. Показать список.\n\t2. Добавить.\n\t3. Удалить\n\t4. Выход.\n";
}

int prov(int a){//проверка введенных значений
    if((a>20)||(a<0)){
            cout << "\tНеверное значение!\n";
            system("pause");
            return 1;
    }
    return 0;
}

int main(){
    setlocale(LC_CTYPE, "rus");
    srand(time(0));
    //создаём массив данных и заполняем первые 4 ячейки случайными значениями
    int mass[20]; int maj=3;
    for(int i=0; i<20; ++i)
        mass[i]=0;
    for(int i=0; i<=maj; ++i)
            mass[i]=rand()%20 + 1;
    for(int i=0; i<=maj; ++i){
        for(int j=0; j<=maj; ++j)
            if((i!=j)&&(mass[i]==mass[j]))
                mass[j]=rand()%20 + 1;
    }



    int ans,elem,pos; //переменные для ответов, элемента и позиции
    int x,y; //специальные переменные для перемещения в сложных ситуациях массива
    while(1){
        menu(); cin >> ans; //меню
        x=0,y=0;
        switch(ans){
            case 1: cout << "\n\tСписок: \n";   //вывод списка элементов
                    for(int i=0; i<=maj; ++i)
                        cout << "\t" << i+1 << ". " << mass[i] << endl;
                    system("pause");
                    break;
            case 2: for(int i=0; i<20; ++i){ //добавление элемента
                        if(mass[i]!=0)
                        ++y;
                    }
                    if(y==19){ //проверка на заполненность
                        cout << "Все ячейки заняты!\n";
                        system("pause");
                        break;
                    }

                    cout << "\tВведите элемент: "; cin >> elem; if(prov(elem)==1)continue; // введение и проверка элемента
                    for(int i=0; i<20; ++i){
                        if((elem==mass[i])&&elem!=0){
                            cout << "\tТакой элемент уже есть!\n";
                            x=1;
                            system("pause");
                            break;
                        }
                    }
                    if(x==1)continue;
                    cout << "\tВведите позицию: "; cin >> pos; if(prov(pos)==1)continue; // введение и проверка позиции
                    if((pos-1)>maj){ // добавление элемента
                            mass[pos-1]=elem;
                            maj=pos-1;
                    }
                    else if(((pos-1)<maj)&&(maj==19)){ //в случае, если край массива заполнен и некуда смещать
                        for(y=0; mass[y]!=0; y++){}
                        for(int i=y; i>=pos-1; --i)
                            mass[i+1]=mass[i];
                        mass[pos-1]=elem;
                    }
                    else{ //в стандартном случае
                        for(int i=maj; i>=pos-1; --i)
                            mass[i+1]=mass[i];
                        mass[pos-1]=elem;
                        ++maj;
                    }
                    cout << "\tЭлемент добавлен!\n";
                    system("pause");
                    break;
            case 3: cout << "\tВведите номер элемента: \n"; cin >> pos; if(prov(pos)==1)continue; //удаление элементов
                    if(pos==20){
                        mass[19]=0;
                        while(mass[maj]==0)
                            --maj;
                    }
                    else{
                        for(int i=pos-1; i<19; ++i)
                            mass[i]=mass[i+1];
                        mass[19]=0;
                        while(mass[maj]==0)
                            --maj;
                    }
                    cout << "\tЭлемент удалён!\n";
                    system("pause");
                    break;
            case 4: cout << "\tУдачного дня!\n\n"; return 0; //выход из программы
            default: cout << "\tНеверное значение!\n"; system("pause");
        }
    }
}
