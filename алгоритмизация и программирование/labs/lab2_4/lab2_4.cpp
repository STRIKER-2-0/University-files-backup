#include <iostream>
#include <My_library.h> //������ ����������. ������������ ������� cin_valid(), ��� �������� ���� �������� ������
#include <string>
#include <windows.h>

using namespace std;

struct list{    //��������� ���� ���������
    list* next;
    string lastname;
    string firstname;
    string patronimic;
    struct{
        int day;
        int month;
        int year;
    }date;
    double perfomance;
};

int N=0;
list* List;
list* last;

void add(int);
void sorting(list*);
void print();
void search_name();
list* init(int);
list* add_elem(list* lst, int number);
void Erase(list* lst);
void print_perf();
void Delete();

int main(){
    SetConsoleCP(1251);     //����������
    SetConsoleOutputCP(1251);
    string name;
    bool flag=false;
    int ans;

    cout << "������ ����!!" << endl;
    for(;;){
        cout << "\n1.������� ��� �� ��� ���������\n2.������ ������ ��������(������� ������)\n3.������ ������ ��������(����� ������)\n4.������ ������ ��������(���� ���������� ��������)\n5.����� �� ��������\n6.������� ��� �� �������� ��������\n7.��������� ��������\n8.�����\n";
        ans=cin_valid();
        switch(ans){
            case 1: if(N==0) cout << "�������� ������\n"; else print(); break;
            case 2: add(0); break;
            case 3: if(N==0) cout << "�������� ������\n";
                    else{
                        last=List;
                        while(last->next!=NULL)
                            last=last->next;
                        add(1);
                    }
                    break;
            case 4: if(N==0) cout << "�������� ������\n";
                    else{
                        cout << "����� ������� ��������, ���� ����� �� ������ ������ ������: ";
                        cin >> name;
                        last=List;
                        if(last->lastname==name)
                                flag=true;
                        while((last->next!=NULL)&&(last->lastname!=name)){
                            last=last->next;
                            if(last->lastname==name)
                                flag=true;
                        }
                        if(flag==true)add(1);
                        else cout << "������� �������� � ������ ������ �� ��������!!" << endl;
                    }
                    break;
            case 5: if(N==0) cout << "�������� ������\n"; else search_name();  break;
            case 6: if(N==0) cout << "�������� ������\n"; else print_perf();  break;
            case 7: if(N==0) cout << "�������� ������\n"; else Delete(); break;
            case 8: cout << "�� ���������!!"; Erase(List); return 0;
            default: cout << "����������� ��������!!!" << endl;
        }
    }
}

void add(int x){     //��������� ��������
    N++;
    if(N==1){
        List=init(0);  //������ ��������
        last=List;
    }
    else if(x==0)
        last=add_elem(List,0);
    else
        last=add_elem(last,0);

    cout << "������ ��� ������ ��������:\n�������: ";    //���� �����
    cin >> last->lastname;
    cout << "��'�: ";
    cin >> last->firstname;
    cout << "��-�������: ";
    cin >> last->patronimic;
    cout << "���� ����������:\n����: ";
    last->date.day=(int)cin_valid();
    while((last->date.day==0)||(last->date.day>31)){    //�������� �� ����������� ����
        cout << "����������� ����! ������ ����� �� 1 �� 31: ";
        last->date.day=(int)cin_valid();
    }
    cout << "̳����: ";
    last->date.month=(int)cin_valid();
    while((last->date.month==0)||(last->date.month>12)){
        cout << "����������� ����! ������ ����� �� 1 �� 12: ";
        last->date.month=(int)cin_valid();
    }
    cout << "г�: ";
    last->date.year=(int)cin_valid();
    while(last->date.year>2019){
        cout << "����������� ����! ������ ����� �� 0 �� 2019: ";
        last->date.year=(int)cin_valid();
    }
    cout << "������� ��������: ";
    last->perfomance=cin_valid();
    while(last->perfomance>100.0){    //� �� ������������ ������������
        cout << "����������� ����! ������ ����� �� 0 �� 100: ";
        last->perfomance=(int)cin_valid();
    }
    cout << "��� ������!!!" << endl;
    sorting(List);
}

list* init(int a){      //������������� ������
    list* lst=new list;
    lst->perfomance=a;
    lst->next=NULL;
    return lst;
}

list* add_elem(list* lst, int number){  //���������� �������� � ������
    list *temp,*p;
    temp=new list;
    p=lst->next;
    lst->next=temp;
    temp->perfomance=number;
    temp->next=p;
    return temp;
}

