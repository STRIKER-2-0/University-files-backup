#include <iostream>
#include <My_library.h> //личная библиотека. Используется функция cin_valid(), для проверки типа вводимых данных
#include <string>
#include <windows.h>

using namespace std;

struct list{    //структура базы студентов
    list* next;
    string lastname;
    string firstname;
    string patronimic;
    struct{
        int day;
        int month;
        int year;
    }date;
    double perfomance;
};

int N=0;
list* List;
list* last;

void add(int);
void sorting(list*);
void print();
void search_name();
list* init(int);
list* add_elem(list* lst, int number);
void Erase(list* lst);
void print_perf();
void Delete();

int main(){
    SetConsoleCP(1251);     //украинский
    SetConsoleOutputCP(1251);
    string name;
    bool flag=false;
    int ans;

    cout << "Добрий день!!" << endl;
    for(;;){
        cout << "\n1.Вивести дані по всім студентам\n2.Додати нового студента(початок списку)\n3.Додати нового студента(кінець списку)\n4.Додати нового студента(після вказанного студенту)\n5.Пошук за прізвищем\n6.Вивести дані по успішності студентів\n7.Видалення студента\n8.Вихід\n";
        ans=cin_valid();
        switch(ans){
            case 1: if(N==0) cout << "Студенти відсутні\n"; else print(); break;
            case 2: add(0); break;
            case 3: if(N==0) cout << "Студенти відсутні\n";
                    else{
                        last=List;
                        while(last->next!=NULL)
                            last=last->next;
                        add(1);
                    }
                    break;
            case 4: if(N==0) cout << "Студенти відсутні\n";
                    else{
                        cout << "Ведіть прізвище студента, після якого ви бажаєте додати нового: ";
                        cin >> name;
                        last=List;
                        if(last->lastname==name)
                                flag=true;
                        while((last->next!=NULL)&&(last->lastname!=name)){
                            last=last->next;
                            if(last->lastname==name)
                                flag=true;
                        }
                        if(flag==true)add(1);
                        else cout << "Жодного студента з такими даними не знайдено!!" << endl;
                    }
                    break;
            case 5: if(N==0) cout << "Студенти відсутні\n"; else search_name();  break;
            case 6: if(N==0) cout << "Студенти відсутні\n"; else print_perf();  break;
            case 7: if(N==0) cout << "Студенти відсутні\n"; else Delete(); break;
            case 8: cout << "До побачення!!"; Erase(List); return 0;
            default: cout << "Неправильне значення!!!" << endl;
        }
    }
}

void add(int x){     //добаление элемента
    N++;
    if(N==1){
        List=init(0);  //случай создания
        last=List;
    }
    else if(x==0)
        last=add_elem(List,0);
    else
        last=add_elem(last,0);

    cout << "Введіть дані нового студента:\nПрізвище: ";    //ввод данніх
    cin >> last->lastname;
    cout << "Ім'я: ";
    cin >> last->firstname;
    cout << "По-батькові: ";
    cin >> last->patronimic;
    cout << "Дата народження:\nДень: ";
    last->date.day=(int)cin_valid();
    while((last->date.day==0)||(last->date.day>31)){    //проверки на возможность даты
        cout << "Неправильна дата! Введіть число від 1 до 31: ";
        last->date.day=(int)cin_valid();
    }
    cout << "Місяць: ";
    last->date.month=(int)cin_valid();
    while((last->date.month==0)||(last->date.month>12)){
        cout << "Неправильна дата! Введіть число від 1 до 12: ";
        last->date.month=(int)cin_valid();
    }
    cout << "Рік: ";
    last->date.year=(int)cin_valid();
    while(last->date.year>2019){
        cout << "Неправильна дата! Введіть число від 0 до 2019: ";
        last->date.year=(int)cin_valid();
    }
    cout << "Середня успішність: ";
    last->perfomance=cin_valid();
    while(last->perfomance>100.0){    //и на правильность испеваемости
        cout << "Неправильна дата! Введіть число від 0 до 100: ";
        last->perfomance=(int)cin_valid();
    }
    cout << "Дані додано!!!" << endl;
    sorting(List);
}

list* init(int a){      //инициализация списка
    list* lst=new list;
    lst->perfomance=a;
    lst->next=NULL;
    return lst;
}

list* add_elem(list* lst, int number){  //добавление элемента в список
    list *temp,*p;
    temp=new list;
    p=lst->next;
    lst->next=temp;
    temp->perfomance=number;
    temp->next=p;
    return temp;
}

