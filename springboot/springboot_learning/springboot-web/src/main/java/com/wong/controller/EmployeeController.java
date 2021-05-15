package com.wong.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wong.dao.DepartmentDao;
import com.wong.dao.EmployeeDao;
import com.wong.pojo.Department;
import com.wong.pojo.Employee;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //查出所有部門的信息
        Collection<Department> department = departmentDao.getDepartment();
        model.addAttribute("departments",department);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
    	System.out.println("save ====> " + employee);
        employeeDao.save(employee);//調用底層業務方法保存員工信息
        return "redirect:/emps";
    }

    // 去到員工的修改頁面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model) {
        //查出原來的數據
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        //查出所有部門的信息
        Collection<Department> department = departmentDao.getDepartment();
        model.addAttribute("departments",department);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    // 刪除員工
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}