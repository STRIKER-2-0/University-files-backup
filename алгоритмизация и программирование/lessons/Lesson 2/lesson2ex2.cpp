#include <iostream>
#include <cmath>
#include <cstdlib>
#include <ctime>

using namespace std;

int N,M;
int** arr;
int** arr2;

void create(){ //�������� ������������ �������
    srand(time(0));
    cout << "������� ������ �������: ";
    cin >> N >> M;
    arr=(int**)malloc(N*sizeof(int*));
    for(int i=0; i<N; ++i)
        arr[i]=(int*)malloc(M*sizeof(int));
    for(int i=0; i<N; ++i)
        for(int j=0; j<M; ++j)
            arr[i][j]=rand()%9;
    cout << "������ ������!!" << endl;
}

void print(){ //������
    cout << "��� ������: " << endl;
    for(int i=0; i<N; ++i){
        cout << "| ";
        for(int j=0; j<M; ++j)
            cout << arr[i][j] << " ";
    cout << "|" << endl;
    }
}

void add_del_line(int x){ //��������� �����
    if(x==0)N++; else N--;          //����� �������� ������
    int pos;                        //�������� ������� ��� ��������
    cout << "������� ����� ������: ";
    cin >> pos; pos--;//������� � ������� �� ����

    arr2=(int**)malloc(N*sizeof(int*));         //�������� ��������� �������
    for(int i=0; i<N; ++i)
        arr2[i]=(int*)malloc(M*sizeof(int));

    for(int i=0; i<pos; ++i)             //�������� �� �������� �������(���� ��� ������������) ������ ����������
        for(int j=0; j<M; ++j)
            arr2[i][j]=arr[i][j];
    if(x==0) //������ - ������� �� ���������� ��������
        for(int i=pos+1; i<N; ++i)      //��� ����������� ������ ������������� ����� �������
            for(int j=0; j<M; ++j)
                arr2[i][j]=arr[i-1][j];
    else
        for(int i=pos; i<N; ++i)  //��� �������� �������� �
            for(int j=0; j<M; ++j)
                arr2[i][j]=arr[i+1][j];

    if(x==0) for(int i=0; i<N-1; ++i)free(arr[i]); //������� ������� �������(��� �������� ��� ��������)
    else for(int i=0; i<N+1; ++i)free(arr[i]);
    free(arr);

    arr=(int**)malloc(N*sizeof(int*));  //������������� ������� ������� ��� � ����� ��������(����������� ����������)
    for(int i=0; i<N; ++i)
        arr[i]=(int*)malloc(M*sizeof(int));
    for(int i=0; i<N; ++i)              //�������� ������
        for(int j=0; j<M; ++j)
            arr[i][j]=arr2[i][j];

    if(x==0)        //� ������ ���������� �������� ����� ������ ��������
        for(int i=0; i<M; ++i)
            arr[pos][i]=0;

    for(int i=0; i<N; ++i)    //������� ��������� �������
        free(arr2[i]);
    free(arr2);
    if(x==0) cout << "������ ���������!!" << endl;
    else cout << "������ �������!!" << endl;
}
void add_del_column(int x){ //��������� ��������
    if(x==0)M++; else M--;
    int pos;
    cout << "������� ����� �������: ";
    cin >> pos; pos--;

    arr2=(int**)malloc(N*sizeof(int*));
    for(int i=0; i<N; ++i)
        arr2[i]=(int*)malloc(M*sizeof(int));

    for(int i=0; i<pos; ++i)
        for(int j=0; j<N; ++j)
            arr2[j][i]=arr[j][i];
    if(x==0)
        for(int i=pos+1; i<M; ++i)
            for(int j=0; j<N; ++j)
                arr2[j][i]=arr[j][i-1];
    else
        for(int i=pos; i<M; ++i)
            for(int j=0; j<N; ++j)
                arr2[j][i]=arr[j][i+1];

    for(int i=0; i<N; ++i)free(arr[i]); //����� ������ ���� �������
    free(arr);

    arr=(int**)malloc(N*sizeof(int*));
    for(int i=0; i<N; ++i)
        arr[i]=(int*)malloc(M*sizeof(int));
    for(int i=0; i<N; ++i)
        for(int j=0; j<M; ++j)
            arr[i][j]=arr2[i][j];

    if(x==0)
        for(int i=0; i<N; ++i)
            arr[i][pos]=0;

    for(int i=0; i<N; ++i)
        free(arr2[i]);
    free(arr2);
    if(x==0) cout << "������� ��������!!" << endl;
    else cout << "������� �����!!" << endl;
}


int menu(){
    setlocale(LC_ALL,"russian");
    int ans;
    cout << "\n�������� ��������:\n\t1.���������� ������\n\t2.�������� ������\n\t3.������� ������\n\t4.�������� �������\n\t5.������� �������\n\t6.�����\n";
    cin >> ans;
    switch(ans){
        case 1: print(); break;
        case 2: add_del_line(0); break;
        case 3: add_del_line(1); break;
        case 4: add_del_column(0); break;
        case 5: add_del_column(1); break;
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

    for(int i=0; i<N; ++i)
        free(arr[i]);
    free(arr);
    return 0;
}
