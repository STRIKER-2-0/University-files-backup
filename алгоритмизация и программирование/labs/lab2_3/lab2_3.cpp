#include <iostream>
#include <My_library.h> //личная библиотека. Используется функция cin_valid(), для проверки типа вводимых данных
#include <string>
#include <windows.h>
#include <stdio.h>

using namespace std;


struct student_base{    //структура базы студентов
    char lastname[20];
    char firstname[20];
    char patronimic[25];
    struct{
        int day;
        int month;
        int year;
    }date;
    double perfomance;
};

int N=0;
student_base* List;
FILE* file;

void load();
void add();
void sorting();
void klass();
void print();
void SearchMenu();
void search_name();
void search_perf();
void search_date();
void Delete();
void klassMenu();

int main(){
    SetConsoleCP(1251);     //украинский
    SetConsoleOutputCP(1251);

    load();//загрузка данных
    int ans;
    cout << "Добрий день!!" << endl;
    for(;;){
        cout << "\n1.Додати нового студента\n2.Вивести дані по всім студентам\n3.Пошук\n4.Видалення студента\n5.Класифікація по категоріям\n6.Вихід\n";
        ans=cin_valid();
        switch(ans){
            case 1: add(); break;
            case 2: if(N==0) cout << "Студенти відсутні\n"; else print(); break;
            case 3: if(N==0) cout << "Студенти відсутні\n"; else SearchMenu();  break;
            case 4: if(N==0) cout << "Студенти відсутні\n"; else Delete(); break;
            case 5: if(N==0) cout << "Студенти відсутні\n"; else klassMenu(); break;
            case 6: cout << "До побачення!!"; delete[] List; return 0;
            default: cout << "Неправильне значення!!!" << endl;
        }
    }
}

void load(){    //загрузка данных с жесткого диска
    file=fopen("base.bin","rb");
    if(file==NULL)
        return;

    while(1){
        if(feof(file)!=0)
            break;
        N++;
        if(N==1)
            List=new student_base[N];
        else{
            student_base* Temp=new student_base[N];
            for(int i=0; i<N-1; i++)
                Temp[i]=List[i];
            delete[] List;
            List=Temp;
        }
        fread(&List[N-1],sizeof(List[N-1]),1,file);
    }
    fclose(file);

    //удаление лишнего элемента, создаваемого из-за бага feof
    N--;
    student_base* Temp=new student_base[N];
    for(int i=0; i<N; i++)
        Temp[i]=List[i];
    delete[] List;
    List=Temp;
}

void add(){     //добаление элемента
    N++;
    if(N==1)
        List=new student_base[N];    //случай создания
    else{
        student_base* Temp=new student_base[N];   //случай добавления
        for(int i=0; i<N-1; i++)
            Temp[i]=List[i];
        delete[] List;
        List=Temp;
    }

    cout << "Введіть дані нового студента:\nПрізвище: ";    //ввод данніх
    cin >> List[N-1].lastname;
    cout << "Ім'я: ";
    cin >> List[N-1].firstname;
    cout << "По-батькові: ";
    cin >> List[N-1].patronimic;
    cout << "Дата народження:\nДень: ";
    List[N-1].date.day=(int)cin_valid();
    while((List[N-1].date.day<=0)||(List[N-1].date.day>31)){    //проверки на возможность даты
        cout << "Неправильна дата! Введіть число від 1 до 31: ";
        List[N-1].date.day=(int)cin_valid();
    }
    cout << "Місяць: ";
    List[N-1].date.month=(int)cin_valid();
    while((List[N-1].date.month<=0)||(List[N-1].date.month>12)){
        cout << "Неправильна дата! Введіть число від 1 до 12: ";
        List[N-1].date.month=(int)cin_valid();
    }
    cout << "Рік: ";
    List[N-1].date.year=(int)cin_valid();
    while((List[N-1].date.year<0)||(List[N-1].date.year>2019)){
        cout << "Неправильна дата! Введіть число від 0 до 2019: ";
        List[N-1].date.year=(int)cin_valid();
    }
    cout << "Середня успішність: ";
    List[N-1].perfomance=cin_valid();
    while((List[N-1].perfomance>100.0)||(List[N-1].perfomance<0)){    //и на правильность испеваемости
        cout << "Неправильні дані! Введіть число від 0 до 100: ";
        List[N-1].perfomance=(int)cin_valid();
    }
    cout << "Дані додано!!!" << endl;
    sorting();

    file=fopen("base.bin","wb");    //перезаписываем данные полностью
    for(int i=0; i<N; i++)
        fwrite(&List[i],sizeof(List[i]),1,file);
    fclose(file);
    klass();//и классифицыруем
}

