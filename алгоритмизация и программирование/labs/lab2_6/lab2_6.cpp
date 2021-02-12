#include <iostream>
#include <windows.h>
#include <My_library.h>
#include <queue>

using namespace std;

struct tree{    //������ ������
    int val;
    tree* left;
    tree* right;
    tree* parent;
};

tree* init(int val){    //�������������
    tree* tmp=new tree;
    tmp->val=val;
    tmp->right=NULL;
    tmp->left=NULL;
    tmp->parent=NULL;
    return tmp;
}

void add(tree* tmp, int val){   //���������� ��������
    while(true){
        if(val>tmp->val){   //���� ������
            if(tmp->right==NULL){   //� ������ �����������, ������������� ������
                tmp->right=new tree;
                tmp->right->right=NULL;
                tmp->right->left=NULL;
                tmp->right->parent=tmp;
                tmp->right->val=val;
                return;
            }
            else    //���� ������ ����, ������ ��������
                tmp=tmp->right;
        }
        else if(val==tmp->val){ //���� �����, �� ���������
            return;
        }
        else{               //���� ������
            if(tmp->left==NULL){    //� ����� �����������, ������������� �����
                tmp->left=new tree;
                tmp->left->right=NULL;
                tmp->left->left=NULL;
                tmp->left->parent=tmp;
                tmp->left->val=val;
                return;
            }
            else    //����� ����- ��������
                tmp=tmp->left;
        }
    }
}

void preOrderTravers(tree* root) {  //������ �����
    if (root) {
        cout << root->val << " ";
        preOrderTravers(root->left);
        preOrderTravers(root->right);
    }
}

void inOrderTravers(tree* root) {   //������������
    if (root) {
        inOrderTravers(root->left);
        cout << root->val << " ";
        inOrderTravers(root->right);
    }
}

void postOrderTravers(tree* root) {       //��������
    if (root) {
        postOrderTravers(root->left);
        postOrderTravers(root->right);
        cout << root->val << " ";
    }
}

queue<tree*> q; //�������
void longOrderTravers(tree* tr) {   //����� � ������
    q.push(tr);
    while(!q.empty()){
        cout << q.front()->val << " ";
        if(q.front()->left!=NULL)q.push(q.front()->left);
        if(q.front()->right!=NULL)q.push(q.front()->right);
        q.pop();
    }
}

void info(tree* tr){  //����� ���������� �� ��������
    if(tr==NULL)
        cout << "������ �������� ���!" << endl;
    else{
        cout << "����: " << tr->val << endl;
        cout << "��������: "; if(tr->parent==NULL)cout << "���" << endl; else cout << tr->parent->val << endl;
        cout << "����� �������: "; if(tr->left==NULL)cout << "���" << endl; else cout << tr->left->val << endl;
        cout << "������ �������: "; if(tr->right==NULL)cout << "���" << endl; else cout << tr->right->val << endl;
    }
}

//��������� ������� ��� ������ ���� �����, ������ ���� �� ������� ������, ��� ��� ��������, � ������� �� ��������(�����)

tree* Find(tree* tr, int val){  //���������� ����� �������� �� ��������
    tree* tmp=NULL;
    if (tr) {
        if(tr->val==val)
            return tr;
        tmp=Find(tr->left,val);
        if(tmp==NULL)           //���� �� ����� �����, ���� ������
            Find(tr->right,val);

    }
}

