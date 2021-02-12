#include <iostream>
#include <clocale>
#include <My_library.h>

using namespace std;

struct list{    //элемент списка
    list* ptr;
    int field;
};

list* init(int a){      //инициализация списка
    list* lst=new list;
    lst->field=a;
    lst->ptr=NULL;
    return lst;
}

list* add_elem(list* lst, int number){  //добавление элемента в список
    list *temp,*p;
    temp=new list;
    p=lst->ptr;
    lst->ptr=temp;
    temp->field=number;
    temp->ptr=p;
    return temp;
}
/*
list* delete_elem(list* lst, list* root){
    list* temp=root;
    while(temp->ptr!=lst){
        temp=temp->ptr;
    }
    temp->ptr=lst->ptr;
    delete[] lst;
    return temp;
}
*/
void list_print(list* lst){ //печать списка
    list* p=lst;
    do{
        cout << p->field <<" ";
        p=p->ptr;
    }while(p!=NULL);
}

int main(){
    setlocale(LC_CTYPE, "rus");
    list* lst=init(1);  //создание корня списка
    list* tmp;//темп ссылка для манипуляций
    int ans;    //переменная для взаимодействия с пользователем
    int number; //номер элемента
    int x;  //позиция элемента

    cout << "Список создан. Первый элемент - 1. Возможные действия:\n";
    while(true){
        cout << "\n1.Добавить значение в начало списка\n2.Добавить значение в конец списка\n3.Добавить значение после указанного значения\n4.Распечатка узлов списка\n5.Поиск значения в списке\n6.Выход\n";
        ans=(int)cin_valid();
        switch(ans){
            case 1:
                tmp=new list;
                cout << "Введите значение: ";
                number=(int)cin_valid();
                tmp->field=number;
                tmp->ptr=lst;
                lst=tmp;
                cout << "Элемент добавлен!" << endl;
                break;
            case 2:
                tmp=lst;
                while((tmp->ptr)!=NULL)
                    tmp=tmp->ptr;
                cout << "Введите значение: ";
                number=(int)cin_valid();
                add_elem(tmp,number);
                cout << "Элемент добавлен!" << endl;
                break;
            case 3:
                tmp=lst;
                cout << "Введите значение, после которого вы хотите добавить элемент: ";
                number=(int)cin_valid();
                while(((tmp->ptr)!=NULL)&&((tmp->field)!=number))
                        tmp=tmp->ptr;
                if((tmp->field)!=number){
                    cout << "Элемента с таким значением не найдено!" << endl;
                    break;
                }
                cout << "Введите значение, которое хотите добавить: ";
                number=(int)cin_valid();
                add_elem(tmp,number);
                cout << "Элемент добавлен!" << endl;
                break;
            case 4:
                cout << "Элементы списка: ";
                list_print(lst);
                cout << endl;
                break;
            case 5:
                tmp=lst;
                x=1;
                cout << "Введите значение, которе вы хотите найти: ";
                number=(int)cin_valid();
                while(((tmp->ptr)!=NULL)&&((tmp->field)!=number)){
                    tmp=tmp->ptr;
                    x++;
                }
                if((tmp->field)!=number){
                    cout << "Элемента с таким значением не найдено!" << endl;
                    break;
                }
                cout << "Элемент найден! Позиция: " << x << endl;
                break;
            case 6:
                cout << "Удачного дня!";
                delete[] lst;
                return 0;
            default: cerr << "Некорректное значение!!! Повторите попытку: ";
        }
    }
}