void sorting(){ //сортировка по алфавиту
    student_base Temp;
    for(int j=0; j<N; j++)
        for(int i=0; i<N-1; i++)
            if(strcmp(List[i].lastname,List[i+1].lastname)>0){
                Temp=List[i];
                List[i]=List[i+1];
                List[i+1]=Temp;
            }
}

void print(){   //печать
    cout << "Номер\tПрізвище\tІм'я\t\tПо-батькові\tДата народження\tСередня успішність\n";
    for(int i=0; i<N; i++){
        cout << i+1 << ".\t" << List[i].lastname;
        if(strlen(List[i].lastname)>=8)cout<<"\t";   //контроль табуляций
        else cout << "\t\t";
        cout << List[i].firstname;
        if(strlen(List[i].firstname)>=8)cout<<"\t";
        else cout << "\t\t";
        cout << List[i].patronimic;
        if(strlen(List[i].patronimic)>=8)cout<<"\t";
        else cout << "\t\t";
        if(List[i].date.day<10)cout <<"0";  //нули для даты
        cout << List[i].date.day <<".";
        if(List[i].date.month<10)cout <<"0";
        cout << List[i].date.month <<"."<< List[i].date.year <<"\t"<< List[i].perfomance << endl;
    }
}

void SearchMenu(){  //меню поиска
    int ans;
    for(;;){
        cout << "\n1.Пошук за прізвищем\n2.Пошук за діапазоном успішності\n3.Пошук за датою народження\n4.Відхилити\n";
        ans=cin_valid();
        switch(ans){
            case 1: search_name(); return;
            case 2: search_perf(); return;
            case 3: search_date(); return;
            case 4: cout << "Дія відхилена!!\n"; return;
            default: cout << "Неправильне значення!!!" << endl;
        }
    }
}

void search_name(){ //поиск по фамилии
    string name;
    bool flag=false;//флаг для существования

    cout << "Введіть прізвище студента: ";
    cin >> name;
    for(int i=0; i<N; i++)//цикл для проверки, существуют ли данные элементы
        if(List[i].lastname==name){
            cout << "\nСтуденти знайдені:\nНомер\tПрізвище\tІм'я\t\tПо-батькові\tДата народження\tСередня успішність\n";
            flag=true;
            break;
        }

    if(flag==false){
            cout << "Жодного студента з такими даними не знайдено!!" << endl;
            return; //здесь прервется ф-я
    }

    for(int i=0; i<N; i++)
        if(List[i].lastname==name){ //тут такой же вывод, как и в принте
            cout << i+1 << ".\t" << List[i].lastname;
            if(strlen(List[i].lastname)>=8)cout<<"\t";   //контроль табуляций
        else cout << "\t\t";
        cout << List[i].firstname;
        if(strlen(List[i].firstname)>=8)cout<<"\t";
        else cout << "\t\t";
        cout << List[i].patronimic;
        if(strlen(List[i].patronimic)>=8)cout<<"\t";
            else cout << "\t\t";
            if(List[i].date.day<10)cout <<"0";
            cout << List[i].date.day <<".";
            if(List[i].date.month<10)cout <<"0";
            cout << List[i].date.month <<"."<< List[i].date.year <<"\t"<< List[i].perfomance << endl;
        }
}

