#include <iostream>

using namespace std;

//int prior(char);
int main()
{
        char ans; char var[80]; char x[80]; int num[80]; int g=0;
        cout << "Do you want to work with some variables?(Answer y/n): ";
        cin >> ans;
        if(ans=='y'){
            cout << "Enter names of your variables comma-separated(for example: z,j,k,q,etc.): ";
            cin >> var;
            cout << "Now initialize them: " << endl;
            for(int i=0; var[i]!='\0'; i++){
                if(var[i]!=','){
                    cout << var[i] << "=";
                    x[g]=var[i];
                    cin >> num[g];
                    ++g;
                }
            }

            }
        else if(ans=='n'){

        }
        else{
            cout << "Uncorrect answer!";

        }

        for(int i=0; i<g; ++i){
            cout << num[i] << " ";
        }
              for(int i=0; i<g; ++i){
            cout << x[i] << " ";}
        cin.clear();
        return 0;
       /* for(int i=0; var[i]!='\0'; ++i)
            cout << var[i] << " ";*/


}















 /*   char str[80]; //строка для печати пользователем
    int num_stc[80]; int n=0; //стэк для чисел; его счетчик
    char ch_stc[80]; int m=0; //стэк для операций; его счетчик
    cin >> str; //ввод пользователем выражения


    if((str[0]>=48)&&(str[0]<=57)){
        num_stc[0]=str[0]-48;
        ++n;}
    else{                                //запись первого символа в стэк
        ch_stc[0]=str[0];
        ++m;}
    ch_stc[m-1]=0;


    for(int i=1; str[i]!='\0'; ++i){
        if((str[i]>=48)&&(str[i]<=57)){
            num_stc[n]=str[i]-48;
            ++n;}
        else{
            ch_stc[m]=str[i];
            ++m;
            if(prior(ch_stc[m-1])<=prior(ch_stc[m-2])){
                switch(ch_stc[m-2]){
                    case '*': num_stc[n-2]*=num_stc[n-1]; ch_stc[m-2]=ch_stc[m-1]; --n;  --m; break;
                    case '/': num_stc[n-2]/=num_stc[n-1]; ch_stc[m-2]=ch_stc[m-1]; --n;  --m; break;
                    case '+': num_stc[n-2]+=num_stc[n-1]; ch_stc[m-2]=ch_stc[m-1]; --n;  --m; break;
                    case '-': num_stc[n-2]-=num_stc[n-1]; ch_stc[m-2]=ch_stc[m-1]; --n;  --m; break;
                    }
                }

            }
    }

   switch(ch_stc[0]){
                    case '*': num_stc[0]*=num_stc[1]; ch_stc[m-2]=ch_stc[m-1]; --n;  --m; break;
                    case '/': num_stc[0]/=num_stc[1]; ch_stc[m-2]=ch_stc[m-1]; --n;  --m; break;
                    case '+': num_stc[0]+=num_stc[1]; ch_stc[m-2]=ch_stc[m-1]; --n;  --m; break;
                    case '-': num_stc[0]-=num_stc[1]; ch_stc[m-2]=ch_stc[m-1]; --n;  --m; break;
                    }















    for(int i=0; num_stc[i]!=num_stc[n]; ++i){
        cout << num_stc[i] << " ";
        }
   cout << endl;
    for(int i=0; ch_stc[i]!=ch_stc[m]; ++i){
        cout << ch_stc[i] << " ";
        }
    cout << endl;
    for(int i=0; ch_stc[i]!=ch_stc[m]; ++i){
        cout << prior(ch_stc[i]) << " ";
        }





    return 0;
}
int prior(char a){
      switch(a){
            case '*':
            case '/':
                 return 3;

            case '-':
            case '+':
                 return 2;

            case '(':
                 return 1;
        }
    }*/
