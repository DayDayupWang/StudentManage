import java.util.Scanner;
import java.util.ArrayList;

public class StudentManager {
    public static void main(String[] args) {

        ArrayList<Student> array = new ArrayList<Student>();

        while (true) {
            System.out.println("------------------欢迎来到学生管理系统------------------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            switch (line) {

                case "1":
                    // System.out.println("1 添加学生");
                    addStudent(array);
                    break;
                case "2":
                    // System.out.println("2 删除学生");
                    delStudent(array);
                    break;
                case "3":
                    // System.out.println("3 修改学生");
                    updateStudent(array);
                    break;
                case "4":
                    // System.out.println("4 查看所有学生");
                    findAllStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    System.exit(0);

            }
        }
    }

    public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        String sid;
        while (true) {
            System.out.println("请输入学生学号：");
            sid = sc.nextLine();
            boolean flag = isUsed(array, sid);
            if (flag) {
                System.out.println("你输入的学号已经被使用，请重新输入");
            } else {
                break;
            }
        }

        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生居住地：");
        String address = sc.nextLine();

        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        array.add(s);
        System.out.println("添加学生成功");
    }

    public static void findAllStudent(ArrayList<Student> array) {
        if (array.isEmpty()) {
            System.out.println("no data found");
            return;
        }
        System.out.println("学号\t\t姓名\t年龄\t居住地\t");
        for (int i = 0; i < array.size(); i++) {

            Student s = array.get(i);
            System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getAddress());
        }
    }

    public static void delStudent(ArrayList<Student> array) {
        if (array.isEmpty()) {
            System.out.println("本无数据");
            return;
        }
        Scanner sz = new Scanner(System.in);
        System.out.println("输入要删除的学生编号");
        String sid = sz.nextLine();
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                array.remove(i);
                break;
            }
        }
        System.out.println("删除学生成功");
    }

    public static void updateStudent(ArrayList<Student> array) {
        Scanner sz = new Scanner(System.in);
        System.out.println("要修改的学生的学号");
        String sid = sz.nextLine();

        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生居住地：");
        String address = sc.nextLine();
Student s=new Student(); 
s.setSid(sid); 
s.setName(name);
s.setAge(age);
s.setAddress(address);
        if (int i=0;i<array.size();i++) {
Student student=array.get(i);
if (student.getSid().equals(sid)) {
    array.set(i, s);
    break;
}
        }
        System.out.println("修改学生成功");
    }

    public static boolean isUsed(ArrayList<Student> array, String sid) {
        boolean flag = false;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
