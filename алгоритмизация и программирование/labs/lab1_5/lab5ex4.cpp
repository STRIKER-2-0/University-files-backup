#include <iostream>
#include <clocale>
#include <cmath>

using namespace std;

long double sum(double k){//���������� �������� �������� �������� ���� ��� ������ �
    k=1/(2*k+1);
    return k;
}


int main(){
    setlocale(0,""); // �������� ���������

    double lim,res;
    cout << "������� �������� �����������: ";
    cin >> lim;
    for(int k=1; sum(k)>=lim; ++k){ //����������� �������� ����
        res+=sum(k);
    }
    cout << res;

    return 0;
}
