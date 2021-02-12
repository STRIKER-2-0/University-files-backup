#include <iostream>
#include <clocale>

using namespace std;

int NoR(int a){     //������ NoR ���������� ���������� �������� ������� �����
    int s=0;
    for(int k=1; (a/k)!=0; k*=10){
        ++s;
    }
    return s;
}

int PoW(int a){     //������� PoW ���������� �������� ������� �������
    long res=1;
    if(a==0)
        return res;
    for(int i=0; i<a; ++i){
        res*=10;
    }
    return res;
}

int SuM(int a){     //������� SuM ���������� ������� ����� ���� ��������� �����
    int number=0;
    int k=NoR(a)-1;
    for(int i=0; i<=(NoR(a)-1); ++i){
        number=number+a/PoW(k)%10;
        --k;
    }
    number*=number;
    return number;
}

int main(){
    setlocale(LC_CTYPE, "rus");
    int m,n;
    cout << "������� �������� ��������� �������� ����� ����: ";
    cin >> m;
    cout << "�������  �������: ";
    cin >> n;
    cout << "��� �������������� �����: ";
    for(int i=0; i<n; ++i){
        if(SuM(i)==m)
           cout << i << " ";
    }

    return 0;
}
