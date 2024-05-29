import java.util.*;

public class MyTest{
    public static void main(String[] args) {
        ArrayList<Integer> al =  new ArrayList<Integer>();

        for(int i = 0; i<100; i++){
            al.add(i);
        }

        //jdk1.5以后新引入 for循环 
        //for(循环变量类型 循环变量名称 : 要遍历的对象){循环体}
        for(Integer v: al){
            System.out.println(v);
        }
    }
}