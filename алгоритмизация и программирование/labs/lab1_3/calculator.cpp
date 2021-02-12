#include <iostream>

using namespace std;

float expression();

float number(){
    int n=0;
    while(1){
        char c=cin.get();
        if(c>='0'&&c<='9')
            n=n*10+c-'0';
        else{
            cin.putback(c);
            return n;
        }
    }
}

float brackets(){
    char c=cin.get();
    if(c=='('){
        float x=expression();
        cin.get();
        return x;
       }
    else{
        cin.putback(c);
        return number();
     }

}

float factor(){
    float x=brackets();
    while(1){
        char c=cin.get();
        switch (c){
            case '*': x*=brackets(); break;
            case '/': x/=brackets(); break;
            default: cin.putback(c); return x;
        }
    }
}

int main(){
    cout << "Enter an expression: ";
    float res=expression();
    cout << "Result is : " << res << endl;
    return 0;
}

float expression(){
    float x=factor();
    while(1){
        char c=cin.get();
        switch (c){
            case '+': x+=factor(); break;
            case '-': x-=factor(); break;
            default: cin.putback(c); return x;
        }
    }
}
