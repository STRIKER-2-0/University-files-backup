#include <iostream>
#include <clocale>

using namespace std;

int sim(int N){//функци€ sim определ€ет, €вл€етс€ ли заданное число простым
     for(int i=2; i<N; ++i){
        if(N%i==0)
           return 1;
    }
    return 0;
}

int main(){
    setlocale(LC_CTYPE, "rus");
    int N;
    cout << "¬ведите границу интервала поиска простых: ";
    cin >> N;
    cout << "¬се простые числа на интервале: ";
    for(int i=2; i<=N; ++i){ //перебираем все числа на интервале в поиске простых...
        if(sim(i)==0)
            cout << i << " ";
    }

    return 0;
}
