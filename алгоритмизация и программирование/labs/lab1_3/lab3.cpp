#include <iostream>

using namespace std;

int main()
{
    int i;
    unsigned int ui;
    char ch;
    unsigned char uch;
    float f;
    double d;
    short sh;
    long l;
    long long L=10000000000000000000000000000000000000000000000000000;
    long double ld;
    cout << "size of int is: " << sizeof(i) << "\n" << "size of  unsigned int is: " << sizeof(ui) << "\n" << "size of char is: " << sizeof(ch) << "\n" << "size of  unsigned char is: " << sizeof(uch) << "\n" << "size of float is: " << sizeof(f) << "\n" << "size of double is: " << sizeof(d) << "\n" << "size of short is: " << sizeof(sh) << "\n" << "size of long is: " << sizeof(l) << "\n" << "size of long long is: " << sizeof(L) << "\n" << "size of long double is: " << sizeof(ui) << endl;
    cout << L;
    return 0;
}

