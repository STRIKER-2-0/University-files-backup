#include <iostream>
#include <windows.h>
#include <queue>
#include <My_library.h>

using namespace std;

struct obj{
    int key;
    char sym;
};

class Tree{
    obj data;       //������
    Tree* parent=NULL;  //��������
    Tree* left=NULL;    //����� �������
    Tree* right=NULL;   //������ �������
    queue<Tree*> q; //�������(��� ������ � ������)


public:
    Tree(obj elem){
        data=elem;
    }
    void add(obj elem){     //����������  �������� � ������
        if(elem.key<data.key){  //���� ������
            if(left==NULL){     //� ��� �������
                left=new Tree(elem);
                left->parent=this;
            }
            else    //���� �������
                left->add(elem);
        }
        else if(elem.key>data.key){ //���� ������
            if(right==NULL){    //��� �������
                right=new Tree(elem);
                right->parent=this;
            }
            else        //����
                right->add(elem);
        }
        else    //� ������ ���������, ������ ������
            cerr << "ERROR: Element with such key is already existing!" << endl;
    }
    void add(Tree *tr){
        if(tr->data.key<data.key){
            if(left==NULL){
                left=tr;
                left->parent=this;
            }
            else
                left->add(tr);
        }
        else if(tr->data.key>data.key){
            if(right==NULL){
                right=tr;
                right->parent=this;
            }
            else
                right->add(tr);
        }
    }
    void del(int key){        //�������� ���� �� �����
        if(data.key==key){     //���� �������� ����� ���� ��������
            if(parent==NULL){   //���� ��� ������
                swap(data, right->data);
                del(right->data.key);
            }
            else if((left==NULL)&&(right==NULL)){   //���� ��� ��������
                if(this==parent->left){         //� �������� �����
                    parent->left=NULL;
                    delete this;
                }
                else if(this==parent->right){       //�������� ������
                    parent->right=NULL;
                    delete this;
                }
            }
            else if((left==NULL)&&(right!=NULL)){   //���� ������ �������, �� ���� ������
                if(this==parent->left){         //� �������� �����
                    parent->left=right;
                    right->parent=parent;
                    delete this;
                }
                else if(this==parent->right){       //�������� ������
                    parent->right=right;
                    right->parent=parent;
                    delete this;
                }
            }
            else if((left!=NULL)&&(right==NULL)){   //���� ������� �������, �� ���� �����
                if(this==parent->left){         //� �������� �����
                    parent->left=left;
                    left->parent=parent;
                    delete this;
                }
                else if(this==parent->right){       //�������� ������
                    parent->right=left;
                    left->parent=parent;
                    delete this;
                }
            }
            else{               //���� ��� �������
                if(this==parent->left){         //� �������� �����
                    parent->left=right;
                    right->parent=parent;
                    right->add(left);
                    delete this;
                }
                else if(this==parent->right){       //�������� ������
                    parent->right=right;
                    right->parent=parent;
                    right->add(left);
                    delete this;
                }
            }
        }
        else{       //���� �� ��������, ���� ��� ����������
            if(left)left->del(key);
            if(right)right->del(key);
        }
    }

