# 取得用户名和密码
想得到用户输入，还是老办法——猜答案
```java
    String name = txtUser.getText();
    //String password = txtPass.getText();  
    //JPasswordField 里面的 getText() 过时的解决办法
    String password = String.valueOf(txtPass.getPassword());
```
这里的```JPasswordField 里面的 getText() ```过时，但是发现有 getPassword() ，但是他的返回值是 char ，所以需要将字符转换成字符串
```java
 /**
     * Returns the string representation of the {@code char} array
     * argument. The contents of the character array are copied; subsequent
     * modification of the character array does not affect the returned
     * string.
     *
     * @param   data     the character array.
     * @return  a {@code String} that contains the characters of the
     *          character array.
     */
    public static String valueOf(char data[]) {
        return new String(data);
    }
```

---
# 采用面向对象思想重写
### 构造方法
每个类都存在一个构造方法，与类命一致，一般用来初始化
所以，主函数可改成为
```java
public static void main(String args[]){
    MyTest jf = new MyTest();
    jf.setVisible(true);        
}
```

需要的时候就直接new出来，但是在之前就需要改好
```java
public class MyTest extends JFrame{
    //之所以把 JTextField 和 JPasswordField 写到外面是因为其他方法也需要调用
    JTextField txtUser = new JTextField();
    JPasswordField txtPass = new JPasswordField();

    public MyTest(){
        this.setSize(300, 125);
        JLabel labUser = new JLabel("User name");
        JLabel labPass = new JLabel("Password");
        

        JPanel input = new JPanel();
        input.setLayout(new GridLayout(2,2));
        input.add(labUser);
        input.add(txtUser);
        input.add(labPass);
        input.add(txtPass);

        JButton jb1 = new JButton("Login");
        JButton jb2 = new JButton("Register");
        JButton jb3 = new JButton("Cancel");
        JPanel jbp = new JPanel();
        jbp.setLayout(new FlowLayout());
        jbp.add(jb1);
        jbp.add(jb2);
        jbp.add(jb3);

        this.setLayout(new BorderLayout());
        this.add(input, BorderLayout.NORTH);
        this.add(jbp, BorderLayout.SOUTH);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
    }
}
```
