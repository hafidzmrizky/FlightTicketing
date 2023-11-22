package com.smk.hafidzmrizky.view;

import com.smk.hafidzmrizky.MainView;
import com.smk.hafidzmrizky.dao.LocationDao;
import com.smk.hafidzmrizky.model.Location;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Create Booking")
@Route(value = "create-booking", layout = MainView.class)
public class CreateBooking extends VerticalLayout {

    private LocationDao locationDao;

    public CreateBooking() {
        locationDao = new LocationDao();
        createForm();
    }

    private void createForm() {
        setAlignItems(Alignment.STRETCH);

        ComboBox<Location> fromComboBox = new ComboBox<>("Dari");
        fromComboBox.setItems(locationDao.getAll());
        fromComboBox.setItemLabelGenerator(Location::getName);

        ComboBox<Location> toComboBox = new ComboBox<>("Ke");
        toComboBox.setItems(locationDao.getAll());
        toComboBox.setItemLabelGenerator(Location::getName);

        DatePicker departureDatePicker = new DatePicker("Tanggal Keberangkatan");
        DatePicker arrivalDatePicker = new DatePicker("Tanggal Kepulangan");
        Button searchButton = new Button("Search");
        searchButton.addThemeVariants(
                ButtonVariant.LUMO_PRIMARY
        );
        add(fromComboBox, toComboBox, departureDatePicker, arrivalDatePicker, searchButton);
    }

}
