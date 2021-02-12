#include <iostream>
#include <clocale>
#include <cmath>

using namespace std;

long double fact(int N){
    if(N<0) // ���� ������������ ���� ������������� �����
        return 0; // ���������� ����
    if(N==0) // ���� ������������ ���� ����,
        return 1; // ���������� ��������� �� ���� - 1
    else // �� ���� ��������� �������
        return N*fact(N-1); // ������ ��������.
}

long double sum(double x, double lim){ //������� sum ���������� �������� ���������� � �������� �����
    double e=0;
    for(int k=0; (pow(x,k)/fact(k))>=lim; ++k)
        e=e+pow(x,k)/fact(k);
    return e;

}

long double delta(float x,double lim){//������ delta ���������� �������� �������� ���� � ���������� ������� ����������
    return exp(x)-sum(x,lim);
}

int main(){
    setlocale(0,""); // �������� ���������

    double lim;
    cout << "������� �������� �����������: ";
    cin >> lim;
    cout <<  "x\tsum\texp\tdelta\n-------------------------------\n";  //�������� �������
    for (float x=0; x<2.1; x+=0.1){                          //� ����� ������ ���������� �������� �� ������� ��� ������ �������
        cout << x <<"\t"<< sum(x,lim) <<"\t"<< exp(x) <<"\t"<< delta(x,lim) << endl;
    }
    return 0;
}
