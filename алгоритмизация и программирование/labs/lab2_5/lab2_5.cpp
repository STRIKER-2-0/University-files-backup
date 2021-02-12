#include <iostream>
#include <windows.h>

using namespace std;

struct note{
    int value;
    note* next;
};

note* Stack=NULL;
note* Queue=NULL;
int* Stack_arr=NULL;
int* Queue_arr=NULL;
int N=5;  //������ �������
int n;
int ans;

note* init(note* lst, int val){     //������ �������
    lst=new note;
    lst->value=val;
    lst->next=NULL;
    return lst;
}

note* push(note* lst, int val){     //�������� � �����
    note* tmp=new note;
    tmp->value=val;
    tmp->next=lst;
    return tmp;
}

note* pop(note* lst, int &val){     //����� �� �����
    note* tmp=lst;
    val=lst->value;
    lst=lst->next;
    delete tmp;
    return lst;
}

void print(note* lst){      //�����������
    note* tmp=lst;
    while(tmp!=NULL){
        cout << tmp->value << " ";
        tmp=tmp->next;
    }
    cout << endl;
}

void out(note* lst, int &val){  //����� �� ������
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

note* delete_stack(note* lst){  //������� ��������� ���������
    note* tmp=lst;
    int n;
    while(tmp!=NULL){
        tmp=pop(tmp,n);
    }
    return tmp;
}

void icrease(){
    int* temp=new int[N*2];
    for(int i=0; i<N*2; i++)
        temp[i]=0;
    for(int i=0; i<N; i++)
        temp[i]=Stack_arr[i];
    delete[] Stack_arr;
    Stack_arr=temp;
    N*=2;
}

void icrease_q(){
    int* temp=new int[N*2];
    for(int i=0; i<N*2; i++)
        temp[i]=0;
    for(int i=0; i<N; i++)
        temp[i]=Queue_arr[i];
    delete[] Queue_arr;
    Queue_arr=temp;
    N*=2;
}

void submenu_stack_arr(){
    bool flag=false;
    while(true){
        cout << "\n1.��������\n2.�������\n3.�����������\n4.�������� �������\n5.��������\n6.���������, ����� ��\n7.����� � ����������� ����\n";
        cin >> ans;
        switch(ans){
            case 1: cout << "������� �����: ";
                    cin >> n;
                    if(Stack_arr==NULL){
                        Stack_arr=new int[N];
                        for(int i=0; i<N; i++)
                            Stack_arr[i]=0;
                        Stack_arr[0]=n;
                    }
                    else{
                        for(int i=0; i<N; i++){
                            if(Stack_arr[i]==0){
                                Stack_arr[i]=n;
                                break;
                            }
                        }
                        if(Stack_arr[N-1]!=0)
                            icrease();
                    }

                    cout << "����� �������� � ����!" << endl;
                    break;

            case 2: if(Stack_arr==NULL)
                        cout << "���� ����!" << endl;
                    else{
                        flag=false;
                        for(int i=0; i<N; i++)
                            if(Stack_arr[i]!=0){
                                flag=true;
                                break;
                            }

                        if(flag==false)
                            cout << "���� ����!" << endl;
                        else{
                            for(int i=N-1; i>=0; i--)
                                if(Stack_arr[i]!=0){
                                    Stack_arr[i]=0;
                                    break;
                                }
                            cout << "�������� ������� �� �����!" << endl;
                        }
                    }
                    break;

            case 3: if(Stack_arr==NULL)
                        cout << "���� ����!" << endl;
                    else{
                        flag=false;
                        for(int i=0; i<N; i++)
                            if(Stack_arr[i]!=0){
                                flag=true;
                                break;
                            }

                        if(flag==false)
                            cout << "���� ����!" << endl;
                        else{
                            cout << "��������� �����: ";
                            for(int i=0; i<N; i++)
                                cout << Stack_arr[i] << " ";
                        }
                    }
                    break;

            case 4: if(Stack_arr==NULL)
                        cout << "���� ����!" << endl;
                    else{
                        flag=false;
                        for(int i=0; i<N; i++)
                            if(Stack_arr[i]!=0){
                                flag=true;
                                break;
                            }

                        if(flag==false)
                            cout << "���� ����!" << endl;
                        else{
                            for(int i=N-1; i>=0; i--)
                                if(Stack_arr[i]!=0){
                                     cout << "������� ������� �����: " << Stack_arr[i] << endl;
                                     break;
                                }
                        }
                    }
                    break;

            case 5: delete[] Stack_arr;
                    Stack_arr=NULL;
                    cout << "���� ������!" << endl;
                    break;

            case 6: if(Stack_arr==NULL)
                        cout << "���� ����!" << endl;
                    else{
                        flag=false;
                        for(int i=0; i<N; i++)
                            if(Stack_arr[i]!=0){
                                flag=true;
                                break;
                            }

                        if(flag==false)
                            cout << "���� ����!" << endl;
                        else
                            cout << "���� �� ����." << endl;
                    }
                    break;
            case 7: cout << "--����� � ����������� ����--" << endl; return;
            default: cout << "�������� ��������!!" << endl;
        }
    }
}

void submenu_queue_arr(){
    bool flag=false;
    while(true){
        cout << "\n1.��������\n2.�������\n3.�����������\n4.�������� �������\n5.��������\n6.���������, ����� ��\n7.����� � ����������� ����\n";
        cin >> ans;
        switch(ans){
            case 1: cout << "������� �����: ";
                    cin >> n;
                    if(Queue_arr==NULL){
                        Queue_arr=new int[N];
                        for(int i=0; i<N; i++)
                            Queue_arr[i]=0;
                        Queue_arr[0]=n;
                    }
                    else{
                        for(int i=0; i<N; i++){
                            if(Queue_arr[i]==0){
                                Queue_arr[i]=n;
                                break;
                            }
                        }
                        if(Queue_arr[N-1]!=0)
                            icrease_q();
                    }

                    cout << "����� �������� � �������!" << endl;
                    break;

            case 2: if(Queue_arr==NULL)
                        cout << "������� �����!" << endl;
                    else{
                        flag=false;
                        for(int i=0; i<N; i++)
                            if(Queue_arr[i]!=0){
                                flag=true;
                                break;
                            }

                        if(flag==false)
                            cout << "������� �����!" << endl;
                        else{
                            for(int i=0; i<N-1; i++)
                                Queue_arr[i]=Queue_arr[i+1];
                            cout << "�������� ������� �� �������!" << endl;
                        }
                    }
                    break;

            case 3: if(Queue_arr==NULL)
                        cout << "������� �����!" << endl;
                    else{
                        flag=false;
                        for(int i=0; i<N; i++)
                            if(Queue_arr[i]!=0){
                                flag=true;
                                break;
                            }

                        if(flag==false)
                            cout << "������� �����!" << endl;
                        else{
                            cout << "��������� �������: ";
                            for(int i=0; i<N; i++)
                                cout << Queue_arr[i] << " ";
                        }
                    }
                    break;

            case 4: if(Queue_arr==NULL)
                        cout << "������� �����!" << endl;
                    else{
                        flag=false;
                        for(int i=0; i<N; i++)
                            if(Queue_arr[i]!=0){
                                flag=true;
                                break;
                            }

                        if(flag==false)
                            cout << "������� �����!" << endl;
                        else{
                            for(int i=N-1; i>=0; i--)
                                if(Queue_arr[i]!=0){
                                     cout << "������� ������� �������: " << Queue_arr[i] << endl;
                                     break;
                                }
                        }
                    }
                    break;

            case 5: delete[] Queue_arr;
                    Queue_arr=NULL;
                    cout << "������� �������!" << endl;
                    break;

            case 6: if(Queue_arr==NULL)
                        cout << "������� �����!" << endl;
                    else{
                        flag=false;
                        for(int i=0; i<N; i++)
                            if(Queue_arr[i]!=0){
                                flag=true;
                                break;
                            }

                        if(flag==false)
                            cout << "������� �����!" << endl;
                        else
                            cout << "������� �� �����." << endl;
                    }
                    break;
            case 7: cout << "--����� � ����������� ����--" << endl; return;
            default: cout << "�������� ��������!!" << endl;
        }
    }
}

void submenu_stack(){
    while(true){
        cout << "\n1.��������\n2.�������\n3.�����������\n4.�������� �������\n5.��������\n6.���������, ����� ��\n7.����� � ����������� ����\n";
        cin >> ans;
        switch(ans){
            case 1: cout << "������� �����: ";
                    cin >> n;
                    if(Stack==NULL)
                        Stack=init(Stack,n);
                    else
                        Stack=push(Stack,n);
                    cout << "����� �������� � ����!" << endl;
                    break;

            case 2: if(Stack==NULL)
                        cout << "���� ����!" << endl;
                    else{
                        Stack=pop(Stack,n);
                        cout << "�������� ������� �� �����!" << endl;
                    }
                    break;

            case 3: if(Stack==NULL)
                        cout << "���� ����!" << endl;
                    else{
                        cout << "��������� �����: ";
                        print(Stack);
                    }
                    break;

            case 4: if(Stack==NULL)
                        cout << "���� ����!" << endl;
                    else
                        cout << "������� ������� �����: " << Stack->value << endl;
                    break;

            case 5: Stack=delete_stack(Stack);
                    cout << "���� ������!" << endl;
                    break;

            case 6: if(Stack==NULL)
                        cout << "���� ����!" << endl;
                    else
                        cout << "���� �� ����." << endl;
                    break;

            case 7: cout << "--����� � ����������� ����--" << endl; return;
            default: cout << "�������� ��������!!" << endl;
        }
    }
}

void submenu_queue(){
    while(true){
        cout << "\n1.��������\n2.�������\n3.�����������\n4.�������� �������\n5.��������\n6.���������, ����� ��\n7.����� � ����������� ����\n";
        cin >> ans;
        switch(ans){
            case 1: cout << "������� �����: ";
                    cin >> n;
                    if(Queue==NULL)
                        Queue=init(Queue,n);
                    else
                        Queue=push(Queue,n);
                    cout << "����� �������� � �������!" << endl;
                    break;

            case 2: if(Queue==NULL)
                        cout << "������� �����!" << endl;
                    else if(Queue->next==NULL){
                        out(Queue,n);
                        cout << "�������� ������� �� �������!" << endl;
                        delete Queue;
                        Queue=NULL;
                    }
                    else{
                        out(Queue,n);
                        cout << "�������� ������� �� �������!" << endl;
                    }
                    break;

            case 3: if(Queue==NULL)
                        cout << "������� �����!" << endl;
                    else{
                        cout << "��������� �������: ";
                        print(Queue);
                    }
                    break;

            case 4: if(Queue==NULL)
                        cout << "������� �����!" << endl;
                    else
                        cout << "������� ������� �������: " << Queue->value << endl;
                    break;

            case 5: Queue=delete_stack(Queue);
                    cout << "������� �������!" << endl;
                    break;

            case 6: if(Queue==NULL)
                        cout << "������� �����!" << endl;
                    else
                        cout << "������� �� �����." << endl;
                    break;

            case 7: cout << "--����� � ����������� ����--" << endl; return;
            default: cout << "�������� ��������!!" << endl;
        }
    }
}

int main(){
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);

    while(true){
        cout << "\n1.���� ����� ������\n2.���� ����� ���������\n3.������� ����� ������\n4.������� ����� ���������\n5.�����\n";
        cin >> ans;
        switch(ans){
            case 1: submenu_stack_arr(); break;
            case 2: submenu_stack(); break;
            case 3: submenu_queue_arr(); break;
            case 4: submenu_queue(); break;
            case 5: cout << "�������� ���!!"; Stack=delete_stack(Stack); Queue=delete_stack(Queue); delete[] Stack_arr; delete[] Queue_arr; return 0;
            default: cout << "�������� ��������!!" << endl;
        }
    }
}
