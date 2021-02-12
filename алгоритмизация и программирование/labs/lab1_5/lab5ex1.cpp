#include <iostream>
#include <clocale>

using namespace std;

long double fact(int N)
{
    if(N<0) // ���� ������������ ���� ������������� �����
        return 0; // ���������� ����
    if(N==0) // ���� ������������ ���� ����,
        return 1; // ���������� ��������� �� ���� -  1
    else // �� ���� ��������� �������
        return N*fact(N-1); // ������ ��������.
}

int main(){
    setlocale(0,""); // �������� ���������
    double lim=0.0001; //����� ������
    double e=0;
    for(int k=0; (1/fact(k))>=lim; ++k)
        e=e+1/fact(k);
    cout << "����� �=" << e;

    return 0;
}
