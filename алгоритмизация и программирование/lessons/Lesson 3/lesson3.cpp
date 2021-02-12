#include <iostream>
#include <clocale>
#include <cstdlib>
#include <ctime>
#include <cmath>

using namespace std;
int N=0;

struct device{
    int number;
    char name[20];          //создание структуры и списка
    int year;
    double cost;
};
device* List;
device* Temp;

int check_number(int x){    //проверка на  уникальность номера
    for(int i=0; i<N; i++)
        if((x==List[i].number)&&(i!=N-1))
            return 1;
    return 0;
}

int volid(){                //проверка на тип данных
    char volname[20];
    int result;
    bool flag=true;
    do{
        result=0;
        cin >> volname;
        for(int i=0; volname[i]!='\0'; i++){
            if((volname[i]<'0')||(volname[i]>'9')){
                cout << "Некорректное значение!! Повторите попытку: ";
                flag=false;
                break;
            }
            else{
                result=result*10+(volname[i]-48);
                flag=true;
            }
        }
    }while(!flag);
    return result;
}

double volid_double(){          //проверка для цены
    char volname[20];
    double result=0.0;
    bool flag=false;
    int dot=0;

    while(!flag){
        cin >> volname;
        for(int i=0; volname[i]!='\0'; ++i){
            if((volname[i]<'.')||(volname[i]>'9')||(volname[i]=='/')){
                cout << "Неверное значение!!! Повторите попытку: ";
                flag=false;
                break;
            }
            else flag=true;
        }
    }
    for(; volname[dot]!='.'; ++dot){}
    --dot;
    for(int i=0; volname[i]!='\0'; ++i){
        if(volname[i]=='.')i++;

            result+=(volname[i]-48)*pow(10,dot);
            dot--;

    }
    return result;
}

void add(int x){   //функция добавления прибора
        N++;
        if(x==1){
            Temp=(device*)malloc(sizeof(device)*N);
            for(int i=0; i<N; i++)
            Temp[i]=List[i];
            free(List);                                     //1-я часть: работа с дин. памятью
        }
        List=(device*)malloc(sizeof(device)*N);
        if(x==1){
            for(int i=0; i<N; i++)
                List[i]=Temp[i];
            free(Temp);
        }
                                                                //2-я часть: ввод данных
        cout << "Введите данные нового прибора:\nНаименование: ";
        cin.ignore(); cin.getline(List[N-1].name, 20);  //функции для ввода нескольких слов через взятие из потока
        cout << "Инвентарный номер(отличный от нуля): ";
        List[N-1].number=volid();       //теперь считываем тикаим образом, проверяя значения
        while((check_number(List[N-1].number)==1)||(List[N-1].number<=0)){  //проверка на доступность номера
            while(List[N-1].number<=0){
                cout << "Введите значение, большее нуля!!" << endl;
                List[N-1].number=volid();
            }
            while(check_number(List[N-1].number)==1){
                cout << "Такой номер уже есть! Попробуйте еще раз: " << endl;
                List[N-1].number=volid();
            }
        }
        cout << "Год производства: ";
        List[N-1].year=volid();
        while(List[N-1].year>2019){
            cout << "Невозможное значение: год выпуска больше текущего!! Повторите попытку: ";
            List[N-1].year=volid();
        }
        cout << "Цена: ";
        List[N-1].cost=volid_double();
        cout << "\nПрибор добавлен!!" << endl;
}

void print(){   //вывод списка
    cout << "Cписок доступных приборов:\nНомер   Наименование   Год произв.    Цена" << endl;
    for(int i=0; i<N; i++)
    cout  << List[i].number <<"\t"<< List[i].name <<"\t\t"<< List[i].year <<"\t   "<< List[i].cost << endl;
}

void syear(){   //поиск по дате
    int year,check=0;
    cout << "Введите год производства: ";
    cin >> year;
    cout << "Приборы, найденные по дате выпуска:\nНомер   Наименование   Год произв.    Цена" << endl;
    for(int i=0; i<N; i++)
        if(List[i].year==year){
            cout  << List[i].number <<"\t"<< List[i].name <<"\t\t"<< List[i].year <<"\t   "<< List[i].cost << endl;
            check++;
        }
    if(check==0) cout << "Ни одного прибора по данной дате не найдено!!\n\n";
}

void scost(){       //поиск по цене
    int minc,maxc,check=0;
    cout << "Введите диапазон цен: с "; cin >> minc; cout << " по "; cin >> maxc;
    cout << "Приборы, найденные по данному дипазону цен:\nНомер   Наименование  Год произв.  Цена" << endl;
    for(int i=0; i<N; i++)
        if((List[i].cost>=minc)&&(List[i].cost<=maxc)){
            cout  << List[i].number <<"\t"<< List[i].name <<"\t\t"<< List[i].year <<"\t   "<< List[i].cost << endl;
            check++;
        }
    if(check==0) cout << "Ни одного прибора в данном диапазоне цен не найдено!!\n\n";
}

void maxcost(){     //самый дорогой прибор
    int Max=0,res;
    for(int i=0; i<N; i++)
        if(List[i].cost>Max){
            Max=List[i].cost;
            res=i;
        }
    cout  << "Самый дорогой прибор:\nНомер   Наименование   Год произв.    Цена\n" << List[res].number <<"\t\t"<< List[res].name <<"\t\t"<< List[res].year <<"\t   "<< List[res].cost << endl;
}

void del(){         //удаление приборов
    int number,check=0;
    cout << "Введите инвентарный номер прибора(введите 0 что бы отменить дейсвие): ";
    cin >> number;
    if(number!=0){
        for(int i=0; i<N; i++){
            if(List[i].number==number){
                for(int j=i; j<N-1; j++)
                    List[j]=List[j+1];
                N--;
            check++;
            }
        }
        if(check==0){
            cout << "Несуществующий инвентарый номер!" << endl;
            del();
        }
        else
            cout << "\nПрибор удален!!\n";
    }
    else
        cout << "\nДействие отменено\n";
}

int attention(){        //проверка на присутствие приборов в списке
    if(N==0){
        cout << "Нет доступных приборов!!" << endl;
        return 0;
    }
    return 1;
}

int main(){
    system("chcp 1251"); //русский текст для структур
    int ans;
    cout << "\t\t---Интерактивный список приборов---\n1.Добавить прибор\n2.Выход\n";
    cin >> ans;
    while((ans!=1)&&(ans!=2)){
        cout << "Некорректное значение!! Попробуйте еще раз--> ";
        cin >> ans;
    }
    if(ans==1)
        add(0);
    else{
        cout << "Удачного дня!!!";
        return 0;
    }
    for(;;){        //менюшка
        cout << "\nВыберите дальнейшее действие:\n1.Добавить новый прибор\n2.Показать список приборов\n3.Поиск приборов по году производства\n4.Поиск приборов в диапазоне цен\n5.Поиск самого дорогого прибора\n6.Удалить прибор из списка\n7.Выход\n" << endl;
        cin >> ans;
        switch(ans){
            case 1: add(1); break;
            case 2: if(attention()==0)continue;
                    print(); break;
            case 3: if(attention()==0)continue;
                    syear(); break;
            case 4: if(attention()==0)continue;
                    scost(); break;
            case 5: if(attention()==0)continue;
                    maxcost(); break;
            case 6: if(attention()==0)continue;
                    del(); break;
            case 7: free(List); cout << "Удачного дня!!!"; return 0;
            default: cout << "Неверное значение!!!" << endl;
        }
    }
    return 0;
}
