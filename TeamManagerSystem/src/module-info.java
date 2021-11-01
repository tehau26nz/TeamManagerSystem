module TeamManagerSystem {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml,javafx.base;
	opens models to javafx.graphics, javafx.fxml,javafx.base;
	opens layouts to javafx.graphics, javafx.fxml,javafx.base;
}
