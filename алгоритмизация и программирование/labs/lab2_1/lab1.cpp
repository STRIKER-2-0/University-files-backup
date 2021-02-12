#include <iostream>
#include <windows.h>
#include <string>
#include <My_library.h>


using namespace std;
int N=0;
const int b=0,s=1,g=2,all=3;
string* country;
int** medals;

void sorting();
void add_medals(int);
void Delete(int);
string check_country();
int input();
int input_first();
void create();
void add();
void print();
void Search();

int main(){
    SetConsoleCP(1251);     //����������
    SetConsoleOutputCP(1251);
    int ans;
    for(;;){
        cout << "\n1.������ ���\n2.������� ��� �� ����\n3.������� ������ �������\n4.�����\n";
        ans=cin_valid();
        switch(ans){
            case 1: if(N==0) create(); else add(); break;
            case 2: if(N==0) cout << "����� ������!\n"; else Search(); break;
            case 3: if(N==0) cout << "����� ������!\n"; else print(); break;
            case 4: cout << "�� ���������!";
                    delete[] country;
                    for(int i=0; i<N; i++)
                        delete[] medals[i];
                    delete[] medals;

                    return 0;
            default: cout << "����������� ��������!" << endl;
        }
    }
}

void create(){      //�������� ���� ������(���� ����������� ��������)
    N++;
    country=new string[N];
    medals=new int*[N];
    for(int i=0; i<N; i++)
        medals[i]=new int[4];
    input_first();
}

int input_first(){       //���� ������ � ������ ����
    cout << "������ ���\n�����: ";
    cin >> country[N-1];
    cout << "ʳ������ �������:\n������: ";
    medals[N-1][b]=(int)cin_valid();
    cout << "�����: ";
    medals[N-1][s]=(int)cin_valid();
    cout << "������: ";
    medals[N-1][g]=(int)cin_valid();
    medals[N-1][all]=medals[N-1][b]+medals[N-1][s]+medals[N-1][g];
    cout << "����� ������ �� ������!!" << endl;
}

void add(){     //���������� ��������
    N++;//���������� ����
    string* tmp_c=new string[N];
    int** tmp_m=new int*[N];
    for(int i=0; i<N; i++)      //�������� ������ �������
        tmp_m[i]=new int[4];

    for(int i=0; i<N-1; i++){
        tmp_c[i]=country[i];
        tmp_m[i][b]=medals[i][b];
        tmp_m[i][s]=medals[i][s];       //������� ��������
        tmp_m[i][g]=medals[i][g];
        tmp_m[i][all]=medals[i][all];
    }

    delete[] country;
    for(int i=0; i<N-1; i++)
        delete[] medals[i];     //�������� �������
    delete[] medals;

    country=tmp_c;      //���������������� ����������
    medals=tmp_m;

    input();
}

int input(){       //���� ������
    string zero="zero";

    cout << "������ ���\n�����: ";
    string answer=check_country();

    if(answer==zero)
        return 0;
    else
        country[N-1]=answer;

    cout << "ʳ������ �������:\n������: ";
    medals[N-1][b]=(int)cin_valid();
    cout << "�����: ";
    medals[N-1][s]=(int)cin_valid();
    cout << "������: ";
    medals[N-1][g]=(int)cin_valid();
    medals[N-1][all]=medals[N-1][b]+medals[N-1][s]+medals[N-1][g];
    cout << "����� ������ �� ������!!" << endl;
    sorting();
}

string check_country(){     //�������� �� ������� ������
    string zero="zero",name;
    cin >> name;
    for(int i=0; i<N; i++)
        if(name==country[i]){
            Delete(i);
            return zero;
        }
    return name;
}

void Delete(int x){     //�������� ������
    N--;
    string* tmp_c=new string[N];
    int** tmp_m=new int*[N];
    for(int i=0; i<N; i++)
        tmp_m[i]=new int[4];

    for(int i=0; i<N; i++){
        tmp_c[i]=country[i];
        tmp_m[i][b]=medals[i][b];
        tmp_m[i][s]=medals[i][s];
        tmp_m[i][g]=medals[i][g];
        tmp_m[i][all]=medals[i][all];
    }

    delete[] country;
    for(int i=0; i<N+1; i++)
        delete[] medals[i];
    delete[] medals;

    country=tmp_c;
    medals=tmp_m;

    add_medals(x);
}

void add_medals(int x){     //���������� ������� � ������������ ������
    cout << "ʳ������ �������:\n������: ";
    medals[x][b]+=(int)cin_valid();
    cout << "�����: ";
    medals[x][s]+=(int)cin_valid();
    cout << "������: ";
    medals[x][g]+=(int)cin_valid();
    medals[x][all]+=medals[x][b]+medals[x][s]+medals[x][g];
    cout << "����� ������!!" << endl;
    sorting();
}

void Search(){      //����� �� ������
    string name;
    bool flag=false;
    cout << "������ ����� �����: ";
    cin >> name;
    for(int i=0; i<N; i++)
        if(country[i]==name){
            cout << "\n��� �� ����� ���� ��������:\n̳���\t�����\t\t������\t�����\t������\t������\n";
            cout << i+1 << ".\t" << country[i];
            if(country[i].size()<8)cout << "\t\t";
            else cout << "\t";
            for(int j=0; j<4; j++)
                cout << medals[i][j] << "\t";
            cout << endl;
            flag=true;
        }
    if(flag==false)
        cout << "����� �� ��������!!!" << endl;
}

void print(){       //������
    cout << "̳���\t�����\t\t������\t�����\t������\t������\n";
    for(int i=0; i<N; i++){
        cout << i+1 << ".\t" << country[i];
        if(country[i].size()<8)cout << "\t\t";
        else cout << "\t";
        for(int j=0; j<4; j++)
            cout << medals[i][j] << "\t";
        cout << endl;
    }
}

void sorting(){         //����������
    string tmp_c;
    int tmp_m[4];
    for(int k=0; k<N; k++)  //����������� ����
        for(int i=0; i<N-1; i++){
            if(medals[i][g]<medals[i+1][g]){    //�� ������
                tmp_c=country[i];
                for(int j=0; j<4; j++)
                    tmp_m[j]=medals[i][j];
                country[i]=country[i+1];
                for(int j=0; j<4; j++)
                    medals[i][j]=medals[i+1][j];
                country[i+1]=tmp_c;
                for(int j=0; j<4; j++)
                    medals[i+1][j]=tmp_m[j];
            }
            else if(medals[i][g]==medals[i+1][g]){  //� ������ ���� �����
                if(medals[i][s]<medals[i+1][s]){    //�� �������
                    tmp_c=country[i];
                    for(int j=0; j<4; j++)
                        tmp_m[j]=medals[i][j];
                    country[i]=country[i+1];
                    for(int j=0; j<4; j++)
                        medals[i][j]=medals[i+1][j];
                    country[i+1]=tmp_c;
                    for(int j=0; j<4; j++)
                        medals[i+1][j]=tmp_m[j];
                }
                else if(medals[i][s]==medals[i+1][s]){  //� ������ ���� �����
                    if(medals[i][b]<medals[i+1][b]){    //�� ������
                        tmp_c=country[i];
                        for(int j=0; j<4; j++)
                            tmp_m[j]=medals[i][j];
                        country[i]=country[i+1];
                        for(int j=0; j<4; j++)
                            medals[i][j]=medals[i+1][j];
                        country[i+1]=tmp_c;
                        for(int j=0; j<4; j++)
                            medals[i+1][j]=tmp_m[j];
                    }
                }
            }
        }
}
