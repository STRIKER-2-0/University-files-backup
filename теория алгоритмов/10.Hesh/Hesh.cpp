#include <iostream>
#include <clocale>
#include <cstdlib>
#include <ctime>
#include <sstream>
#include <cmath>
#define COUNT 10
#define A 0.6180339887

using namespace std;

struct value{
    string val;
    value* next=NULL;
};

class HashTable{
    value* values[COUNT];
public:
    HashTable(){
        for(int i=0; i<COUNT; i++)
            values[i]=NULL;
    }
    void add(int val){
        int index=hashing(val);
        if(values[index]==NULL){
            values[index]=new value;
            values[index]->val=toString(val);
        }
        else{
            value* tmp=values[index];
            while(tmp->next!=NULL){
                tmp=tmp->next;
            }
            tmp->next=new value;
            tmp->next->val=toString(val);
        }
    }
    int get(int key){
        int index=hashing(key);
        value* tmp=values[index];
        while(toInt(tmp->val)!=key && tmp->next!=NULL){
            tmp=tmp->next;
        }
        if(toInt(tmp->val)==key)
            return toInt(tmp->val);
        cerr << "--no such element---" << endl;
        return -1;
    }
    void del(int  key){
        int index=hashing(key);
        value* tmp=values[index];
        if(toInt(tmp->val)==key){
            values[index]=tmp->next;
            delete tmp;
        }
        else{
            while(toInt(tmp->next->val)!=key && tmp->next->next!=NULL){
                tmp=tmp->next;
            }
            if(toInt(tmp->next->val)==key){
                value* tmp2=tmp->next;
                tmp->next=tmp2->next;
                delete tmp2;
            }
            else cerr << "---no such element---" << endl;
        }
    }
    void print(){
        value* tmp;
        for(int i=0; i<COUNT; i++){
            cout << i << ": ";
            tmp=values[i];
            while(tmp!=NULL){
                cout << tmp->val << " ";
                tmp=tmp->next;
            }
            cout << endl;
        }
    }
    int hashing(int a){
        return a%COUNT;
    }
private:
    string toString(int a){
        stringstream ss;
        ss << a;
        string str;
        ss >> str;
        return str;
    }
    int toInt(string a){
        stringstream ss;
        ss << a;
        int str;
        ss >> str;
        return str;
    }
};

class LineHashTable{
    string* arr=NULL;
    int SIZE;
    int CAPACITY;
public:
    LineHashTable(){
        SIZE=COUNT;
        CAPACITY=0;
        arr=new string[SIZE];
        for(int i=0; i<SIZE; i++)
            arr[i]="EMPTY";
    }
    void add(int val){
        CAPACITY++;
        int index=hashing(val);
        while(index<SIZE){
            if(arr[index]=="EMPTY")
                break;
            index++;
        }
        if(index==SIZE)increase();
        arr[index]=toString(val);
        if(CAPACITY==SIZE)increase();
    }
    int get(int key){
        int index=hashing(key);
        for(int i=index; i<SIZE; i++){
            if(toInt(arr[i])==key){
                return toInt(arr[i]);
            }
        }
        cerr << "--no such element---" << endl;
        return -1;
    }
    void del(int key){
        int index=hashing(key);
        for(int i=index; i<SIZE; i++){
            if(toInt(arr[i])==key){
                arr[i]="EMPTY";
                return;
            }
        }
        cerr << "--no such element---" << endl;
    }
    void print(){
        for(int i=0; i<SIZE; i++)
            cout << i << ": " << arr[i] << endl;
    }
    int hashing(int a){
        double tmp;
        return (int)(COUNT*modf(a*A, &tmp));
    }
private:
    string toString(int a){
        stringstream ss;
        ss << a;
        string str;
        ss >> str;
        return str;
    }
    int toInt(string a){
        stringstream ss;
        ss << a;
        int str;
        ss >> str;
        return str;
    }
    void increase(){
        SIZE++;
        string* tmp=arr;
        arr=new string[SIZE];
        for(int i=0; i<SIZE-1; i++)
            arr[i]=tmp[i];
        arr[SIZE-1]="EMPTY";
        delete tmp;
    }
};


int counter=0;
bool isCollision(int arr[], int a, int index){
    for(int i=0; i<index; i++)
        if(arr[i]==a)
            return true;
    return false;
}
void hash_function(int N, int arr[], bool type){
    double tmp;
    counter=0;
    int hash_arr[100];
    for(int i=0; i<100; i++){
        if(type)hash_arr[i]=arr[i]%N;
        else hash_arr[i]=(int)(N*modf(arr[i]*A, &tmp));
        if(isCollision(hash_arr,hash_arr[i],i))
            counter++;
    }
    for(int i=0; i<100; i++)
       cout << hash_arr[i] << " ";
    cout << endl << " ол-во коллизий при N=" << N << ": " << counter << endl << endl;
}
int main(){
    setlocale(LC_CTYPE, "rus");
    srand(time(0));
    int bigarr[1000];
    for(int i=0; i<1000; i++)
        bigarr[i]=i;
    for(int i=0; i<3000; i++)
        swap(bigarr[rand()%1000],bigarr[rand()%1000]);
    int arr[100];
    for(int i=450; i<550; i++)
        arr[i-450]=bigarr[i];

    int N=10;
    hash_function(N, arr, 1);
    hash_function(N*10, arr, 1);
    hash_function(N*10+1, arr, 1);

    HashTable h;
    for(int i=0; i<100; i++)
        h.add(arr[i]);
    cout << "’еш-таблица с цепочным разрешением коллизий:" << endl;
    h.print();

    cout << endl;


    hash_function(N, arr, 0);
    hash_function(N*10, arr, 0);

    LineHashTable l;
    for(int i=0; i<100; i++)
        l.add(arr[i]);
    cout << "’еш-таблица с линейным разрешением коллизий:" << endl;
    l.print();
    l.del(336);

    return 0;
}
