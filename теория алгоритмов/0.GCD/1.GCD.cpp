//Greatest Common Divisor. ����������� ��������� ���������� � ��������� ��������.
#include <iostream>
#include <clocale>
#include <My_library.h>

using namespace std;

int gcd_1(int a, int b){    //���������� � ����� ��������� ����� - �������
    if(a==0)return b;
    if(b==0)return a;

    int nod=1;

    for(int i=min(a,b); i>1; i--){
        if((a%i==0)&&(b%i==0)){
            nod=i;
            break;
        }
    }
    return nod;
}

int gcd_2(int a, int b){    //����������� ����� ���������� �� ���������
    if(a==0)return b;
    if(b==0)return a;

    int nod=1;

    while((a>1)&&(b>1)){
        for(int i=2; i<=min(a,b); i++){
            if((a%i==0)&&(b%i==0)){
                nod*=i;
                a/=i;
                b/=i;
                break;
            }
            if(a%i==0){
                a/=i;
                break;
            }
            if(b%i==0){
                b/=i;
                break;
            }
        }
    }
    return nod;
}

int gcd_3(int a, int b){    //����������� ������� �������
    if(a==0)return b;
    if(b==0)return a;

    if(a==b)
        return a;
    if(a>b)
        swap(a,b);
    return gcd_3(a, b-a);
}

int gcd_4(int a, int b){
    if(a==0)
        return b;
    if(b==0)
        return a;
    if(a==b)
        return a;
    if((a==1)||(b==1))
        return 1;

    if((a%2==0)&&(b%2==0))
        return 2*gcd_4(a/2, b/2);
    if((a%2==0)&&(b%2!=0))
        return gcd_4(a/2, b);
    if((a%2!=0)&&(b%2==0))
        return gcd_4(a, b/2);
    if(a<b)
        return gcd_4((b-a)/2, a);
    else
        return gcd_4((a-b)/2, b);
}

int main(){
    setlocale(LC_CTYPE, "rus");
    int a,b;

    while(true){
        cout << "\n***������� ������������� ����� ��� �� ���������***\n������� a � b: ";
        a=cin_valid(); if(a<0)break;
        b=cin_valid();
        cout << "\t���(a,b): \n���������: " << gcd_1(a,b) << "\n����������� �� ���������: " << gcd_2(a,b) << "\n���������� �������: " << gcd_3(a,b) << "\n�������� ���������� �������: " << gcd_4(a,b) << endl;
    }
    return 0;
}
