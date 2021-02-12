//***������ � ���� N ��������� ��������������� �����***
#include <fstream>
#include <iostream>
#include <cstdlib>
#include <ctime>
#define N 1000

using namespace std;

void quick(int arr[], int start, int end){
    int mid;
    int f=start, l=end;
    mid=arr[(f+l)/2];               //���������� �������� ��������
    do{
        while(arr[f]<mid)f++;
        while(arr[l]>mid)l--;
        if(f<=l){                  //������������ ���������
            swap(arr[f], arr[l]);
            f++;
            l--;
        }
    }while(f<l);
    if(start<l)quick(arr, start, l);
    if(f<end)quick(arr, f, end);
}

int main(){
    srand(time(0));
    int arr[N];
    int bigArr[N*10];
    int pos;
    for(int i=0; i<N*10; i++)       //10 000 ��������������� �����
        bigArr[i]=i;

    for(int i=0; i<N; i++){     //��������� � ������ � 1000 ���������
        do{
            pos=rand()%(N*10);
        }while(bigArr[pos]<0);
        arr[i]=bigArr[pos];
        bigArr[pos]=-1;
    }

    ofstream fout("3_1.random_numbers.bin");    //���������� � ����
    for(int i=0; i<N; i++){
        fout << arr[i] << " ";
        if((i%20==0)&&(i>0))
            fout << endl;
    }
    fout.close();

    cout << ">>random_numbers - Done!" << endl;

    quick(arr, 0, N-1);        //���������
    for(int i=0; i<N; i++)      //���������
        bigArr[i]=arr[i];
    for(int i=0; i<N; i++)      //��������
        arr[i]=bigArr[N-1-i];
    fout.open("3_2.reverse_numbers.bin");       //������ �������-���������������
    for(int i=0; i<N; i++){
        fout << arr[i] << " ";
        if((i%20==0)&&(i>0))
            fout << endl;
    }
    fout.close();

    cout << ">>reverse_numbers - Done!" << endl;

    ifstream fin("3_1.random_numbers.bin");    //��������� ��������� �����
    for(int i=0; i<N; i++)
        fin >> arr[i];
    fin.close();

    for(int i=0; i<N; i+=100)           //��������� �� 100 ���������
        quick(arr, i, i+99);


    fout.open("3_3.hundreds_numbers.bin");       //������ ��������������� �� 100
    for(int i=0; i<N; i++){
        fout << arr[i] << " ";
        if((i%20==0)&&(i>0))
            fout << endl;
    }
    fout.close();

    cout << ">>hundreds_numbers - Done!" << endl;

    quick(arr, 0, N-1);    //��������� ����
    swap(arr[0], arr[N-1]);       //������ ������ � ���������

    fout.open("3_4.mostly_sorted_numbers.bin");       //������ ����� ����������������
    for(int i=0; i<N; i++){
        fout << arr[i] << " ";
        if((i%20==0)&&(i>0))
            fout << endl;
    }
    fout.close();

    cout << ">>mostly_sorted_numbers - Done!" << endl;

    return 0;
}
