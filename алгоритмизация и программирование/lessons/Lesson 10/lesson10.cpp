#include <iostream>
#include <windows.h>

using namespace std;

struct list{
    int value;
    list* next;
    list* prev;
};

list* init(int val){
    list* tmp=new list;
    tmp->value=val;
    tmp->next=NULL;
    tmp->prev=NULL;
    return tmp;
}

list* del(list* lst){
    list* tmp=lst;
    while(tmp->next!=NULL){
        tmp=tmp->next;
        if(tmp->prev!=NULL)
            delete tmp->prev;
    }
    return NULL;
}

list* add(list* lst, int val){
    list* tmp=lst;
    lst=new list;
    lst->value=val;
    lst->prev=NULL;
    lst->next=tmp;
    tmp->prev=lst;
    return lst;
}

list* add_back(list* last, int val){
    list* tmp=last;
    last=new list;
    last->value=val;
    last->prev=tmp;
    last->next=NULL;
    tmp->next=last;
    return last;
}

void print(list* lst){
    while(lst!=NULL){
        cout << lst->value<< " ";
        lst=lst->next;
    }
    cout << endl;
}

void print_back(list* last){
    while(last!=NULL){
        cout << last->value<< " ";
        last=last->prev;
    }
    cout << endl;
}

void change(list* &lst, list* &last){
    cout << "i" << endl;

}

int main(){
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);
    list* lst=NULL;
    list* last=NULL;
    list* tmp_lst=NULL;
    list* tmp_prev=NULL;
    int ans;
    while(true){
        cout << "\n1.Добавление нового значения в начало списка\n2.Добавление нового значения в конец списка\n3.Распечатка всех узлов списка от головы к хвосту\n4.Распечатка всех узлов списка от хвоста к голове\n5.Поменять местами первый и последний элементы\n6.Выход\n";
        cin >> ans;
        switch(ans){
        case 1: cout << "Введите значение: "; cin >> ans;
                if(lst==NULL){
                    lst=init(ans);
                    last=lst;
                }
                else
                    lst=add(lst,ans);
                cout << "Значение добавлено!" << endl;
                break;
        case 2: cout << "Введите значение: "; cin >> ans;
                if(last==NULL){
                    lst=init(ans);
                    last=lst;
                }
                else
                    last=add_back(last,ans);
                cout << "Значение добавлено!" << endl;
                break;
        case 3: if(last==NULL)cout << "Список пуст!" << endl; else {cout << "Элементы списка: "; print(lst);} break;
        case 4: if(last==NULL)cout << "Список пуст!" << endl; else {cout << "Элементы списка: "; print_back(last);} break;
        case 5: if(last==NULL)cout << "Список пуст!" << endl;
                else if(last==lst)cout << "В списке недостаточно элементов!" << endl;
                else{
                        if(lst->next!=last){
                            tmp_lst=lst;
                            tmp_prev=last->prev;

                            lst=last;
                            lst->prev=NULL;
                            lst->next=tmp_lst->next;
                            tmp_lst->next->prev=lst;

                            last=tmp_lst;
                            last->next=NULL;
                            last->prev=tmp_prev;
                            tmp_prev->next=last;
                        }
                        else{
                            tmp_lst=lst;

                            lst=last;
                            lst->next=lst->prev;
                            lst->prev=NULL;

                            last=tmp_lst;
                            last->prev=lst;
                            last->next=NULL;
                        }
                    cout << "Элементы поменялись местами!" << endl;
                }
                break;
        case 6: lst=del(lst); last=NULL; cout << "---Конец теста---" << endl; return 0;
        default: cout << "Неверное значение!!!" << endl;
        }
    }
}
