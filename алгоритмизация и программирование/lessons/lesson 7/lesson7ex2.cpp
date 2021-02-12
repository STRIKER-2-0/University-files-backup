#include <iostream>
#include <windows.h>
#include <stdio.h>
#include <My_library.h>
#include <cstdio>

using namespace std;
int N=0;

struct product{
    char name[20];
    int Count;
    double price;
};
product* shop;//склад продуктов))
product type;//темп-переменная для считывания
FILE* file;//ссылка на файл

void fake(){    //фейковая запись
    product fake;
    strcpy(fake.name,"pomidorka");  //копировать в массив символов только так!!!
    fake.Count=100;
    fake.price=10.5;

    file=fopen("ex2.bin","ab");
    fwrite(&fake,sizeof(fake),1,file);
    fclose(file);
}

void add(){//добавление элемента
    N++;
    if(N!=1){//добавление
        product* temp=new product[N];
        for(int i=0; i<N-1; i++)
            temp[i]=shop[i];
        delete[] shop;
        shop=temp;
    }
    else shop=new product[N];//или создание

    cout << "Ведите данные о продукте:\nНаименование: ";    //ввод данных
    cin >> shop[N-1].name;
    cout << "Количество: ";
    shop[N-1].Count=(int)cin_valid();
    cout << "Цена: ";
    shop[N-1].price=cin_valid();

    //запись данных в файл
    file=fopen("ex2.bin","ab");
    fwrite(&shop[N-1],sizeof(shop[N-1]),1,file);
    fclose(file);
    fake();//добавление фейка
}

void print(){//вывод на экран из файла
    file=fopen("ex2.bin","rb");
    if(file==NULL){ //проверка на наличие файла
        cerr << "Не удалось открыть файл!!" << endl;
        return;
    }

    cout << "Наименование\tКоличество\tЦена\n";
    while(feof(file)==0){
        fread(&type,sizeof(type),1,file);//считывание
        if(strcmp(type.name,"pomidorka")==0)//отброс фейковых записей на печати(они остаются только в файле)
            continue;
        if(feof(file)!=0)//исправление бага с повтором в конце
            break;
        cout << type.name;
        if(strlen(type.name)>7)cout << "\t";
        else cout << "\t\t";
        cout << type.Count << "\t\t" << type.price << endl;
    }
    fclose(file);
}

void seek(){    //замена записи
    int x=0;
    char name[20];
    cout << "Введите наименование записи, которую хотите заменить: ";
    cin >> name;
    file=fopen("ex2.bin","rb");
    if(file==NULL){ //проверка на наличие файла
        cerr << "Не удалось открыть файл!!" << endl;
        return;
    }

    int i=0;
    do{
        fread(&type,sizeof(type),1,file);
        if(feof(file)!=0)break;
        x=i;
        i++;
    }while((strcmp(type.name,name)!=0)&&(feof(file)==0));
    fclose(file);

    cout << "Ведите данные о новом продукте:\nНаименование: ";    //ввод новых данных
    cin >> type.name;
    cout << "Количество: ";
    type.Count=(int)cin_valid();
    cout << "Цена: ";
    type.price=cin_valid();

    file=fopen("ex2.bin","rb+");    //запись. Важно: открывать в режиме rb+!!!!!!!! а не в аb
    fseek(file,x*sizeof(type),SEEK_SET);
    fwrite(&type,sizeof(type),1,file);
    fclose(file);
}

int main(){
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);

    int ans;
    while(true){
        cout << "1.Добавить новый продукт\n2.Просмотр всех продуктов\n3.Замена продукта\n4.Выход\n";
        ans=(int)cin_valid();
        switch(ans){
            case 1: add(); break;
            case 2: print(); break;
            case 3: seek(); break;
            case 4: cout << "Удачного дня!!"; return 0;
            default: cout << "Неверное значение!!" << endl;
        }
    }
    return 0;
}