    void preOrderDFS() {  //������ �����
        cout << data.key << " ";
        if(left)left->preOrderDFS();
        if(right)right->preOrderDFS();
    }
    void inOrderDFS() {   //������������
        if(left)left->inOrderDFS();
        cout << data.key << " ";
        if(right)right->inOrderDFS();
    }
    void postOrderDFS() {  //�������� �����
        if(left)left->postOrderDFS();
        if(right)right->postOrderDFS();
        cout << data.key << " ";
    }
    void longOrderBFS() {   //����� � ������
        q.push(this);
        while(!q.empty()){
            cout << q.front()->data.key << " ";
            if(q.front()->left!=NULL)q.push(q.front()->left);
            if(q.front()->right!=NULL)q.push(q.front()->right);
            q.pop();
        }
    }
    void print() {
        int counter=0;
        obj symb; symb.sym=' ';
        Tree NONE(symb);

        int tabs=0;
        for(int i=0; i<depth(this, 0); i++)
            tabs=2*tabs+1;

        Tree* tmp;
        q.push(this);
        q.push(NULL);
        print_symbol(tabs, ' ');
        while(!q.empty()) {
            tmp=q.front(); q.pop();
            if(tmp!=NULL){
                if(tmp->data.sym==' ')cout << tmp->data.sym;
                else cout <</*"|"<<*/ tmp->data.key;//<<"|";

                print_symbol(2*tabs+1, ' ');
                if(tmp->left)q.push(tmp->left);
                else if(tabs>0) q.push(&NONE);
                if(tmp->right)q.push(tmp->right);
                else if(tabs>0) q.push(&NONE);
            }
            else if(!q.empty()){
                //int space_counter=0;

                if(counter==0)counter=1;
                else counter*=2;
                cout << endl;
                tabs=(tabs-1)/2;
                /*while(q.front()==&NONE){
                    print_symbol(4*tabs+4, ' ');
                    q.pop();
                    counter--;
                    space_counter++;
                }*/
                //if(q.front()!=&NONE){
                    print_symbol(tabs, ' ');
                    for(int i=0; i<counter; i++){
                        print_symbol(tabs+1, '_'); cout <<"|";
                        print_symbol(tabs+1, '_');
                        print_symbol(2*tabs+1, ' ');
                    }
                    cout << endl;
                    /*
                    for(int i=0; i<space_counter; i++){
                        print_symbol(4*tabs+4, ' ');
                        //counter--;
                    }
                    */
                    print_symbol(tabs, ' ');
                    for(int i=0; i<counter*2; i++){
                        cout <<"|";
                        print_symbol(2*tabs+1, ' ');
                    }
                    cout << endl;
                    //counter+=space_counter;

                //}

                print_symbol(tabs, ' ');
                q.push(NULL);
            }
        }
    }
    /*int Find(int elem){


       ///////////////3-------------------------------1
       ///////________|________
       ///////|---------------|---------------|
       ///////6---------------0---------------3
       ///____|____-------____|____
       ///|-------|-------|-------|
       ///4-------7-------8-------7
       /3---4---5---5---8---5---4---5
       1_2_5_6_6_6_6_6




    }*/


    int depth(Tree* tr, int dep_count){         //������� ������
        if((tr->left==NULL)&&(tr->right==NULL))
            return dep_count;
        if(tr->left==NULL)
            return depth(tr->right, dep_count+1);
        if(tr->right==NULL)
            return depth(tr->left, dep_count+1);
        else return max(depth(tr->left, dep_count+1), depth(tr->right, dep_count+1));
    }
    void deleteTree(){
        if(left){cout << left->data.key <<" "; left->deleteTree();}
        left=NULL;
        if(right){cout << right->data.key<<" "; right->deleteTree();}
        right=NULL;
        delete this;
    }
private:
    void print_symbol(int n, char c){       //��� ������
        for(int i=0; i<n; i++)
            cout << c;
    }
};

int main(){
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);
    obj n;
    n.key=5;

    Tree t(n);

    n.key=1;
    t.add(n);
    n.key=7;
    t.add(n);
    n.key=3;
    t.add(n);
    n.key=2;
    t.add(n);
    n.key=0;
    t.add(n);
    n.key=4;
    t.add(n);
    n.key=6;
    t.add(n);

    n.key=77;
    Tree t2(n);
    n.key=12;
    t2.add(n);
    n.key=100;
    t2.add(n);
    n.key=10;
    t2.add(n);
    n.key=11;
    t2.add(n);
    t.add(&t2);

    int ans;
    while(true){
        cout << "\n1.�������� �������� � ������\n2.������� ����\n3.����������� ������\n4.������\n5.�����\n";
        ans=cin_valid();
        switch(ans){
        case 1:  cout << "������� ��������: ";
            n.key=cin_valid();
            t.add(n);
            break;
        case 2: cout << "������� ��������: ";
            n.key=cin_valid();
            t.del(n.key);
            break;
        case 3: t.print(); break;
        case 4: cout << "������ �����: "; t.preOrderDFS(); cout << endl;
                cout << "������������  �����: "; t.inOrderDFS(); cout << endl;
                cout << "�������� �����: "; t.postOrderDFS(); cout << endl;
                cout << "����� � ������: "; t.longOrderBFS(); cout << endl;
                break;
        case 5: return 0;
        default: cout << "Wrong value!! Try again: " << endl;
        }
    }
/*
    t.add(&t2);
    t.postOrderDFS();
    //cout << endl;
    //t.longOrderBFS();
    cout << endl;
    //t.del(5);
    //t.longOrderBFS();
    cout << endl;
    //t.del(3);
    //t.longOrderBFS();
    //t.preOrderDFS();
    //t.deleteTree();
    t.print();
    //cout << endl << t.depth(&t, 0);*/
    return 0;
}
