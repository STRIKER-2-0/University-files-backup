#include <iostream>
#include <clocale>
#include <cstdlib>
#include <ctime>

using namespace std;
int n;  //���������� �������� �����
int m;  //���������� �������� ��������
int** arr;  //������������ ������

void create(){ //������ �������� ���. �������
    cin >> n >> m;
    arr=(int**)malloc(n*(sizeof(int*)));
    for(int i=0; i<n; ++i)
        arr[i]=(int*)malloc(m*(sizeof(int)));
}

int ans(){  //�������, ����������� ������ ����� �� �������� � ���������� ���
    srand(time(0));
    short a; cin >> a;
    switch(a){
        case 1: for(int i=0; i<n; ++i)
                    for(int j=0; j<m; ++j)
                            cin >> arr[i][j]; break;
        case 2: for(int i=0; i<n; ++i)
                    for(int j=0; j<m; ++j)
                            arr[i][j]=rand()%20; break;
        default: cout << "�������� ��������!!!"; return 1;
    }
    for(int i=0; i<n; ++i){
        for(int j=0; j<m; ++j)
            cout << arr[i][j] << " ";
        cout << endl;
    }
}
int norm(){ //�������, ��������� �����
    int res=0,x;
    for(int i=0; i<n; ++i){
        x=0;
        for(int j=0; j<m; ++j)
            x+=arr[i][j];
        if(x>res)
            res=x;
    }
    return res;
}
int main(){
    setlocale(LC_CTYPE, "rus");
    cout << "������� ���������� ����� � �������� � �������: ";
    create();
    cout << "��� ��������� �������?:\n1.������ � ����������.\n2.���������� �������.\n";
    if(ans()==1)return 0;
    cout << "����� �������� �������: " << norm();

    for(int i=0; i<n; ++i)  //������� ������
        free(arr[i]);
    free(arr);
    return 0;
}