/*� ������� � ��������� ������� 8 ��������� �������� �������� ����-
1-������ ������, �� ������� ��������
2-������ ������ � ������ ��������
3-������ ������ � ����� ��������
4-������ ������ � ������ ���������
5-������������ ������� ��� ��������
6-������������ ������� � ������ ��������
7-������������ ������� � ����� ��������
8-������������ ������� � ������ ���������
*/
tree* del(tree* tr, tree* root){ //�������� ������
    tree* tmp_left;
    tree* temp=tr;

    if((tr->parent==NULL)&&(tr->left==NULL)&&(tr->right==NULL)){     //������ ������
        delete tr;
        return NULL;
    }
    else if((tr->parent==NULL)&&(tr->left==NULL)&&(tr->right!=NULL)){   //������ � ������ ��������
        temp=tr->right;
        delete tr;
        temp->parent=NULL;
        return temp;
    }
    else if((tr->parent==NULL)&&(tr->left!=NULL)&&(tr->right==NULL)){   //������ � �����
        temp=tr->left;
        delete tr;
        temp->parent=NULL;
        return temp;
    }
    else if((tr->parent==NULL)&&(tr->left!=NULL)&&(tr->right!=NULL)){   //������ � ����� ���������

        temp=tr->left;
        tmp_left=tr->right->left;

        delete tr;
        tr=tr->right;
        tr->left=temp;
        tr->left->parent=tr;
        tr->parent=NULL;

        temp=tr->left;
        while(temp->right!=NULL){
            temp=temp->right;
           }

        temp->right=tmp_left;
        if(tmp_left!=NULL)tmp_left->parent=temp;

        return tr;
    }
    else if((tr->left==NULL)&&(tr->right==NULL)){    //���� ��� ��������
        if(tr==tr->parent->left)
            tr->parent->left=NULL;
        else if(tr==tr->parent->right)
            tr->parent->right=NULL;
        delete tr;
    }
    else if((tr->left==NULL)&&(tr->right!=NULL)){   //���� ���� ������ �������
        if(tr==tr->parent->left)
            tr->parent->left=tr->right;

        else if(tr==tr->parent->right)
            tr->parent->right=tr->right;

        tr->right->parent=tr->parent;
        delete tr;
    }
    else if((tr->left!=NULL)&&(tr->right==NULL)){       //���� ���� ����� �������
        if(tr==tr->parent->left)
            tr->parent->left=tr->left;

        else if(tr==tr->parent->right)
            tr->parent->right=tr->left;

        tr->left->parent=tr->parent;
        delete tr;
    }
    else if((tr->left!=NULL)&&(tr->right!=NULL)){       //���� ���� ��� �������
        if(tr==tr->parent->right){
            tr->parent->right=tr->right;
            tr->right->parent=tr->parent;
            tmp_left=tr->right->left;
            tr->right->left=tr->left;
            tr->left->parent=tr->right;

            temp=tr->left;
            while(temp->right!=NULL)
                temp=temp->right;

            temp->right=tmp_left;

        }
        else if(tr==tr->parent->left){
            tr->parent->left=tr->right;
            tr->right->parent=tr->parent;
            tmp_left=tr->right->left;
            tr->right->left=tr->left;
            tr->left->parent=tr->right;

            temp=tr->left;
            while(temp->right!=NULL)
                temp=temp->right;

            temp->right=tmp_left;

        }
    }
    return root;
}

tree* Erase(tree* tr){  //������ �������� ������
    if(tr->left!=NULL)
        Erase(tr->left);
    else if(tr->right!=NULL)
        Erase(tr->right);
    else{
        delete tr;
        return NULL;
    }
}

int main(){
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);
    tree* tr=NULL;
    tree* min=NULL;

    int ans;
    while(true){
        cout << "\n1.�������� �������� � ������\n2.���������� �� ����\n3.������� ����\n4.����������� ������\n5.����� ����������� �������\n6.�����\n";
        ans=cin_valid();
        switch(ans){
        case 1:
            cout << "������� ��������: ";
            ans=cin_valid();
            if(tr==NULL)
                tr=init(ans);
            else
                add(tr,ans);
            break;
        case 2:
            if(tr==NULL)cout << "� ������ ��� ���������!!" << endl;
            else{
                cout << "������� �������� ���� ��� ������: ";
                ans=cin_valid();
                info(Find(tr,ans));
            }
            break;
        case 3:
            if(tr==NULL)cout << "� ������ ��� ���������!!" << endl;
            else{
                cout << "������� �������� ���� ��� ��������: ";
                ans=(int)cin_valid();
                tr=del(Find(tr, ans),tr);
            }
            break;
        case 4:
            if(tr==NULL)cout << "� ������ ��� ���������!!" << endl;
            else{
                cout << "������ �����: "; preOrderTravers(tr); cout << endl;
                cout << "������������  �����: "; inOrderTravers(tr); cout << endl;
                cout << "�������� �����: "; postOrderTravers(tr); cout << endl;
                cout << "����� � ������: "; longOrderTravers(tr); cout << endl;
            }
            break;
        case 5:
            if(tr==NULL)cout << "� ������ ��� ���������!!" << endl;
            else{
                min=tr;
                while(min->left!=NULL){
                    min=min->left;
                }
                cout << "����������� �������: " << min->val << endl;
            }
            break;
        case 6: if(tr!=NULL)tr=Erase(tr); return 0;
        default: cout << "������������ ��������!!!" << endl;
        }
    }
}
