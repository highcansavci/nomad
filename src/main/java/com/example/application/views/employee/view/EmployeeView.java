package com.example.application.views.employee.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.application.views.MainLayout;
import com.example.application.views.employee.controller.EmployeeController;
import com.example.application.views.employee.model.Employee;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.MultiSortPriority;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Personel")
@Route(value = "personel", layout = MainLayout.class)
@RouteAlias(value = "personel", layout = MainLayout.class)
public class EmployeeView extends VerticalLayout {

    private TextField nameSearchTextField;
    private Grid<Employee> employeeGrid;
    private EmployeeController employeeController;

    public EmployeeView(EmployeeController employeeController) {
        this.employeeController = employeeController;
        employeeGrid = new Grid<>(Employee.class, false);
        employeeGrid.addColumn((ValueProvider<Employee, String>) Employee::getTurkishIdentificationNumber).setHeader("TC No").setSortable(true);
        employeeGrid.addColumn((ValueProvider<Employee, String>) Employee::getName).setHeader("Ad").setSortable(true);
        employeeGrid.addColumn((ValueProvider<Employee, String>) Employee::getSurname).setHeader("Soyad").setSortable(true);
        nameSearchTextField = new TextField("Search by Name");
        nameSearchTextField.setValueChangeMode(ValueChangeMode.EAGER);
        employeeGrid.setItems(this.employeeController.getAllEmployees().getBody());
        employeeGrid.setMultiSort(true, MultiSortPriority.APPEND);
        nameSearchTextField.addValueChangeListener(e -> {
            String text = nameSearchTextField.getValue().toLowerCase(); 
            if(text.equals(""))
                employeeGrid.setItems(this.employeeController.getAllEmployees().getBody());
            else
                employeeGrid.setItems(this.employeeController.filterEmployeesByName(text).getBody());
        });

        setMargin(true);
        add(nameSearchTextField);
        add(employeeGrid);
    }

}
