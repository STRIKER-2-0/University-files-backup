#include <iostream>
#include <clocale>

using namespace std;

int main(){
    setlocale(LC_CTYPE, "rus");

    int n,res=0,k=0;
    cout << "������� ���-�� ��������� �������: ";
    cin >> n;
    int mass[n];
    cout << "������� ������: ";
    for(int i=0; i<n; ++i)
        cin >> mass[i];

    for(int i=n; i>=0; --i){
        if(mass[i]==0){
            for(int j=i; j<n; ++j){
                res+=mass[j];
                ++k;
            }
        }
    }
    if(k==0)
        cout << "������! ����������� ������� �������� ���� ��� ��������=0";

    else
        cout <<"����� ��������� �������, ������������� ����� ���������� ��������, ������� ����: "<< res;

    return 0;

}
