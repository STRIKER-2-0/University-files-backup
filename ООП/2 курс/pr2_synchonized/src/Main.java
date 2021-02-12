public class Main {
    public static int N=100;
    public static int Init=1000;
    public static int Delay=10;
    public static void main(String[] args) {
        Bank bank=new Bank(N, Init);
        for(int i=0; i<N; i++){
            int i1=i;
            Runnable r=new Runnable() {
                @Override
                public void run() {
                    try{
                        while(true){
                            int to=(int)(Math.random()*N);
                            int a=(int)(Math.random()*Init);
                            bank.transfer(i1,to,a);
                            Thread.sleep((int)(Math.random()*Delay));
                        }
                    }catch(InterruptedException e){}

                }
            };
            Thread t=new Thread(r);
            t.start();
        }
    }
}