void sorting(list* lst){
    list* tmp=lst;
    list CELL;

    while(tmp->next!=NULL){
        if((tmp->lastname)>(tmp->next->lastname)){
            CELL.lastname=tmp->lastname;
            CELL.firstname=tmp->firstname;
            CELL.patronimic=tmp->patronimic;
            CELL.date=tmp->date;
            CELL.perfomance=tmp->perfomance;

            tmp->lastname=tmp->next->lastname;
            tmp->firstname=tmp->next->firstname;
            tmp->patronimic=tmp->next->patronimic;
            tmp->date=tmp->next->date;
            tmp->perfomance=tmp->next->perfomance;

            tmp->next->lastname=CELL.lastname;
            tmp->next->firstname=CELL.firstname;
            tmp->next->patronimic=CELL.patronimic;
            tmp->next->date=CELL.date;
            tmp->next->perfomance=CELL.perfomance;

            tmp=lst;
        }
        else tmp=tmp->next;
    }
}

void print(){   //печать
    last=List;
    cout << "Номер\tПрізвище\tІм'я\t\tПо-батькові\tДата народження\tСередня успішність\n";
    for(int i=0; i<N; i++){
        cout << i+1 << ".\t" << last->lastname;
        if(last->lastname.size()>=8)cout<<"\t";   //контроль табуляций
        else cout << "\t\t";
        cout << last->firstname;
        if(last->firstname.size()>=8)cout<<"\t";
        else cout << "\t\t";
        cout << last->patronimic;
        if(last->patronimic.size()>=8)cout<<"\t";
        else cout << "\t\t";
        if(last->date.day<10)cout <<"0";  //нули для даты
        cout << last->date.day <<".";
        if(last->date.month<10)cout <<"0";
        cout << last->date.month <<"."<< last->date.year <<"\t"<< last->perfomance << endl;
        last=last->next;
    }
}

void search_name(){ //поиск по фамилии
    string name;
    bool flag=false;//флаг для существования
    last=List;

    cout << "Введіть прізвище студента: ";
    cin >> name;
    for(int i=0; i<N; i++){//цикл для проверки, существуют ли данные элементы
        if(last->lastname==name){
            cout << "\nСтуденти знайдені:\nНомер\tПрізвище\tІм'я\t\tПо-батькові\tДата народження\tСередня успішність\n";
            flag=true;
            break;
        }
        last=last->next;
    }

    if(flag==false){
            cout << "Жодного студента з такими даними не знайдено!!" << endl;
            return; //здесь прервется ф-я
    }

    last=List;
    for(int i=0; i<N; i++){
        if(last->lastname==name){ //тут такой же вывод, как и в принте
            cout << i+1 << ".\t" << last->lastname;
            if(last->lastname.size()>=8)cout<<"\t";   //контроль табуляций
            else cout << "\t\t";
            cout << last->firstname;
            if(last->firstname.size()>=8)cout<<"\t";
            else cout << "\t\t";
            cout << last->patronimic;
            if(last->patronimic.size()>=8)cout<<"\t";
            else cout << "\t\t";
            if(last->date.day<10)cout <<"0";
            cout << last->date.day <<".";
            if(last->date.month<10)cout <<"0";
            cout << last->date.month <<"."<< last->date.year <<"\t"<< last->perfomance << endl;
        }
        last=last->next;
    }
}

