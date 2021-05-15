package com.wong.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wong.pojo.Department;
import com.wong.pojo.Employee;

//員工Dao
@Repository
public class EmployeeDao {

  //模擬數據庫數據
  private static Map<Integer, Employee> employees = null;
  //員工所屬部門
  @Autowired
  private DepartmentDao departmentDao;

  static {
      employees = new HashMap<Integer, Employee>();//創建一個員工表

      employees.put(1001,new Employee(1001,"AA","A123456@gmail.com",1,new Department(101,"教學部")));
      employees.put(1002,new Employee(1002,"BB","B123456@gmail.com",0,new Department(102,"市場部")));
      employees.put(1003,new Employee(1003,"CC","C123456@gmail.com",1,new Department(103,"教研部")));
      employees.put(1004,new Employee(1004,"DD","D123456@gmail.com",0,new Department(104,"運營部")));
      employees.put(1005,new Employee(1005,"EE","E123456@gmail.com",1,new Department(105,"後勤部")));
  }

  //主鍵自增
  private static Integer ininId = 1006;

  //增加一個員工
  public void save(Employee employee) {
      if (employee.getId() == null) {
          employee.setId(ininId++);
      }
      employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

      employees.put(employee.getId(),employee);
  }

  // 查詢全部員工信息
  public Collection<Employee> getAll() {
      return employees.values();
  }

  // 通過id查詢員工
  public Employee getEmployeeById(Integer id) {
      return employees.get(id);
  }

  //刪除員工通過id
  public void delete(Integer id) {
      employees.remove(id);
  }
}
