#include <iostream>

using namespace std;

int main()
{
    int x,y,z,result; //a) �������� ���������� x, y, z � result ���� int.
    cout << "Enter three integer numbers: \n";//b) ���������� ������������ ������ ��� ����� �����.
    cin >> x >> y >> z; //c) ��������� ��� ����� ����� � ���������� � ��������� �� � ���������� x, y � z.
    result=x*y*z;//d)��������� ������������ ���� ����� �����, ������������ � ���������� x,y,z � ��������� ��������� ���������� result.
    cout << "result is: " << result << endl; //e) ���������� �Result is � � ����� �������� ���������� result.
    return 0; //f) ���������� �� ������� main ��������, ����������������� �� �������� ���������� ���������.

}

