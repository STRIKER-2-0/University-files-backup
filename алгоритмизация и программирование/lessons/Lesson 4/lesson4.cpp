#include <iostream>
#include <My_library.h> //������ ����������. ������������ ������� cin_valid(), ��� �������� ���� �������� ������
#include <string>
#include <windows.h>

using namespace std;

union T{    //����������� ��� ����/��������
    char author[30];
    struct{
        char issue[30];
        int states;
    }magazine;
};
struct library{ //��������� ������ ��������
    string name;
    int year;
    int pages;
    bool flag;//���� ��� �������� ���� ����������
    T type;
};

int N=0;
library* List;
int books=0,magazines=0; //�������� ��� ���� � ���������

void add();
void print(bool);
void num_st();

int main(){
    SetConsoleCP(1251);     //����������
    SetConsoleOutputCP(1251);

    int ans;
    cout << "������ ����!!" << endl;
    for(;;){
        cout << "\n1.������ ����� �������\n2.������� ��� �� ��� �������\n3.������� ��� �� ��� ��������\n4.ϳ��������� ������� ������ � ��� ��������\n5.�����\n";
        ans=cin_valid();
        switch(ans){
            case 1: add(); break;
            case 2: if(books==0) cout << "������ ������\n"; else print(0); break;
            case 3: if(magazines==0) cout << "������� ������!\n"; else print(1); break;
            case 4: if(magazines==0) cout << "������� ������!\n"; else num_st(); break;
            case 5: cout << "�� ���������!!"; delete[] List; return 0;
            default: cout << "����������� ��������!!!" << endl;
        }
    }
}
void add(){     //��������� ��������
    int change;//��� ������

    N++;
    if(N==1)
        List=new library[N];    //������ ��������
    else{
        library* Temp=new library[N];   //������ ����������
        for(int i=0; i<N-1; i++)
            Temp[i]=List[i];
        delete[] List;
        List=Temp;
    }

    cout << "�� �� ��������� ������?:\n1.�����\n2.������" << endl;
    for(;;){
        change=cin_valid();                                 //����� �����/������
        if((change!=1)&&(change!=2))
            cout << "����������� ��������!!!" << endl;
        else break;
    }

    cout << "������ ��� ���:\n�����: ";
    cin >> List[N-1].name;
    cout << "г� �������: ";                //���� ����� ������
    List[N-1].year=cin_valid();
    cout << "�-��� �������: ";
    List[N-1].pages=cin_valid();
    if(change==1){      //���� ���������� ������ �����
        cout << "�����: ";
        cin.ignore(); cin.getline(List[N-1].type.author, 30);   //��� ���������� ����
        List[N-1].flag=true;
        books++;
    }
    else{   //���� ���������� ������ �������
        cout << "������: ";
        cin.ignore(); cin.getline(List[N-1].type.magazine.issue, 30);
        cout << "�-��� ������: ";
        List[N-1].type.magazine.states=cin_valid();
        List[N-1].flag=false;
        magazines++;
    }
    cout << "��� ������!!!" << endl;
}
void print(bool Case){      //������ ������ �� ����� ����������
    cout << "�����\t\tг� �������\t�-��� �������\t";
    if(Case==0)cout << "�����\n";
    else cout << "������\t�-��� ������\n";

    for(int i=0; i<N; i++){
        if(Case==0){
            if(List[i].flag==true){//�������� �� ��, ��� ������ ������� �������� ������
                cout << List[i].name;
                if(List[i].name.size()<8)cout<<"\t\t";  //�������� ���������
                else cout<<"\t";
                cout << List[i].year << "\t\t" << List[i].pages << "\t\t" << List[i].type.author;
            }else continue;
        }
        else{
            if(List[i].flag==false){//�� ��������
                cout << List[i].name;
                if(List[i].name.size()<8)cout<<"\t\t";      //�������� ���������
                else cout<<"\t";
                cout << List[i].year << "\t\t" << List[i].pages << "\t\t" << List[i].type.magazine.issue << "\t" << List[i].type.magazine.states;
            }else continue;
        }
        cout << endl;
    }

}
void num_st(){  //������� ���-�� ������
    int result=0;
    for(int i=0; i<N; i++)
        if(List[i].flag==false)
            result+=List[i].type.magazine.states;
    cout << "�-��� ������ � ��� ��������: " << result << endl;
}
