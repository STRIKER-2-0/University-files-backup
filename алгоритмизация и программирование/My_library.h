#include <iostream>
#include <cmath>

using namespace std;

double cin_valid(){
    char volname[30];
    double result=0.0;
    bool flag=false;
    int dot=0;
    //dot сдесь выступает в качестве определения разряда числа, либо же в качетсве положения точки

    while(!flag){   //цикл пропустит только цифры и точку, при нахождении других символов предлагается сделать повторный ввод
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
    //определение местоположения точки, либо же, если её нет, разрадности числа

    for(int i=0; volname[i]!='\0'; ++i){
        if(volname[i]=='-'){//в случае отрицательного, пропуск и уменьшение разряда(учет минуса в ячейке)
            i++;
            dot--;
        }
        if(volname[i]=='.')i++;

        result+=(volname[i]-48)*pow(10,dot-1);
        dot--;
    }
    if(volname[0]=='-')//если минус есть, делаем ответ отрицательным
            result=result*(-1);

    return result;
}
void while_neg(int n){      //валидность отрицательных
    while(n<=0){
        cout << "Invalid value!!! Try again: ";
        n=cin_valid();
    }
}

