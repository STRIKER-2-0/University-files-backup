#include <iostream>
#include <clocale>
#include <cstdlib>
#include <ctime>
#include <cmath>

using namespace std;
int N=0;

struct device{
    int number;
    char name[20];          //�������� ��������� � ������
    int year;
    double cost;
};
device* List;
device* Temp;

int check_number(int x){    //�������� ��  ������������ ������
    for(int i=0; i<N; i++)
        if((x==List[i].number)&&(i!=N-1))
            return 1;
    return 0;
}

int volid(){                //�������� �� ��� ������
    char volname[20];
    int result;
    bool flag=true;
    do{
        result=0;
        cin >> volname;
        for(int i=0; volname[i]!='\0'; i++){
            if((volname[i]<'0')||(volname[i]>'9')){
                cout << "������������ ��������!! ��������� �������: ";
                flag=false;
                break;
            }
            else{
                result=result*10+(volname[i]-48);
                flag=true;
            }
        }
    }while(!flag);
    return result;
}

double volid_double(){          //�������� ��� ����
    char volname[20];
    double result=0.0;
    bool flag=false;
    int dot=0;

    while(!flag){
        cin >> volname;
        for(int i=0; volname[i]!='\0'; ++i){
            if((volname[i]<'.')||(volname[i]>'9')||(volname[i]=='/')){
                cout << "�������� ��������!!! ��������� �������: ";
                flag=false;
                break;
            }
            else flag=true;
        }
    }
    for(; volname[dot]!='.'; ++dot){}
    --dot;
    for(int i=0; volname[i]!='\0'; ++i){
        if(volname[i]=='.')i++;

            result+=(volname[i]-48)*pow(10,dot);
            dot--;

    }
    return result;
}

void add(int x){   //������� ���������� �������
        N++;
        if(x==1){
            Temp=(device*)malloc(sizeof(device)*N);
            for(int i=0; i<N; i++)
            Temp[i]=List[i];
            free(List);                                     //1-� �����: ������ � ���. �������
        }
        List=(device*)malloc(sizeof(device)*N);
        if(x==1){
            for(int i=0; i<N; i++)
                List[i]=Temp[i];
            free(Temp);
        }
                                                                //2-� �����: ���� ������
        cout << "������� ������ ������ �������:\n������������: ";
        cin.ignore(); cin.getline(List[N-1].name, 20);  //������� ��� ����� ���������� ���� ����� ������ �� ������
        cout << "����������� �����(�������� �� ����): ";
        List[N-1].number=volid();       //������ ��������� ������ �������, �������� ��������
        while((check_number(List[N-1].number)==1)||(List[N-1].number<=0)){  //�������� �� ����������� ������
            while(List[N-1].number<=0){
                cout << "������� ��������, ������� ����!!" << endl;
                List[N-1].number=volid();
            }
            while(check_number(List[N-1].number)==1){
                cout << "����� ����� ��� ����! ���������� ��� ���: " << endl;
                List[N-1].number=volid();
            }
        }
        cout << "��� ������������: ";
        List[N-1].year=volid();
        while(List[N-1].year>2019){
            cout << "����������� ��������: ��� ������� ������ ��������!! ��������� �������: ";
            List[N-1].year=volid();
        }
        cout << "����: ";
        List[N-1].cost=volid_double();
        cout << "\n������ ��������!!" << endl;
}

void print(){   //����� ������
    cout << "C����� ��������� ��������:\n�����   ������������   ��� ������.    ����" << endl;
    for(int i=0; i<N; i++)
    cout  << List[i].number <<"\t"<< List[i].name <<"\t\t"<< List[i].year <<"\t   "<< List[i].cost << endl;
}

void syear(){   //����� �� ����
    int year,check=0;
    cout << "������� ��� ������������: ";
    cin >> year;
    cout << "�������, ��������� �� ���� �������:\n�����   ������������   ��� ������.    ����" << endl;
    for(int i=0; i<N; i++)
        if(List[i].year==year){
            cout  << List[i].number <<"\t"<< List[i].name <<"\t\t"<< List[i].year <<"\t   "<< List[i].cost << endl;
            check++;
        }
    if(check==0) cout << "�� ������ ������� �� ������ ���� �� �������!!\n\n";
}

void scost(){       //����� �� ����
    int minc,maxc,check=0;
    cout << "������� �������� ���: � "; cin >> minc; cout << " �� "; cin >> maxc;
    cout << "�������, ��������� �� ������� �������� ���:\n�����   ������������  ��� ������.  ����" << endl;
    for(int i=0; i<N; i++)
        if((List[i].cost>=minc)&&(List[i].cost<=maxc)){
            cout  << List[i].number <<"\t"<< List[i].name <<"\t\t"<< List[i].year <<"\t   "<< List[i].cost << endl;
            check++;
        }
    if(check==0) cout << "�� ������ ������� � ������ ��������� ��� �� �������!!\n\n";
}

void maxcost(){     //����� ������� ������
    int Max=0,res;
    for(int i=0; i<N; i++)
        if(List[i].cost>Max){
            Max=List[i].cost;
            res=i;
        }
    cout  << "����� ������� ������:\n�����   ������������   ��� ������.    ����\n" << List[res].number <<"\t\t"<< List[res].name <<"\t\t"<< List[res].year <<"\t   "<< List[res].cost << endl;
}

void del(){         //�������� ��������
    int number,check=0;
    cout << "������� ����������� ����� �������(������� 0 ��� �� �������� �������): ";
    cin >> number;
    if(number!=0){
        for(int i=0; i<N; i++){
            if(List[i].number==number){
                for(int j=i; j<N-1; j++)
                    List[j]=List[j+1];
                N--;
            check++;
            }
        }
        if(check==0){
            cout << "�������������� ���������� �����!" << endl;
            del();
        }
        else
            cout << "\n������ ������!!\n";
    }
    else
        cout << "\n�������� ��������\n";
}

int attention(){        //�������� �� ����������� �������� � ������
    if(N==0){
        cout << "��� ��������� ��������!!" << endl;
        return 0;
    }
    return 1;
}

int main(){
    system("chcp 1251"); //������� ����� ��� ��������
    int ans;
    cout << "\t\t---������������� ������ ��������---\n1.�������� ������\n2.�����\n";
    cin >> ans;
    while((ans!=1)&&(ans!=2)){
        cout << "������������ ��������!! ���������� ��� ���--> ";
        cin >> ans;
    }
    if(ans==1)
        add(0);
    else{
        cout << "�������� ���!!!";
        return 0;
    }
    for(;;){        //�������
        cout << "\n�������� ���������� ��������:\n1.�������� ����� ������\n2.�������� ������ ��������\n3.����� �������� �� ���� ������������\n4.����� �������� � ��������� ���\n5.����� ������ �������� �������\n6.������� ������ �� ������\n7.�����\n" << endl;
        cin >> ans;
        switch(ans){
            case 1: add(1); break;
            case 2: if(attention()==0)continue;
                    print(); break;
            case 3: if(attention()==0)continue;
                    syear(); break;
            case 4: if(attention()==0)continue;
                    scost(); break;
            case 5: if(attention()==0)continue;
                    maxcost(); break;
            case 6: if(attention()==0)continue;
                    del(); break;
            case 7: free(List); cout << "�������� ���!!!"; return 0;
            default: cout << "�������� ��������!!!" << endl;
        }
    }
    return 0;
}
