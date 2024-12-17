package com.example.task0;

import com.example.task0.Procent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class HelloController {
    @FXML
    private TextField sumField;

    @FXML
    private Label resultLabelHigh;
    @FXML
    private Label resultLabelNormal;
    @FXML
    private Label resultLabelLow;

    @FXML
    private Button buttonHigh; // 15%
    @FXML
    private Button buttonNormal; // Выбрать
    @FXML
    private Button buttonLow; // 3%

    @FXML
    private ChoiceBox<String> choiceBoxNormalTip; // Выбор 10% или 9%

    private Procent procent;
    private int selectedNormalTip; // Текущий выбранный процент (10 или 9)

    public void initialize() {
        procent = new Procent(0);

        // Инициализация ChoiceBox с обработчиком выбора
        choiceBoxNormalTip.getItems().addAll("10%", "9%");
        choiceBoxNormalTip.setValue("10%"); // Устанавливаем значение по умолчанию
        selectedNormalTip = 10; // По умолчанию 10%

        choiceBoxNormalTip.setOnAction(this::updateNormalTip); // Обработчик выбора
    }

    @FXML
    public void calculateHighTip() {
        calculateTip(15, resultLabelHigh);
    }

    @FXML
    public void calculateNormalTip() {
        calculateTip(selectedNormalTip, resultLabelNormal);
    }

    @FXML
    public void calculateLowTip() {
        calculateTip(3, resultLabelLow);
    }

    private void calculateTip(int tipPercent, Label resultLabel) {
        try {
            float sum = Float.parseFloat(sumField.getText());
            procent = new Procent(sum);
            int result = procent.countSumrnd(tipPercent);
            resultLabel.setText("Итого: " + result + " Руб");
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR, "Некорректная сумма. Введите число", ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void updateNormalTip(ActionEvent actionEvent) {
        // Обновляем текущий выбранный процент на основе выбора пользователя
        String selectedValue = choiceBoxNormalTip.getValue();
        if ("10%".equals(selectedValue)) {
            selectedNormalTip = 10;
        } else if ("9%".equals(selectedValue)) {
            selectedNormalTip = 9;
        }
    }

    public void onHelloButtonClick(ActionEvent actionEvent) {
    }
}