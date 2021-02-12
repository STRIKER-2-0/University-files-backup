#include <iostream>

using namespace std;

int main()
{
    int x,y,z,result; //a) Объявить переменные x, y, z и result типа int.
    cout << "Enter three integer numbers: \n";//b) Предложить пользователю ввести три целых числа.
    cin >> x >> y >> z; //c) Прочитать три целых числа с клавиатуры и сохранить их в переменных x, y и z.
    result=x*y*z;//d)Вычислить произведение трех целых чисел, содержащихся в переменных x,y,z и присвоить результат переменной result.
    cout << "result is: " << result << endl; //e) Напечатать «Result is » и затем значение переменной result.
    return 0; //f) Возвратить из функции main значение, свидетельствующее об успешном завершении программы.

}

