#include <iostream>
#include <My_library.h> //������ ����������. ������������ ������� cin_valid(), ��� �������� ���� �������� ������
#include <string>
#include <windows.h>
#include <stdio.h>

using namespace std;


struct student_base{    //��������� ���� ���������
    char lastname[20];
    char firstname[20];
    char patronimic[25];
    struct{
        int day;
        int month;
        int year;
    }date;
    double perfomance;
};

int N=0;
student_base* List;
FILE* file;

void load();
void add();
void sorting();
void klass();
void print();
void SearchMenu();
void search_name();
void search_perf();
void search_date();
void Delete();
void klassMenu();

int main(){
    SetConsoleCP(1251);     //����������
    SetConsoleOutputCP(1251);

    load();//�������� ������
    int ans;
    cout << "������ ����!!" << endl;
    for(;;){
        cout << "\n1.������ ������ ��������\n2.������� ��� �� ��� ���������\n3.�����\n4.��������� ��������\n5.������������ �� ���������\n6.�����\n";
        ans=cin_valid();
        switch(ans){
            case 1: add(); break;
            case 2: if(N==0) cout << "�������� ������\n"; else print(); break;
            case 3: if(N==0) cout << "�������� ������\n"; else SearchMenu();  break;
            case 4: if(N==0) cout << "�������� ������\n"; else Delete(); break;
            case 5: if(N==0) cout << "�������� ������\n"; else klassMenu(); break;
            case 6: cout << "�� ���������!!"; delete[] List; return 0;
            default: cout << "����������� ��������!!!" << endl;
        }
    }
}

void load(){    //�������� ������ � �������� �����
    file=fopen("base.bin","rb");
    if(file==NULL)
        return;

    while(1){
        if(feof(file)!=0)
            break;
        N++;
        if(N==1)
            List=new student_base[N];
        else{
            student_base* Temp=new student_base[N];
            for(int i=0; i<N-1; i++)
                Temp[i]=List[i];
            delete[] List;
            List=Temp;
        }
        fread(&List[N-1],sizeof(List[N-1]),1,file);
    }
    fclose(file);

    //�������� ������� ��������, ������������ ��-�� ���� feof
    N--;
    student_base* Temp=new student_base[N];
    for(int i=0; i<N; i++)
        Temp[i]=List[i];
    delete[] List;
    List=Temp;
}

void add(){     //��������� ��������
    N++;
    if(N==1)
        List=new student_base[N];    //������ ��������
    else{
        student_base* Temp=new student_base[N];   //������ ����������
        for(int i=0; i<N-1; i++)
            Temp[i]=List[i];
        delete[] List;
        List=Temp;
    }

    cout << "������ ��� ������ ��������:\n�������: ";    //���� �����
    cin >> List[N-1].lastname;
    cout << "��'�: ";
    cin >> List[N-1].firstname;
    cout << "��-�������: ";
    cin >> List[N-1].patronimic;
    cout << "���� ����������:\n����: ";
    List[N-1].date.day=(int)cin_valid();
    while((List[N-1].date.day<=0)||(List[N-1].date.day>31)){    //�������� �� ����������� ����
        cout << "����������� ����! ������ ����� �� 1 �� 31: ";
        List[N-1].date.day=(int)cin_valid();
    }
    cout << "̳����: ";
    List[N-1].date.month=(int)cin_valid();
    while((List[N-1].date.month<=0)||(List[N-1].date.month>12)){
        cout << "����������� ����! ������ ����� �� 1 �� 12: ";
        List[N-1].date.month=(int)cin_valid();
    }
    cout << "г�: ";
    List[N-1].date.year=(int)cin_valid();
    while((List[N-1].date.year<0)||(List[N-1].date.year>2019)){
        cout << "����������� ����! ������ ����� �� 0 �� 2019: ";
        List[N-1].date.year=(int)cin_valid();
    }
    cout << "������� ��������: ";
    List[N-1].perfomance=cin_valid();
    while((List[N-1].perfomance>100.0)||(List[N-1].perfomance<0)){    //� �� ������������ ������������
        cout << "���������� ���! ������ ����� �� 0 �� 100: ";
        List[N-1].perfomance=(int)cin_valid();
    }
    cout << "��� ������!!!" << endl;
    sorting();

    file=fopen("base.bin","wb");    //�������������� ������ ���������
    for(int i=0; i<N; i++)
        fwrite(&List[i],sizeof(List[i]),1,file);
    fclose(file);
    klass();//� ��������������
}

