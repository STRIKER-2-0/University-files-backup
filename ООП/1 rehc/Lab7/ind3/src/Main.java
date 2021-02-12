
import java.util.Scanner;


public class Main{
    static Scanner scan=new Scanner(System.in);
    static Vector list=new Vector();
    public static void main(String ags[]){     
        int ans;
        String str;
        ClientMan man;
        ClientWoman woman;
               
        System.out.println("---������� �������� ��������������---");
        while(true) {
            System.out.println("1.�������� ����� ����������� ��������\n2.�������� ����� �������\n3.������� �������\n4.������������� �������\n5.����� �� ��������\n6.�����");
            ans=scan.nextInt();
            switch(ans) {
            case 1: list.print(); break;
            case 2: System.out.print("������� ��� �������: 1.������� 2.�������  ");
                    ans=scan.nextInt();
                    if(ans==1) {
                        man=new ClientMan();
                        System.out.println("������� ������ �������:\n�������: ");
                        str=scan.next();
                        man.setLastname(str);
                        System.out.println("\n���: ");
                        str=scan.next();
                        man.setFirstname(str);
                        System.out.println("\n��������: ");
                        str=scan.next();
                        man.setPatronimic(str);
                        System.out.println("\n�������: ");
                        ans=scan.nextInt();
                        man.setOld(ans);
                        System.out.println("\n������ �������: ");
                        ans=scan.nextInt();
                        if(!man.setHairLength(ans))
                            System.out.println("\n������������ ��������!");
                        System.out.println("������� �������: ");
                        ans=scan.nextInt();
                        list.insert(man, ans);
                    }
                    else if(ans==2){
                        woman=new ClientWoman();                       
                        System.out.println("\n������� ������ �������:\n�������: ");
                        str=scan.next();
                        woman.setLastname(str);
                        System.out.println("\n���: ");
                        str=scan.next();
                        woman.setFirstname(str);
                        System.out.println("\n��������: ");
                        str=scan.next();
                        woman.setPatronimic(str);
                        System.out.println("\n�������: ");
                        ans=scan.nextInt();
                        woman.setOld(ans);
                        System.out.println("\n��� �������: ");
                        str=scan.next();
                        woman.setHairCut(str);
                        System.out.println("������� �������: ");
                        ans=scan.nextInt();
                        list.insert(woman, ans);
                    }
                    else {
                        System.out.println("������� �������� ������.");
                        break;
                    }    
                    break;
            case 3: System.out.println("������� ������� ��� ��������: ");
                    ans=scan.nextInt();
                    list.erase(ans);
                    break;
            case 4: if(list.getSize()>0)
            			edit();
            		else
            			System.out.println("������ ����!");
                    break;
            case 5: if(list.getSize()>0)
            			searchmenu();
            		else
            			System.out.println("������ ����!");
            		break;
            case 6: System.out.println("---���� �������---"); scan.close(); return;
            default: System.out.println("������� �������� ��������! ��������� �������.");
            }
        }
    }
    public static void edit() {
        int pos,ans=0,tmp;
        String str;
        ClientMan man;
        ClientWoman woman;
       
        System.out.println("������� ������� ��� ��������������: ");
        tmp=scan.nextInt();
        if(tmp<list.getSize()) {
            System.out.print("��� �� ������� �������������:\n1.�������\n2.���\n3.��������\n4.�������");
            if(list.get(tmp).getGender())
                System.out.println("\n5.������ �������\n6.�����");
            else
                System.out.println("\n5.��� �������\n6.�����");
            ans=scan.nextInt();
            switch(ans) {
            case 1: System.out.print("������� ����� �������: ");
                    str=scan.next();
                    list.get(tmp).setLastname(str);
                    break;
            case 2: System.out.print("\n������� ����� ���: ");
                    str=scan.next();
                    list.get(tmp).setFirstname(str);
                    break;
            case 3: System.out.print("\n������� ����� ��������: ");
                    str=scan.next();
                    list.get(tmp).setPatronimic(str);
                    break;
            case 4: System.out.print("\n������� ����� �������: ");
                    pos=scan.nextInt();                
                    list.get(tmp).setOld(pos);
                    break;
            case 5: if(list.get(tmp).getGender()) {
                        System.out.print("\n������� ������ �������: ");
                        pos=scan.nextInt();
                        man=new ClientMan();
                        man.setLastname(list.get(tmp).getLastname());
                        man.setFirstname(list.get(tmp).getFirstname());
                        man.setPatronimic(list.get(tmp).getPatronimic());
                        man.setOld(list.get(tmp).getOld());
                        man.setHairLength(pos);
                        list.set(man, tmp);
                    }
                    else {
                        System.out.print("\n������� ��� �������: ");
                        str=scan.next();
                        woman=new ClientWoman();
                        woman.setLastname(list.get(tmp).getLastname());
                        woman.setFirstname(list.get(tmp).getFirstname());
                        woman.setPatronimic(list.get(tmp).getPatronimic());
                        woman.setOld(list.get(tmp).getOld());
                        woman.setHairCut(str);
                        list.set(woman, tmp);
                    }
                    break;
            case 6: System.out.println("---�������---"); return;
            default: System.out.println("������� �������� ��������");
            }
        }
        else
            System.out.println("������� �������� ������.");
    }
    static void searchmenu(){
    	boolean flag=false;
        String str;
        System.out.println("�������� �������� ������:\n1.����� �� �������\n2.����� �� ��������\n3.����� �� ������\n4.������� ���� ��������\n5.������� ���� ��������\n6.�����");
        int ans=scan.nextInt();
        switch(ans){
            case 1:
                System.out.println("������� �������: ");
                str=scan.next();
                for(int i=0; i<list.getSize(); i++){
                    if(str.equals(list.get(i).getLastname())) {
                        list.get(i).info();
                        flag=true;
                    }
                }
                if(flag==false)
                	System.out.println("������� �� �������!");
                else
                	System.out.println();
                break;
            case 2:
                System.out.print("������� �������: ");
                ans=scan.nextInt();
                for(int i=0; i<list.getSize(); i++){
                    if(list.get(i).getOld()==ans) {
                        list.get(i).info();
                        flag=true;
                    }
                }
                if(flag==false)
                	System.out.println("������� �� �������!");
                else
                   	System.out.println();
                break;
            case 3:
                System.out.print("������� �����: ");
                ans=scan.nextInt();
                if((ans>=0)&&(ans<list.getSize()))
                    list.get(ans).info();
                else
                    System.out.println("�������� �������� ������!");
                System.out.println();
                break;
            case 4:
                System.out.println("������ ��������-������: ");
                for(int i=0; i<list.getSize(); i++){
                    if(list.get(i).getGender())
                        list.get(i).info();
                }
                System.out.println();
                break;
            case 5:
                System.out.println("������ ��������-������: ");
                for(int i=0; i<list.getSize(); i++){
                    if(!list.get(i).getGender())
                        list.get(i).info();
                }
                System.out.println();
                break;
            case 6: System.out.println("---�������---"); return;
            default: System.out.println("������� �������� ��������");
        }
    }
}