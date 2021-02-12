#include <iostream>
#include <windows.h>
#include <cstdio>

using namespace std;

int N=0, size=0;
FILE* file;

int* init(int val){
    N=10;
    int *tmp=new int[N];
    tmp[0]=val;
    size=1;
    return tmp;
}

void print(int* Stack){
    file=fopen("lol.txt", "r");
    for(int i=0; i<N; i++){
        fread(&Stack[i], sizeof(Stack[i]), 1, file);
    }
    fclose(file);
    for(int i=0; i<size; i++)
        cout << Stack[i] << " ";
    cout << endl;
}

int* increase(int* Stack){
    N+=10;
    int* tmp=new int[N];
    for(int i=0; i<N-10; i++)
        tmp[i]=Stack[i];
    return tmp;
}

int* push(int *Stack, int val){
    if(size==N-1)
        Stack=increase(Stack);
    Stack[size]=val;
    size++;
    file=fopen("lol.txt", "w");
    for(int i=0; i<N; i++){
        fwrite(&Stack[i], sizeof(Stack[i]), 1, file);
    }
    fclose(file);

    return Stack;
}

int pop(int* Stack){
    size--;
    file=fopen("lol.txt", "w");
    for(int i=0; i<N; i++){
        fwrite(&Stack[i], sizeof(Stack[i]), 1, file);
    }
    fclose(file);
    return Stack[size];
}

int main(){
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);
    int n;
    int* Stack;


    Stack=init(0);
    for(int i=1; i<10; i++)
        Stack=push(Stack,i);
    print(Stack);

    file=fopen("lol.txt", "w");
    for(int i=0; i<N; i++){
        fwrite(&Stack[i], sizeof(Stack[i]), 1, file);
    }
    fclose(file);


    int ans;
    while(true){
        cout << "\n1.������� �������� � ����\n2.��������� �������� �� �����\n5.������ �����\n7.�����\n";
        cin >> ans;
        switch(ans){
            case 1: cout << "������� �����: ";
                    cin >> n;
                    if(Stack==NULL)
                        Stack=init(n);
                    else
                        Stack=push(Stack,n);
                    cout << "����� �������� � ����!" << endl;
                    break;

            case 2: if(Stack==NULL)
                        cout << "���� ����!" << endl;
                    else{
                        n=pop(Stack);
                        cout << "�������� ������� �� ����� � �������� � �����: " << n << endl;
                    }
                    break;

            case 5: if(Stack==NULL)
                        cout << "���� ����!" << endl;
                    else{
                        cout << "��������� �����: ";
                        print(Stack);
                    }
                    break;

            case 7: cout << "�������� ���!!"; delete[] Stack;  return 0;
            default: cout << "�������� ��������!!" << endl;
        }
    }
}
