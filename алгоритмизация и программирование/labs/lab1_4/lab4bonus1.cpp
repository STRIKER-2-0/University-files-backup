#include <iostream>
#include <clocale>
#include <cstdlib>
#include <ctime>

using namespace std;


int Rand(int min, int max) {
  srand(time(0));
  return min + rand() % (max - min);
}

int main(){
    setlocale(LC_CTYPE, "rus");
    char ans; int q=Rand(0,100);
    cout << "��������� ����� ����� �� 1 �� 100" << endl;
    cout << "n > " << q << "? (��������� y/n)" << endl;
    cin >> ans;
    if(ans=='y'){
        q=Rand(q,100);
        cout<<q;
    }
    else if(ans=='n'){
        q=Rand(0,q);
    cout<<q;
    }
    else
        cout << "������������ �����!" << endl;
    return 0;
}