void print_perf(){
    bool flag=false;
    last=List;

    for(int i=0; i<N; i++){//цикл для проверки, существуют ли данные элементы
        if(last->perfomance>=90){
            cout << "\n\"Відміннно\":\nНомер\tПрізвище\tІм'я\t\tПо-батькові\tДата народження\tСередня успішність\n";
            flag=true;
            break;
        }
        last=last->next;
    }

    if(flag==false){
            cout << "\n\"Відміннно\":\n--Відсутні--" << endl;

    }

    last=List;
    for(int i=0; i<N; i++){
        if(last->perfomance>=90){ //тут такой же вывод, как и в принте
            cout << i+1 << ".\t" << last->lastname;
            if(last->lastname.size()>=8)cout<<"\t";   //контроль табуляций
            else cout << "\t\t";
            cout << last->firstname;
            if(last->firstname.size()>=8)cout<<"\t";
            else cout << "\t\t";
            cout << last->patronimic;
            if(last->patronimic.size()>=8)cout<<"\t";
            else cout << "\t\t";
            if(last->date.day<10)cout <<"0";
            cout << last->date.day <<".";
            if(last->date.month<10)cout <<"0";
            cout << last->date.month <<"."<< last->date.year <<"\t"<< last->perfomance << endl;
        }
        last=last->next;
    }

    flag=false;
    last=List;

    for(int i=0; i<N; i++){//цикл для проверки, существуют ли данные элементы
        if((last->perfomance<90)&&(last->perfomance>=70)){
            cout << "\n\"Добре\":\nНомер\tПрізвище\tІм'я\t\tПо-батькові\tДата народження\tСередня успішність\n";
            flag=true;
            break;
        }
        last=last->next;
    }

    if(flag==false){
            cout << "\n\"Добре\":\n--Відсутні--" << endl;

    }

    last=List;
    for(int i=0; i<N; i++){
        if((last->perfomance<90)&&(last->perfomance>=70)){ //тут такой же вывод, как и в принте
            cout << i+1 << ".\t" << last->lastname;
            if(last->lastname.size()>=8)cout<<"\t";   //контроль табуляций
            else cout << "\t\t";
            cout << last->firstname;
            if(last->firstname.size()>=8)cout<<"\t";
            else cout << "\t\t";
            cout << last->patronimic;
            if(last->patronimic.size()>=8)cout<<"\t";
            else cout << "\t\t";
            if(last->date.day<10)cout <<"0";
            cout << last->date.day <<".";
            if(last->date.month<10)cout <<"0";
            cout << last->date.month <<"."<< last->date.year <<"\t"<< last->perfomance << endl;
        }
        last=last->next;
    }

    flag=false;
    last=List;

    for(int i=0; i<N; i++){//цикл для проверки, существуют ли данные элементы
        if((last->perfomance<70)&&(last->perfomance>=50)){
            cout << "\n\"Задовільно\":\nНомер\tПрізвище\tІм'я\t\tПо-батькові\tДата народження\tСередня успішність\n";
            flag=true;
            break;
        }
        last=last->next;
    }

    if(flag==false){
            cout << "\n\"Задовільно\":\n--Відсутні--" << endl;

    }

    last=List;
    for(int i=0; i<N; i++){
        if((last->perfomance<70)&&(last->perfomance>=50)){ //тут такой же вывод, как и в принте
            cout << i+1 << ".\t" << last->lastname;
            if(last->lastname.size()>=8)cout<<"\t";   //контроль табуляций
            else cout << "\t\t";
            cout << last->firstname;
            if(last->firstname.size()>=8)cout<<"\t";
            else cout << "\t\t";
            cout << last->patronimic;
            if(last->patronimic.size()>=8)cout<<"\t";
            else cout << "\t\t";
            if(last->date.day<10)cout <<"0";
            cout << last->date.day <<".";
            if(last->date.month<10)cout <<"0";
            cout << last->date.month <<"."<< last->date.year <<"\t"<< last->perfomance << endl;
        }
        last=last->next;
    }

    flag=false;
    last=List;

    for(int i=0; i<N; i++){//цикл для проверки, существуют ли данные элементы
        if(last->perfomance<50){
            cout << "\n\"Незадовільно\":\nНомер\tПрізвище\tІм'я\t\tПо-батькові\tДата народження\tСередня успішність\n";
            flag=true;
            break;
        }
        last=last->next;
    }

    if(flag==false){
            cout << "\n\"Незадовільно\":\n--Відсутні--" << endl;

    }

    last=List;
    for(int i=0; i<N; i++){
        if(last->perfomance<50){ //тут такой же вывод, как и в принте
            cout << i+1 << ".\t" << last->lastname;
            if(last->lastname.size()>=8)cout<<"\t";   //контроль табуляций
            else cout << "\t\t";
            cout << last->firstname;
            if(last->firstname.size()>=8)cout<<"\t";
            else cout << "\t\t";
            cout << last->patronimic;
            if(last->patronimic.size()>=8)cout<<"\t";
            else cout << "\t\t";
            if(last->date.day<10)cout <<"0";
            cout << last->date.day <<".";
            if(last->date.month<10)cout <<"0";
            cout << last->date.month <<"."<< last->date.year <<"\t"<< last->perfomance << endl;
        }
        last=last->next;
    }
}

void Erase(list* lst){
    list* tmp;
    while(lst!=NULL){
        tmp=lst;
        lst=lst->next;
        delete &tmp;
    }
}

void Delete(){  //удаление студента
    string name;
    list* temp=List;
    bool flag=false;

    cout << "Вкажіть прізвище студентів, яких бажаєте видалити: ";
    cin >> name;

    last=List;
    while(last!=NULL){
        if(last->lastname==name){
            while((temp->next!=last)&&(temp!=last))
                temp=temp->next;
            if(temp==last){
                List=last->next;
                delete &List;
                }
            else{
                temp->next=last->next;
                delete &last;
            }

            flag=true;
            N--;
        }
        last=last->next;
    }

    if(flag==false)
        cout << "Жодного студента з такими даними не знайдено!" << endl;

    else cout << "Студентів видалено!" << endl;
}

