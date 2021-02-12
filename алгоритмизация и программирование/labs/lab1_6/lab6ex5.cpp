#include <iostream>
#include <clocale>

using namespace std;


int main(){
    setlocale(LC_CTYPE, "rus");

    int n,k,x=0;
    cout << "¬ведите размер массива: ";
    cin >> n;
    int mass[n]; //основной массив
    int mass2[n]; //удобней работать с двум€ массивами, что бы не перемещать элементы

    for(int i=0; i<n; ++i) //зануление второго  массива
        mass2[i]=0;

    cout << "¬ведите массив: "; //ввод основного
    for(int i=0; i<n; ++i)
        cin >> mass[i];

    for(int i=0; i<n; ++i){
        k=1;
        for(int j=0; j<n; ++j){
            if((mass[i]==mass[j])&&(i!=j)) //размечаем, какие элементы повтор€ютс€
                ++k;
        }
        if(k<3){      //«јѕ»—џ¬ј≈ћ ¬ Ќќ¬џ… “ќЋ№ ќ “≈,  ќ“ќ–џ≈ ѕќ¬“ќ–яё“—я ћ≈Ќ№Ў≈ 3 –ј«
            for(int j=0; j<n; j++){
                    if(mass2[j]==0){
                        mass2[j]=mass[i];
                        ++x;
                        break;
                    }
            }
        }
    }



    cout << "Ёлементы, которые повтор€ютс€ меньше 3 раз: ";
    for(int i=0; i<x; ++i)                  //–≈«”Ћ№“ј“
        cout << mass2[i] << " ";

    return 0;
}
