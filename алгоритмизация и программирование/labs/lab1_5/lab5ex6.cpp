#include <iostream>
#include <clocale>

using namespace std;

int main(){
    setlocale(LC_CTYPE, "rus");
    int N;
    cout << "������� N: ";
    cin >> N;
    for(int i=2; i<N; ++i){
        if(N%i==0){
            cout << "����� N - ���������. ���������� ����������� ��������, �������� �� �������: " << i;
            return 0;
        }

    }
    cout << "����� N - �������";
    return 0;
}
