//задача о размене
#include <iostream>
#include <My_library.h>

using namespace std;
void quick(int arr[], int start, int end){  //сортировка
    int mid;
    int f=start, l=end;
    mid=arr[(f+l)/2];               //вычисление опорного элемента
    do{
        while(arr[f]<mid)f++;
        while(arr[l]>mid)l--;
        if(f<=l){                  //перестановка элементов
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

    cout << "Введите кол-во монет: ";   //ввод корректного кол-ва монет
    int N=(int)cin_valid();
    while_neg(N);

    int cents[N];
    cout << "Введите номиналы монет: ";     //ввод корректных номиналов
    for(int i=0; i<N; i++){
        cents[i]=(int)cin_valid();
        while_neg(cents[i]);
    }
    quick(cents, 0, N-1);   //номиналы по возрастанию

    cout << "Введите сумму: ";  //корректный ввод желаемой суммы
    int S=(int)cin_valid();
    while_neg(S);


    int results[S+1];       //массив для хранения результатов ДП
    results[0]=0;
    for(int i=1; i<S+1; i++)
        results[i]=S+1;

    for(int i=1; i<S+1; i++){       //подсчет оптимальным алгоритмом
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

    int counter=0;  //счетчик монет для ЖА
    for(int i=N-1; (i>=0)&&(S!=0); i--){    //подсчет жадным алгоритмом
        while(S>=cents[i]){
            S-=cents[i];
            counter++;
        }
    }
    cout << "Кол-во монет для размена: \n\tЖадный алгоритм: ";
    if(S==0)
         cout << counter << endl;
    else
        cout << "Эту сумму нельзя выдать этим алгоритмом!" << endl;
    cout << "\tОптимальный алгоритм: ";
    if(res!=0)
        cout << res << endl;
    else
        cout << "Эту сумму нельзя выдать этим алгоритмом!" << endl;
    return 0;
}
