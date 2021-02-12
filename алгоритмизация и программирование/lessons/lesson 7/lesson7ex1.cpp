#include <iostream>
#include <clocale>
#include <windows.h>
#include <ctime>
#include <cstdlib>
#include <stdio.h>

using namespace std;

int main(){
    setlocale(LC_CTYPE, "Russian");
    srand(time(0));
    FILE* file;
    int n;
    int max=0,min=100;


    file=fopen("file_in.bin", "wb");
    for(int i=0; i<10; i++){
        n=rand()%100;
        fputc(n,file);
    }
    fclose(file);
    cout << "Значения сохранены в бинарный файл!!" << endl;
    system("pause");

    file=fopen("file_in.bin", "rb");
    for(int i=0; i<10; i++){
        n=fgetc(file);
        if(n>max)
            max=n;
        if(n<min)
            min=n;
    }
    fclose(file);

    FILE* fout=fopen("file_out.txt", "w");
    fprintf(fout,"%s","Максимум: ");
    fprintf(fout,"%d",max);
    fprintf(fout,"%s"," Минимум: ");
    fprintf(fout,"%d ",min);
    fclose(fout);
    cout << "Данные обработаны и помещены в файл file_out.txt. Максимум: " << max << " Минимум: " << min;


    return 0;
}
