#include <iostream>

#include <string>
#include <windows.h>
#include <cmath>

using namespace std;


struct base{
    string vid;
    double haste;
    int old;
};

int N=0;
base* List;


void add();
void print();
void Search();
void sorting();
void Delete();

double cin_valid(){
    char volname[30];
    double result=0.0;
    bool flag=false;
    int dot=0;

    while(!flag){
        cin >> volname;
        for(int i=0; volname[i]!='\0'; ++i){
            if((volname[i]<'-')||(volname[i]>'9')||(volname[i]=='/')||((volname[i]=='-')&&(i!=0))){
                cout << "Invalid type of value!!! Try again: ";
                flag=false;
                break;
            }
            else flag=true;
        }
    }

    for(; (volname[dot]!='.')&&(volname[dot]!='\0'); ++dot){}


    for(int i=0; volname[i]!='\0'; ++i){
        if(volname[i]=='-'){
            i++;
            dot--;
        }
        if(volname[i]=='.')i++;

        result+=(volname[i]-48)*pow(10,dot-1);
        dot--;
    }
    if(volname[0]=='-')
            result=result*(-1);

    return result;
}

int main(){
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);

    int ans;
    cout << "Добрий день!!" << endl;
    for(;;){
        cout << "\n1.Додати нову тварину\n2.Друк всього списку\n3.Пошук найповільнішої тварини\n4.Видалення тварини\n5.Вихід\n";
        ans=cin_valid();
        switch(ans){
            case 1: add(); break;
            case 2: if(N==0) cout << "Тварини відсутні\n"; else print(); break;
            case 3: if(N==0) cout << "Тварини відсутні\n"; else Search(); break;
            case 4: if(N==0) cout << "Тварини відсутні\n"; else Delete(); break;
            case 5: cout << "До побачення!!"; delete[] List; return 0;
            default: cout << "Неправильне значення!!!" << endl;
        }
    }
}

void add(){
    N++;
    if(N==1)
        List=new base[N];
    else{
        base* Temp=new base[N];
        for(int i=0; i<N-1; i++)
            Temp[i]=List[i];
        delete[] List;
        List=Temp;
    }

    cout << "Введіть дані нової тварини:\nВид: ";
    cin >> List[N-1].vid;
    cout << "Швидкість: ";
    List[N-1].haste=cin_valid();
    while(List[N-1].haste<=0){
        cout << "Некорректні дані!!Спробуйте ще: ";
        List[N-1].haste=cin_valid();
    }
    cout << "Вік: ";
    List[N-1].old=cin_valid();
    while(List[N-1].old<0){
        cout << "Некорректні дані!!Спробуйте ще: ";
        List[N-1].old=cin_valid();
    }

    cout << "Дані додано!!!" << endl;
    sorting();
}

void sorting(){
    base Temp;
    for(int j=0; j<N; j++)
        for(int i=0; i<N-1; i++)
            if(List[i].vid>List[i+1].vid){
                Temp=List[i];
                List[i]=List[i+1];
                List[i+1]=Temp;
            }
}

void print(){
    cout << "Номер\tВид\t\tШвидкість\tВік\n";
    for(int i=0; i<N; i++){
        cout << i+1 << ".\t" << List[i].vid;
        if(List[i].vid.size()>=8)cout<<"\t";
        else cout << "\t\t";
        cout << List[i].haste << "\t\t" << List[i].old << endl;
    }
}

void Search(){
    double Min=100000;
    int pos;
    for(int i=0; i<N; i++)
        if(List[i].haste<Min){
            Min=List[i].haste;
            pos=i;
    }
    cout << "Найповільніша тварина знайдена:\nНомер\tВид\t\tШвидкість\tВік\n";
    cout << pos+1 << ".\t" << List[pos].vid;
    if(List[pos].vid.size()>=8)cout<<"\t";
    else cout << "\t\t";
    cout << List[pos].haste << "\t\t" << List[pos].old << endl;
}

void Delete(){
    int pos;

    cout << "Вкажіть номер тварини, якого бажаєте видалити(введіть 0 щоб скасувати): ";
    pos=(unsigned int)cin_valid();
    if(pos==0){
        cout << "Скасовано!!\n"; return;
    }
    while((pos>N)||(pos<0)){
        cout << "Такий номер відсутній!!\n";
        pos=(int)cin_valid();
    }

    pos--;
    N--;
    base* Temp=new base[N];
    for(int i=0; i<pos; i++)
        Temp[i]=List[i];
    for(int i=pos+1; i<N+1; i++)
        Temp[i-1]=List[i];

    delete[] List;
    List=Temp;
    cout << "Тварину видалено!!" << endl;
}

