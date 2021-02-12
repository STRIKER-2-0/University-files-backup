#include <iostream>
#include <windows.h>

using namespace std;

struct note{
    int value;
    note* next;
};

note* init(note* lst, int val){
    lst=new note;
    lst->value=val;
    lst->next=NULL;
    return lst;
}

note* push(note* lst, int val){
    note* tmp=new note;
    tmp->value=val;
    tmp->next=lst;
    return tmp;
}

note* pop(note* lst, int &val){
    note* tmp=lst;
    val=lst->value;
    lst=lst->next;
    delete tmp;
    return lst;
}

void print(note* lst){
    note* tmp=lst;
    while(tmp!=NULL){
        cout << tmp->value << " ";
        tmp=tmp->next;
    }
    cout << endl;
}

note* delete_stack(note* lst){
    note* tmp=lst;
    int n;
    while(tmp!=NULL){
        tmp=pop(tmp,n);
    }
    return tmp;
}

void out(note* lst, int &val){
    note* tmp=lst;
    if(tmp->next==NULL){
        val=tmp->value;
        delete lst;
        return;
    }

    while(tmp->next->next!=NULL){
        tmp=tmp->next;
    }

    val=tmp->next->value;
    lst=tmp->next;
    tmp->next=NULL;
    delete lst;

}

int main(){
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);

    note* Stack=NULL;
    note* Queue=NULL;
    int n;
    int ans;
    while(true){
        cout << "\n1.Вставка значения в стек\n2.Получение значения из стека\n3.Вставка значения в очередь\n4.Получение значения из очереди\n5.Печать Стека\n6.Печать очереди\n7.Выход\n";
        cin >> ans;
        switch(ans){
            case 1: cout << "Введите число: ";
                    cin >> n;
                    if(Stack==NULL)
                        Stack=init(Stack,n);
                    else
                        Stack=push(Stack,n);
                    cout << "Число помещено в стек!" << endl;
                    break;

            case 2: if(Stack==NULL)
                        cout << "Стек пуст!" << endl;
                    else{
                        Stack=pop(Stack,n);
                        cout << "Значение удалено из стека и получено в поток: " << n << endl;
                    }
                    break;

            case 3: cout << "Введите число: ";
                    cin >> n;
                    if(Queue==NULL)
                        Queue=init(Queue,n);
                    else
                        Queue=push(Queue,n);
                    cout << "Число помещено в очередь!" << endl;
                    break;

            case 4: if(Queue==NULL)
                        cout << "Очередь пуста!" << endl;
                    else if(Queue->next==NULL){
                        out(Queue,n);
                        cout << "Значение удалено из очереди и получено в поток: " << n << endl;
                        delete Queue;
                        Queue=NULL;
                    }
                    else{
                        out(Queue,n);
                        cout << "Значение удалено из очереди и получено в поток: " << n << endl;
                    }
                    break;

            case 5: if(Stack==NULL)
                        cout << "Стек пуст!" << endl;
                    else{
                        cout << "Состояние стека: ";
                        print(Stack);
                    }
                    break;

            case 6: if(Queue==NULL)
                        cout << "Очередь пуста!" << endl;
                    else{
                        cout << "Состояние очереди: ";
                        print(Queue);
                    }
                    break;

            case 7: cout << "Удачного дня!!"; Stack=delete_stack(Stack); Queue=delete_stack(Queue); return 0;
            default: cout << "Неверное значение!!" << endl;
        }
    }


}
