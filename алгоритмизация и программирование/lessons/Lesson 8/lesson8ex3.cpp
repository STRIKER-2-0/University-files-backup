#include <iostream>
#include <clocale>
#include <My_library.h>
#include <cstdlib>
#include <ctime>

using namespace std;

struct list{    //элемент списка
    list* ptr;
    int field;
};

/*list* lst1;
list* lst2;*/

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

void sorting(list* lst){
    list* tmp=lst;
    int field;

    while(tmp->ptr!=NULL){
        if((tmp->field)>(tmp->ptr->field)){
            field=tmp->field;
            tmp->field=tmp->ptr->field;
            tmp->ptr->field=field;
            tmp=lst;
        }
        else tmp=tmp->ptr;
    }
}
void Delete(list* lst){
    list* tmp;
    while(lst!=NULL){
        tmp=lst;
        lst=lst->ptr;
        delete &tmp;
    }
}

int main(){
    setlocale(LC_CTYPE, "rus");
    srand(time(0));
    int n=rand()%10+5;

    list* lst1=init(rand()%20);
    list* lst2=init(rand()%20);
    list* tmp=lst1;
    for(int i=0; i<n; i++){
        add_elem(tmp,rand()%20);
        if((tmp->field)<(tmp->ptr->field))
            tmp=tmp->ptr;
    }
    tmp=lst2;
    n=rand()%10+5;
    for(int i=0; i<n; i++){
        add_elem(tmp,rand()%20);
        tmp=tmp->ptr;
    }
    cout << "Списки, сгенерированные случайным образом: "  << endl;
    list_print(lst1);
    cout << endl;
    list_print(lst2);
    cout << endl << "Отсортированнные списки: "  << endl;
    sorting(lst1);
    sorting(lst2);
    list_print(lst1);
    cout << endl;
    list_print(lst2);
    cout << endl << "Соединенный отсортированный список: "  << endl;

    tmp=lst1;
    while(tmp->ptr!=NULL)
        tmp=tmp->ptr;
    tmp->ptr=lst2;
    sorting(lst1);
    list_print(lst1);

    Delete(lst1);
    Delete(lst2);
}
