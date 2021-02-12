//задача о рюкзаке
#include <iostream>
#include <My_library.h>
#define N 3

using namespace std;

int main() {
    int weigth[N]={12, 4, 6};
    int costs[N]={50, 35, 10};
    int capacity=20;
    for(int i=0; i<N; i++)
        for(int j=0; j<N-1; j++)
            if(weigth[j]>weigth[j+1]){
                swap(weigth[j],weigth[j+1]);
                swap(costs[j],costs[j+1]);
            }

    int cache[N+1][capacity+1];
    for(int i=0; i<N+1; i++){
        for(int j=0; j<capacity+1; j++){

            int current=i-1;
            if((i==0)||(j==0)){
                cache[i][j]=0;
            }
            else if(weigth[current>j]){
                cache[i][j]=cache[i-1][j];
            }
            else{
                cache[i][j]=min(costs[current]+cache[i-1][j-weigth[current]], cache[i-1][j]);
            }
        }
    }

    for(int i=0; i<N; i++)
        cout << weigth[i] << " " << costs[i] << "\n";

    for(int i=0; i<N+1; i++){
        for(int j=0; j<capacity+1; j++)
            cout << cache[i][j] << " ";
        cout << endl;
    }
    cout << "\n" << cache[N+1][capacity+1];
}