void sorting(){ //���������� �� ��������
    student_base Temp;
    for(int j=0; j<N; j++)
        for(int i=0; i<N-1; i++)
            if(strcmp(List[i].lastname,List[i+1].lastname)>0){
                Temp=List[i];
                List[i]=List[i+1];
                List[i+1]=Temp;
            }
}

void print(){   //������
    cout << "�����\t�������\t��'�\t\t��-�������\t���� ����������\t������� ��������\n";
    for(int i=0; i<N; i++){
        cout << i+1 << ".\t" << List[i].lastname;
        if(strlen(List[i].lastname)>=8)cout<<"\t";   //�������� ���������
        else cout << "\t\t";
        cout << List[i].firstname;
        if(strlen(List[i].firstname)>=8)cout<<"\t";
        else cout << "\t\t";
        cout << List[i].patronimic;
        if(strlen(List[i].patronimic)>=8)cout<<"\t";
        else cout << "\t\t";
        if(List[i].date.day<10)cout <<"0";  //���� ��� ����
        cout << List[i].date.day <<".";
        if(List[i].date.month<10)cout <<"0";
        cout << List[i].date.month <<"."<< List[i].date.year <<"\t"<< List[i].perfomance << endl;
    }
}

void SearchMenu(){  //���� ������
    int ans;
    for(;;){
        cout << "\n1.����� �� ��������\n2.����� �� ��������� ��������\n3.����� �� ����� ����������\n4.³�������\n";
        ans=cin_valid();
        switch(ans){
            case 1: search_name(); return;
            case 2: search_perf(); return;
            case 3: search_date(); return;
            case 4: cout << "ĳ� ��������!!\n"; return;
            default: cout << "����������� ��������!!!" << endl;
        }
    }
}

void search_name(){ //����� �� �������
    string name;
    bool flag=false;//���� ��� �������������

    cout << "������ ������� ��������: ";
    cin >> name;
    for(int i=0; i<N; i++)//���� ��� ��������, ���������� �� ������ ��������
        if(List[i].lastname==name){
            cout << "\n�������� �������:\n�����\t�������\t��'�\t\t��-�������\t���� ����������\t������� ��������\n";
            flag=true;
            break;
        }

    if(flag==false){
            cout << "������� �������� � ������ ������ �� ��������!!" << endl;
            return; //����� ��������� �-�
    }

    for(int i=0; i<N; i++)
        if(List[i].lastname==name){ //��� ����� �� �����, ��� � � ������
            cout << i+1 << ".\t" << List[i].lastname;
            if(strlen(List[i].lastname)>=8)cout<<"\t";   //�������� ���������
        else cout << "\t\t";
        cout << List[i].firstname;
        if(strlen(List[i].firstname)>=8)cout<<"\t";
        else cout << "\t\t";
        cout << List[i].patronimic;
        if(strlen(List[i].patronimic)>=8)cout<<"\t";
            else cout << "\t\t";
            if(List[i].date.day<10)cout <<"0";
            cout << List[i].date.day <<".";
            if(List[i].date.month<10)cout <<"0";
            cout << List[i].date.month <<"."<< List[i].date.year <<"\t"<< List[i].perfomance << endl;
        }
}