void search_perf(){ //поиск по диапазону успеваемости(дальнейшие функции работают по аналогии, лишь с небольшими специальными отличиями)
    int beg,fin;
    bool flag=false;

    cout << "Введіть діапазон баллів успішності(В межах від 0 до 100 включно):\nЗ(Нижня межа): ";
    beg=(int)cin_valid();
    while((beg<0)||(beg>100)){  //контроль границ ввода
        cout << "Неправильна межа! Введіть число від 0 до 100: ";
        beg=(int)cin_valid();
    }
    cout << "По(Верхня межа): ";
    fin=(int)cin_valid();
    while((fin<0)||(fin>100)){
        cout << "Неправильна межа! Введіть число від 0 до 100: ";
        fin=(int)cin_valid();
    }

    for(int i=0; i<N; i++)
        if((List[i].perfomance>=beg)&&(List[i].perfomance<=fin)){
            cout << "\nСтуденти знайдені:\nНомер\tПрізвище\tІм'я\t\tПо-батькові\tДата народження\tСередня успішність\n";
            flag=true;
            break;
        }
    if(flag==false){
        cout << "Жодного студента з такими даними не знайдено!!" << endl;
        return;
    }

    for(int i=0; i<N; i++)
        if((List[i].perfomance>=beg)&&(List[i].perfomance<=fin)){
            cout << i+1 << ".\t" << List[i].lastname;
            if(strlen(List[i].lastname)>=8)cout<<"\t";   //контроль табуляций
        else cout << "\t\t";
        cout << List[i].firstname;
        if(strlen(List[i].firstname)>=8)cout<<"\t";
        else cout << "\t\t";
        cout << List[i].patronimic;
        if(strlen(List[i].patronimic)>=8)cout<<"\t";
            else cout << "\t\t";
            if(List[i].date.day<10)cout <<"0";
            cout << List[i].date.day <<".";
            if(List[i].date.month<10)cout <<"0";
            cout << List[i].date.month <<"."<< List[i].date.year <<"\t"<< List[i].perfomance << endl;
        }
}

void search_date(){ //поиск по дате
    int day,month;
    bool flag=false;

    cout << "Введіть дату народження:\nДень: ";
    day=(int)cin_valid();
    while((day<=0)||(day>31)){  //контроль границ ввода
        cout << "Неправильна дата! Введіть число від 1 до 31: ";
        day=(int)cin_valid();
    }
    cout << "Місяць: ";
    month=(int)cin_valid();
    while((month<=0)||(month>12)){  //контроль границ ввода
        cout << "Неправильна дата! Введіть число від 1 до 12: ";
        month=(int)cin_valid();
    }

    for(int i=0; i<N; i++)
        if((List[i].date.day==day)&&(List[i].date.month==month)){
            cout << "\nСтуденти знайдені:\nНомер\tПрізвище\tІм'я\t\tПо-батькові\tДата народження\tСередня успішність\n";
            flag=true;
            break;
        }
    if(flag==false){
        cout << "Жодного студента з такими даними не знайдено!!" << endl;
        return;
    }

    for(int i=0; i<N; i++)
        if((List[i].date.day==day)&&(List[i].date.month==month)){
            cout << i+1 << ".\t" << List[i].lastname;
            if(strlen(List[i].lastname)>=8)cout<<"\t";   //контроль табуляций
        else cout << "\t\t";
        cout << List[i].firstname;
        if(strlen(List[i].firstname)>=8)cout<<"\t";
        else cout << "\t\t";
        cout << List[i].patronimic;
        if(strlen(List[i].patronimic)>=8)cout<<"\t";
            else cout << "\t\t";
            if(List[i].date.day<10)cout <<"0";
            cout << List[i].date.day <<".";
            if(List[i].date.month<10)cout <<"0";
            cout << List[i].date.month <<"."<< List[i].date.year <<"\t"<< List[i].perfomance << endl;
        }
}

void Delete(){  //удаление студента
    int pos;

    cout << "Вкажіть номер студента, якого бажаєте видалити(введіть 0 щоб скасувати): ";
    pos=(int)cin_valid();
    if(pos==0){
        cout << "Скасовано!!\n"; return;
    }
    while(pos>N){
        cout << "Такий номер відсутній!!\n";
        pos=(int)cin_valid();
    }

    pos--;
    N--;
    student_base* Temp=new student_base[N];
    for(int i=0; i<pos; i++)
        Temp[i]=List[i];
    for(int i=pos+1; i<N+1; i++)
        Temp[i-1]=List[i];

    delete[] List;
    List=Temp;
    cout << "Студента видалено!!" << endl;

    file=fopen("base.bin","wb");
    for(int i=0; i<N; i++)
        fwrite(&List[i],sizeof(List[i]),1,file);
    fclose(file);
    klass();//не заьываем классифицировать
}

