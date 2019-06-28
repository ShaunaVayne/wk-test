package cn.wk.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static cn.wk.test.EmployeePredicates.*;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2019/6/20 15:07
 * @ProjectName: wk-test
 * @Version: 1.0.0
 */
public class PredicateDemo {

    public static void main(String[] args) {
        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");
        ArrayList<Employee> employees = new ArrayList<>();
        employees.addAll(Arrays.asList(new Employee[]{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10}));
        System.out.println(filterEmployees(employees, isAdultMale()));
        Runnable runnable = () -> System.out.println("-----------------------------");
        runnable.run();
        System.out.println(filterEmployees(employees, isAdultFemale()));
        runnable.run();
        System.out.println(filterEmployees(employees, isAgeMoreThan(35)));
        runnable.run();
        //negate表示测试方法返回false的结果,即取其反
        System.out.println(filterEmployees(employees, isAgeMoreThan(35).negate()));


    }
}