void search_perf(){ //����� �� ��������� ������������(���������� ������� �������� �� ��������, ���� � ���������� ������������ ���������)
    int beg,fin;
    bool flag=false;

    cout << "������ ������� ����� ��������(� ����� �� 0 �� 100 �������):\n�(����� ����): ";
    beg=(int)cin_valid();
    while((beg<0)||(beg>100)){  //�������� ������ �����
        cout << "����������� ����! ������ ����� �� 0 �� 100: ";
        beg=(int)cin_valid();
    }
    cout << "��(������ ����): ";
    fin=(int)cin_valid();
    while((fin<0)||(fin>100)){
        cout << "����������� ����! ������ ����� �� 0 �� 100: ";
        fin=(int)cin_valid();
    }

    for(int i=0; i<N; i++)
        if((List[i].perfomance>=beg)&&(List[i].perfomance<=fin)){
            cout << "\n�������� �������:\n�����\t�������\t��'�\t\t��-�������\t���� ����������\t������� ��������\n";
            flag=true;
            break;
        }
    if(flag==false){
        cout << "������� �������� � ������ ������ �� ��������!!" << endl;
        return;
    }

    for(int i=0; i<N; i++)
        if((List[i].perfomance>=beg)&&(List[i].perfomance<=fin)){
            cout << i+1 << ".\t" << List[i].lastname;
            if(strlen(List[i].lastname)>=8)cout<<"\t";   //�������� ���������
        else cout << "\t\t";
        cout << List[i].firstname;
        if(strlen(List[i].firstname)>=8)cout<<"\t";
        else cout << "\t\t";
        cout << List[i].patronimic;
        if(strlen(List[i].patronimic)>=8)cout<<"\t";
            else cout << "\t\t";
            if(List[i].date.day<10)cout <<"0";
            cout << List[i].date.day <<".";
            if(List[i].date.month<10)cout <<"0";
            cout << List[i].date.month <<"."<< List[i].date.year <<"\t"<< List[i].perfomance << endl;
        }
}

void search_date(){ //����� �� ����
    int day,month;
    bool flag=false;

    cout << "������ ���� ����������:\n����: ";
    day=(int)cin_valid();
    while((day<=0)||(day>31)){  //�������� ������ �����
        cout << "����������� ����! ������ ����� �� 1 �� 31: ";
        day=(int)cin_valid();
    }
    cout << "̳����: ";
    month=(int)cin_valid();
    while((month<=0)||(month>12)){  //�������� ������ �����
        cout << "����������� ����! ������ ����� �� 1 �� 12: ";
        month=(int)cin_valid();
    }

    for(int i=0; i<N; i++)
        if((List[i].date.day==day)&&(List[i].date.month==month)){
            cout << "\n�������� �������:\n�����\t�������\t��'�\t\t��-�������\t���� ����������\t������� ��������\n";
            flag=true;
            break;
        }
    if(flag==false){
        cout << "������� �������� � ������ ������ �� ��������!!" << endl;
        return;
    }

    for(int i=0; i<N; i++)
        if((List[i].date.day==day)&&(List[i].date.month==month)){
            cout << i+1 << ".\t" << List[i].lastname;
            if(strlen(List[i].lastname)>=8)cout<<"\t";   //�������� ���������
        else cout << "\t\t";
        cout << List[i].firstname;
        if(strlen(List[i].firstname)>=8)cout<<"\t";
        else cout << "\t\t";
        cout << List[i].patronimic;
        if(strlen(List[i].patronimic)>=8)cout<<"\t";
            else cout << "\t\t";
            if(List[i].date.day<10)cout <<"0";
            cout << List[i].date.day <<".";
            if(List[i].date.month<10)cout <<"0";
            cout << List[i].date.month <<"."<< List[i].date.year <<"\t"<< List[i].perfomance << endl;
        }
}

void Delete(){  //�������� ��������
    int pos;

    cout << "������ ����� ��������, ����� ������ ��������(������ 0 ��� ���������): ";
    pos=(int)cin_valid();
    if(pos==0){
        cout << "���������!!\n"; return;
    }
    while(pos>N){
        cout << "����� ����� �������!!\n";
        pos=(int)cin_valid();
    }

    pos--;
    N--;
    student_base* Temp=new student_base[N];
    for(int i=0; i<pos; i++)
        Temp[i]=List[i];
    for(int i=pos+1; i<N+1; i++)
        Temp[i-1]=List[i];

    delete[] List;
    List=Temp;
    cout << "�������� ��������!!" << endl;

    file=fopen("base.bin","wb");
    for(int i=0; i<N; i++)
        fwrite(&List[i],sizeof(List[i]),1,file);
    fclose(file);
    klass();//�� �������� ����������������
}