void sorting(list* lst){
    list* tmp=lst;
    list CELL;

    while(tmp->next!=NULL){
        if((tmp->lastname)>(tmp->next->lastname)){
            CELL.lastname=tmp->lastname;
            CELL.firstname=tmp->firstname;
            CELL.patronimic=tmp->patronimic;
            CELL.date=tmp->date;
            CELL.perfomance=tmp->perfomance;

            tmp->lastname=tmp->next->lastname;
            tmp->firstname=tmp->next->firstname;
            tmp->patronimic=tmp->next->patronimic;
            tmp->date=tmp->next->date;
            tmp->perfomance=tmp->next->perfomance;

            tmp->next->lastname=CELL.lastname;
            tmp->next->firstname=CELL.firstname;
            tmp->next->patronimic=CELL.patronimic;
            tmp->next->date=CELL.date;
            tmp->next->perfomance=CELL.perfomance;

            tmp=lst;
        }
        else tmp=tmp->next;
    }
}

void print(){   //������
    last=List;
    cout << "�����\t�������\t��'�\t\t��-�������\t���� ����������\t������� ��������\n";
    for(int i=0; i<N; i++){
        cout << i+1 << ".\t" << last->lastname;
        if(last->lastname.size()>=8)cout<<"\t";   //�������� ���������
        else cout << "\t\t";
        cout << last->firstname;
        if(last->firstname.size()>=8)cout<<"\t";
        else cout << "\t\t";
        cout << last->patronimic;
        if(last->patronimic.size()>=8)cout<<"\t";
        else cout << "\t\t";
        if(last->date.day<10)cout <<"0";  //���� ��� ����
        cout << last->date.day <<".";
        if(last->date.month<10)cout <<"0";
        cout << last->date.month <<"."<< last->date.year <<"\t"<< last->perfomance << endl;
        last=last->next;
    }
}

void search_name(){ //����� �� �������
    string name;
    bool flag=false;//���� ��� �������������
    last=List;

    cout << "������ ������� ��������: ";
    cin >> name;
    for(int i=0; i<N; i++){//���� ��� ��������, ���������� �� ������ ��������
        if(last->lastname==name){
            cout << "\n�������� �������:\n�����\t�������\t��'�\t\t��-�������\t���� ����������\t������� ��������\n";
            flag=true;
            break;
        }
        last=last->next;
    }

    if(flag==false){
            cout << "������� �������� � ������ ������ �� ��������!!" << endl;
            return; //����� ��������� �-�
    }

    last=List;
    for(int i=0; i<N; i++){
        if(last->lastname==name){ //��� ����� �� �����, ��� � � ������
            cout << i+1 << ".\t" << last->lastname;
            if(last->lastname.size()>=8)cout<<"\t";   //�������� ���������
            else cout << "\t\t";
            cout << last->firstname;
            if(last->firstname.size()>=8)cout<<"\t";
            else cout << "\t\t";
            cout << last->patronimic;
            if(last->patronimic.size()>=8)cout<<"\t";
            else cout << "\t\t";
            if(last->date.day<10)cout <<"0";
            cout << last->date.day <<".";
            if(last->date.month<10)cout <<"0";
            cout << last->date.month <<"."<< last->date.year <<"\t"<< last->perfomance << endl;
        }
        last=last->next;
    }
}

