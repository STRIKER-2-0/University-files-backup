#include <iostream>
#include <clocale>

using namespace std;

int sim(int N){//������� sim ����������, �������� �� �������� ����� �������
     for(int i=2; i<N; ++i){
        if(N%i==0)
           return 1;
    }
    return 0;
}

int main(){
    setlocale(LC_CTYPE, "rus");
    int N;
    cout << "������� ������� ��������� ������ �������: ";
    cin >> N;
    cout << "��� ������� ����� �� ���������: ";
    for(int i=2; i<=N; ++i){ //���������� ��� ����� �� ��������� � ������ �������...
        if(sim(i)==0)
            cout << i << " ";
    }

    return 0;
}
