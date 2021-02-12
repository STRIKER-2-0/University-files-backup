#include <iostream>
#include <clocale>
#include <cmath>

using namespace std;

long double fact(int N)
{
    if(N<0) // ���� ������������ ���� ������������� �����
        return 0; // ���������� ����
    if(N==0) // ���� ������������ ���� ����,
        return 1; // ���������� ��������� �� ���� - 1
    else // �� ���� ��������� �������
        return N*fact(N-1); // ������ ��������.
}

int main(){
    setlocale(0,""); // �������� ���������
    double lim=0.0001,e=0,x;
    cout << "������� �������� �: ";
    cin >> x;

    for(int k=0; (1/fact(k))>=lim; ++k) //���� ������� ���������, �� � ���������, �� �� ���������
        e=e+pow(x,k)/fact(k);

    cout <<  "�^x=" << e;
    return 0;
}