void klass(){   //запись студентов в файлы классификации
    file=fopen("high.bin", "wb");
    for(int i=0; i<N; i++)
        if(List[i].perfomance>=70)
            fwrite(&List[i],sizeof(List[i]),1,file);
    fclose(file);
    file=fopen("low.bin", "wb");
    for(int i=0; i<N; i++)
        if((List[i].perfomance>=50)&&(List[i].perfomance<70))
            fwrite(&List[i],sizeof(List[i]),1,file);
    fclose(file);
    file=fopen("none.bin", "wb");
    for(int i=0; i<N; i++)
        if(List[i].perfomance<50)
            fwrite(&List[i],sizeof(List[i]),1,file);
    fclose(file);
}

void klassMenu(){   //меню класификации студентов
    student_base temp;
    int ans,i=0;
    cout << "\n--Меню класифікації студентів--!!" << endl;
    for(;;){
        cout << "\n1.Студенти з високим балом\n2.Студенти з низьким балом\n3.Студенти без заліку\n4.Повернутися у попереднє меню\n";
        ans=cin_valid();
        switch(ans){
            case 1:
                file=fopen("high.bin", "rb");
                while(1){
                    fread(&temp,sizeof(temp),1,file);
                    if(feof(file)!=0)break;
                    if(temp.perfomance>=70){
                        cout << ++i << ".\t" << temp.lastname;
                        if(strlen(temp.lastname)>=8)cout<<"\t";   //контроль табуляций
                        else cout << "\t\t";
                        cout << temp.firstname;
                        if(strlen(temp.firstname)>=8)cout<<"\t";
                        else cout << "\t\t";
                        cout << temp.patronimic;
                        if(strlen(temp.patronimic)>=8)cout<<"\t";
                        else cout << "\t\t";
                        if(temp.date.day<10)cout <<"0";  //нули для даты
                        cout << temp.date.day <<".";
                        if(temp.date.month<10)cout <<"0";
                        cout << temp.date.month <<"."<< temp.date.year <<"\t"<< temp.perfomance << endl;
                    }
                }
                fclose(file);
                break;
            case 2:
                file=fopen("low.bin", "rb");
                while(1){
                    fread(&temp,sizeof(temp),1,file);
                    if(feof(file)!=0)break;
                    if((temp.perfomance>=50)&&(temp.perfomance<70)){
                        cout << ++i << ".\t" << temp.lastname;
                        if(strlen(temp.lastname)>=8)cout<<"\t";   //контроль табуляций
                        else cout << "\t\t";
                        cout << temp.firstname;
                        if(strlen(temp.firstname)>=8)cout<<"\t";
                        else cout << "\t\t";
                        cout << temp.patronimic;
                        if(strlen(temp.patronimic)>=8)cout<<"\t";
                        else cout << "\t\t";
                        if(temp.date.day<10)cout <<"0";  //нули для даты
                        cout << temp.date.day <<".";
                        if(temp.date.month<10)cout <<"0";
                        cout << temp.date.month <<"."<< temp.date.year <<"\t"<< temp.perfomance << endl;
                    }
                }
                fclose(file);
                break;
            case 3:
                file=fopen("none.bin", "rb");
                while(1){
                    fread(&temp,sizeof(temp),1,file);
                    if(feof(file)!=0)break;
                    if(temp.perfomance<50){
                        cout << ++i << ".\t" << temp.lastname;
                        if(strlen(temp.lastname)>=8)cout<<"\t";   //контроль табуляций
                        else cout << "\t\t";
                        cout << temp.firstname;
                        if(strlen(temp.firstname)>=8)cout<<"\t";
                        else cout << "\t\t";
                        cout << temp.patronimic;
                        if(strlen(temp.patronimic)>=8)cout<<"\t";
                        else cout << "\t\t";
                        if(temp.date.day<10)cout <<"0";  //нули для даты
                        cout << temp.date.day <<".";
                        if(temp.date.month<10)cout <<"0";
                        cout << temp.date.month <<"."<< temp.date.year <<"\t"<< temp.perfomance << endl;
                    }
                }
                fclose(file);
                break;
            case 4: return;
            default: cout << "Неправильне значення!!!" << endl;
        }
    }
}
