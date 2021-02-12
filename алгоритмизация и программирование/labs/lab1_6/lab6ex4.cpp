#include <iostream>
#include <clocale>
#include <cstdlib>
#include <ctime>
#include <windows.h>

using namespace std;

void menu(){ //������� ��� ������ ������ ������
    cout << "\n\t��������:\n\t1. �������� ������.\n\t2. ��������.\n\t3. �������\n\t4. �����.\n";
}

int prov(int a){//�������� ��������� ��������
    if((a>20)||(a<0)){
            cout << "\t�������� ��������!\n";
            system("pause");
            return 1;
    }
    return 0;
}

int main(){
    setlocale(LC_CTYPE, "rus");
    srand(time(0));
    //������ ������ ������ � ��������� ������ 4 ������ ���������� ����������
    int mass[20]; int maj=3;
    for(int i=0; i<20; ++i)
        mass[i]=0;
    for(int i=0; i<=maj; ++i)
            mass[i]=rand()%20 + 1;
    for(int i=0; i<=maj; ++i){
        for(int j=0; j<=maj; ++j)
            if((i!=j)&&(mass[i]==mass[j]))
                mass[j]=rand()%20 + 1;
    }



    int ans,elem,pos; //���������� ��� �������, �������� � �������
    int x,y; //����������� ���������� ��� ����������� � ������� ��������� �������
    while(1){
        menu(); cin >> ans; //����
        x=0,y=0;
        switch(ans){
            case 1: cout << "\n\t������: \n";   //����� ������ ���������
                    for(int i=0; i<=maj; ++i)
                        cout << "\t" << i+1 << ". " << mass[i] << endl;
                    system("pause");
                    break;
            case 2: for(int i=0; i<20; ++i){ //���������� ��������
                        if(mass[i]!=0)
                        ++y;
                    }
                    if(y==19){ //�������� �� �������������
                        cout << "��� ������ ������!\n";
                        system("pause");
                        break;
                    }

                    cout << "\t������� �������: "; cin >> elem; if(prov(elem)==1)continue; // �������� � �������� ��������
                    for(int i=0; i<20; ++i){
                        if((elem==mass[i])&&elem!=0){
                            cout << "\t����� ������� ��� ����!\n";
                            x=1;
                            system("pause");
                            break;
                        }
                    }
                    if(x==1)continue;
                    cout << "\t������� �������: "; cin >> pos; if(prov(pos)==1)continue; // �������� � �������� �������
                    if((pos-1)>maj){ // ���������� ��������
                            mass[pos-1]=elem;
                            maj=pos-1;
                    }
                    else if(((pos-1)<maj)&&(maj==19)){ //� ������, ���� ���� ������� �������� � ������ �������
                        for(y=0; mass[y]!=0; y++){}
                        for(int i=y; i>=pos-1; --i)
                            mass[i+1]=mass[i];
                        mass[pos-1]=elem;
                    }
                    else{ //� ����������� ������
                        for(int i=maj; i>=pos-1; --i)
                            mass[i+1]=mass[i];
                        mass[pos-1]=elem;
                        ++maj;
                    }
                    cout << "\t������� ��������!\n";
                    system("pause");
                    break;
            case 3: cout << "\t������� ����� ��������: \n"; cin >> pos; if(prov(pos)==1)continue; //�������� ���������
                    if(pos==20){
                        mass[19]=0;
                        while(mass[maj]==0)
                            --maj;
                    }
                    else{
                        for(int i=pos-1; i<19; ++i)
                            mass[i]=mass[i+1];
                        mass[19]=0;
                        while(mass[maj]==0)
                            --maj;
                    }
                    cout << "\t������� �����!\n";
                    system("pause");
                    break;
            case 4: cout << "\t�������� ���!\n\n"; return 0; //����� �� ���������
            default: cout << "\t�������� ��������!\n"; system("pause");
        }
    }
}
