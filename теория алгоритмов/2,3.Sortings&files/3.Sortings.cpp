//***сортировака чисел в файлах***
#include <iostream>
#include <fstream>
#include <clocale>
#define N 1000

using namespace std;

int counter;

void shaker(int arr[], int start, int end){
    if(end==start+1)
        return;

    for(int i=start; i<end; i++)
        if(arr[i]>arr[i+1]){
            swap(arr[i], arr[i+1]);
            counter++;
        }
    end--;
    for(int i=end; i>start; i--)
        if(arr[i-1]>arr[i]){
            swap(arr[i-1], arr[i]);
            counter++;
        }
    start++;
    shaker(arr, start, end);
}

void stooge(int arr[], int start, int end){
	int temp;
	if(end-start+1>2){
		temp=(end-start+1)/3;
		stooge(arr, start, end-temp);
		stooge(arr, start+temp, end);
		stooge(arr, start, end-temp);
	}
	if(arr[end]<arr[start]){
        counter++;
        swap(arr[end], arr[start]);
	}
}

void quick(int arr[], int start, int end){
    int mid;
    int f=start, l=end;
    mid=arr[(f+l)/2];               //вычисление опорного элемента
    do{
        while(arr[f]<mid)f++;
        while(arr[l]>mid)l--;
        if(f<=l){                  //перестановка элементов
            swap(arr[f], arr[l]);
            counter++;
            f++;
            l--;
        }
    }while(f<l);
    if(start<l)quick(arr, start, l);
    if(f<end)quick(arr, f, end);
}

void files(int arr[], int file, int sorting){
    ifstream fin;
    switch(file){
        case 0: fin.open("3_1.random_numbers.bin"); break;
        case 1: fin.open("3_2.reverse_numbers.bin"); break;
        case 2: fin.open("3_3.hundreds_numbers.bin"); break;
        case 3: fin.open("3_4.mostly_sorted_numbers.bin"); break;
    }
    if(!fin.is_open())
        cerr << "Ошибка открытия файла!!" << endl;
    else{
        for(int i=0; i<N; i++)
            fin >> arr[i];
        fin.close();
    }
    counter=0;
    switch(sorting){
        case 0: shaker(arr,0,N-1); break;
        case 1: quick(arr,0,N-1); break;
        case 2: stooge(arr,0,N-1); break;
    }
    cout << "\t\t" << counter;
}

int main(){
    setlocale(LC_CTYPE, "rus");
    int arr[N];

    cout << "\n\n\t\trandom_numbers  reverse_numbers  hundreds_numbers  mostly_sorted_numbers";
    cout << "\nShaker sort:";
    for(int i=0; i<=3; i++)
        files(arr, i, 0);
    cout << "\nQuick sort:";
    for(int i=0; i<=3; i++)
        files(arr, i, 1);
    cout << "\nStooge sort:";
    for(int i=0; i<=3; i++)
        files(arr, i, 2);
    cout << "\n\n";
    /*
    for(int i=0; i<N; i++){
        cout << arr[i] << " ";
        if((i%20==0)&&(i>0))
            cout << endl;
    }*/
    return 0;
}
