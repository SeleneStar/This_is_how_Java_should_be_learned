public class PrintAcsii{
    public static void main(String args[]){
        char[] a = new char[5];
        a[0] = 'a';
        a[1] = 'A';
        a[2] = '0';
        a[3] = ' ';
        a[4] = '\n';
        for(int i = 0; i<a.length; i++){
            System.out.println(a[i]+"==>"+((int)a[i]));
        }
    }
}