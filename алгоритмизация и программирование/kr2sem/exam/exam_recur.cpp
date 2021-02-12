#include <iostream>
#include <clocale>


using namespace std;

int recur(int* arr, int i, int S, int size){
    if(i==size-1)
        return S;
    else if(arr[i]%2==0){
        S+=arr[i];
        return recur(arr, i+1, S, size);
    }
    else
        return recur(arr, i+1, S, size);

}


int main(){
    setlocale(LC_CTYPE, "rus");
    int S=0;
    int arr[12];
    for(int i=0; i<12; i++)
        arr[i]=i;

    cout << recur(arr, 0, S, 12);
    return 0;
}
