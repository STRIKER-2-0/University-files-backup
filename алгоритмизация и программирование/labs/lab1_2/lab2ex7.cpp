#include <iostream>

using namespace std;

int main()
{
    int number,digit;
    cout << "Enter a three figures number: \n";
    cin >> number;                    //ввод числа
    if(number/100>=1&&number/100<=9){   //проверка на трехзначность
        digit=number/100;
        cout << digit << "\n";
        digit=number/10%10;
        cout << digit << "\n";
        digit=number%10;
        cout << digit << "\n";
    }

    else
        cout << "There isn't three figures number!!!";
    string z="hello";
    cout << z;
    return 0;
}

