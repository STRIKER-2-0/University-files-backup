#include <iostream>
#include <clocale>

using namespace std;

int main(){
    setlocale(LC_CTYPE, "rus");
    int n;
    cout << "������� n: ";
    cin >> n;
    cout << "��� ����������� �������� ����� n: ";
    for(int i=1; i<=n; ++i){
        if(n%i==0)
            cout << i << " ";
    }
    return 0;
}
