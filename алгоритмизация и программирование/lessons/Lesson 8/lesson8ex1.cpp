#include <iostream>
#include <clocale>
#include <My_library.h>

using namespace std;

struct list{    //������� ������
    list* ptr;
    int field;
};

list* init(int a){      //������������� ������
    list* lst=new list;
    lst->field=a;
    lst->ptr=NULL;
    return lst;
}

list* add_elem(list* lst, int number){  //���������� �������� � ������
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
void list_print(list* lst){ //������ ������
    list* p=lst;
    do{
        cout << p->field <<" ";
        p=p->ptr;
    }while(p!=NULL);
}

int main(){
    setlocale(LC_CTYPE, "rus");
    list* lst=init(1);  //�������� ����� ������
    list* tmp;//���� ������ ��� �����������
    int ans;    //���������� ��� �������������� � �������������
    int number; //����� ��������
    int x;  //������� ��������

    cout << "������ ������. ������ ������� - 1. ��������� ��������:\n";
    while(true){
        cout << "\n1.�������� �������� � ������ ������\n2.�������� �������� � ����� ������\n3.�������� �������� ����� ���������� ��������\n4.���������� ����� ������\n5.����� �������� � ������\n6.�����\n";
        ans=(int)cin_valid();
        switch(ans){
            case 1:
                tmp=new list;
                cout << "������� ��������: ";
                number=(int)cin_valid();
                tmp->field=number;
                tmp->ptr=lst;
                lst=tmp;
                cout << "������� ��������!" << endl;
                break;
            case 2:
                tmp=lst;
                while((tmp->ptr)!=NULL)
                    tmp=tmp->ptr;
                cout << "������� ��������: ";
                number=(int)cin_valid();
                add_elem(tmp,number);
                cout << "������� ��������!" << endl;
                break;
            case 3:
                tmp=lst;
                cout << "������� ��������, ����� �������� �� ������ �������� �������: ";
                number=(int)cin_valid();
                while(((tmp->ptr)!=NULL)&&((tmp->field)!=number))
                        tmp=tmp->ptr;
                if((tmp->field)!=number){
                    cout << "�������� � ����� ��������� �� �������!" << endl;
                    break;
                }
                cout << "������� ��������, ������� ������ ��������: ";
                number=(int)cin_valid();
                add_elem(tmp,number);
                cout << "������� ��������!" << endl;
                break;
            case 4:
                cout << "�������� ������: ";
                list_print(lst);
                cout << endl;
                break;
            case 5:
                tmp=lst;
                x=1;
                cout << "������� ��������, ������ �� ������ �����: ";
                number=(int)cin_valid();
                while(((tmp->ptr)!=NULL)&&((tmp->field)!=number)){
                    tmp=tmp->ptr;
                    x++;
                }
                if((tmp->field)!=number){
                    cout << "�������� � ����� ��������� �� �������!" << endl;
                    break;
                }
                cout << "������� ������! �������: " << x << endl;
                break;
            case 6:
                cout << "�������� ���!";
                delete[] lst;
                return 0;
            default: cerr << "������������ ��������!!! ��������� �������: ";
        }
    }
}
