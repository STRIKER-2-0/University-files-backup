#include <iostream>
#include <clocale>

using namespace std;


int main(){
    setlocale(LC_CTYPE, "rus");

    int n,k,x=0;
    cout << "������� ������ �������: ";
    cin >> n;
    int mass[n]; //�������� ������
    int mass2[n]; //������� �������� � ����� ���������, ��� �� �� ���������� ��������

    for(int i=0; i<n; ++i) //��������� �������  �������
        mass2[i]=0;

    cout << "������� ������: "; //���� ���������
    for(int i=0; i<n; ++i)
        cin >> mass[i];

    for(int i=0; i<n; ++i){
        k=1;
        for(int j=0; j<n; ++j){
            if((mass[i]==mass[j])&&(i!=j)) //���������, ����� �������� �����������
                ++k;
        }
        if(k<3){      //���������� � ����� ������ ��, ������� ����������� ������ 3 ���
            for(int j=0; j<n; j++){
                    if(mass2[j]==0){
                        mass2[j]=mass[i];
                        ++x;
                        break;
                    }
            }
        }
    }



    cout << "��������, ������� ����������� ������ 3 ���: ";
    for(int i=0; i<x; ++i)                  //���������
        cout << mass2[i] << " ";

    return 0;
}