void print_perf(){
    bool flag=false;
    last=List;

    for(int i=0; i<N; i++){//���� ��� ��������, ���������� �� ������ ��������
        if(last->perfomance>=90){
            cout << "\n\"³������\":\n�����\t�������\t��'�\t\t��-�������\t���� ����������\t������� ��������\n";
            flag=true;
            break;
        }
        last=last->next;
    }

    if(flag==false){
            cout << "\n\"³������\":\n--³�����--" << endl;

    }

    last=List;
    for(int i=0; i<N; i++){
        if(last->perfomance>=90){ //��� ����� �� �����, ��� � � ������
            cout << i+1 << ".\t" << last->lastname;
            if(last->lastname.size()>=8)cout<<"\t";   //�������� ���������
            else cout << "\t\t";
            cout << last->firstname;
            if(last->firstname.size()>=8)cout<<"\t";
            else cout << "\t\t";
            cout << last->patronimic;
            if(last->patronimic.size()>=8)cout<<"\t";
            else cout << "\t\t";
            if(last->date.day<10)cout <<"0";
            cout << last->date.day <<".";
            if(last->date.month<10)cout <<"0";
            cout << last->date.month <<"."<< last->date.year <<"\t"<< last->perfomance << endl;
        }
        last=last->next;
    }

    flag=false;
    last=List;

    for(int i=0; i<N; i++){//���� ��� ��������, ���������� �� ������ ��������
        if((last->perfomance<90)&&(last->perfomance>=70)){
            cout << "\n\"�����\":\n�����\t�������\t��'�\t\t��-�������\t���� ����������\t������� ��������\n";
            flag=true;
            break;
        }
        last=last->next;
    }

    if(flag==false){
            cout << "\n\"�����\":\n--³�����--" << endl;

    }

    last=List;
    for(int i=0; i<N; i++){
        if((last->perfomance<90)&&(last->perfomance>=70)){ //��� ����� �� �����, ��� � � ������
            cout << i+1 << ".\t" << last->lastname;
            if(last->lastname.size()>=8)cout<<"\t";   //�������� ���������
            else cout << "\t\t";
            cout << last->firstname;
            if(last->firstname.size()>=8)cout<<"\t";
            else cout << "\t\t";
            cout << last->patronimic;
            if(last->patronimic.size()>=8)cout<<"\t";
            else cout << "\t\t";
            if(last->date.day<10)cout <<"0";
            cout << last->date.day <<".";
            if(last->date.month<10)cout <<"0";
            cout << last->date.month <<"."<< last->date.year <<"\t"<< last->perfomance << endl;
        }
        last=last->next;
    }

    flag=false;
    last=List;

    for(int i=0; i<N; i++){//���� ��� ��������, ���������� �� ������ ��������
        if((last->perfomance<70)&&(last->perfomance>=50)){
            cout << "\n\"���������\":\n�����\t�������\t��'�\t\t��-�������\t���� ����������\t������� ��������\n";
            flag=true;
            break;
        }
        last=last->next;
    }

    if(flag==false){
            cout << "\n\"���������\":\n--³�����--" << endl;

    }

    last=List;
    for(int i=0; i<N; i++){
        if((last->perfomance<70)&&(last->perfomance>=50)){ //��� ����� �� �����, ��� � � ������
            cout << i+1 << ".\t" << last->lastname;
            if(last->lastname.size()>=8)cout<<"\t";   //�������� ���������
            else cout << "\t\t";
            cout << last->firstname;
            if(last->firstname.size()>=8)cout<<"\t";
            else cout << "\t\t";
            cout << last->patronimic;
            if(last->patronimic.size()>=8)cout<<"\t";
            else cout << "\t\t";
            if(last->date.day<10)cout <<"0";
            cout << last->date.day <<".";
            if(last->date.month<10)cout <<"0";
            cout << last->date.month <<"."<< last->date.year <<"\t"<< last->perfomance << endl;
        }
        last=last->next;
    }

    flag=false;
    last=List;

    for(int i=0; i<N; i++){//���� ��� ��������, ���������� �� ������ ��������
        if(last->perfomance<50){
            cout << "\n\"�����������\":\n�����\t�������\t��'�\t\t��-�������\t���� ����������\t������� ��������\n";
            flag=true;
            break;
        }
        last=last->next;
    }

    if(flag==false){
            cout << "\n\"�����������\":\n--³�����--" << endl;

    }

    last=List;
    for(int i=0; i<N; i++){
        if(last->perfomance<50){ //��� ����� �� �����, ��� � � ������
            cout << i+1 << ".\t" << last->lastname;
            if(last->lastname.size()>=8)cout<<"\t";   //�������� ���������
            else cout << "\t\t";
            cout << last->firstname;
            if(last->firstname.size()>=8)cout<<"\t";
            else cout << "\t\t";
            cout << last->patronimic;
            if(last->patronimic.size()>=8)cout<<"\t";
            else cout << "\t\t";
            if(last->date.day<10)cout <<"0";
            cout << last->date.day <<".";
            if(last->date.month<10)cout <<"0";
            cout << last->date.month <<"."<< last->date.year <<"\t"<< last->perfomance << endl;
        }
        last=last->next;
    }
}

void Erase(list* lst){
    list* tmp;
    while(lst!=NULL){
        tmp=lst;
        lst=lst->next;
        delete &tmp;
    }
}

void Delete(){  //�������� ��������
    string name;
    list* temp=List;
    bool flag=false;

    cout << "������ ������� ��������, ���� ������ ��������: ";
    cin >> name;

    last=List;
    while(last!=NULL){
        if(last->lastname==name){
            while((temp->next!=last)&&(temp!=last))
                temp=temp->next;
            if(temp==last){
                List=last->next;
                delete &List;
                }
            else{
                temp->next=last->next;
                delete &last;
            }

            flag=true;
            N--;
        }
        last=last->next;
    }

    if(flag==false)
        cout << "������� �������� � ������ ������ �� ��������!" << endl;

    else cout << "�������� ��������!" << endl;
}

