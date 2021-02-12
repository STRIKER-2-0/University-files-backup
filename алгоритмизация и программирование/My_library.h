#include <iostream>
#include <cmath>

using namespace std;

double cin_valid(){
    char volname[30];
    double result=0.0;
    bool flag=false;
    int dot=0;
    //dot ����� ��������� � �������� ����������� ������� �����, ���� �� � �������� ��������� �����

    while(!flag){   //���� ��������� ������ ����� � �����, ��� ���������� ������ �������� ������������ ������� ��������� ����
        cin >> volname;
        for(int i=0; volname[i]!='\0'; ++i){
            if((volname[i]<'-')||(volname[i]>'9')||(volname[i]=='/')||((volname[i]=='-')&&(i!=0))){
                cerr << "Invalid type of value!!! Try again: ";
                flag=false;
                break;
            }
            else flag=true;
        }
    }

    for(; (volname[dot]!='.')&&(volname[dot]!='\0'); ++dot){}
    //����������� �������������� �����, ���� ��, ���� � ���, ����������� �����

    for(int i=0; volname[i]!='\0'; ++i){
        if(volname[i]=='-'){//� ������ ��������������, ������� � ���������� �������(���� ������ � ������)
            i++;
            dot--;
        }
        if(volname[i]=='.')i++;

        result+=(volname[i]-48)*pow(10,dot-1);
        dot--;
    }
    if(volname[0]=='-')//���� ����� ����, ������ ����� �������������
            result=result*(-1);

    return result;
}
void while_neg(int n){      //���������� �������������
    while(n<=0){
        cout << "Invalid value!!! Try again: ";
        n=cin_valid();
    }
}

