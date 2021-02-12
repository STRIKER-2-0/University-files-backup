//������ � �������
#include <iostream>
#include <My_library.h>

using namespace std;
void quick(int arr[], int start, int end){  //����������
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

in+t main(){
    setlocale(LC_CTYPE, "rus");

    cout << "������� ���-�� �����: ";   //���� ����������� ���-�� �����
    int N=(int)cin_valid();
    while_neg(N);

    int cents[N];
    cout << "������� �������� �����: ";     //���� ���������� ���������
    for(int i=0; i<N; i++){
        cents[i]=(int)cin_valid();
        while_neg(cents[i]);
    }
    quick(cents, 0, N-1);   //�������� �� �����������

    cout << "������� �����: ";  //���������� ���� �������� �����
    int S=(int)cin_valid();
    while_neg(S);


    int results[S+1];       //������ ��� �������� ����������� ��
    results[0]=0;
    for(int i=1; i<S+1; i++)
        results[i]=S+1;

    for(int i=1; i<S+1; i++){       //������� ����������� ����������
        for(int j=0; j<N; j++){
            if(i-cents[j]>=0){
                results[i]=min(results[i-cents[j]]+1, results[i]);
            }
        }
    }
    /*for(int i=0; i<S+1; i++)
        cout << results[i] << " ";
    cout << endl;*/
    int res;
    if(results[S]==S+1)
        res=0;
    else res=results[S];

    int counter=0;  //������� ����� ��� ��
    for(int i=N-1; (i>=0)&&(S!=0); i--){    //������� ������ ����������
        while(S>=cents[i]){
            S-=cents[i];
            counter++;
        }
    }
    cout << "���-�� ����� ��� �������: \n\t������ ��������: ";
    if(S==0)
         cout << counter << endl;
    else
        cout << "��� ����� ������ ������ ���� ����������!" << endl;
    cout << "\t����������� ��������: ";
    if(res!=0)
        cout << res << endl;
    else
        cout << "��� ����� ������ ������ ���� ����������!" << endl;
    return 0;
}
