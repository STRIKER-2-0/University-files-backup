#include <iostream>
#include <windows.h>
#include <string>
#include <My_library.h>


using namespace std;
int N=0;
const int b=0,s=1,g=2,all=3;
string* country;
int** medals;

void sorting();
void add_medals(int);
void Delete(int);
string check_country();
int input();
int input_first();
void create();
void add();
void print();
void Search();

int main(){
    SetConsoleCP(1251);     //украинский
    SetConsoleOutputCP(1251);
    int ans;
    for(;;){
        cout << "\n1.Змінити дані\n2.Вивести дані по країні\n3.Вивести звітову таблицю\n4.Вихід\n";
        ans=cin_valid();
        switch(ans){
            case 1: if(N==0) create(); else add(); break;
            case 2: if(N==0) cout << "Країни відсутні!\n"; else Search(); break;
            case 3: if(N==0) cout << "Країни відсутні!\n"; else print(); break;
            case 4: cout << "До побачення!";
                    delete[] country;
                    for(int i=0; i<N; i++)
                        delete[] medals[i];
                    delete[] medals;

                    return 0;
            default: cout << "Неправильне значення!" << endl;
        }
    }
}

void create(){      //создание базы данных(если отсутствуют элементы)
    N++;
    country=new string[N];
    medals=new int*[N];
    for(int i=0; i<N; i++)
        medals[i]=new int[4];
    input_first();
}

int input_first(){       //Ввод данных в пустую базу
    cout << "Введіть дані\nКраїна: ";
    cin >> country[N-1];
    cout << "Кількість медалей:\nБронза: ";
    medals[N-1][b]=(int)cin_valid();
    cout << "Срібло: ";
    medals[N-1][s]=(int)cin_valid();
    cout << "Золото: ";
    medals[N-1][g]=(int)cin_valid();
    medals[N-1][all]=medals[N-1][b]+medals[N-1][s]+medals[N-1][g];
    cout << "Країну додано до списку!!" << endl;
}

void add(){     //добавление элемента
    N++;//увеличение базы
    string* tmp_c=new string[N];
    int** tmp_m=new int*[N];
    for(int i=0; i<N; i++)      //создание нового массива
        tmp_m[i]=new int[4];

    for(int i=0; i<N-1; i++){
        tmp_c[i]=country[i];
        tmp_m[i][b]=medals[i][b];
        tmp_m[i][s]=medals[i][s];       //перенос значений
        tmp_m[i][g]=medals[i][g];
        tmp_m[i][all]=medals[i][all];
    }

    delete[] country;
    for(int i=0; i<N-1; i++)
        delete[] medals[i];     //удаление старого
    delete[] medals;

    country=tmp_c;      //переприсваивание указателей
    medals=tmp_m;

    input();
}

int input(){       //Ввод данных
    string zero="zero";

    cout << "Введіть дані\nКраїна: ";
    string answer=check_country();

    if(answer==zero)
        return 0;
    else
        country[N-1]=answer;

    cout << "Кількість медалей:\nБронза: ";
    medals[N-1][b]=(int)cin_valid();
    cout << "Срібло: ";
    medals[N-1][s]=(int)cin_valid();
    cout << "Золото: ";
    medals[N-1][g]=(int)cin_valid();
    medals[N-1][all]=medals[N-1][b]+medals[N-1][s]+medals[N-1][g];
    cout << "Країну додано до списку!!" << endl;
    sorting();
}

string check_country(){     //проверка на наличие страны
    string zero="zero",name;
    cin >> name;
    for(int i=0; i<N; i++)
        if(name==country[i]){
            Delete(i);
            return zero;
        }
    return name;
}

void Delete(int x){     //удаление ячейки
    N--;
    string* tmp_c=new string[N];
    int** tmp_m=new int*[N];
    for(int i=0; i<N; i++)
        tmp_m[i]=new int[4];

    for(int i=0; i<N; i++){
        tmp_c[i]=country[i];
        tmp_m[i][b]=medals[i][b];
        tmp_m[i][s]=medals[i][s];
        tmp_m[i][g]=medals[i][g];
        tmp_m[i][all]=medals[i][all];
    }

    delete[] country;
    for(int i=0; i<N+1; i++)
        delete[] medals[i];
    delete[] medals;

    country=tmp_c;
    medals=tmp_m;

    add_medals(x);
}

void add_medals(int x){     //добавление медалей в существующую страну
    cout << "Кількість медалей:\nБронза: ";
    medals[x][b]+=(int)cin_valid();
    cout << "Срібло: ";
    medals[x][s]+=(int)cin_valid();
    cout << "Золото: ";
    medals[x][g]+=(int)cin_valid();
    medals[x][all]+=medals[x][b]+medals[x][s]+medals[x][g];
    cout << "Медалі додано!!" << endl;
    sorting();
}

void Search(){      //поиск по стране
    string name;
    bool flag=false;
    cout << "Введіть назву країни: ";
    cin >> name;
    for(int i=0; i<N; i++)
        if(country[i]==name){
            cout << "\nДані по вашій країні знайдено:\nМісце\tКраїна\t\tБронза\tСрібло\tЗолото\tУсього\n";
            cout << i+1 << ".\t" << country[i];
            if(country[i].size()<8)cout << "\t\t";
            else cout << "\t";
            for(int j=0; j<4; j++)
                cout << medals[i][j] << "\t";
            cout << endl;
            flag=true;
        }
    if(flag==false)
        cout << "Країну не знайдено!!!" << endl;
}

void print(){       //печать
    cout << "Місце\tКраїна\t\tБронза\tСрібло\tЗолото\tУсього\n";
    for(int i=0; i<N; i++){
        cout << i+1 << ".\t" << country[i];
        if(country[i].size()<8)cout << "\t\t";
        else cout << "\t";
        for(int j=0; j<4; j++)
            cout << medals[i][j] << "\t";
        cout << endl;
    }
}

void sorting(){         //сортировка
    string tmp_c;
    int tmp_m[4];
    for(int k=0; k<N; k++)  //пузырьковый цикл
        for(int i=0; i<N-1; i++){
            if(medals[i][g]<medals[i+1][g]){    //по золоту
                tmp_c=country[i];
                for(int j=0; j<4; j++)
                    tmp_m[j]=medals[i][j];
                country[i]=country[i+1];
                for(int j=0; j<4; j++)
                    medals[i][j]=medals[i+1][j];
                country[i+1]=tmp_c;
                for(int j=0; j<4; j++)
                    medals[i+1][j]=tmp_m[j];
            }
            else if(medals[i][g]==medals[i+1][g]){  //в случае если равны
                if(medals[i][s]<medals[i+1][s]){    //по серебру
                    tmp_c=country[i];
                    for(int j=0; j<4; j++)
                        tmp_m[j]=medals[i][j];
                    country[i]=country[i+1];
                    for(int j=0; j<4; j++)
                        medals[i][j]=medals[i+1][j];
                    country[i+1]=tmp_c;
                    for(int j=0; j<4; j++)
                        medals[i+1][j]=tmp_m[j];
                }
                else if(medals[i][s]==medals[i+1][s]){  //в случае если равны
                    if(medals[i][b]<medals[i+1][b]){    //по бронзе
                        tmp_c=country[i];
                        for(int j=0; j<4; j++)
                            tmp_m[j]=medals[i][j];
                        country[i]=country[i+1];
                        for(int j=0; j<4; j++)
                            medals[i][j]=medals[i+1][j];
                        country[i+1]=tmp_c;
                        for(int j=0; j<4; j++)
                            medals[i+1][j]=tmp_m[j];
                    }
                }
            }
        }
}
