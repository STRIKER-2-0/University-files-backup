#include <iostream>
#include <windows.h>
#include <stdio.h>
#include <My_library.h>
#include <cstdio>

using namespace std;
int N=0;

struct product{
    char name[20];
    int Count;
    double price;
};
product* shop;//����� ���������))
product type;//����-���������� ��� ����������
FILE* file;//������ �� ����

void fake(){    //�������� ������
    product fake;
    strcpy(fake.name,"pomidorka");  //���������� � ������ �������� ������ ���!!!
    fake.Count=100;
    fake.price=10.5;

    file=fopen("ex2.bin","ab");
    fwrite(&fake,sizeof(fake),1,file);
    fclose(file);
}

void add(){//���������� ��������
    N++;
    if(N!=1){//����������
        product* temp=new product[N];
        for(int i=0; i<N-1; i++)
            temp[i]=shop[i];
        delete[] shop;
        shop=temp;
    }
    else shop=new product[N];//��� ��������

    cout << "������ ������ � ��������:\n������������: ";    //���� ������
    cin >> shop[N-1].name;
    cout << "����������: ";
    shop[N-1].Count=(int)cin_valid();
    cout << "����: ";
    shop[N-1].price=cin_valid();

    //������ ������ � ����
    file=fopen("ex2.bin","ab");
    fwrite(&shop[N-1],sizeof(shop[N-1]),1,file);
    fclose(file);
    fake();//���������� �����
}

void print(){//����� �� ����� �� �����
    file=fopen("ex2.bin","rb");
    if(file==NULL){ //�������� �� ������� �����
        cerr << "�� ������� ������� ����!!" << endl;
        return;
    }

    cout << "������������\t����������\t����\n";
    while(feof(file)==0){
        fread(&type,sizeof(type),1,file);//����������
        if(strcmp(type.name,"pomidorka")==0)//������ �������� ������� �� ������(��� �������� ������ � �����)
            continue;
        if(feof(file)!=0)//����������� ���� � �������� � �����
            break;
        cout << type.name;
        if(strlen(type.name)>7)cout << "\t";
        else cout << "\t\t";
        cout << type.Count << "\t\t" << type.price << endl;
    }
    fclose(file);
}

void seek(){    //������ ������
    int x=0;
    char name[20];
    cout << "������� ������������ ������, ������� ������ ��������: ";
    cin >> name;
    file=fopen("ex2.bin","rb");
    if(file==NULL){ //�������� �� ������� �����
        cerr << "�� ������� ������� ����!!" << endl;
        return;
    }

    int i=0;
    do{
        fread(&type,sizeof(type),1,file);
        if(feof(file)!=0)break;
        x=i;
        i++;
    }while((strcmp(type.name,name)!=0)&&(feof(file)==0));
    fclose(file);

    cout << "������ ������ � ����� ��������:\n������������: ";    //���� ����� ������
    cin >> type.name;
    cout << "����������: ";
    type.Count=(int)cin_valid();
    cout << "����: ";
    type.price=cin_valid();

    file=fopen("ex2.bin","rb+");    //������. �����: ��������� � ������ rb+!!!!!!!! � �� � �b
    fseek(file,x*sizeof(type),SEEK_SET);
    fwrite(&type,sizeof(type),1,file);
    fclose(file);
}

int main(){
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);

    int ans;
    while(true){
        cout << "1.�������� ����� �������\n2.�������� ���� ���������\n3.������ ��������\n4.�����\n";
        ans=(int)cin_valid();
        switch(ans){
            case 1: add(); break;
            case 2: print(); break;
            case 3: seek(); break;
            case 4: cout << "�������� ���!!"; return 0;
            default: cout << "�������� ��������!!" << endl;
        }
    }
    return 0;
}
