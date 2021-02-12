#include <iostream>
#include <cmath>
#include <cstdlib>
#include <ctime>

using namespace std;

int N;
int* arr;
int* arr2;

void create(){
    srand(time(0));
    cout << "������� ������ �������: ";
    cin >> N;
    arr=(int*)malloc(N*sizeof(int));
    for(int i=0; i<N; ++i)
        arr[i]=rand()%9;
    cout << "������ ������!!" << endl;
}

void print(){
    cout << "��� ������: ";
    for(int i=0; i<N; ++i)
        cout << arr[i] << " ";
}

void addpoint(int x){
    if(x==0)N++;else N--;
    int pos;
    cout << "������� ������� ������: ";
    cin >> pos; pos--;

    arr2=(int*)malloc((N)*sizeof(int));
    for(int i=0; i<pos; ++i)
        arr2[i]=arr[i];
    if(x==0)
        for(int i=pos+1; i<N; ++i)
            arr2[i]=arr[i-1];
    else
        for(int i=pos; i<N; ++i)
            arr2[i]=arr[i+1];

    free(arr);

    arr=(int*)malloc((N)*sizeof(int));

    for(int i=0; i<N; ++i)
        arr[i]=arr2[i];
    free(arr2);

    if(x==0)arr[pos]=0;
    if(x==0)
        cout << "������ ���������!!";
    else
        cout << "������ �������!!";
}

void addnumbers(int x){
    int beg,fin;
    cout << "������� �������� ��������: � "; cin >> beg; cout << " �� "; cin >> fin;
    if(x==0){
        for(int i=beg-1; i<=fin-1; i++)
            arr[i]=0;
        cout << "�������� �������!" << endl;
    }
    else{
        cout << "������� ��������: ";
        for(int i=beg-1; i<=fin-1; i++)
            cin >> arr[i];
        cout << "�������� ���������!" << endl;
    }
}

int menu(){

    int ans;
    cout << "\n�������� ��������:\n\t1.���������� ������\n\t2.�������� ������\n\t3.�������� ������\n\t4.������� �������� �������� �� �������\n\t5.�������� �������� �������� � ������\n\t6.�����\n";
    cin >> ans;
    switch(ans){
        case 1: print(); break;
        case 2: addpoint(0); break;
        case 3: addpoint(1); break;
        case 4: addnumbers(0); break;
        case 5: addnumbers(1); break;
        case 6: cout << "�������� ���!!!"; return 0;
        default: cout << "������������ ��������!!!";
    }
}
int psevdomenu(){
    int ans=0;
    cout << "1.������� ������\n2.�����\n";
    cin >> ans;
    switch(ans){
        case 1: create(); return 1;
        case 2: cout << "�������� ���!!!"; return 0;
        default: cout << "������������ ��������!!!"; psevdomenu();
    }
}

int main(){
    setlocale(LC_ALL,"russian");
    cout << "\t\t---��������� ������ ������---\n";
    if(psevdomenu()==0)return 0;
    while(menu()!=0){}

    free(arr);
    return 0;
}
