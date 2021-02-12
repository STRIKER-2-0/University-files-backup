#include <iostream>

using namespace std;

float expression();

float number(){
    int n=0;
    for(int i=0;;i++){
        char c[80];
        cin >> c;
        if(c[i]>='0'&&c[i]<='9')
            n=n*10+c[i]-'0';
        else{
            cin.putback(c[i]);
            return n;
        }
    }
}

float brackets(){
    char c[80];
        cin >> c;
    if(c=='('){
        float x=expression();
         cin >> c;
        return x;
       }
    else{
        cin.putback(c);
        return number();
     }

}

float factor(){
    float x=brackets();
    for(int i=0;;++i){
        char c[80];
        cin >> c;
        switch (c[i]){
            case '*': x*=brackets(); break;
            case '/': x/=brackets(); break;
            default: cin.putback(c[i]); return x;
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
    for(int i=0;;++i){
        char c[80];
        cin >> c;
        switch (c[i]){
            case '+': x+=factor(); break;
            case '-': x-=factor(); break;
            default: cin.putback(c[i]); return x;
        }
    }
}
