#include <iostream>
#include <My_library.h> //личная библиотека. Используется функция cin_valid(), для проверки типа вводимых данных
#include <string>
#include <windows.h>

using namespace std;

union T{    //обьединение для книг/журналов
    char author[30];
    struct{
        char issue[30];
        int states;
    }magazine;
};
struct library{ //структура ячейки хранения
    string name;
    int year;
    int pages;
    bool flag;//флаг для контроля типа информации
    T type;
};

int N=0;
library* List;
int books=0,magazines=0; //счетчики для книг и жураналов

void add();
void print(bool);
void num_st();

int main(){
    SetConsoleCP(1251);     //украинский
    SetConsoleOutputCP(1251);

    int ans;
    cout << "Добрий день!!" << endl;
    for(;;){
        cout << "\n1.Додати новый елемент\n2.Вивести дані по всім книжкам\n3.Вивести дані по всім журналам\n4.Підрахувати кількість статей у всіх журналах\n5.Вихід\n";
        ans=cin_valid();
        switch(ans){
            case 1: add(); break;
            case 2: if(books==0) cout << "Книжки відсутні\n"; else print(0); break;
            case 3: if(magazines==0) cout << "Журнали відсутні!\n"; else print(1); break;
            case 4: if(magazines==0) cout << "Журнали відсутні!\n"; else num_st(); break;
            case 5: cout << "До побачення!!"; delete[] List; return 0;
            default: cout << "Неправильне значення!!!" << endl;
        }
    }
}
void add(){     //добаление элемента
    int change;//для выбора

    N++;
    if(N==1)
        List=new library[N];    //случай создания
    else{
        library* Temp=new library[N];   //случай добавления
        for(int i=0; i<N-1; i++)
            Temp[i]=List[i];
        delete[] List;
        List=Temp;
    }

    cout << "Що ви збираєтесь додати?:\n1.Книгу\n2.Журнал" << endl;
    for(;;){
        change=cin_valid();                                 //выбор книга/журнал
        if((change!=1)&&(change!=2))
            cout << "Неправильне значення!!!" << endl;
        else break;
    }

    cout << "Введіть нові дані:\nНазва: ";
    cin >> List[N-1].name;
    cout << "Рік випуску: ";                //ввод общих данных
    List[N-1].year=cin_valid();
    cout << "К-сть сторінок: ";
    List[N-1].pages=cin_valid();
    if(change==1){      //ввод уникальных данных книги
        cout << "Автор: ";
        cin.ignore(); cin.getline(List[N-1].type.author, 30);   //для нескольких слов
        List[N-1].flag=true;
        books++;
    }
    else{   //ввод уникальных данных журнала
        cout << "Випуск: ";
        cin.ignore(); cin.getline(List[N-1].type.magazine.issue, 30);
        cout << "К-сть статей: ";
        List[N-1].type.magazine.states=cin_valid();
        List[N-1].flag=false;
        magazines++;
    }
    cout << "Дані додано!!!" << endl;
}
void print(bool Case){      //печать одного из типов информации
    cout << "Назва\t\tРік випуску\tК-сть сторінок\t";
    if(Case==0)cout << "Автор\n";
    else cout << "Випуск\tК-сть статей\n";

    for(int i=0; i<N; i++){
        if(Case==0){
            if(List[i].flag==true){//проверка на то, что данный элемент является книгой
                cout << List[i].name;
                if(List[i].name.size()<8)cout<<"\t\t";  //контроль табуляций
                else cout<<"\t";
                cout << List[i].year << "\t\t" << List[i].pages << "\t\t" << List[i].type.author;
            }else continue;
        }
        else{
            if(List[i].flag==false){//по аналогии
                cout << List[i].name;
                if(List[i].name.size()<8)cout<<"\t\t";      //контроль табуляций
                else cout<<"\t";
                cout << List[i].year << "\t\t" << List[i].pages << "\t\t" << List[i].type.magazine.issue << "\t" << List[i].type.magazine.states;
            }else continue;
        }
        cout << endl;
    }

}
void num_st(){  //подсчет кол-ва статей
    int result=0;
    for(int i=0; i<N; i++)
        if(List[i].flag==false)
            result+=List[i].type.magazine.states;
    cout << "К-сть статей у всіх журналах: " << result << endl;
}
