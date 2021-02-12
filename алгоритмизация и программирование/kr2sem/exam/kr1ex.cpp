#include <iostream>

#include <string>
#include <windows.h>
#include <cmath>

using namespace std;


struct base{
    string vid;
    double haste;
    int old;
};

int N=0;
base* List;


void add();
void print();
void Search();
void sorting();
void Delete();

double cin_valid(){
    char volname[30];
    double result=0.0;
    bool flag=false;
    int dot=0;

    while(!flag){
        cin >> volname;
        for(int i=0; volname[i]!='\0'; ++i){
            if((volname[i]<'-')||(volname[i]>'9')||(volname[i]=='/')||((volname[i]=='-')&&(i!=0))){
                cout << "Invalid type of value!!! Try again: ";
                flag=false;
                break;
            }
            else flag=true;
        }
    }

    for(; (volname[dot]!='.')&&(volname[dot]!='\0'); ++dot){}


    for(int i=0; volname[i]!='\0'; ++i){
        if(volname[i]=='-'){
            i++;
            dot--;
        }
        if(volname[i]=='.')i++;

        result+=(volname[i]-48)*pow(10,dot-1);
        dot--;
    }
    if(volname[0]=='-')
            result=result*(-1);

    return result;
}

int main(){
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);

    int ans;
    cout << "������ ����!!" << endl;
    for(;;){
        cout << "\n1.������ ���� �������\n2.���� ������ ������\n3.����� ����������� �������\n4.��������� �������\n5.�����\n";
        ans=cin_valid();
        switch(ans){
            case 1: add(); break;
            case 2: if(N==0) cout << "������� ������\n"; else print(); break;
            case 3: if(N==0) cout << "������� ������\n"; else Search(); break;
            case 4: if(N==0) cout << "������� ������\n"; else Delete(); break;
            case 5: cout << "�� ���������!!"; delete[] List; return 0;
            default: cout << "����������� ��������!!!" << endl;
        }
    }
}

void add(){
    N++;
    if(N==1)
        List=new base[N];
    else{
        base* Temp=new base[N];
        for(int i=0; i<N-1; i++)
            Temp[i]=List[i];
        delete[] List;
        List=Temp;
    }

    cout << "������ ��� ���� �������:\n���: ";
    cin >> List[N-1].vid;
    cout << "��������: ";
    List[N-1].haste=cin_valid();
    while(List[N-1].haste<=0){
        cout << "���������� ���!!��������� ��: ";
        List[N-1].haste=cin_valid();
    }
    cout << "³�: ";
    List[N-1].old=cin_valid();
    while(List[N-1].old<0){
        cout << "���������� ���!!��������� ��: ";
        List[N-1].old=cin_valid();
    }

    cout << "��� ������!!!" << endl;
    sorting();
}

void sorting(){
    base Temp;
    for(int j=0; j<N; j++)
        for(int i=0; i<N-1; i++)
            if(List[i].vid>List[i+1].vid){
                Temp=List[i];
                List[i]=List[i+1];
                List[i+1]=Temp;
            }
}

void print(){
    cout << "�����\t���\t\t��������\t³�\n";
    for(int i=0; i<N; i++){
        cout << i+1 << ".\t" << List[i].vid;
        if(List[i].vid.size()>=8)cout<<"\t";
        else cout << "\t\t";
        cout << List[i].haste << "\t\t" << List[i].old << endl;
    }
}

void Search(){
    double Min=100000;
    int pos;
    for(int i=0; i<N; i++)
        if(List[i].haste<Min){
            Min=List[i].haste;
            pos=i;
    }
    cout << "����������� ������� ��������:\n�����\t���\t\t��������\t³�\n";
    cout << pos+1 << ".\t" << List[pos].vid;
    if(List[pos].vid.size()>=8)cout<<"\t";
    else cout << "\t\t";
    cout << List[pos].haste << "\t\t" << List[pos].old << endl;
}

void Delete(){
    int pos;

    cout << "������ ����� �������, ����� ������ ��������(������ 0 ��� ���������): ";
    pos=(unsigned int)cin_valid();
    if(pos==0){
        cout << "���������!!\n"; return;
    }
    while((pos>N)||(pos<0)){
        cout << "����� ����� �������!!\n";
        pos=(int)cin_valid();
    }

    pos--;
    N--;
    base* Temp=new base[N];
    for(int i=0; i<pos; i++)
        Temp[i]=List[i];
    for(int i=pos+1; i<N+1; i++)
        Temp[i-1]=List[i];

    delete[] List;
    List=Temp;
    cout << "������� ��������!!" << endl;
}

