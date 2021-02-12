#include <iostream>
#include <clocale>
#include <cstdlib>
#include <ctime>

using namespace std;


const int N=10;
void print(int arr[], int start, int end){
    cout << endl;
    for(int j=0; j<start; j++)
            cout << "  ";
    for(int i=start; i<=end; i++)
        cout << arr[i] << " ";
}


void shaker(int arr[], int start, int end){
    if(end==start+1)
        return;

    for(int i=start; i<end; i++)
        if(arr[i]>arr[i+1]){
            swap(arr[i], arr[i+1]);
            print(arr, start, end);
        }
    end--;
    print(arr, start, end);
    cout << "\tend=" << end;
    for(int i=end; i>start; i--)
        if(arr[i-1]>arr[i]){
            swap(arr[i-1], arr[i]);
            print(arr, start, end);
        }
    start++;
    print(arr, start, end);
    cout << "\tstart=" << start;
    shaker(arr, start, end);
}

int main(){
    setlocale(LC_CTYPE, "rus");
    srand(time(0));
    int arr[N];
    for(int i=0; i<N; i++){
        arr[i]=rand()%10;
        cout << arr[i] << " ";
    }
    cout << "\tstart=0  end=" << N-1;
    shaker(arr,0,N-1);
    print(arr, 0, N-1);
    return 0;
}
