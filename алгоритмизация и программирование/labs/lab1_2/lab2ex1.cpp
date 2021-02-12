#include <iostream>
#include <clocale>
using namespace std;

int main()
{
    setlocale(LC_CTYPE, "rus");//русский текст в консоли
    cout << "Добро пожаловать в С++! \n";
    return 0;

}

