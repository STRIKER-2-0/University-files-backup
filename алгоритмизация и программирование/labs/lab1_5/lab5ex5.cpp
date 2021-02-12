#include <iostream>
#include <clocale>
#include <cmath>

using namespace std;

int Mpow(int k,int m){//���������� ������������ ������� ����� k, � ������� ��� �� ��������� m
    int res=0;
    while(pow(k,res)<=m)
        ++res;
    return res-1;

}

int main(){
    setlocale(0,""); // �������� ���������
    int N,k,n,d;
    cout << "������� �����: ";
    cin >> N;
    cout << "������� ��������� ������� ��������� ��� ��������(�� 2 �� 16): ";
    cin >> k;
    if((k<2)||(k>16)){
        cout << "������������ �������� ��������� ������� ����������!!!!";
        return 0;
    }

    n=Mpow(k,N);
    cout << "����� � ����� ������� ����������: ";
    while(n>=0){
        d=N/pow(k,n);
        if(d>=10){
            switch(d){
                case 10: cout << "a"; break;
                case 11: cout << "b"; break;
                case 12: cout << "c"; break;
                case 13: cout << "d"; break;
                case 14: cout << "e"; break;
                case 15: cout << "f"; break;
            }
        }
        else
            cout << d;
        N=N-d*pow(k,n);
        n=n-1;
    }
    return 0;
}
