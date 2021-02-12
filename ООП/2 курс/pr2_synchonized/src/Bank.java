class Bank{
    private int[] accs;
    public Bank(int n, int accs_a){
        accs=new int[n];
        for(int i=0; i<n; i++)
            accs[i]=accs_a;
    }
    public synchronized void  transfer(int from, int to, int amount){
        accs[from]-=amount;
        System.out.println("Переводим с "+from+" На "+to+"... "+amount);
        accs[to]+=amount;
        System.out.println("Общая сумма: "+getAll());
    }
    public int getAll(){
        int sum=0;
        for(int i=0; i< accs.length; i++){
            sum+=accs[i];
        }
        return sum;

    }
}
