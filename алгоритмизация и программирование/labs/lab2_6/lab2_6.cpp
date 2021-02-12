#include <iostream>
#include <windows.h>
#include <My_library.h>
#include <queue>

using namespace std;

struct tree{    //корень дерева
    int val;
    tree* left;
    tree* right;
    tree* parent;
};

tree* init(int val){    //инициализация
    tree* tmp=new tree;
    tmp->val=val;
    tmp->right=NULL;
    tmp->left=NULL;
    tmp->parent=NULL;
    return tmp;
}

void add(tree* tmp, int val){   //добавление элемента
    while(true){
        if(val>tmp->val){   //если больше
            if(tmp->right==NULL){   //и правый отсутствует, устанавливаем вправо
                tmp->right=new tree;
                tmp->right->right=NULL;
                tmp->right->left=NULL;
                tmp->right->parent=tmp;
                tmp->right->val=val;
                return;
            }
            else    //если правый есть, делаем итерацию
                tmp=tmp->right;
        }
        else if(val==tmp->val){ //если равен, не добавляем
            return;
        }
        else{               //если меньше
            if(tmp->left==NULL){    //и левый отсутствует, устанавливаем влево
                tmp->left=new tree;
                tmp->left->right=NULL;
                tmp->left->left=NULL;
                tmp->left->parent=tmp;
                tmp->left->val=val;
                return;
            }
            else    //левый есть- итерация
                tmp=tmp->left;
        }
    }
}

void preOrderTravers(tree* root) {  //прямой обход
    if (root) {
        cout << root->val << " ";
        preOrderTravers(root->left);
        preOrderTravers(root->right);
    }
}

void inOrderTravers(tree* root) {   //симметричный
    if (root) {
        inOrderTravers(root->left);
        cout << root->val << " ";
        inOrderTravers(root->right);
    }
}

void postOrderTravers(tree* root) {       //обратный
    if (root) {
        postOrderTravers(root->left);
        postOrderTravers(root->right);
        cout << root->val << " ";
    }
}

queue<tree*> q; //очередь
void longOrderTravers(tree* tr) {   //обход в ширину
    q.push(tr);
    while(!q.empty()){
        cout << q.front()->val << " ";
        if(q.front()->left!=NULL)q.push(q.front()->left);
        if(q.front()->right!=NULL)q.push(q.front()->right);
        q.pop();
    }
}

void info(tree* tr){  //вывод информации об элементе
    if(tr==NULL)
        cout << "Такого элемента нет!" << endl;
    else{
        cout << "Узел: " << tr->val << endl;
        cout << "Родитель: "; if(tr->parent==NULL)cout << "нет" << endl; else cout << tr->parent->val << endl;
        cout << "Левый потомок: "; if(tr->left==NULL)cout << "нет" << endl; else cout << tr->left->val << endl;
        cout << "Правый потомок: "; if(tr->right==NULL)cout << "нет" << endl; else cout << tr->right->val << endl;
    }
}

//следующая функция это чистой воды магия, можете даже не пытатся понять, как она работает, я написал ее случайно(шутка)

tree* Find(tree* tr, int val){  //возвращает адрес элемента по значению
    tree* tmp=NULL;
    if (tr) {
        if(tr->val==val)
            return tr;
        tmp=Find(tr->left,val);
        if(tmp==NULL)           //если не нашли слева, ищем справа
            Find(tr->right,val);

    }
}

/*я выделил в отдельные условия 8 возможных ситуаций удаления узла-
1-корень дерева, не имеющий потомков
2-корень дерева с правым потомком
3-корень дерева с левым потомком
4-корень дерева с обеими потомками
5-произвольный элемент без потомков
6-произвольный элемент с правым потомком
7-произвольный элемент с левым потомком
8-произвольный элемент с обеими потомками
*/
tree* del(tree* tr, tree* root){ //удаление ячейки
    tree* tmp_left;
    tree* temp=tr;

    if((tr->parent==NULL)&&(tr->left==NULL)&&(tr->right==NULL)){     //только корень
        delete tr;
        return NULL;
    }
    else if((tr->parent==NULL)&&(tr->left==NULL)&&(tr->right!=NULL)){   //корень с правым потомком
        temp=tr->right;
        delete tr;
        temp->parent=NULL;
        return temp;
    }
    else if((tr->parent==NULL)&&(tr->left!=NULL)&&(tr->right==NULL)){   //корень с левым
        temp=tr->left;
        delete tr;
        temp->parent=NULL;
        return temp;
    }
    else if((tr->parent==NULL)&&(tr->left!=NULL)&&(tr->right!=NULL)){   //корень с двумя потомками

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
    else if((tr->left==NULL)&&(tr->right==NULL)){    //если нет потомков
        if(tr==tr->parent->left)
            tr->parent->left=NULL;
        else if(tr==tr->parent->right)
            tr->parent->right=NULL;
        delete tr;
    }
    else if((tr->left==NULL)&&(tr->right!=NULL)){   //если есть правый потомок
        if(tr==tr->parent->left)
            tr->parent->left=tr->right;

        else if(tr==tr->parent->right)
            tr->parent->right=tr->right;

        tr->right->parent=tr->parent;
        delete tr;
    }
    else if((tr->left!=NULL)&&(tr->right==NULL)){       //если есть левый потомок
        if(tr==tr->parent->left)
            tr->parent->left=tr->left;

        else if(tr==tr->parent->right)
            tr->parent->right=tr->left;

        tr->left->parent=tr->parent;
        delete tr;
    }
    else if((tr->left!=NULL)&&(tr->right!=NULL)){       //если есть оба потомка
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

tree* Erase(tree* tr){  //полное удаление дерева
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
        cout << "\n1.Добавить значение в дерево\n2.Информация об узле\n3.Удалить узел\n4.Распечатать дерево\n5.Найти минимальный элемент\n6.Выход\n";
        ans=cin_valid();
        switch(ans){
        case 1:
            cout << "Введите значение: ";
            ans=cin_valid();
            if(tr==NULL)
                tr=init(ans);
            else
                add(tr,ans);
            break;
        case 2:
            if(tr==NULL)cout << "В дереве нет элементов!!" << endl;
            else{
                cout << "Введите значение узла для поиска: ";
                ans=cin_valid();
                info(Find(tr,ans));
            }
            break;
        case 3:
            if(tr==NULL)cout << "В дереве нет элементов!!" << endl;
            else{
                cout << "Введите значение узла для удаления: ";
                ans=(int)cin_valid();
                tr=del(Find(tr, ans),tr);
            }
            break;
        case 4:
            if(tr==NULL)cout << "В дереве нет элементов!!" << endl;
            else{
                cout << "Прямой обход: "; preOrderTravers(tr); cout << endl;
                cout << "Симметричный  обход: "; inOrderTravers(tr); cout << endl;
                cout << "Обрантый обход: "; postOrderTravers(tr); cout << endl;
                cout << "Обход в ширину: "; longOrderTravers(tr); cout << endl;
            }
            break;
        case 5:
            if(tr==NULL)cout << "В дереве нет элементов!!" << endl;
            else{
                min=tr;
                while(min->left!=NULL){
                    min=min->left;
                }
                cout << "Минимальный элемент: " << min->val << endl;
            }
            break;
        case 6: if(tr!=NULL)tr=Erase(tr); return 0;
        default: cout << "Некорректное значение!!!" << endl;
        }
    }
}
