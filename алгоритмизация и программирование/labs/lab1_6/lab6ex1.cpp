#include <iostream>
#include <clocale>

using namespace std;

int main(){
    setlocale(LC_CTYPE, "rus");
    int mass[20];
    for(int i=0; i<20; ++i){
        mass[i]=i+1;
    }
    cout << "n\tn*n\n";
    for(int i=0; i<20; ++i){
        cout << mass[i] << "\t" << mass[i]*mass[i] << endl;
    }
    return 0;
}