void klass(){   //������ ��������� � ����� �������������
    file=fopen("high.bin", "wb");
    for(int i=0; i<N; i++)
        if(List[i].perfomance>=70)
            fwrite(&List[i],sizeof(List[i]),1,file);
    fclose(file);
    file=fopen("low.bin", "wb");
    for(int i=0; i<N; i++)
        if((List[i].perfomance>=50)&&(List[i].perfomance<70))
            fwrite(&List[i],sizeof(List[i]),1,file);
    fclose(file);
    file=fopen("none.bin", "wb");
    for(int i=0; i<N; i++)
        if(List[i].perfomance<50)
            fwrite(&List[i],sizeof(List[i]),1,file);
    fclose(file);
}

void klassMenu(){   //���� ������������ ���������
    student_base temp;
    int ans,i=0;
    cout << "\n--���� ������������ ��������--!!" << endl;
    for(;;){
        cout << "\n1.�������� � ������� �����\n2.�������� � ������� �����\n3.�������� ��� �����\n4.����������� � �������� ����\n";
        ans=cin_valid();
        switch(ans){
            case 1:
                file=fopen("high.bin", "rb");
                while(1){
                    fread(&temp,sizeof(temp),1,file);
                    if(feof(file)!=0)break;
                    if(temp.perfomance>=70){
                        cout << ++i << ".\t" << temp.lastname;
                        if(strlen(temp.lastname)>=8)cout<<"\t";   //�������� ���������
                        else cout << "\t\t";
                        cout << temp.firstname;
                        if(strlen(temp.firstname)>=8)cout<<"\t";
                        else cout << "\t\t";
                        cout << temp.patronimic;
                        if(strlen(temp.patronimic)>=8)cout<<"\t";
                        else cout << "\t\t";
                        if(temp.date.day<10)cout <<"0";  //���� ��� ����
                        cout << temp.date.day <<".";
                        if(temp.date.month<10)cout <<"0";
                        cout << temp.date.month <<"."<< temp.date.year <<"\t"<< temp.perfomance << endl;
                    }
                }
                fclose(file);
                break;
            case 2:
                file=fopen("low.bin", "rb");
                while(1){
                    fread(&temp,sizeof(temp),1,file);
                    if(feof(file)!=0)break;
                    if((temp.perfomance>=50)&&(temp.perfomance<70)){
                        cout << ++i << ".\t" << temp.lastname;
                        if(strlen(temp.lastname)>=8)cout<<"\t";   //�������� ���������
                        else cout << "\t\t";
                        cout << temp.firstname;
                        if(strlen(temp.firstname)>=8)cout<<"\t";
                        else cout << "\t\t";
                        cout << temp.patronimic;
                        if(strlen(temp.patronimic)>=8)cout<<"\t";
                        else cout << "\t\t";
                        if(temp.date.day<10)cout <<"0";  //���� ��� ����
                        cout << temp.date.day <<".";
                        if(temp.date.month<10)cout <<"0";
                        cout << temp.date.month <<"."<< temp.date.year <<"\t"<< temp.perfomance << endl;
                    }
                }
                fclose(file);
                break;
            case 3:
                file=fopen("none.bin", "rb");
                while(1){
                    fread(&temp,sizeof(temp),1,file);
                    if(feof(file)!=0)break;
                    if(temp.perfomance<50){
                        cout << ++i << ".\t" << temp.lastname;
                        if(strlen(temp.lastname)>=8)cout<<"\t";   //�������� ���������
                        else cout << "\t\t";
                        cout << temp.firstname;
                        if(strlen(temp.firstname)>=8)cout<<"\t";
                        else cout << "\t\t";
                        cout << temp.patronimic;
                        if(strlen(temp.patronimic)>=8)cout<<"\t";
                        else cout << "\t\t";
                        if(temp.date.day<10)cout <<"0";  //���� ��� ����
                        cout << temp.date.day <<".";
                        if(temp.date.month<10)cout <<"0";
                        cout << temp.date.month <<"."<< temp.date.year <<"\t"<< temp.perfomance << endl;
                    }
                }
                fclose(file);
                break;
            case 4: return;
            default: cout << "����������� ��������!!!" << endl;
        }
    }
}
